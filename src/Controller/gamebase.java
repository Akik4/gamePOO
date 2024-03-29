package Controller;

import Model.Character.Ennemy;
import Model.Character.Merchant;
import Model.Character.Personnage;
import Model.Character.Player;
import Model.Object.Armes.Stick;

import Model.Object.Armes.Template;
import Model.Object.Objet;
import Model.Object.Weapon;
import Model.map;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import static View.cli.displayMap;
import java.util.Random;

public class gamebase {

    public static ArrayList<Ennemy> ennemies = new ArrayList<Ennemy>();

    static map laMap = new map(22, 22);

    private static Weapon defaultWeapon;
    public static Player e;

    public static boolean isGameOver;
    public static boolean isSaved;

    public static void init() throws FileNotFoundException {
        /** This function takes the game back according to the save file,
         * and launches the game functions. **/
        if(!isSaved){
            defaultWeapon = new Stick();
            e = new Player("test", 200, 1, "p",defaultWeapon, 0);
        } else {
            Scanner save = Saver.readFile();
            Map<String, String> data = new HashMap<>();
            while (save.hasNextLine())
            {
                String test = save.nextLine();
                String[] split = test.split(":");
                data.put(split[0], split[1]);
                System.out.println(split[0] + " : "+split[1]);
            }
            defaultWeapon = new Template(10, data.get("wname"), "", Float.parseFloat(data.get("damage")), false, Integer.parseInt(data.get("range")), 0);
            e = new Player("Bernard", Float.parseFloat(data.get("HP")), Float.parseFloat(data.get("Force")), "p", defaultWeapon, Integer.parseInt(data.get("Coins")));
        }
        isGameOver = false;
        laMap.generateMap();

        placePlayer(12, 12);
        //displayMap();
        spawnEnnemy(3);
        placeEnnemy();

        showMap();
    }

    public static void getNextInput()
    {
        System.out.println("1 - Droite\r\n2 - Haut\r\n3 - Bas\r\n4 - Gauche \r\n5 - Attaquer\r\n6 - Utiliser potion(interragir)\r\n7 - Sauvegarder");
        /** This function takes input from the player,
         * checks all nearby enemies and game over status,
         * and updates the map.**/

        List<Ennemy> inRange = new ArrayList<Ennemy>();
        Scanner scanner = new Scanner(System.in);
        for(Ennemy ennemie : ennemies)
        {
            int getDistance = (int) Math.sqrt(Math.pow(ennemie.getCordX() - e.getCordX(), 2) + Math.pow(ennemie.getCordY() - e.getCordY(), 2));
            if(getDistance < e.getArme().getRange())
            {
                inRange.add(ennemie);
                System.out.println("PV Restant : " + ennemie.getPointsDeVie());
                System.out.println(ennemies.size());
            }
        }
        if(isGameOver)
        {
            gameOver();
            return;
        }
        //System.out.println(isGameOver);
        if(ennemies.size() <= 0)
        {
            spawnEnnemy(3);
            placeEnnemy();
        }
        if (!laMap.isMerchantSequenceActivated()) {
            System.out.println(e.getPointsDeVie() + "HP | Arme " + e.getArme().getName() + " | " + e.getCoins() + " Coins");
            try {
                int response = scanner.nextInt();
                switch (response) {
                    case 1:
                        movePlayer(e.getCordX(), e.getCordY(), e.getCordX() + 1, e.getCordY());
                        update();
                        showMap();
                        break;
                    case 2:
                        movePlayer(e.getCordX(), e.getCordY(), e.getCordX(), e.getCordY() - 1);
                        update();
                        showMap();
                        break;
                    case 3:
                        movePlayer(e.getCordX(), e.getCordY(), e.getCordX(), e.getCordY() + 1);
                        update();
                        showMap();
                        break;
                    case 4:
                        movePlayer(e.getCordX(), e.getCordY(), e.getCordX() - 1, e.getCordY());
                        update();
                        showMap();
                        break;
                    case 5:
                        e.attaquer(inRange);
                        update();
                        showMap();
                        break;
                    case 6:
                        e.interagir();
                    case 7:
                        //sauvegarder
                        Writer saveFile = Saver.getSaver();
                        saveFile.write("HP:" + e.getPointsDeVie() + "\r\n");
                        saveFile.write("Coins:" + e.getCoins()+ "\r\n");
                        saveFile.write("Force:" + e.getForce() + "\r\n");
                        saveFile.write("range:" + e.getArme().getRange() + "\r\n");
                        saveFile.write("damage:" +e.getArme().getDamage()+ "\r\n");
                        saveFile.write("wname:" +e.getArme().getName() +"\r\n");
                        saveFile.close();

                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Invalide");
                        showMap();
                        break;
                }
            } catch (InputMismatchException | IOException e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Entrée invalide");
                getNextInput();
            }
        }
    }

    public static void showMap()
    {
        laMap.display();
        getNextInput();
    }

    public static void gameOver()
    {
        /** This function displays the game over screen. **/
        System.out.println(
                "#####################################\r\n" +
                        "#                                   #\r\n"+
                        "#              Game Over            #\r\n"+
                        "#                                   #\r\n"+
                        "#####################################"

        );
    }

    public static void update()
    {
       /** This function checks if player or enemy
         * is defeated and launches the merchant menu screen
         * if the player won. **/
        List<Ennemy> count = new ArrayList<>();

        if(e.getPointsDeVie() <= 0)
        {
            isGameOver = true;
            gameOver();
            return;
        }

        for(Ennemy ennemie : ennemies)
        {
            if(ennemie.getPointsDeVie() <= 0)
            {
                laMap.test[ennemie.getCordY()][ennemie.getCordX()] = ".";
                count.add(ennemie);
                e.setCoins(e.getCoins() + 11);
            }
            moveEnnemie(ennemie);
        }


        for(Ennemy current : count)
        {
            ennemies.remove(current);
        }
        count.clear();


        if(ennemies.isEmpty())
        {
            System.out.println("Vous avez gagné ce round");
            laMap.setMerchantSequenceActivated(true);
            Merchant marchand = new Merchant();
            ArrayList<Objet> selectedObjects = marchand.randomizedItemChoice();
            merchantSequence(marchand, selectedObjects);

        }
    }

    public static void merchantSequence(Merchant marchand, ArrayList<Objet> selectedObjects) {
        /** This function manages the merchant sequence
         * and checks if the player has enough coins when purchasing
         * an item.
         * @param marchand Merchant object
         * @param selectedObjects list of previously randomized object choice **/
        System.out.println("Bienvenue dans la boutique !");
        StringBuilder response = new StringBuilder();
        int i = 1;
        for (Objet current : selectedObjects) {
            response.append(i + " - " + current.getName() + " ("+  current.getPrice() + ") |" + current.getDescription() + "\r\n");
            i++;
        }
        System.out.println(response + "4 - Quitter la boutique \r\n");

        Scanner scanner = new Scanner(System.in);
        int playerResponse = scanner.nextInt();
        Objet playerItemChoice = null;
        switch (playerResponse) {
            case 1:
                playerItemChoice = selectedObjects.get(0);
                break;
            case 2:
                playerItemChoice = selectedObjects.get(1);
                break;
            case 3:
                playerItemChoice = selectedObjects.get(2);
                break;
            case 4:
                laMap.setMerchantSequenceActivated(false);
                break;
            default:
                merchantSequence(marchand, selectedObjects);
                break;
            }
            if(playerItemChoice != null)
            {
                int playerItemChoicePrice = playerItemChoice.getPrice(); // Price of the ITEM the player chose
                int playerCoinBalance = e.getCoins();                    // Player coins
                if (Merchant.buy(playerCoinBalance, playerItemChoice)) { // If enough coins
                    System.out.println("Item acheté !");
                    e.setCoins(playerCoinBalance - playerItemChoicePrice);// Updated player coins
                    if (playerItemChoice instanceof Weapon) {
                        e.setArme((Weapon) playerItemChoice);
                    } else {
                        e.setObjectInventory(playerItemChoice);
                    }
                } else {
                    System.out.println("Pas assez de coins :(");
                    merchantSequence(marchand, selectedObjects);
                }
            }
        System.out.println("A bientôt !");
        laMap.setMerchantSequenceActivated(false);
    }

    public static void movePlayer(int oldX, int oldY, int x, int y)
    {
        /** This function updates the player's symbol index
         * in the map array if the position is available.
         * @param oldX previous player X position
         * @param oldY previous player Y position
         * @param x new player X position
         * @param y new player Y position **/
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(laMap.test[y][x] == ".")
        {
            laMap.test[oldY][oldX] = ".";
            laMap.test[y][x] = e.getSymbole();
            e.setCord(x, y);
            System.out.println("Mouvement effectué");
        } else
        {
            System.out.println("Vous vous êtes hurter à un mur");
        }
    }

    public static void moveEnnemie(Ennemy ennemy)
    {
        /** This function manages enemy movement. **/
        Random random = new Random();
        int luck = random.nextInt(6);
        int getDistance = (int) Math.sqrt(Math.pow(ennemy.getCordX() - e.getCordX(), 2) + Math.pow(ennemy.getCordY() - e.getCordY(), 2));

        if(getDistance < ennemy.getArme().getRange()){
            ennemy.attaquer(e);
            return;
        }
        if(luck <= 3)
        {
            if(ennemy.getCordX() > e.getCordX())
            {
                if(laMap.test[ennemy.getCordY()][e.getCordX() -1] == ".")
                {
                    laMap.test[ennemy.getCordY()][ennemy.getCordX()] = ".";
                    laMap.test[ennemy.getCordY()][ennemy.getCordX() - 1] = ennemy.getSymbole();
                    ennemy.setCord(ennemy.getCordX() - 1, ennemy.getCordY());
                }
            } else if (ennemy.getCordX() < e.getCordX())
            {
                if(laMap.test[ennemy.getCordY()][e.getCordX() + 1] == ".") {
                    laMap.test[ennemy.getCordY()][ennemy.getCordX()] = ".";

                    laMap.test[ennemy.getCordY()][ennemy.getCordX() + 1] = ennemy.getSymbole();
                    ennemy.setCord(ennemy.getCordX() + 1, ennemy.getCordY());
                }
            } else if (ennemy.getCordY() > e.getCordY()){
                if(laMap.test[ennemy.getCordY() - 1][e.getCordX()] == ".") {
                    laMap.test[ennemy.getCordY()][ennemy.getCordX()] = ".";


                    laMap.test[ennemy.getCordY() - 1][ennemy.getCordX()] = ennemy.getSymbole();
                    ennemy.setCord(ennemy.getCordX(), ennemy.getCordY() - 1);
                }
            } else if (ennemy.getCordY() < e.getCordY())
            {
                if(laMap.test[ennemy.getCordY()+ 1][e.getCordX()] == ".") {
                    laMap.test[ennemy.getCordY()][ennemy.getCordX()] = ".";

                    laMap.test[ennemy.getCordY() + 1][ennemy.getCordX()] = ennemy.getSymbole();
                    ennemy.setCord(ennemy.getCordX(), ennemy.getCordY() + 1);
                }
            }
        }
    }

    public static void placePlayer(int x, int y)
    {
        /** This function adds the player in the map
         * and modifies its x y coordinates. 
         @param x coordinate X
         @param y coordinate Y **/
        laMap.spawn(x, y, e.getSymbole());
        e.setCord(x, y);
    }

public static void spawnEnnemy(int nbrEnnemy){
    /** This function creates new Enemies, sets their weapon
     * and health points for the current round and adds it
     * to the list of enemies. 
     @param nbrEnnemy number of desired enemies for this round **/
    for (int i = 0; i < nbrEnnemy ; i++) {
        Ennemy mechant = new Ennemy("nomDeMechant",100,1,"e", null, false, false);
        mechant.setArme(mechant.randomizedEnnemyWeapon());
        if(mechant.getArme().getRange() > 4)
        {
            mechant.setPointsDeVie(30);
        }
        System.out.println(mechant.getArme().getName());
        ennemies.add(mechant);
    }
}

public static void placeEnnemy()
{
    /** This function places all the enemies for
     * the current round at random coordinates on the map. **/
    for (Ennemy mechant : ennemies) {

        Random random = new Random();
        int xRandom = random.nextInt(2,20);
        int yRandom = random.nextInt(2,20);
        mechant.setCord(xRandom,yRandom);
        laMap.spawn(mechant.getCordX(), mechant.getCordY(), mechant.getSymbole());
    }
}

}

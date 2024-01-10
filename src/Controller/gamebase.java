package Controller;


import Model.Character.Ennemy;
import Model.Character.Personnage;
import Model.Character.Player;
import Model.map;

import java.util.*;

import static View.cli.displayMap;
import java.util.Random;

public class gamebase {

    public static ArrayList<Ennemy> ennemies = new ArrayList<Ennemy>();

    static map laMap = new map(22, 22);
    public static Player e = new Player("test", 100, 1, "p",null);

    public static void init()
    {
        laMap.generateMap();

        placePlayer(12, 12);
        //displayMap();
        spawnEnnemy(3);
        placeEnnemy();

        showMap();

    }

    public static void getNextInput()
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1 - Droite\r\n2 - Haut\r\n3 - Bas\r\n4 - Gauche");
            int response = scanner.nextInt();
            switch (response){
                case 1:
                    movePlayer(e.getCordX(), e.getCordY(), e.getCordX() + 1, e.getCordY());
                    showMap();
                    break;
                case 2:
                    movePlayer(e.getCordX(), e.getCordY(), e.getCordX(), e.getCordY() - 1);
                    showMap();
                    break;
                case 3:
                    movePlayer(e.getCordX(), e.getCordY(), e.getCordX(), e.getCordY() + 1);
                    showMap();
                    break;
                case 4:
                    movePlayer(e.getCordX(), e.getCordY(), e.getCordX() - 1, e.getCordY());
                    showMap();
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Invalide");
                    showMap();
                    break;
            }
        } catch (InputMismatchException e)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Entrée invalide");
            getNextInput();
        }
    }

    public static void showMap()
    {
        laMap.display();
        getNextInput();
    }

    public static void movePlayer(int oldX, int oldY, int x, int y)
    {
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
        laMap.display();
    }

    public static void placePlayer(int x, int y)
    {
        laMap.spawn(x, y, e.getSymbole());
        e.setCord(x, y);
    }

public static void spawnEnnemy(int nbrEnnemy){

    for (int i = 0; i < nbrEnnemy ; i++) {
        Ennemy mechant = new Ennemy("nomDeMechant",100,1,"e",null, false, false);
        ennemies.add(mechant);
    }
}

public static void placeEnnemy()
{
    for (Ennemy mechant : ennemies) {

        Random random = new Random();
        int xRandom = random.nextInt(20);
        int yRandom = random.nextInt(20);
        laMap.spawn(xRandom,yRandom, mechant.getSymbole());
        mechant.setCord(xRandom,yRandom);
    }
}





}
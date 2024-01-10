package Controller;


import Model.Character.Ennemy;
import Model.Character.Personnage;
import Model.Character.Player;
import Model.map;

import java.util.ArrayList;
import java.util.Collection;

import static View.cli.displayMap;
import java.util.Random;

public class gamebase {


    static map laMap = new map(22, 22);
    public static Player e = new Player("test", 100, 1, "p",null, 0);

    public static void init()
    {
        laMap.generateMap();

        placePlayer(12, 12);
        //displayMap();
        spawnEnnemy(3);
        placeEnnemy();

        laMap.display();


    }

    public static void placePlayer(int x, int y)
    {
        laMap.spawn(x, y, e.getSymbole());
        e.setCord(x, y);
    }

    public static ArrayList<Ennemy> ennemies = new ArrayList<Ennemy>();

    public static void spawnEnnemy(int nbrEnnemy){

        for (int i = 0; i < nbrEnnemy ; i++) {
            Ennemy mechant = new Ennemy("nomDeMechant",100,1,"X",null,false,false);
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

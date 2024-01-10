package Controller;

import Model.Character.Personnage;
import Model.Character.Player;
import Model.map;

import java.util.ArrayList;
import java.util.Collection;

import static View.cli.displayMap;

public class gamebase {


    static map laMap = new map(22, 22);
    public static Player e = new Player("test", 100, 1, "p",null);

    public static void init()
    {
        laMap.generateMap();

        laMap.spawn(12, 12, e.getSymbole());
        e.setCord(12, 12);
        laMap.display();
        //displayMap();
    }

    public static void placePlayer(int x, int y)
    {
    }


}

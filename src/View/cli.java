package View;


import Controller.gamebase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Controller.gamebase.init;


public class cli {

    public static void startMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Jouer \r\n2 - Charger\r\n3 - Quitter");
        try {
            int response = scanner.nextInt();
            switch (response){
                case 1:
                    System.out.println("Vous jouez");
                    try {
                        init();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try
                    {
                        gamebase.isSaved = true;
                        init();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Invalide");
                    startMenu();
                    break;
            }
        } catch (InputMismatchException e)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Entrée invalide");
            startMenu();
        }
    }

    public static void displayMap()
    {
        System.out.println(
                "       ######################\r\n" +
                "       #....................#\r\n" +
                "       #....................#\r\n" +
                "       #....................#\r\n" +
                "       #....................#\r\n" +
                "       #....................#\r\n" +
                "       #....................#\r\n" +
                "       ######################\r\n" +
                "    100HP | Items | x restant | Objets\r\n" +
                "1 - attaquer"
        );
    }
}

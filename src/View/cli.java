package View;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Controller.gamebase.init;


public class cli {

    public static void startMenu()
    {
        /** This function displays the start menu
         * and manages player input accordingly. **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Jouer \r\n2 - Quitter");
        try {
            int response = scanner.nextInt();
            switch (response){
                case 1:
                    System.out.println("Vous jouez");
                    init();
                    break;
                case 2:
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

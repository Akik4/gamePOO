package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Saver {

    public static boolean CreateFile() throws IOException {
        if(isFileNotExist())
        {
            File newFile = new File("save.txt");
            boolean success = newFile.createNewFile();
            return success;
        }
        return false;
    }

    protected static boolean isFileNotExist()
    {
        File newFile = new File("save.txt");
        return !newFile.exists();
    }

    public static Scanner readFile() throws FileNotFoundException {
        File newFile = new File("save.txt");
        Scanner myFile = new Scanner(newFile);
//        while (myFile.hasNextLine())
//        {
//            System.out.println(myFile.nextLine());
//        }
        return(myFile);
    }

    public static void loadSave()
    {

    }

    public static FileWriter getSaver() throws IOException {
        File newFile = new File("save.txt");
        return new FileWriter(newFile);
    }
}

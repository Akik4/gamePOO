package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Saver {

    public static boolean CreateFile() throws IOException {
        /** This function verifies if the save.txt
         * file can be opened succesfully.
         * @return boolean true if file opened successfully **/
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
        /** This function verifies the save.txt
         * file exists.
         * @return boolean true if file found **/
        File newFile = new File("save.txt");
        return !newFile.exists();
    }

    public static Scanner readFile() throws FileNotFoundException {
        /** This function reads the entire file and
         * returns it.
         @return (myFile) content of the save.txt file **/
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
        /** This function creates a FileWriter object to
         * access the file in write mode.
         * @return FileWriter(newFile) FileWriter object **/
        File newFile = new File("save.txt");
        return new FileWriter(newFile);
    }
}

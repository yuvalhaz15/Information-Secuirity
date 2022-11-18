import java.io.*;
import java.util.*;

public class Main {
    private static String readString(String file) {//convert file to a long String
        String text = "";
        try {
            Scanner s = new Scanner (new File(file));
            s.nextLine();
            while (s.hasNextLine()) {
                text+=s.nextLine()+ "\t";
            }
        }
        catch (FileNotFoundException e) {//Throw an exception if the file is not found
            System.out.println("file "+ file + " not found");
        }
        return text;
    }
    public static  String[] createFile (String file) {
        String text = readString(file);
        return text.split("\t");
    }


    public static void main(String[] args) throws IOException {

        String check="a-b\r\nb-c\r\nc-c";
        System.out.println(readString("src/myKey.txt"));
        System.out.println(check);
    }
}
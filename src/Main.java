import java.io.*;
import java.util.*;

public class Main {
    private static String readString(String file) {//convert file to a long String
        String text = "";
        try {
            Scanner s = new Scanner(new File(file));

            while (s.hasNextLine()) {
                text += s.nextLine() + "\t";
            }
        } catch (FileNotFoundException e) {//Throw an exception if the file is not found
            System.out.println("file " + file + " not found");
        }
        return text;
    }

    public static String[] createFile(String file) {
        String text = readString(file);
        return text.split("\t");
    }


    public static void main(String[] args) throws IOException {

        String check = "a-b\r\nb-c\r\nc-c";
        String fileString = readString("src/myKey.txt");
//        System.out.println(fileString);

        String checkChiper = CipherBlockChaining.encrypt("ABCDQRSTA", "0000000000", fileString);
        System.out.println(checkChiper);
//
//        HashMap<Character, Character> keyDictonary = new HashMap<Character, Character>();
//        for (char ch = 'a'; ch <= 'z'; ++ch)
//            keyDictonary.put(ch, ch);
//        for (char ch = 'A'; ch <= 'Z'; ++ch)
//            keyDictonary.put(ch, ch);
//
//
//        for (Map.Entry<Character, Character> set : keyDictonary.entrySet())
//            System.out.println(set.getKey() + " - " + set.getValue());


    }

}

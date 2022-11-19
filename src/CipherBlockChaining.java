

import java.io.*;
import java.util.*;
public class CipherBlockChaining {
   private static HashMap<Character, Character> keyDictonary = new HashMap<Character, Character>();
   private static String chiperText="";
    private static String readString(String file) {//convert file to a long String
        String text = "";
        try {
            Scanner s = new Scanner (new File(file));
            while (s.hasNextLine()) {
                text+=s.nextLine()+ "\t";
            }
        }
        catch (FileNotFoundException e) {//Throw an exception if the file is not found
            System.out.println("file "+ file + " not found");
        }
        return text;
    }
    private static  String[] createFile (String file) {
        String text = readString(file);
        return text.split("\t");
    }
    private static void initWithAllEnglishLetters() {
        for (char ch = 'a'; ch <= 'z'; ++ch)
            keyDictonary.put(ch, ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            keyDictonary.put(ch, ch);
    }

    private static void initMapDictanory(String key) {
        initWithAllEnglishLetters();
        for (int i = 0; i < key.length(); i += 4)
            keyDictonary.replace(key.charAt(i), key.charAt(i+2));


    }



    private static void makeXorBetweenPlainTextAndVectorIv( String plain_text, String init_vector) {
     for (int i=0;i<plain_text.length();i++)
     chiperText+= (char) ((int) plain_text.charAt(i) ^ (int) init_vector.charAt(i));



    }
    private static void useKeyToCreateFinalCipherText() {
        String replacedChiperText="";
        for (int i=0;i<chiperText.length();i++)
            replacedChiperText+=keyDictonary.get(chiperText.charAt(i));
        chiperText=replacedChiperText;

    }
    public static String encrypt(String plain_text, String init_vector, String key){

        initMapDictanory(key);
        makeXorBetweenPlainTextAndVectorIv(plain_text,init_vector);
        useKeyToCreateFinalCipherText();

        return chiperText ;
    }




}

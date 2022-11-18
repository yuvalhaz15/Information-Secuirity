

import java.io.*;
import java.util.*;
public class CipherBlockChaining {

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

    private static void initMapDictanory(String key, HashMap<Character, Character> keyDictonary) {
        for (char ch = 'a'; ch <= 'z'; ++ch)
            keyDictonary.put(ch, ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            keyDictonary.put(ch, ch);



    }
    private static void makeXorBetweenPlainTextAndVectorIv(String chiperText, String plain_text, String init_vector) {
     for (int i=0;i<plain_text.length();i++){
     chiperText+= (char) ((int) plain_text.charAt(i) ^ (int) init_vector.charAt(i));

     }

    }
    private static void useKeyToCreateFinalCipherText(String chiperText, String init_vector, String key) {
    }
    public static String encrypt(String plain_text, String init_vector, String key){
        String chiperText="";
        HashMap<Character, Character> keyDictonary = new HashMap<Character, Character>();

        initMapDictanory(key,keyDictonary);
        makeXorBetweenPlainTextAndVectorIv(chiperText,plain_text,init_vector);
        useKeyToCreateFinalCipherText(chiperText,init_vector,key);

        return chiperText ;
    }




}

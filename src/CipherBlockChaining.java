

import java.io.*;
import java.util.*;

public class CipherBlockChaining {
    private static HashMap<Character, Character> encryptKeyDictonary = new HashMap<Character, Character>();
    private static HashMap<Character, Character> decryptKeyDictonary = new HashMap<Character, Character>();
    private static String chiperText = "";
    private static String plainText = "";

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

    private static String[] createFile(String file) {
        String text = readString(file);
        return text.split("\t");
    }

    private static void initWithAllEnglishLetters(HashMap<Character, Character> keyDictonary) {
        for (char ch = 'a'; ch <= 'z'; ++ch)
            keyDictonary.put(ch, ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            keyDictonary.put(ch, ch);
    }

    private static void initMapDictanory(String key, HashMap<Character, Character> keyDictonary) {
        initWithAllEnglishLetters(keyDictonary);
        for (int i = 0; i < key.length(); i += 4)
            keyDictonary.replace(key.charAt(i), key.charAt(i + 2));


    }

    private static String makeXorBetweenTextAndVectorIv(String text, String init_vector) {
        String xorText = "";
        for (int i = 0; i < text.length(); i++)
            xorText += (char) ((int) text.charAt(i) ^ (int) init_vector.charAt(i));

        return xorText;

    }


    private static String textReplacmentByKey(String text, HashMap<Character, Character> keyDictonary) {
        String replacedChiperText = "";

        for (int i = 0; i < text.length(); i++)
            replacedChiperText += keyDictonary.get(text.charAt(i));

        return replacedChiperText;
    }

    public static String encrypt(String plain_text, String init_vector, String key) {

        initMapDictanory(key, encryptKeyDictonary);
        chiperText = makeXorBetweenTextAndVectorIv(plain_text, init_vector);
        chiperText = textReplacmentByKey(chiperText, encryptKeyDictonary);
        return chiperText;
    }

    public static String decrypt(String encrypted_text, String init_vector, String key) {
        initMapDictanory(key, decryptKeyDictonary);
        plainText = textReplacmentByKey(encrypted_text, decryptKeyDictonary);
        plainText = makeXorBetweenTextAndVectorIv(plainText, init_vector);
        return plainText;
    }


}






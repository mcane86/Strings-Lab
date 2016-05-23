package Tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyStringUtils {

    public static Date convertStringToDate(String strToBeConverted) throws Exception {
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        try{
            return df.parse(strToBeConverted);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public static char convertStringToChar(String strToBeConverted) {
        return strToBeConverted.charAt(0);
    }

    public static boolean convertStringToBoolean(String strToBeConverted) {
        return Boolean.parseBoolean(strToBeConverted);
    }

    public static String convertArrayToString(String[] array) {
        String joinedArray = String.join(",", array);
        return joinedArray;
    }

    public static String[] convertStringToArray(String string) {
        String[] array = string.split("\n");
        return array;
    }

    public String capitalSwapper(String string) {
        String[] list = string.split(" ");
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i].substring(0,1).toLowerCase() + list[i].substring(1).toUpperCase();
        }
        String newString = String.join(" ", list);
        return newString;
    }

    public String wordReverser(String string) {
        String[] list = string.split(" ");
        for (int i = 0; i < list.length; i++) {
            StringBuilder str = new StringBuilder(list[i]);
            list[i] = String.valueOf(str.reverse());
        }
        String newString = String.join(" ", list);
        return newString;
    }

    public String replaceTheWhites(String string) {
        String newString = string.replaceAll("\\s", "\n");
        return newString;
    }

    public ArrayList<String> everyPossibleSubstring(String string) {
        ArrayList<String> substringList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = string.length(); j > i; j--) {
                String substring = string.substring(i,j);
                substringList.add(substring);
            }
        }
        return substringList;
    }
}

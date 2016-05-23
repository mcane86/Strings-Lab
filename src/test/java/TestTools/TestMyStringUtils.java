package TestTools;

import Tools.MyStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestMyStringUtils {

    String[] test = new String[4];

    MyStringUtils myStringUtils;
    @Before public void setupInit() {
        myStringUtils = new MyStringUtils();
        test[0] = "1";
        test[1] = "2";
        test[2] = "3";
        test[3] = "4";
    }

    @Test
    public void testConvertArrayToString() {
        String expected = "1,2,3,4";
        String actual = myStringUtils.convertArrayToString(test);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertStringToArray() {
        String testString = "1\n2\n3\n4";
        String expected = "1";
        String actual = myStringUtils.convertStringToArray(testString)[0];
        assertEquals(expected, actual);
    }

    @Test
    public void testCapitalSwapper() {
        String testString = "My Name Is Kiiiiid";
        String expected = "mY nAME iS kIIIIID";
        String actual = myStringUtils.capitalSwapper(testString);
        assertEquals(expected, actual);
    }

    @Test
    public void testWordReverser() {
        String testString = "My Name Is Kiiiiid";
        String expected = "yM emaN sI diiiiiK";
        String actual = myStringUtils.wordReverser(testString);
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceTheWhites() {
        String testString = "Kid Rockin' up and down the block.";
        String expected = "Kid\nRockin'\nup\nand\ndown\nthe\nblock.";
        String actual = myStringUtils.replaceTheWhites(testString);
        assertEquals(expected, actual);
    }

    @Test
    public void testEveryPossibleSubstring() {
        String testString = "dove";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("dove", "dov", "do", "d", "ove", "ov", "o", "ve", "v", "e"));
        ArrayList<String> actual = myStringUtils.everyPossibleSubstring(testString);
        assertEquals(expected, actual);
    }
}

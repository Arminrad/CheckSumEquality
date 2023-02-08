import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

class CheckSumEqualityTest {

    String[] inputString = {"2", "4", "7", "3", "6", "9", "7", "2", "23", "15"};
    Integer sumEquality = 9;
    Integer[] nums = new Integer[inputString.length];
    HashSet<Integer> numSet = new HashSet<Integer>();
    HashMap<Integer, Integer> equalPair = new HashMap<Integer, Integer>();

    @Test
    public void testStringToIntAndAddToSet() throws CheckEqualityExceptions {
        Integer[] testNums = {2, 4, 7, 3, 6, 9, 7, 2, 23, 15};
        HashSet<Integer> testNumSet = new HashSet<>(Arrays.asList(2, 3, 4, 6, 7, 9, 15, 23));
        CheckSumEquality.stringToIntAndAddToSet(nums, inputString, numSet);
        assertEquals(nums, testNums);
        Assertions.assertEquals(numSet, testNumSet);
    }

    @Test
    public void testCheckEquality() throws CheckEqualityExceptions {
        HashMap<Integer, Integer> testEqualPair = new HashMap<>();
        testEqualPair.put(2, 7);
        testEqualPair.put(3, 6);
        CheckSumEquality.stringToIntAndAddToSet(nums, inputString, numSet);
        CheckSumEquality.checkEquality(nums, equalPair, numSet, sumEquality);
        Assertions.assertEquals(equalPair, testEqualPair);
    }
}
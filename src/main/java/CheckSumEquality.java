import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CheckSumEquality {

    private static Boolean exceptionFlag = false;

    public static void main(String[] args) throws CheckEqualityExceptions {

        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> numSet = new HashSet<>();
        HashMap<Integer, Integer> equalPair = new HashMap<>();
        Integer[] nums;
        do {
            exceptionFlag = false;
            System.out.println("Enter your list of numbers: ");
            String input = scanner.nextLine();
            String[] inputString = input.split("[\\s,]+");
            nums = new Integer[inputString.length];
            stringToIntAndAddToSet(nums, inputString, numSet);
        } while (exceptionFlag);
        System.out.println("compare the sum value with: ");
        int sumEquality = scanner.nextInt();

        checkEquality(nums, equalPair, numSet, sumEquality);
        printResult(equalPair, sumEquality);
    }

    public static void stringToIntAndAddToSet(Integer[] nums, String[] inputString, HashSet<Integer> numSet) throws CheckEqualityExceptions {
        for (int i = 0; i < nums.length; i++) {
            try {
                nums[i] = Integer.parseInt(inputString[i]);
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
                exceptionFlag = true;
            }
            numSet.add(nums[i]);
        }
    }

    public static void checkEquality(Integer[] nums, HashMap<Integer, Integer> equalPair, HashSet<Integer> numSet, Integer sumEquality) {
        for (Integer num : nums) {
            int remainder = sumEquality - num;
            if (numSet.contains(remainder) && !equalPair.containsValue(num) && !equalPair.containsKey(remainder)) {
                equalPair.put(num, remainder);
            }
        }
    }

    public static void printResult(HashMap equalPair, int sumEquality) {
        System.out.println("The sum of these numbers in your list is equal to " + sumEquality + ":");
        for (Object key : equalPair.keySet()) {
            String firstNum = String.valueOf(key);
            String secondNum = String.valueOf(equalPair.get(key));
            System.out.println(firstNum + " " + secondNum);
        }
    }
}
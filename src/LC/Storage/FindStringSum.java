package LC;// Java program to find sum of two large numbers.
import java.util.*;
import LC.*;


public class FindStringSum
{
    // Function for finding sum of larger numbers
    public static String findSum(String str1, String str2)
    {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        String str = "";

        // Calculate lenght of both String
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++)
        {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((int)(str1.charAt(i) - '0') +
                    (int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');

            // Calculate carry for next step
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++)
        {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str += (char)(carry + '0');

        // reverse resultant String
        str = new StringBuilder(str).reverse().toString();

        return str;
    }
    public static boolean isPalindrome(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }


    // Driver code
    public static void main(String[] args)
    {
        String str1 = "1222542345098767546725";
        String str2 = "19811123452453";
        int a = 1211;
        System.out.println(isPalindrome(a));
        System.out.println(findSum(str1, str2));
        System.out.println('\0');
    }
}
// This code is contributed by mits
package task0606_integer_to_digits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Integer to digits;
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        String number = String.valueOf(num);
        for (int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}

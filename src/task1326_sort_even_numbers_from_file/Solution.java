package task1326_sort_even_numbers_from_file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> num = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            String fileName = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedReader input = new BufferedReader(new InputStreamReader(fileInputStream));

            String data;
            try {

                while ((data = input.readLine()) != null) {
                    int number = Integer.parseInt(data);
                    if (number % 2 == 0) {
                        num.add(number);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Collections.sort(num);

            for (Integer integer : num) {
                System.out.println(integer);
            }

            reader.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

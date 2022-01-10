package task0712_longest_or_shortest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Longest or shortest
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> lista = new ArrayList<>(10);
        ArrayList<Integer> dlugosc = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            String ciag = reader.readLine();
            lista.add(ciag);
            dlugosc.add(ciag.length());
        }

        int min = dlugosc.get(0);
        int max = min;

        for (int zapas : dlugosc) {
            if (zapas < min) {
                min = zapas;
            } else if (zapas > max) {
                max = zapas;
            }
        }
        if (dlugosc.indexOf(max) < dlugosc.indexOf(min)) {
            System.out.println(lista.get(dlugosc.indexOf(max)));
        } else {
            System.out.println(lista.get(dlugosc.indexOf(min)));
        }
    }
}


package task0716_r_or_l;

import java.util.ArrayList;

/*
R or L
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("rosa");
        lista.add("luz");
        lista.add("lira");
        napraw(lista);

        for (String s : lista) {
            System.out.println(s);
        }
    }

    public static void napraw(ArrayList<String> lista) {
        ArrayList<String> newList = new ArrayList<>(lista);
        for (String s : newList) {
            if (s.contains("r") && !s.contains("l")) {
                lista.remove(s);
            } else if (s.contains("l") && !s.contains("r")) {
                lista.add(s);
            }
        }
    }
}

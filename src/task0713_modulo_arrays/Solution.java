package task0713_modulo_arrays;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> lista0 = new ArrayList<>();
        ArrayList<Integer> podzielnePrzez3 = new ArrayList<>();
        ArrayList<Integer> podzielnePrzez2 = new ArrayList<>();
        ArrayList<Integer> reszta = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            lista0.add(Integer.parseInt(reader.readLine()));
        }
        for (Integer integer : lista0) {
            if (integer % 3 == 0) {
                podzielnePrzez3.add(integer);
            }
            if (integer % 2 == 0) {
                podzielnePrzez2.add(integer);
            } else if (integer % 3 != 0){
                reszta.add(integer);
            }
        }
        printLista(podzielnePrzez3);
        printLista(podzielnePrzez2);
        printLista(reszta);
    }
    public static void printLista (List<Integer> lista) {
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }

}

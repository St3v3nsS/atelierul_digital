package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void createFizzBuzz(){

        String s="";
        int valueMax = 100;
        for(int i = 1; i <= valueMax; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                s += "Fizz Buzz, ";
            } else if (i % 3 == 0) {
                s += "Fizz, ";
            } else if (i % 5 == 0) {
                s += "Buzz, ";
            } else {
                s += i;
                s+= ", ";
            }
        }

        System.out.println(s);
    }

    public static void find2pairs(){

        int[] arr = {3, 2 , -3, -2, 3, 0};

        Arrays.sort(arr);

        int i = 0, j = arr.length - 1;

        HashMap<pereche, Integer> hash = new HashMap<pereche, Integer>();


        while(i < j){
            if(arr[i] == -1*arr[j]){
                pereche a = new pereche(arr[i], arr[j]);
                hash.put(a, 1);
                i++;
                j--;

            }
            else{
                if(arr[i] < arr[j]){
                    j--;
                }
                else{
                    i++;
                }
            }
        }

        System.out.println("There are " + hash.size() +" pairs!");

        //  Print the pairs
       System.out.println(hash);

    }

    public static void find3(){
        int[] arr = {3, -2, -1, -3, 3, 0, 5};

        Arrays.sort(arr);

        HashMap<triplet, Integer> hash = new HashMap<>();


        int i = 0, j = arr.length - 1, k;
        while(i < j){
            k = i+1;
            j = arr.length - 1;
            while(k < j){
                if(arr[i] + arr[k] + arr[j] == 0){
                    pereche a = new pereche(arr[i], arr[k]);
                    triplet tr = new triplet(a, arr[j]);
                    hash.put(tr, 1);
                    j--;
                    k++;
                }
                else{
                    if(arr[i] + arr[k] + arr[j] > 0){
                        j--;
                    }
                    else{
                        k++;
                    }
                }
            }
            i++;
        }

        System.out.println("There are " + hash.size() + " pairs!");
        System.out.println(hash);
    }

    public static void main(String[] args) {

       //createFizzBuzz();
       //find2pairs();
       find3();
    }
}

package com.company;

public class triplet {

    private pereche first;
    private int second;

    public triplet(pereche a, int b){
        first = a;
        second = b;
    }

    public void setFirst(int a, int b){
        first.setFirst(a);
        first.setSecond(b);
    }

    public void setSecond(int a){
        second = a;
    }

    @Override
    public String toString(){
        String s = "(" + first.getFirst() + ", " + first.getSecond() + ", " + second + ")";
        return s;
    }
}

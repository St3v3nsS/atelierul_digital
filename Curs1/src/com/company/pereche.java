package com.company;

public class pereche {

    private int first;
    private int second;

    public pereche(int a, int b){
        this.first = a;
        this.second = b;
    }


    public pereche() {}

    public int getFirst(){
        return this.first;
    }

    public int getSecond(){
        return this.second;
    }

    public void setFirst(int a){
        this.first = a;
    }

    public void setSecond(int b){
        this.second = b;
    }

    @Override
    public String toString(){
        String s = "(" + first + ", " + second + ")";
        return s;
    }
}

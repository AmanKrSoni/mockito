package com.cvt.powermock;

public class UtilClass {

    static String getToUpperCase(String s){
    return s.toUpperCase();}

    private String getToLowerCase(String s){
        return ""+s.toLowerCase();
    }

    public String lower(String s){
        return "Hello "+ getToLowerCase(s);
    }

    final void get(String s){
        System.out.println(s);
    }
}
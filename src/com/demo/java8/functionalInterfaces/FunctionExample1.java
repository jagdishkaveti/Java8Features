package com.demo.java8.functionalInterfaces;

public class FunctionExample1 {

    public String appendDefault(String input){

        return FunctionExample.addSomeString.apply(input);
    }

    public static void main(String[] args) {

    }

}

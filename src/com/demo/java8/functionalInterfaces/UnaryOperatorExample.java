package com.demo.java8.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");



    public static void main(String[] args) {
        String s = "Test";

        System.out.println(unaryOperator.apply("java8"));

        unaryOperator.apply(s);
        System.out.println(s);


    }
}

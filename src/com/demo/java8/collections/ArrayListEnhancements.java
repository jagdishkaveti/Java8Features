package com.demo.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayListEnhancements {

    static List<String> names = Arrays.asList("Dave", "Jessie", "Alex", "Dan");




   static void listForEach(){

       List<String> namesList = new ArrayList<String>();

       for(String name : names){
           System.out.println(name);
       }

       names.forEach(name -> { System.out.println(name); });

       String[] namesArr = (String[])names.toArray();
       for(int i= 0 ;i<namesArr.length;i++){
           System.out.println(namesArr[i]);
       }

       AtomicInteger atomicInteger = new AtomicInteger(0);
       System.out.println(atomicInteger.getAndIncrement());
       System.out.println(atomicInteger.intValue());


       for(String s : names){
           System.out.println(s);
       }
       names.forEach((s) -> System.out.println(s));

       names.forEach(s -> System.out.println(s));

       names.forEach(name -> namesList.add(name));

       List<String> strings = Arrays.asList("one", "two","three","four");
       AtomicInteger count= new AtomicInteger();

       strings.forEach((name) -> {
           System.out.println("name : " + name);
           System.out.println(count.getAndIncrement());
       });


   }

    static void replaceAll(){

        for(String s : names){
            System.out.println(s);
        }
    }


    public static void main(String[] args) {


        listForEach();

    }
}

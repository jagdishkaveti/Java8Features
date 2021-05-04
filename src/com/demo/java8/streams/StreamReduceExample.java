package com.demo.java8.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class StreamReduceExample {

    public static int performMultiplication(List<Integer> integerList){

        int[] intArray = { 10,10,20,20,20,30,30,30,30};

        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(30);
        arrayList.add(30);
        arrayList.add(30);

        arrayList.stream().distinct().map(x->x*x).forEach(x-> System.out.println(x));



        return integerList.stream()
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b); // performs multiplication for each element in the stream and returns a new result fo.
    }

    public static String combineStudentNames(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .reduce("",(a,b) -> a.concat(b));  // performs multiplication for each element in the stream.
    }

    public static Optional<Student> getHighestGradeStudent(){

        Optional<Student> studentOptional =  StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
        return studentOptional;
    }




    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        System.out.println(str3==str2);
        System.out.println(str1.equals(str3));

        List<Integer> integerList = Arrays.asList(1,3,5,7);
        //List<Integer> integerList = Arrays.asList();

        System.out.println("Result is : " + performMultiplication(integerList));
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }

        System.out.println(combineStudentNames());
        System.out.println(getHighestGradeStudent().get());
    }
}

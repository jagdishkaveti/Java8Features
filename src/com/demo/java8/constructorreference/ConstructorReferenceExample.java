package com.demo.java8.constructorreference;

import com.learnJava.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    // Normal Function
    static Function<String, Student> studentFunctionNormal = name -> { return new Student(name); };

    //Function with Constructor Reference
    static Function<String, Student> studentFunction = Student::new;

    static Function<String, Student> newStudentFunction = Student::new;

    //Student student = Student::new;

    public static void main(String[] args) {

//        System.out.println(studentSupplier.get());

        System.out.println(studentFunctionNormal.apply("Normal Way of Student Creation"));

        System.out.println(studentFunction.apply("Client123"));


    }
}

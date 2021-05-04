package com.demo.java8.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>>  function = (students -> {

        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {

            if(PredicateStudentExample.p1.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }
        });

        return studentGradeMap;

    });

    public static void main(String[] args) {

        System.out.println(function.apply(StudentDataBase.getAllStudents()));

        Predicate<Student> studentPredicate = student -> student.getGpa()>3;
        System.out.println(studentPredicate.test(new Student("testStudent")));

    }
}

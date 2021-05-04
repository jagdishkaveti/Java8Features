package com.demo.java8.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGradeLevel()>=3.9;

/*
        List<String> names = Arrays.asList("adam","dan","jenny");
        names.stream();
        names.parallelStream();
        StudentDataBase.getAllStudents().stream();
        StudentDataBase.getAllStudents().parallelStream();
*/

        StudentDataBase.getAllStudents().stream().filter(s->s.getGradeLevel()>2).collect(Collectors.toList()).forEach(student -> System.out.println(student));


        System.out.println("**********Practice ***********");

        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);



        Predicate<Student> gradePredicateNew =  student -> student.getGradeLevel() >2;
        StudentDataBase.getAllStudents().stream().filter(gradePredicateNew).sorted(nameComparator).collect(Collectors.toList()).forEach(student -> System.out.println(student));
        Optional<Student> maxGradeStudent =  StudentDataBase.getAllStudents().stream().reduce((s1, s2)-> s1.getGradeLevel()>s2.getGradeLevel()?s1:s2);
        System.out.println("Max Grade Student is : "+ maxGradeStudent.get());


        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().stream(). //.parallelStream dont forger.
                filter(gpaPredicate) // Stream<Student>
                .collect(Collectors.toMap(Student::getName ,Student::getActivities ));

        System.out.println("studentMap  : " + studentMap);

        List<String> studentActivities = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .map(Student::getActivities) //<Stream<List<Activites>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((student -> {
                    System.out.println(student);
                }))
                .map(Student::getName) //<Stream<List<Activites>>
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);


    }
}

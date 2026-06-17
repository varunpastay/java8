package com.notes;
import java.util.*;

//Student Class
class Student {
 int id;
 String name;
 double salary;

 Student(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 @Override
 public String toString() {
     return "ID = " + id + ", Name = " + name + ", Salary = " + salary;
 }
}

//Sort by ID
class IdComparator implements Comparator<Student> {
 @Override
 public int compare(Student s1, Student s2) {
     return s1.id - s2.id;
 }
}

//Sort by Name
class NameComparator implements Comparator<Student> {
 @Override
 public int compare(Student s1, Student s2) {
     return s1.name.compareTo(s2.name);
 }
}

//Sort by Salary
class SalaryComparator implements Comparator<Student> {
 @Override
 public int compare(Student s1, Student s2) {

     if (s1.salary > s2.salary)
         return 1;
     else if (s1.salary < s2.salary)
         return -1;
     else {
         return 0;
         }
 }
}

public class demo {
 public static void main(String[] args) {

     LinkedList<Student> list = new LinkedList<>();

     list.add(new Student(103, "Varun", 30000));
     list.add(new Student(101, "Arun", 25000));
     list.add(new Student(106, "Prajwal", 45000));
     list.add(new Student(102, "Vinod", 20000));
     list.add(new Student(105, "Abhi", 35000));
     list.add(new Student(104, "Sanjay", 40000));

     System.out.println("Original List:");
    for (Student s : list) {
         System.out.println(s);
     }

     Collections.sort(list, new IdComparator());
     System.out.println("\nSorted By ID:");
     for (Student s : list) {
         System.out.println(s);
     }

     Collections.sort(list, new NameComparator());
     System.out.println("\nSorted By Name:");
     for (Student s : list) {
         System.out.println(s);
     }

     Collections.sort(list, new SalaryComparator());
     System.out.println("\nSorted By Salary:");
     for (Student s : list) {
         System.out.println(s);
     }

     list.remove(2); // removes 3rd element

     System.out.println("\nAfter Removing 3rd Element:");
     for (Student s : list) {
         System.out.println(s);
     }
 }
}
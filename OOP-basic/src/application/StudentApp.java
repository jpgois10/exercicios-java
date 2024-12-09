package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.print("Enter student name: ");
        student.name = sc.nextLine();
        System.out.print("Enter grade 1: ");
        student.grade1 = sc.nextDouble();
        System.out.print("Enter grade 2: ");
        student.grade2 = sc.nextDouble();
        System.out.print("Enter grade 3: ");
        student.grade3 = sc.nextDouble();

        if (student.finalGrade() < 60.0) {
            System.out.printf("\nFINAL GRADE = %.2f", student.finalGrade());
            System.out.println(" FAILED");
            System.out.printf("MISSING %.2f POINTS", student.missingGrade());
        } else {
            System.out.printf("FINAL GRADE = %.2f", student.finalGrade());
            System.out.println(" PASS");
        }

        sc.close();
    }
}
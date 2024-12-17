/*Em um portal de cursos online, cada usuário possui um código único, representado por
 um número inteiro.
 Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se
 matricular em quantos cursos quiser. Assim, o número total de alunos de um instrutor não
 é simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
 alunos repetidos em mais de um curso.
 O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
 Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
 quantidade total e alunos dele*/

package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> list = new HashSet<>();
        int totalCourses = 3;

        for (int i = 0; i < totalCourses; i++) {
            String courseQuestion = "";
            if (i == 0) courseQuestion = ("How many students for course A? ");
            if (i == 1) courseQuestion = ("How many students for course B? ");
            if (i == 2) courseQuestion = ("How many students for course C? ");

            System.out.print(courseQuestion);
            int numberOfStudents = sc.nextInt();
            for (int j = 0; j < numberOfStudents; j++) {
                int student = sc.nextInt();
                list.add(student);
            }
        }

        System.out.println("Total sudents: " + list.size());

        sc.close();
    }
}

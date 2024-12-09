/*Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários.*/


package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> totalEmployees = new ArrayList<>();

        System.out.print("Hom many employees will be registered? ");
        int numberEmployees = sc.nextInt();

        for (int i = 0; i < numberEmployees; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();
//          Evitando a repetição de Id
            while(hasId(totalEmployees, id)) {
                System.out.print("Id is already taken. Try again: ");
                id = sc.nextInt();
            }

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee employee = new Employee(id, name, salary);
            totalEmployees.add(employee);
        }

        System.out.print("\nEnter the employee id that will have the salary increase: ");
        int idSalaryIncrease = sc.nextInt();

//        Integer positionId = position(totalEmployees, idSalaryIncrease);

        Employee emp = totalEmployees.stream().filter(x -> x.getId() == idSalaryIncrease).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
//            totalEmployees.get(positionId).salaryIncrease(percent);
            emp.salaryIncrease(percent);
        }

        System.out.println("\nList of employees: ");
        for (Employee employee : totalEmployees) {
            System.out.println(employee);
        }

        sc.close();
    }

//    public static Integer position(List<Employee> list, int id) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return null;
//    }

    //    Função para verificar repetição de Id
    public static boolean hasId(List<Employee> list, int id) {
        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}

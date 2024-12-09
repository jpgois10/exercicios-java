/*A dona de um pensionato possui dez quartos para alugar para estudantes,
sendo esses quartos identificados pelos números 0 a 9.
Fazer um programa que inicie com todos os dez quartos vazios, e depois
leia uma quantidade N representando o número de estudantes que vão
alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
N estudantes. Para cada registro de aluguel, informar o nome e email do
estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
um relatório de todas ocupações do pensionato, por ordem de quarto.*/

package application;

import java.util.Locale;
import java.util.Scanner;


import entities.RentCostumers;


public class HostelApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        RentCostumers[] rooms = new RentCostumers[10];

        System.out.print("How many rooms will be rented (from 1 to 10)? ");
        int roomsRented = sc.nextInt();

        for (int i = 1; i <= roomsRented; i++) {
            System.out.println("Rent #" + i + ": ");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int roomNumber = sc.nextInt();
            System.out.println();

            RentCostumers rent = new RentCostumers(name, email);
            rooms[roomNumber] = rent;

        }

        System.out.println("Busy rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {
                System.out.println(i + ": " + rooms[i]);
            }
        }


        sc.close();
    }
}

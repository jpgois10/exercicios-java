/*Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
o instante do sistema: new Date()*/

package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class ProgramApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:\n");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(sc.nextLine(), Client.DATE_FORMATTER);

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());

        LocalDateTime momentOrder = LocalDateTime.now();
        Order order = new Order(momentOrder, orderStatus, client );

        System.out.print("How many items to this order? ");
        int numItems = sc.nextInt();

        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            Product productOrder = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, productOrder);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}

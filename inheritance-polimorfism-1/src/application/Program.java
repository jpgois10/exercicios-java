/*Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final,
mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e
produtos usados possuem data de fabricação. Estes dados específicos devem ser
acrescentados na etiqueta de preço conforme exemplo. Para produtos importados,
a taxa e alfândega deve ser acrescentada ao preço final do produto.*/

package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList();

        System.out.print("Enter the number of products: ");
        int productsQuantity = sc.nextInt();

        for (int i = 0; i < productsQuantity; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char option = sc.next().charAt(0);

            if (Character.toLowerCase(option) == 'c') {
                System.out.print("Name: ");
                String productName = sc.next();
                System.out.print("Price: ");
                double productPrice = sc.nextDouble();
                list.add(new Product(productPrice, productName));

            } else if (Character.toLowerCase(option) == 'u') {
                System.out.print("Name: ");
                String productName = sc.next();
                System.out.print("Price: ");
                double productPrice = sc.nextDouble();
                System.out.print("Manufacture Date (DD/MM/YYYY): ");
                LocalDate productManufactureDate = LocalDate.parse(sc.next(), UsedProduct.DATE_FORMATTER);
                list.add(new UsedProduct(productPrice, productName, productManufactureDate));

            } else if (Character.toLowerCase(option) == 'i') {
                System.out.print("Name: ");
                String productName = sc.next();
                System.out.print("Price: ");
                double productPrice = sc.nextDouble();
                System.out.print("Custom fee: ");
                double productFee = sc.nextDouble();
                list.add(new ImportedProduct(productPrice, productName, productFee));

            } else {
                System.out.println("Invalid option");
            }

        }

        System.out.println("\nPRICE TAGS:");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}

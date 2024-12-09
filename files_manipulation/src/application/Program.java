/*Fazer um programa para ler o caminho de um arquivo .csv
contendo os dados de itens vendidos. Cada item possui um
nome, preço unitário e quantidade, separados por vírgula. Você
deve gerar um novo arquivo chamado "summary.csv", localizado
em uma subpasta chamada "out" a partir da pasta original do
arquivo de origem, contendo apenas o nome e o valor total para
aquele item (preço unitário multiplicado pela quantidade),
conforme exemplo.*/

package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        File sourceFile = new File(filePath);
        String sourceFolder = sourceFile.getParent();

        boolean success = new File(sourceFile + "\\out").mkdir();
        String targetFile = sourceFolder + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            String itemCSV = br.readLine();
            while (itemCSV != null) {
                String[] fields = itemCSV.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]); //Converção, pois variavel fields é uma String
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCSV = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
                for (Product product : list) {
                    bw.write(product.getName() + "," + String.format("%.2f", product.totalPrice()));
                    bw.newLine();

                    System.out.println(targetFile + " CREATED!");
                }

            } catch (IOException e) {
                System.out.println("Error writing file " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }

        sc.close();

    }
}

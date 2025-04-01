package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class ProductMgmtApp {
    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparingDouble(Product::getUnitPrice).reversed());

        System.out.println("Printed in JSON Format");
        printInJSONFormat(products);
        System.out.println("-------------------------------------");

        System.out.println("Printed in XML Format");
        printInXMLFormat(products);
        System.out.println("-------------------------------------");


        System.out.println("Printed in Comma-Separated Values (CVS) Format");
        printInCSVFormat(products);
    }

    private static void printInJSONFormat(Product[] products) {
        String jsonData = Arrays.stream(products)
                .map(product -> String.format(
                        "  { \"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f }",
                        product.getProductId(),product.getName(),product.getDateSupplied(),product.getQuantityInStock(),product.getUnitPrice()))
                .collect(Collectors.joining(",\n", "[\n", "\n]"));

        System.out.println(jsonData);
    }

    private static void printInXMLFormat(Product[] products) {
        String xmlData = Arrays.stream(products)
                .map(product -> String.format(
                        "  <product productId=%d, name=\"%s\", dateSupplied=\"%s\", quantityInStock=%d, unitPrice=%.2f />",
                        product.getProductId(),product.getName(),product.getDateSupplied(),product.getQuantityInStock(),product.getUnitPrice()))
                .collect(Collectors.joining("\n","<?xml version=\"1.0\">\n<products>\n", "\n</products>"));

        System.out.println(xmlData);
    }

    private static void printInCSVFormat(Product[] products) {
        String csvData = Arrays.stream(products)
                .map(product -> String.format(
                        "%d, %s, %s, %d, %.2f",
                        product.getProductId(),product.getName(),product.getDateSupplied(),product.getQuantityInStock(),product.getUnitPrice()))
                .collect(Collectors.joining("\n"));

        System.out.println( csvData);
    }
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24"), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99)
        };
        printProducts(products);
    }
}
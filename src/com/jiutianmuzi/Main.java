package com.jiutianmuzi;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BookStore.init();

        mainUi();

        do {
            int operation = input.nextInt();
            input.nextLine();
            switch (operation) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    buyBook();
                    break;
                case 6:
                    System.exit(0);

            }
        } while (true);


    }


    private static void mainUi() {

        System.out.println("welcome to bookStore\n" +
                "searchBook: 1\n" +
                "addBook: 2\n" +
                "editBook: 3\n" +
                "deleteBook: 4\n" +
                "buyBook: 5\n" +
                "exit System: 6\n" +
                "please input your selection(1-6):");

    }

    private static void searchBook() {
        System.out.println("please input title:");
        String title = input.nextLine();
        System.out.println("please input author:");
        String author = input.nextLine();
        Book target = new Book();
        target.setTitle(title);
        target.setAuthor(author);

        int index = BookStore.binarySearch(target);
        if (-1 == index) {
            System.out.println("您要查找的书不存在");
        } else {
            System.out.println("index: " + index + " " + BookStore.books[index]);
        }

        mainUi();

    }

    private static void addBook() {
        System.out.println("please input title:");
        String title = input.nextLine();
        System.out.println("please input author:");
        String author = input.nextLine();
        System.out.println("please input chapters separate by blank :");
        String[] chapterList = input.nextLine().split(" ");
        System.out.println("please input copyright:");
        String copyright = input.nextLine();
        System.out.println("please input publisher:");
        String publisher = input.nextLine();
        System.out.println("please input price:");
        Double price = input.nextDouble();
        System.out.println("please input gstRate:");
        Double gstRate = input.nextDouble();
        System.out.println("please input stock:");
        int stock = input.nextInt();

        Book book = new Book(title, author, copyright, publisher, chapterList, stock, price);

        try {
            BookStore.addBook(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mainUi();
    }

    private static void editBook() {

    }


    private static void deleteBook() {

    }


    private static void buyBook() {
        System.out.println("please input book index:");
        int index = Integer.parseInt(input.nextLine());
        System.out.println("please input purchase num:");
        int count = Integer.parseInt(input.nextLine());

        try {
            System.out.println("您本次购买需要付款"+BookStore.buyBook(index,count)+"元");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mainUi();
    }

}

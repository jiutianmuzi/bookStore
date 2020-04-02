package com.jiutianmuzi;

import java.util.Scanner;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private String copyright;
    private String publisher;
    private String[] chapterList;
    private int stock;
    private double price;
    private static double gstRate;

    public Book() {
    }

    public Book(String title, String author, String copyright, String publisher, String[] chapterList, int stock, double price) {
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        this.publisher = publisher;
        this.chapterList = chapterList;
        this.stock = stock;
        this.price = price;
    }

    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.copyright = book.copyright;
        this.publisher = book.publisher;
        this.chapterList = book.chapterList;
        this.stock = book.stock;
        this.price = book.price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getPublisher() {
        return publisher;
    }

    public String[] getChapterList() {
        return chapterList;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setChapterList(String[] chapterList) {
        this.chapterList = chapterList;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChapterName(int index) {
        Scanner input = new Scanner(System.in);
        if (index >= 0 && index <= (getChapterList().length - 1)) {
            System.out.println("Enter the new chapter name:");
            String chapterName = input.nextLine();
            chapterName = chapterList[index];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getChapterName(int index) {
        if (index >= 0 && index <= (getChapterList().length - 1)) {
            return chapterList[index];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        String str = "";
        return str;
    }

    public double buy(int amount) {
        if (amount > 0 && amount <= getStock()) {
            setStock(stock - amount);
            return (amount * getPrice());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static double getGSTRate() {
        return gstRate;
    }

    public static void setGSTRate(double gstr) {
        gstRate = gstr;
    }


    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.getTitle())
        if (result == 0) {
            return this.author.compareTo(o.getAuthor());
        }
        return result;
    }
}



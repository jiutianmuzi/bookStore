package com.jiutianmuzi;

import java.util.Scanner;

public class BookStore {

    private static int capacity = 100;

    public static Book[] books = new Book[100];

    private static int lastIndex = 0;

    public static void init() {

        String[] chapters = {"one", "two", "three", "four"};

        Book book1 = new Book("aaa", "zhao", "2020", "中信", chapters, 10, 88.0);
        Book book2 = new Book("bbb", "zhao", "2020", "中信", chapters, 10, 88.0);
        Book book3 = new Book("bbb", "qian", "2020", "中信", chapters, 10, 88.0);
        Book book4 = new Book("ccc", "sun", "2020", "中信", chapters, 10, 88.0);
        try {
            addBook(book1);
            addBook(book2);
            addBook(book3);
            addBook(book4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("初始化书店书籍");
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(books[i]);
        }

    }


    public static void addBook(Book book) throws Exception {
        if (lastIndex <= capacity - 1 && null == books[lastIndex]) {
            books[lastIndex++] = book;
            insertionSort();
        } else {
            throw new Exception("书店已满无法添加新书");
        }
    }

    public static void editBook(int index, Book newBook) {
        if (newBook.getTitle() != null) {
            books[index].setTitle(newBook.getTitle());
        }
        if (newBook.getAuthor() != null) {
            books[index].setAuthor(newBook.getAuthor());
        }
        if (newBook.getPrice() != 0){
            books[index].setPrice(newBook.getPrice());
        }
        if(newBook.getStock()!=0){
            books[index].setStock(newBook.getStock());
        }
        if(newBook.getChapterList() != null){
            books[index].setChapterList(newBook.getChapterList());
        }
        if (newBook.getCopyright() !=null){
            books[index].setCopyright(newBook.getCopyright());
        }
        if(newBook.getPublisher()!=null){
            books[index].setPublisher(newBook.getPublisher());
        }

        insertionSort();
    }

    public static void deleteBook(int index) throws Exception {
        if(index >= 0 &&  index < lastIndex ){
            for (int i = index; i <= lastIndex - 2 ; i++) {
                books[i] = books[i+1];
            }
            lastIndex--;
        }else {
            throw new Exception("您要删除的数不存在");
        }
    }

    public static Double buyBook(int index, int count) throws Exception {

        if (books[index].getStock() < count) {
            throw new Exception("该书库存不足，请下次够买");
        } else {
            books[index].setStock(books[index].getStock() - count);
        }
        return books[index].getPrice() * count * (1 + Book.getGSTRate());
    }

    public static Double buyBook(String title, String author,int count) throws Exception {

        int index = binarySearch(title,author);

        if(-1 == index){
            throw new Exception("该书不存在");
        }

        if (books[index].getStock() < count) {
            throw new Exception("该书库存不足，请下次够买");
        } else {
            books[index].setStock(books[index].getStock() - count);
        }
        return books[index].getPrice() * count * (1 + Book.getGSTRate());
    }


    public static void insertionSort() {
        Book temp;
        for (int i = 1; i < lastIndex; i++) {
            temp = books[i];
            for (int j = i - 1; j >= 0; j--) {

                if (books[i].compareTo(books[j]) < 0) {
                    books[j + 1] = books[j];
                } else {
                    books[j + 1] = temp;
                    break;
                }
            }
        }
    }

    public static int binarySearch(String title,String author) {
        Book target = new Book();
        target.setTitle(title);
        target.setAuthor(author);

        int l = 0;
        int r = lastIndex - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(books[mid]) > 0) {
                l = mid + 1;
            }
            if (target.compareTo(books[mid]) < 0) {
                r = mid - 1;
            }
            if (target.compareTo(books[mid]) == 0) {
                return mid;
            }
        }
        return -1;
    }
}

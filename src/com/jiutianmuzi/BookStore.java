package com.jiutianmuzi;

public class BookStore {

    private static int capacity = 100;

    private static Book[]  books = new Book[100];

    private static int lastIndex = 0;

    public static void addBook(Book book) throws Exception {
        if(lastIndex <= capacity -1 && null == books[lastIndex]){
            books[lastIndex++] = book;
        }else {
            throw new Exception("书店已满无法添加新书");
        }
    }

    public void editBook(int index , Book newBook){
        if(newBook.getTitle() != null )
    }

    public static void insertionSort(){
        Book temp;
        for (int i = 1; i < lastIndex; i++) {

            for (int j = i-1; j>= 0 ; j--) {
                if(books[i].compareTo(books[j]) < 0 ){
                    temp = books[i];
                    books[j+1] = books[j];
                }else {
//                    books[j+1] = temp;
                }
            }

        }
    }
}

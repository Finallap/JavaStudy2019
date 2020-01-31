package com.fang.reflection;

public class Book {
    private final static String TAG = "com.fang.reflection.Book";

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "com.fang.reflection.Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case '0':
                string = "I am declaredMethod 1 !";
                break;
            case '1':
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }
        return string;
    }
}

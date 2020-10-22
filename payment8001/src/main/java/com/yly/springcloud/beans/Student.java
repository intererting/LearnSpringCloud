package com.yly.springcloud.beans;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2020/10/22 下午4:26
 * @since 1.0
 */
public class Student {
    private String name;
    private Book   book;

    public Student(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public String getName() {
        return name;
    }
}

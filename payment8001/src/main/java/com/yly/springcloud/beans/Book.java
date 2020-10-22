package com.yly.springcloud.beans;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2020/10/22 下午4:26
 * @since 1.0
 */
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public Book(String name) {
        this.name = name;
    }
}
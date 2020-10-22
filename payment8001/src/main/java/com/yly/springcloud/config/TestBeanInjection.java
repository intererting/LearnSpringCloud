package com.yly.springcloud.config;

import com.yly.springcloud.beans.Book;
import com.yly.springcloud.beans.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2020/10/22 下午4:22
 * @since 1.0
 */
@Configuration
public class TestBeanInjection {

    @Bean
    public Book book() {
        return new Book("my book");
    }

    @ConditionalOnBean(value = {Book.class})
    @Bean
    public Student student(Book book) {
        return new Student("yuliyang", book);
    }
}



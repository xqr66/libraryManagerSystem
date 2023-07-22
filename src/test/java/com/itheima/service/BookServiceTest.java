package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private  IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void TestGetPage(){
        IPage<Book> page = new Page<>(2,5);
        bookService.page(page);
        System.out.println(page);
    }
    @Test
    void TestRemove(){
        bookService.removeById(3);
    }

    @Test
    void testSave(){
        Book book = new Book(null,"物理学","大学物理","简述了电场和磁场");
        bookService.save(book);
    }

    @Test
    void TestSave(){
        Book book = new Book(null,"生物学","生物与遗传","简述生物精华");
        bookService.saveBook(book);
    }
}

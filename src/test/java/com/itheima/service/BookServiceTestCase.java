package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
   private  BookService bookService;
    @Test
     void testGetById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void TestGetPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page);
    }


}

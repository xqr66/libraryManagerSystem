package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById(){
        Book bookById = bookDao.selectById(1);
        System.out.println(bookById);
    }

    @Test
    void testInsert(){
        Book book = new Book(null,"计算机理论","计算机组成原理","简述了计算机的组成和优化");
        Book book1 = new Book(null,"计算机理论","spring6","简述了计算机的组成和优化");
        Book book2 = new Book(null,"计算机理论","springboot","简述了计算机的组成和优化");
        Book book3 = new Book(null,"计算机理论","mybaits","简述了计算机的组成和优化");
        Book book4 = new Book(null,"计算机理论","mybatis-plus","简述了计算机的组成和优化");
        bookDao.insert(book);
        bookDao.insert(book2);
        bookDao.insert(book3);
        bookDao.insert(book4);
        bookDao.insert(book3);
        bookDao.insert(book2);
    }

    @Test
    void testUpdate(){
        Book book = new Book(3,"历史","中国历史","简述中国历史的演变");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(2);
    }

    @Test
    void testAll(){
        List<Book> books = bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
         IPage page = new Page(2, 5);
         bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
    }

    @Test
    public void testQueryByCondition(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("type","计算机");
        bookDao.selectList(qw);
    }
    @Test
    public void testQueryByLambdaCondition(){
        String type = "计算机";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(type != null,Book::getType,type);
        bookDao.selectList(lqw);
    }
}

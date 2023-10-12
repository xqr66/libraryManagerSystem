package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import com.itheima.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//设置公共的请求路径前缀
@RequestMapping("/books")
public class BookController {
    //    自动注入业务层的接口
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    //设置请求路径
    @DeleteMapping("{id}")
    public R Delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    //设置请求路径，并将请求路径参数传入方法中
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        System.out.println("query success!");
        return new R(true, bookService.getById(id));
    }

    //    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码作为当前页码值
//        if (currentPage > page.getPages()) {
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {

        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(null != page, page);
    }
}

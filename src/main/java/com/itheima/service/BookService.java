package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookService {
    public Boolean save(Book book);
    public Boolean update(Book book);
    public Boolean delete(Integer id);
    public Book getById(Integer id);
    public List<Book> getAll();
    public IPage<Book> getPage(int currentPage, int pageSize);
}

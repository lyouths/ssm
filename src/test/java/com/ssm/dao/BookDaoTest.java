package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById(){
        long bookId=1000;
        Book book=bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookDao.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void testReduceNumber(){
        long bookId=1000;
        int upate=bookDao.reduceNumber(bookId);
        System.out.println("upate="+upate);
    }
}

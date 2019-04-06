package com.xm.test;


import com.xm.entity.Book;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class BookTest {

    public static void main(String[] args)throws Exception{

        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book book=  new Book();
        book.setBookName("小城故事");
        book.setPrice(12.50f);
        book.setPulishDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-4-8"));

        LobHelper lobHelper= session.getLobHelper();
        InputStream is = new FileInputStream("E:\\Tools\\fly\\421.jpg");
        book.setImage(lobHelper.createBlob(is,is.available()));

        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
}

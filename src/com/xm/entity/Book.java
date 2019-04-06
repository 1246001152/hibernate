package com.xm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name="book")
public class Book {

    private Integer id;
    private String bookName;
    private float price;
    private Date pulishDate;
    private Blob image;

    @Id
    @GeneratedValue
    @GenericGenerator(name="_native" ,strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "pulish_date")
    public Date getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(Date pulishDate) {
        this.pulishDate = pulishDate;
    }
    @Column
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}

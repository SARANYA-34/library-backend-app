package com.nestdigital.librarybackendapp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libraries")
public class LibraryModel {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private  String  author;
    private int year;
    private int stock;

    public LibraryModel() {
    }

    public LibraryModel(int id, String name, String author, int year, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

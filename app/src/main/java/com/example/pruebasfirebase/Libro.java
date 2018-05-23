package com.example.pruebasfirebase;

import java.util.HashMap;
import java.util.List;

/**
 * Created by NINO on 24/05/2018.
 */

public class Libro {

    String author;
    Detalle detail;
    String genre;
    List<Precio> price;
    String title;


    public Libro(String author, Detalle detail, String genre, List<Precio> price, String title) {
        this.author = author;
        this.detail = detail;
        this.genre = genre;
        this.price = price;
        this.title = title;
    }

    public Libro() {
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Detalle getDetail() {
        return detail;
    }

    public void setDetail(Detalle detail) {
        this.detail = detail;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Precio> getPrice() {
        return price;
    }

    public void setPrice(List<Precio> price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

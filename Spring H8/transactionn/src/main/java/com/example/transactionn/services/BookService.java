package com.example.transactionn.services;


import java.util.Optional;

import com.example.transactionn.entity.Book;

public interface BookService {

    boolean isBookExists(Book book);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    Iterable<Book> listBooks();

    void deleteBookById(String isbn);

}
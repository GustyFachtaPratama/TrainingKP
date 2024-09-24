package com.example.transactionn.repositories;

import com.example.transactionn.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}

package com.example.transactionn.repositories;

import com.example.transactionn.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

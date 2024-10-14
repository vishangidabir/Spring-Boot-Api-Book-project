package com.bridgelabz.Spring.Boot.Api.Book.Dao;

import com.bridgelabz.Spring.Boot.Api.Book.Entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}

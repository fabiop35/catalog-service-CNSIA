package com.cnsia.catalogservice.persistence;

import java.util.Optional;

import com.cnsia.catalogservice.domain.Book;
 
public interface BookRepository {
  Iterable<Book> findAll();
  Optional<Book> findByIsbn(String isbn);
  boolean existsByIsbn(String isbn);
  Book save(Book book);
  void deleteByIsbn(String isbn);
}

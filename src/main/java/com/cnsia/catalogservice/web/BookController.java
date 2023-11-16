package com.cnsia.catalogservice.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cnsia.catalogservice.domain.Book;
import com.cnsia.catalogservice.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
  private final BookService bookService;
 
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }
  
   @GetMapping("{isbn}")
  public Book getByIsbn(@PathVariable String isbn) {
    return bookService.viewBookDetails(isbn);
  }
  
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Book post(@Valid @RequestBody Book book) {
   return bookService.addBookToCatalog(book);
 }
 
 @DeleteMapping("{isbn}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void delete(@PathVariable String isbn){
   bookService.removeBookFromCatalog(isbn);
 }

 @PutMapping("{isbn}")
 public Book put(@PathVariable String isbn, @Valid @RequestBody Book book) {
   return bookService.editBookDetails(isbn, book);
   }
  
  @GetMapping
  public Iterable<Book> getAllBooks(){
    return bookService.viewBookList();
  }

  
}





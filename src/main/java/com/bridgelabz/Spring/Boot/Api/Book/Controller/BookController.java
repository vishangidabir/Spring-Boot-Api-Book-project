package com.bridgelabz.Spring.Boot.Api.Book.Controller;

import com.bridgelabz.Spring.Boot.Api.Book.Entities.Book;
import com.bridgelabz.Spring.Boot.Api.Book.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

        Book book = new Book();
        @Autowired
        private BookService bookService;

        //Get all books------------------------------->
        @GetMapping("/books")
        public ResponseEntity<List<Book>> getBook(){
                List<Book> list = this.bookService.getAllBooks();
                if(list.size() <= 0){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }else{
                        return ResponseEntity.status(HttpStatus.CREATED).body(list);
                }
        }

        //get single book by id----------------------->
        @GetMapping("/books/{id}")
        public ResponseEntity<Book> getbookById(@PathVariable("id") int id){
                Book book = this.bookService.getBookById(id);
                if(book == null){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }else{
                        return ResponseEntity.of(Optional.of(book));
                }
        }

        //add single book----------------------------->
        @PostMapping("/books")
        public ResponseEntity<Book> addBook(@RequestBody Book book){
                Book book1 = null;
                try {
                        book1 = this.bookService.addBook(book);
                        return ResponseEntity.of(Optional.of(book1));
                }catch (Exception e){
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
        }

        //delete book by id---------------------------->
        @DeleteMapping("/books/{id}")
        public ResponseEntity<Void>deleteBookByid(@PathVariable("id")int id){
                try {
                       this.bookService.deleteBookById(id);
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }catch (Exception e){
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
        }

        //update book by id---------------------------------->
        @PutMapping("/books/{bookId}")
        public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
                try {
                        this.bookService.UpdateBook(book, bookId);
                        return ResponseEntity.ok().body(book);
                }catch (Exception e){
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
        }
}

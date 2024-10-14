package com.bridgelabz.Spring.Boot.Api.Book.Services;

import com.bridgelabz.Spring.Boot.Api.Book.Dao.BookRespository;
import com.bridgelabz.Spring.Boot.Api.Book.Entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRespository bookRespository;
//     private static List<Book> list = new ArrayList<>();
//
//     static {
//         list.add(new Book(1234,"Time is money","John Willams"));
//         list.add(new Book(4567,"Savage","Amit chaudhari"));
//         list.add(new Book(7891,"Health is wealth","Dyani Albert"));
//     }


     public List<Book> getAllBooks(){
         List<Book> list = (List<Book>) this.bookRespository.findAll();
         return list;
     }


    public Book getBookById(int id){
         Book book = null;
         try{
//         book = list.stream().filter(e->e.getId()==id).findFirst().get();
             book = this.bookRespository.findById(id);
         } catch (Exception e){
             e.printStackTrace();
         }
         return book;
    }

    public Book addBook(Book book){
//         list.add(book);
       Book book1 = bookRespository.save(book);
         return book1;
    }

    public void deleteBookById(int id) {
//         list = list.stream().filter(book->book.getId()!=id).
//                 collect(Collectors.toList());
        bookRespository.deleteById(id);

    }

    public void UpdateBook(Book book, int bookId) {
//         list = list.stream().map(book1 ->{
//              if(book.getId()==bookId){
//                  book.setTitle(book.getTitle());
//                  book.setAuthor(book.getAuthor());
//              }
//              return book;
//         }).collect(Collectors.toList());

            book.setId(bookId);
            bookRespository.save(book);
    }
}

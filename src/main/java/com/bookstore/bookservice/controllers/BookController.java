package com.bookstore.bookservice.controllers;

import com.bookstore.bookservice.models.Book;
import com.bookstore.bookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController implements ErrorController {
    @Autowired
    private BookRepository bookRepository;

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(){
        return "Error Handling";
    }

    @GetMapping(value = "/books")
    public List<Book> getAllBooks(){
        List<Book> books = bookRepository.getAllBooks();
        return books;
    }

    @PostMapping(value = "/books")
    public void saveBook(@RequestBody Book book){
        bookRepository.saveBook(book);
    }
}

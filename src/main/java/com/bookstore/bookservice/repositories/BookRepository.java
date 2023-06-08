package com.bookstore.bookservice.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bookstore.bookservice.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public void saveBook(final Book book){
        mapper.save(book);
    }

    public List<Book> getAllBooks(){
        List<Book> books = mapper.scan(Book.class, new DynamoDBScanExpression());
        return books;
    }

    public void deleteAllBooks(){
        List<Book> books = mapper.scan(Book.class, new DynamoDBScanExpression());
        mapper.batchDelete(books);
    }
}

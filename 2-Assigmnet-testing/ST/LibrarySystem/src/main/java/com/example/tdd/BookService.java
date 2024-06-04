package com.example.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksById(String id) {
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Book> getBooksByTitle(String title) {
        try{
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getTitle().equals(title.strip()))
                .collect(Collectors.toList());
        }catch (NullPointerException e){
            System.out.println("Error");
            return new ArrayList<>();
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        try {
            return bookRepository.findAllBooks().stream()
                    .filter(book -> book.getAuthor().equals(author.strip()))
                    .collect(Collectors.toList());
        }catch (NullPointerException e){
            System.out.println("Error");
            return new ArrayList<>();
        }

    }

    public List<Book> getBooksByAuthorAndTitle(String author, String title) {
        try {
            return bookRepository.findAllBooks().stream()
                    .filter(book -> book.getAuthor().equals(author.strip()) && book.getTitle().equals(title.strip()))
                    .collect(Collectors.toList());
        }catch (NullPointerException e){
        System.out.println("Error");
        return new ArrayList<>();
    }
    }
}

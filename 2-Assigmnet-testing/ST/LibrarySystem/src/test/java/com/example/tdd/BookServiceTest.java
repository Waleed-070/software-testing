package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new BookRepository();
//        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByTitle_ExistingTitle() {
        List<Book> books = bookService.getBooksByTitle("Test Driven Development");
        assertEquals(1, books.size());
        assertEquals("Test Driven Development", books.get(0).getTitle());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByTitle_NonExistingTitle() {
        List<Book> books = bookService.getBooksByTitle("Nonexistent Book");
        assertEquals(0, books.size());
    }

    // GET BOOK BY AUTHOR ** UNIT TEST

    @Test
    public void testGetBooksByAuthor() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        assertEquals(1, books.size());
        assertEquals("Clean Code", books.get(0).getTitle());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthor_NullTitle() {
        List<Book> books = bookService.getBooksByAuthor(null);
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthor_EmptyStringTitle() {
        List<Book> books = bookService.getBooksByAuthor("");
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthor_WhitespaceInTitle() {
        List<Book> books = bookService.getBooksByAuthor("  Kent Beck  ");
        assertEquals(2, books.size());
        assertEquals("Kent Beck", books.get(0).getAuthor());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByTitle_MultipleBooksWithSameAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        assertEquals(2, books.size());
        assertEquals("Kent Beck", books.get(0).getAuthor());
    }


    // GET BOOK BY AUTHOR AND TITLE ** UNIT TEST
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthorAndTitle() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin","Clean Code");
        assertEquals(1, books.size());
        assertEquals("Clean Code", books.get(0).getTitle());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("abc","Unknown Author");
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthorAndTitle_NullTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null,null);
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthorAndTitle_EmptyStringTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("","");
        assertEquals(0, books.size());
    }
//---------------------------------------------------------------------------------------------------------

    @Test
    public void testGetBooksByAuthorAndTitle_WhitespaceInTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("  Robert C. Martin  "," Clean Code ");
        assertEquals(1, books.size());
        assertEquals("Clean Code", books.get(0).getTitle());
    }
//---------------------------------------------------------------------------------------------------------

}












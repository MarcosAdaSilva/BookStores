package com.stores.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.stores.DTOs.dto.BookDTO;
import com.stores.NotFoundExceptions.BookNotFoundException;
import com.stores.Services.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) { 
        this.bookService = bookService; 
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Validated @RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Validated @RequestBody BookDTO bookDTO) {
        try {
            BookDTO updatedBook = bookService.updateBook(id, bookDTO);
            return ResponseEntity.ok(updatedBook);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable Long id) {
        try {
            BookDTO bookDTO = bookService.findById(id);
            return ResponseEntity.ok(bookDTO);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> listAllBooks() {
        List<BookDTO> books = bookService.listAll();
        return ResponseEntity.ok(books);
    }
}

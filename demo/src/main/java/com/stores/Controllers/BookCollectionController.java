package com.stores.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stores.DTOs.dto.BookCollectionDTO;
import com.stores.Services.BookCollectionService;

@RestController
@RequestMapping("/api/books")
public class BookCollectionController {

    @Autowired
    private BookCollectionService bookService;

    @GetMapping
    public List<BookCollectionDTO> listAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/search/title")
    public List<BookCollectionDTO> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/search/author")
    public List<BookCollectionDTO> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/search/isbn")
    public List<BookCollectionDTO> findByIsbn(@RequestParam String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @GetMapping("/search/category")
    public List<BookCollectionDTO> findByCategory(@RequestParam String category) {
        return bookService.findByCategory(category);
    }
}

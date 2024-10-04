package com.stores.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.DTOs.dto.BookCollectionDTO;
import com.stores.Mappers.BookCollectionMapper;
import com.stores.Repository.BookCollectionRepository;

@Service
public class BookCollectionService {

    @Autowired
    private BookCollectionRepository bookRepository;

    @Autowired
    private BookCollectionMapper bookMapper;

    public List<BookCollectionDTO> listAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookCollectionDTO> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookCollectionDTO> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookCollectionDTO> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookCollectionDTO> findByCategory(String category) {
        return bookRepository.findByCategory(category)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}

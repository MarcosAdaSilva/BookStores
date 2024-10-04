package com.stores.BookServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stores.DTOs.dto.BookDTO;
import com.stores.Entities.Book;
import com.stores.Mappers.BookMapper;
import com.stores.NotFoundExceptions.BookNotFoundException;
import com.stores.Repository.BookRepository;
import com.stores.Services.BookService;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBook_Success() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Book");
        bookDTO.setAuthor("Test Author");
        bookDTO.setIsbn("1234567890");
        bookDTO.setPrice(new BigDecimal("19.99"));
        bookDTO.setStockQuantity(10);

        Book bookToSave = new Book.BookBuilder()
                .withTitle("Test Book")
                .withAuthor("Test Author")
                .withIsbn("1234567890")
                .withPrice(new BigDecimal("19.99"))
                .withStockQuantity(10)
                .build();

        Book savedBook = new Book.BookBuilder()
                .withId(1L)
                .withTitle("Test Book")
                .withAuthor("Test Author")
                .withIsbn("1234567890")
                .withPrice(new BigDecimal("19.99"))
                .withStockQuantity(10)
                .build();

        when(bookMapper.toModel(any(BookDTO.class))).thenReturn(bookToSave);
        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);
        when(bookMapper.toDTO(any(Book.class))).thenReturn(new BookDTO(1L, "Test Book", "Test Author", "1234567890", new BigDecimal("19.99"), 10));

        BookDTO result = bookService.createBook(bookDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Book", result.getTitle());
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    public void testFindById_Success() throws BookNotFoundException {
        Book book = new Book.BookBuilder()
                .withId(1L)
                .withTitle("Test Book")
                .withAuthor("Test Author")
                .withIsbn("1234567890")
                .withPrice(new BigDecimal("19.99"))
                .withStockQuantity(10)
                .build();

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookMapper.toDTO(any(Book.class))).thenReturn(new BookDTO(1L, "Test Book", "Test Author", "1234567890", new BigDecimal("19.99"), 10));

        BookDTO result = bookService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(bookRepository, times(1)).findById(1L);
    }


}

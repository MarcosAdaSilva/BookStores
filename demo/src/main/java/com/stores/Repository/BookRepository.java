package com.stores.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stores.DTOs.dto.BookDTO;
import com.stores.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Collection<BookDTO> findByTitleContainingIgnoreCase(String title);

	Collection<BookDTO> findByAuthorContainingIgnoreCase(String author);

	Collection<BookDTO> findByIsbn(String isbn);

	Collection<BookDTO> findByCategory(String category);
}

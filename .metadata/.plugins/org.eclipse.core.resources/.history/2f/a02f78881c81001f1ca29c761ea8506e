package com.stores.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stores.Entities.BookCollection;

public interface BookCollectionRepository extends JpaRepository<BookCollection, Long> {
    List<BookCollection> findByTitleContainingIgnoreCase(String title);
    List<BookCollection> findByAuthorContainingIgnoreCase(String author);
    List<BookCollection> findByIsbn(String isbn);
    List<BookCollection> findByCategory(String category);
}

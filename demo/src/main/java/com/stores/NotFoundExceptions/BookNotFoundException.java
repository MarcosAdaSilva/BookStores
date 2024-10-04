package com.stores.NotFoundExceptions;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(Long id) {
        super("Book not found with ID " + id);
    }
}

package com.stores.Entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String category;
    private String isbn;
    private BigDecimal price;
    private String description;
    private Integer stockQuantity;

    public Book() {
    }

    private Book(BookBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.category = builder.category;
        this.isbn = builder.isbn;
        this.price = builder.price;
        this.description = builder.description;
        this.stockQuantity = builder.stockQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
        
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
        
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    
    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "'}";
    }

    
    public static class BookBuilder {
        private Long id;
        private String title;
        private String author;
        private String category;
        private String isbn;
        private BigDecimal price;
        private String description;
        private Integer stockQuantity;

        public BookBuilder() {
        }

        public BookBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public BookBuilder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public BookBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public BookBuilder withStockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

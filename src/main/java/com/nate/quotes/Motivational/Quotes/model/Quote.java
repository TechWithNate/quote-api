package com.nate.quotes.Motivational.Quotes.model;


import com.nate.quotes.Motivational.Quotes.enumerations.QuoteCategory;
import jakarta.persistence.*;

@Entity
@Table
public class Quote {

    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_sequence")
    private Long id;
    private String author;
    private String quote;
    @Enumerated(EnumType.STRING)
    private QuoteCategory quoteCategory;

    public Quote(Long id, String author, String quote, QuoteCategory quoteCategory) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.quoteCategory = quoteCategory;
    }

    public Quote(String author, String quote, QuoteCategory quoteCategory) {
        this.author = author;
        this.quote = quote;
        this.quoteCategory = quoteCategory;
    }

    public Quote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public QuoteCategory getQuoteCategory() {
        return quoteCategory;
    }

    public void setQuoteCategory(QuoteCategory quoteCategory) {
        this.quoteCategory = quoteCategory;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}

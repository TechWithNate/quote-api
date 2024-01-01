package com.nate.quotes.Motivational.Quotes.repo;

import com.nate.quotes.Motivational.Quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findByQuote(String quote);
    Optional<Quote> findByAuthor(String author);

}

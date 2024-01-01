package com.nate.quotes.Motivational.Quotes.repo;

import com.nate.quotes.Motivational.Quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}

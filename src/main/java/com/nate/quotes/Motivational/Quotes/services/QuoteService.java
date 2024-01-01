package com.nate.quotes.Motivational.Quotes.services;


import com.nate.quotes.Motivational.Quotes.model.Quote;
import com.nate.quotes.Motivational.Quotes.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;


    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    //Fetch all quotes in the quote repository stored by the spring data JPA
    public List<Quote> getQuotes(){
        return quoteRepository.findAll();
    }

    //Add quotes to the database
    public void addQuote(Quote quote){
        quoteRepository.save(quote);
    }

    // Delete quote from repository
    public void deleteQuote(Long id){
        boolean exists = quoteRepository.existsById(id);

        if (!exists){
            throw new IllegalStateException("Quote Does not exits");
        }

        quoteRepository.deleteById(id);
    }


    //Update Quote in repository
    //private void updateQuote(Quote quote)
}

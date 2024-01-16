package com.nate.quotes.Motivational.Quotes.services;


import com.nate.quotes.Motivational.Quotes.model.Quote;
import com.nate.quotes.Motivational.Quotes.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Quote> quoteByTxt = quoteRepository.findByQuote(quote.getQuote());
        Optional<Quote> quoteByAuthor = quoteRepository.findByAuthor(quote.getAuthor());

        if (quoteByTxt.isPresent() && quoteByAuthor.isPresent()){
            throw new IllegalStateException("Quote Already Present");
        }
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
    @Transactional
    public void updateQuote(Long id, String quote, String author) {
        Quote quote1 = quoteRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Quote Unavailable"));

        if (quote != null && quote.length() > 0 && !Objects.equals(quote1.getQuote(), quote)){
            quote1.setQuote(quote);
        }

        if (author != null && author.length() > 0 && !Objects.equals(quote1.getAuthor(), author)){
            quote1.setAuthor(author);
        }
    }

    public void addLoveQuote(Quote quote) {
        Optional<Quote> quoteByTxt = quoteRepository.findByQuote(quote.getQuote());
        Optional<Quote> quoteByAuthor = quoteRepository.findByAuthor(quote.getAuthor());

        if (quoteByTxt.isPresent() && quoteByAuthor.isPresent()){
            throw new IllegalStateException("Quote Already Present");
        }
        quoteRepository.save(quote);
    }

    public List<Quote> getLoveQuotes() {
        return quoteRepository.findAll();
    }
}

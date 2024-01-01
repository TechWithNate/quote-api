package com.nate.quotes.Motivational.Quotes.controller;


import com.nate.quotes.Motivational.Quotes.model.Quote;
import com.nate.quotes.Motivational.Quotes.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    private List<Quote> getQuotes(){
        return quoteService.getQuotes();
    }

    @PostMapping
    public void addQuotes(@RequestBody Quote quote){
        quoteService.addQuote(quote);
    }

    @DeleteMapping(path = "{quoteId}")
    public void deleteQuote(@PathVariable ("quoteId") Long id){
        quoteService.deleteQuote(id);
    }

}

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

    @PostMapping(path = "/love")
    public void loveQuotes(@RequestBody Quote quote){
        quoteService.addLoveQuote(quote);
    }

    @GetMapping(path = "/love")
    public List<Quote> getLoveQuotes(){
        return quoteService.getLoveQuotes();
    }

    @DeleteMapping(path = "{quoteId}")
    public void deleteQuote(@PathVariable ("quoteId") Long id){
        quoteService.deleteQuote(id);
    }

    @PutMapping(path = "{quoteId}")
    public void updateQuote(@PathVariable ("quoteId")
                            Long id,
                            @RequestParam(required = false) String quote,
                            @RequestParam(required = false) String author){
        quoteService.updateQuote(id, quote, author);
    }

}

package com.nate.quotes.Motivational.Quotes.config;

import com.nate.quotes.Motivational.Quotes.enumerations.QuoteCategory;
import com.nate.quotes.Motivational.Quotes.model.Quote;
import com.nate.quotes.Motivational.Quotes.repo.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(QuoteRepository quoteRepository){
        return args -> {
            Quote q1 = new Quote("Dzreke Nathan", "This is quote 1", QuoteCategory.AMBITION);
            Quote q2 = new Quote("John Doe", "This is quote 2", QuoteCategory.ADVENTURE);
            Quote q3 = new Quote("John Smith", "This is quote 3", QuoteCategory.CHARACTER);
            Quote q4 = new Quote("Mike Baiths", "This is quote 4", QuoteCategory.CHANGE);
            Quote q5 = new Quote("Jim Reeves", "This is quote 5", QuoteCategory.DREAMS);
            quoteRepository.saveAll(List.of(q1, q2, q3, q4, q5));
        };
    }

}

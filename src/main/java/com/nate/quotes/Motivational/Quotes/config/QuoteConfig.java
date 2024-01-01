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
            Quote q1 = new Quote("This is quote 1", "Dzreke Nathan", QuoteCategory.AMBITION);
            Quote q2 = new Quote("This is quote 2", "John Doe", QuoteCategory.ADVENTURE);
            Quote q3 = new Quote("This is quote 3", "John Smith", QuoteCategory.CHARACTER);
            Quote q4 = new Quote("This is quote 4", "Mike Baiths", QuoteCategory.CHANGE);
            Quote q5 = new Quote("This is quote 5", "Jim Reeves", QuoteCategory.DREAMS);
            quoteRepository.saveAll(List.of(q1, q2, q3, q4, q5));
        };
    }

}

package com.nate.quotes.Motivational.Quotes.config;

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
            Quote q1 = new Quote("This is quote 1", "Dzreke Nathan");
            Quote q2 = new Quote("This is quote 2", "John Doe");
            Quote q3 = new Quote("This is quote 3", "John Smith");
            Quote q4 = new Quote("This is quote 4", "Mike Baiths");
            Quote q5 = new Quote("This is quote 5", "Jim Reeves");
            quoteRepository.saveAll(List.of(q1, q2, q3, q4, q5));
        };
    }

}

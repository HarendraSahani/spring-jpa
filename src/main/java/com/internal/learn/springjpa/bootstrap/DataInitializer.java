package com.internal.learn.springjpa.bootstrap;

import com.internal.learn.springjpa.domain.Book;
import com.internal.learn.springjpa.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Book DDD = new Book("Domain Driven Design","RandomHouse","123452345");
        Book saveDDD = bookRepository.save(DDD);

        Book SIA = new Book("Spring In Action","OReily","123452309");
        Book saveSIA = bookRepository.save(SIA);

        bookRepository.findAll().forEach( book -> {
            System.out.println("BookID: "+ book.getId());
            System.out.println("Book Title: "+book.getTitle());
        });
    }
}

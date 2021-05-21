package com.chuchin.bootstrap;

import com.chuchin.domain.Author;
import com.chuchin.domain.Book;
import com.chuchin.repositories.AuthorRepository;
import com.chuchin.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author julioV = new Author("Julio", "Verne");
        Book viajeSub = new Book("20,000 leguas de viaje submarino","ABC12354", (Set<Author>) julioV);
        Author franzK = new Author("Franz", "Kafka");
        Book metarmorf = new Book("Metamorfosis", "ABCD4321", Collections.singleton(franzK));
        Author georgeO = new Author("George", "Orwell");

    }
}

package com.chuchin.bootstrap;

import com.chuchin.domain.Author;
import com.chuchin.domain.Book;
import com.chuchin.domain.Publisher;
import com.chuchin.repositories.AuthorRepository;
import com.chuchin.repositories.BookRepository;
import com.chuchin.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author julioV = new Author("Julio", "Verne");
        Book viajeSub = new Book("20,000 leguas de viaje submarino","ABC12354");
        Author franzK = new Author("Franz", "Kafka");
        Book metarmorf = new Book("Metamorfosis", "ABCD4321");
        Author georgeO = new Author("George", "Orwell");
        Book revGranj = new Book("Revelion en la Granja", "asdasd2445");

        Publisher oreilley = new Publisher("O'reilley","NYC wst 450.","NYC","NY","ABC740");

        julioV.getBooks().add(viajeSub);
        viajeSub.getAuthors().add(julioV);

        franzK.getBooks().add(metarmorf);
        metarmorf.getAuthors().add(franzK);

        georgeO.getBooks().add(revGranj);
        revGranj.getAuthors().add(georgeO);

        authorRepository.save(julioV);
        authorRepository.save(franzK);
        authorRepository.save(georgeO);

        bookRepository.save(viajeSub);
        bookRepository.save(metarmorf);
        bookRepository.save(revGranj);

        publisherRepository.save(oreilley);

        System.out.println("Started in BootStrap");
        System.out.println("Libros Almacenados: " + bookRepository.count());

        System.out.println("Publicadores Almacenados: "+ publisherRepository.count());

    }
}

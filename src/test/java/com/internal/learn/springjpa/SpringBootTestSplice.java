package com.internal.learn.springjpa;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.internal.learn.springjpa.domain.Book;
import com.internal.learn.springjpa.repositories.BookRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

@ComponentScan(value = "com.internal.learn.springjpa.bootstrap")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringBootTestSplice {

    @Autowired
    BookRepository bookRepository;


    @Commit
    @Order(1)
    @Test
    void testJPATestSplice(){
     long beforeCounts = bookRepository.count();

     Book book1 = new Book("Google","OReilly","B12345");
     bookRepository.save(book1);
     long afterCount = bookRepository.count();
     assertThat(afterCount).isGreaterThan(beforeCounts);
     assertThat(beforeCounts).isEqualTo(2);
    }

    @Order(2)
    @Test
    void testJPATestSpliceTransaction(){
        long beforeCounter = bookRepository.count();

        assertThat(beforeCounter).isGreaterThan(0);
        assertThat(beforeCounter).isEqualTo(3);
    }
}

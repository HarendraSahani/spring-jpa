package com.internal.learn.springjpa.repositories;

import com.internal.learn.springjpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends  JpaRepository<Book, Long> {
}

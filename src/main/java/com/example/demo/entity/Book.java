package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Book {
    private int id;
    @Size(min = 0, max = 50)
    @NotBlank
    private String bookName;
    @Size(min = 0, max = 100)
    private String author;
    @Size(min = 0)
    private int num;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                '}';
    }
}

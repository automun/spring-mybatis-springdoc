package com.example.demo.controller;

import com.example.demo.exception.missingException;
import com.example.demo.mapper.BookMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Book;
import com.example.demo.exception.myNotFoundException;

@RestController
@Tag(name = "图书管理控制制器")
@RequestMapping("/book-app")
public class BookController {
    @Resource
    BookMapper bookMapper;

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    @Operation(summary = "获取图书信息",description = "获取")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@RequestParam("id") int id)
    {
        Book book = bookMapper.selectById(id);
        if (book == null)
            throw new myNotFoundException();
        return book;
    }

    @Operation(summary = "增加图书信息")
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book)
    {
        Book newBook = book;
        if (book.getBookName() == null || book.getNum() == 0 || book.getAuthor() == null)
            throw new missingException();
        bookMapper.insert(newBook);
        return newBook;
    }

    @Operation(summary = "更新图书信息")
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book)
    {
        int id = book.getId();
        if (id == 0)
            throw new myNotFoundException();
        bookMapper.update(book);
        return book;
    }

    @Operation(summary = "删除图书信息")
    @Parameter(name = "id",description = "bookId")
    @RequestMapping(value = "/books", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@RequestParam("id") int id)
    {
        bookMapper.deleteById(id);
    }

    @Operation(summary = "部分更新图书信息（书名）")
    @RequestMapping(value = "/books", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public void patchBook(@RequestParam("id") int id, @RequestBody String bookName)
    {
        bookMapper.updateName(id, bookName);
    }
}

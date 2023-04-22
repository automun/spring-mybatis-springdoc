package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface BookMapper {

    @Select("select * from book")
    List<Book> selectAll();

    @Select("select * from book where id = #{id}")
    Book selectById(int id);

    @Insert("insert into book(bookname,author,num) values (#{bookName}, #{author}, #{num})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Book book);

    @Delete("delete from book where id = #{id}")
    void deleteById(@Param("id") int id);

    @Update("update book set bookname = #{bookName}, author = #{author}, num = #{num} where id = #{id}")
    void update(Book book);

    @Update("update book set bookname = #{bookName} where id = #{id}")
    void updateName(int id, String bookName);
}
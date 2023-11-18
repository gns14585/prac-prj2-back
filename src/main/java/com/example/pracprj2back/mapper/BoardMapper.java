package com.example.pracprj2back.mapper;

import com.example.pracprj2back.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO board(title, content, writer)
            VALUES (#{title}, #{content}, #{writer})
            """)
    int insert(Board board);


    @Select("""
            SELECT id, title, writer, inserted
            FROM board
            ORDER BY 1 DESC
            """)
    List<Board> selectAll();

}

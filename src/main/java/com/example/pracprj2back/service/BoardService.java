package com.example.pracprj2back.service;

import com.example.pracprj2back.domain.Board;
import com.example.pracprj2back.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public boolean save(Board board) {
        // insert, update, delete 는 1개씩 데이터를 다루다 보니 boolean 리턴타입으로 == 1 로 처리
        return mapper.insert(board) == 1;
    }

    public boolean validate(Board board) {
        if (board == null) {
            return false;
        }
        if (board.getContent() == null || board.getContent().isBlank()) {
            return false;
        }
        if (board.getTitle() == null || board.getTitle().isBlank()) {
            return false;
        }
        if (board.getWriter() == null || board.getWriter().isBlank()) {
            return false;
        }
        return true;
    }

    public List<Board> boardList() {
        return mapper.selectAll();

    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public boolean remove(Integer id) {
        // insert, update, delete 는 1개씩 데이터를 다루다 보니 boolean 리턴타입으로 == 1 로 처리
        return mapper.deleteById(id) == 1;
    }
}

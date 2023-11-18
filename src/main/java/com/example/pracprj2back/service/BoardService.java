package com.example.pracprj2back.service;

import com.example.pracprj2back.domain.Board;
import com.example.pracprj2back.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void save(Board board) {
        mapper.insert(board);
    }
}

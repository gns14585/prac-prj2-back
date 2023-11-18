package com.example.pracprj2back;

import com.example.pracprj2back.domain.Board;
import com.example.pracprj2back.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService service;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody Board board) {

        // 글이 제대로 들어갔는지 검증
        if (!service.validate(board)) { // 검증이 잘 안됐으면
            return ResponseEntity.badRequest().build();
        }

        if (service.save(board)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("list")
    public List<Board> list() {
        return service.boardList();
    }
}


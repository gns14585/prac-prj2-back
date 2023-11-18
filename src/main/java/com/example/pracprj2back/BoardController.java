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

    // 넘어오는 주소가 axios.get("/api/board/id/" + id) 니까 뒤에있는 + id는 {id}로 받아줘야함
    // url주소의 특정 바뀌는 값들을 넘겨받는거니까 @PathVariable 매개변수에 넣어줘야함.
    @GetMapping("id/{id}")
    public Board get(@PathVariable Integer id) {
        return service.get(id);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        if (service.remove(id)) { // service.remove가 문제가 없다면 응답코드 ok (200)
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build(); // service.remove가 문제가 있다면 응답코드 error(500)
        }
    }

    @PutMapping("edit")
    public void edit(@RequestBody Board board) {
        service.update(board);
    }
}


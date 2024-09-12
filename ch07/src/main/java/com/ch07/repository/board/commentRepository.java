package com.ch07.repository.board;

import com.ch07.entity.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository<Comment, Integer> {
}

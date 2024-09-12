package com.ch07.repository.board;

import com.ch07.entity.User1;
import com.ch07.entity.board.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
}

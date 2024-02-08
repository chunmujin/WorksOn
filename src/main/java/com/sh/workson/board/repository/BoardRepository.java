package com.sh.workson.board.repository;

import com.sh.workson.board.entity.Board;
import com.sh.workson.board.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("from Board b left join fetch b.employee m left join fetch b.attachments where (:type is null or b.type = :type) order by b.id desc")
    Page<Board> findAllByType(@Param("type") Type type, Pageable pageable);
}
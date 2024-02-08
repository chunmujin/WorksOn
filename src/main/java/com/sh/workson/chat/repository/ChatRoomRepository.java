package com.sh.workson.chat.repository;

import com.sh.workson.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query("from ChatRoom cr join fetch cr.chatEmps where cr.chatEmps = :id")
    List<ChatRoom> findByEmpId(Long id);
}

package com.spotviper.repositories;

import com.spotviper.entities.ListeningHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListeningHistoryRepository extends JpaRepository<ListeningHistory, UUID> {

    Page<ListeningHistory> findByUser_IdOrderByPlayedAtDesc(UUID userId, Pageable pageable);
}

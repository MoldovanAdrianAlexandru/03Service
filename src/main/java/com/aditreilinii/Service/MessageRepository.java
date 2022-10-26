package com.aditreilinii.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

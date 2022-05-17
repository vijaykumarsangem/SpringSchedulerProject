package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.config.Data;

public interface DataRepo extends JpaRepository<Data, Integer> {
	Data findByName(String name);
}

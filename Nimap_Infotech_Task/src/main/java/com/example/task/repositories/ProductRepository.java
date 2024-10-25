package com.example.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
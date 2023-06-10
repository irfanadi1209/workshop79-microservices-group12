package com.example.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@EnableJpaAuditing
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
package com.example.transactionn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @SequenceGenerator(
            name = "authors_generator",
            sequenceName = "authors_id_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private Integer age;


}

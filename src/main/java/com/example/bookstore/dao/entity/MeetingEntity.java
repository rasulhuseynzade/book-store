package com.example.bookstore.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "meetings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    @ManyToMany(mappedBy = "meetings")
    private List<BookEntity> bookEntityList;

}

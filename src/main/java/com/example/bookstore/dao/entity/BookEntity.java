package com.example.bookstore.dao.entity;

import com.example.bookstore.model.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal price;
    @Column(name = "name_of_books")
    private String name;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String section;
    private String genre;
    private LocalDate originDate;
    @OneToMany(mappedBy = "bookEntity", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @ManyToMany
    @JoinTable(name = "book_meeting",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id"))
    private List<MeetingEntity> meetings;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
}

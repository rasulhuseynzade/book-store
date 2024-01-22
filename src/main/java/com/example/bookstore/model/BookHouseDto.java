package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookHouseDto {

    private int id;
    private String url;
    private String title;
    private String author;
    @JsonProperty("imageURL")
    private String imageUrl;
    private double rating;
    private int ratings;
    @JsonProperty("rankingPosition")
    private int rankingPosition;


}

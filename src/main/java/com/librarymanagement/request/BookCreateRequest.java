package com.librarymanagement.request;

import com.librarymanagement.models.Author;
import com.librarymanagement.models.Book;
import com.librarymanagement.models.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {
    @NotBlank
    private  String name;
    @NonNull
    private Author author;
    @NonNull
    private Genre genre;
    @Positive
    private double cost;

    public Book to(){
        return Book
                .builder()
                .cost(this.cost)
                .author(this.author)
                .genre(this.genre)
                .name(this.name)
                .build();
    }
}

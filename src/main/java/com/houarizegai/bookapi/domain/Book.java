package com.houarizegai.bookapi.domain;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "book")
@Entity
@TypeDefs({
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private String title;

    @Column(unique = true)
    private String isbn;

    @Type(type = "list-array")
    @Column(columnDefinition = "varchar[]")
    private List<String> authors;
}
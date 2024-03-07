package mpn.dev.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
public class Author extends BaseEntity {
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}

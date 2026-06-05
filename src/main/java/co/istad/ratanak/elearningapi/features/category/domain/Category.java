package co.istad.ratanak.elearningapi.features.category.domain;

import co.istad.ratanak.elearningapi.features.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;
    private String icon;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}

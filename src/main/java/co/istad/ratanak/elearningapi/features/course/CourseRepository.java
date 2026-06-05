package co.istad.ratanak.elearningapi.features.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean existsBySlug(String slug);

}
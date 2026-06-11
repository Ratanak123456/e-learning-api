package co.istad.ratanak.elearningapi.features.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean existsBySlug(String slug);

    // Use named query
    List<Course> allCourses();

    Course byId(Integer id);

}

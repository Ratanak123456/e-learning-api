package co.istad.ratanak.elearningapi.features.course;

import co.istad.ratanak.elearningapi.features.course.dto.CourseResponse;
import co.istad.ratanak.elearningapi.features.course.dto.CreateCourseRequest;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CourseService {
    CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt);

}

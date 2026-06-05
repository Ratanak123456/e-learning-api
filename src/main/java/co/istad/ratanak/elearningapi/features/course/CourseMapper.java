package co.istad.ratanak.elearningapi.features.course;

import co.istad.ratanak.elearningapi.features.course.dto.CourseResponse;
import co.istad.ratanak.elearningapi.features.course.dto.CreateCourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course mapCreateCourseRequestToCourse(CreateCourseRequest createCourseRequest);

    CourseResponse mapCourseToCourseResponse(Course course);

}
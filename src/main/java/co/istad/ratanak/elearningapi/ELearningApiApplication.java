package co.istad.ratanak.elearningapi;

import co.istad.ratanak.elearningapi.features.course.Course;
import co.istad.ratanak.elearningapi.features.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class ELearningApiApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ELearningApiApplication.class, args);
    }

    private CourseRepository courseRepository;

    @Autowired
    ELearningApiApplication(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Course> courses = courseRepository.allCourses();
        Course course = courseRepository.byId(6);

        IO.println(course.getTitle());
    }
}

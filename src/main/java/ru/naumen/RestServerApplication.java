package ru.naumen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.naumen.entities.Course;
import ru.naumen.entities.Scholarship;
import ru.naumen.entities.Student;
import ru.naumen.model.CourseDao;
import ru.naumen.model.ScholarshipDao;
import ru.naumen.model.StudentDao;

@SpringBootApplication
public class RestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }

    @Autowired
    private StudentDao _studentDao;

    @Autowired
    private CourseDao _courseDao;

    @Autowired
    private ScholarshipDao _scholarshipDao;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            Student student = new Student();
            Course course = new Course();
            Scholarship scholarship = new Scholarship();

            course.setNumber(3);
            course.setTitle("kn007");

            student.setFirstName("Вася");
            student.setLastName("Пупкин");
            student.setCourse(course);

            scholarship.setStudent(student);
            scholarship.setAmount(1500);

            _studentDao.create(student);
            _courseDao.create(course);
            _scholarshipDao.create(scholarship);
        };
    }
}

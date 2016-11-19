package ru.naumen.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ru.naumen.entities.Course;
import ru.naumen.entities.Student;

/**
 * @author aarkaev
 * @since 21.11.2016
 */
@Repository
public class InMemoryCourseDao implements CourseDao {
    private List<Course> storage = new ArrayList<>();

    @Override
    public List<Course> findAll() {
        return storage;
    }

    @Override
    public void create(Course course) {
        storage.add(course);
    }
}

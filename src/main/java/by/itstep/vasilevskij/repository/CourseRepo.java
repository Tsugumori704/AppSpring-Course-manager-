package by.itstep.vasilevskij.repository;

import by.itstep.vasilevskij.domain.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepo extends CrudRepository<Course, Long> {

    List<Course> findByIsActiveTrue();

    List<Course> findByTeacherId_Id(Long id, Sort var1);
}

package by.itstep.vasilevskij.repository;

import by.itstep.vasilevskij.domain.CourseGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseGroupRepo extends CrudRepository<CourseGroup, Long> {

    List<CourseGroup> findByCourseId_Id(Long courseId);

    List<CourseGroup> findByUserId_Id(Long userId);
}

package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    public Iterable<Course> coursesAll(){
        return courseRepo.findAll();
    }

    public boolean addCourse(Course course){
        courseRepo.save(course);
        return true;
    }

}

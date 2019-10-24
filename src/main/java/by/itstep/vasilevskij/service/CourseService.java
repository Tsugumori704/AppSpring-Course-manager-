package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    public Iterable<Course> teachersCourses(Long id){
        return courseRepo.findByTeacherId_Id(id, Sort.by("courseName"));
    }

    public Iterable<Course> coursesActive(){
        return courseRepo.findByIsActiveTrue();
    }

    public Iterable<Course> coursesAll(){
        return courseRepo.findAll();
    }

    public boolean addCourse(Course course){
        courseRepo.save(course);
        return true;
    }

    public void deactivationCourse(Course removeCourse) {
        removeCourse.setActive(false);
        courseRepo.save(removeCourse);
    }

    public void activationCourse(Course reaperCourse) {
        reaperCourse.setActive(true);
        courseRepo.save(reaperCourse);
    }
}

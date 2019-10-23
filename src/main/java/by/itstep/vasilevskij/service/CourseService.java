package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    public Iterable<Course> teachersCourses(Long id){
        return courseRepo.findByTeacherId_Id(id);
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

    public void remove(Course removeCourse) {
        removeCourse.setActive(false);
        courseRepo.save(removeCourse);
    }

    public void reaper(Course reaperCourse) {
        reaperCourse.setActive(true);
        courseRepo.save(reaperCourse);
    }
}

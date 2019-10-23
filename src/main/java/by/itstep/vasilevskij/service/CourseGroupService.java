package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.repository.CourseGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseGroupService {
    @Autowired
    CourseGroupRepo courseGroupRepo;

    public boolean addUserInCourse(CourseGroup courseGroup){
        courseGroupRepo.save(courseGroup);
        return true;
    }
}

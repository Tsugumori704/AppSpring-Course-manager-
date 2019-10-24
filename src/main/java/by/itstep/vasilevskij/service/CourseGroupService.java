package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.repository.CourseGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseGroupService {
    @Autowired
    CourseGroupRepo courseGroupRepo;

    public boolean addUserInCourse(CourseGroup courseGroup){
        courseGroupRepo.save(courseGroup);
        return true;
    }

    public List<CourseGroup> findAllUserInCourse(Long courseId){
        List<CourseGroup> byCourseId = courseGroupRepo.findByCourseId_Id(courseId);

        return byCourseId;
    }

    public CourseGroup findUserOnCourse(Long userId){
       return courseGroupRepo.findByUserId_Id(userId);
    }

}

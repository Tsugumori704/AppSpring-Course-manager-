package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.service.CourseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("courseGroup")
public class CourseGroupController {
    @Autowired
    CourseGroupService courseGroupService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping("{course}")
    public String main(Model model,
                       @PathVariable Course course,
                       @RequestParam(defaultValue = "") CourseGroup courseGroupMark,
                       @RequestParam(defaultValue = "") Long Mark

    ){


        model.addAttribute("courseGroup", course);
        List<CourseGroup> allUserInCourse = courseGroupService.findAllUserInCourse(course.getId());
        Collections.sort(allUserInCourse,(o1, o2) -> o1.getUserId().getFirstName().compareTo(o2.getUserId().getFirstName()));
        model.addAttribute("allUserInCourse", allUserInCourse);

        if (courseGroupMark!= null){
            courseGroupMark.setGradeOnCourse(Mark);
            courseGroupService.addUserInCourse(courseGroupMark);
        }


        return "courseGroup";
    }
}

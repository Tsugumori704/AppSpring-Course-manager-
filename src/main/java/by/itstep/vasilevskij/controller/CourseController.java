package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseGroupService;
import by.itstep.vasilevskij.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseGroupService courseGroupService;

    @GetMapping
    public String courseList(Model model){

        model.addAttribute("courseList", courseService.coursesActive());
        return "course";
    }

    @GetMapping("{course}")
    public String courseDetails(@PathVariable Course course, Model model){
        model.addAttribute("course", course);
//        model.addAttribute("user", user.getUsername());

        return "courseDetails";
    }

    @PostMapping("{course}")
    public String courseSignUp(@Valid CourseGroup courseGroup,
                               @PathVariable Course course,
                               @AuthenticationPrincipal User user){
        courseGroup.setCourseId(course);
        courseGroup.setUserId(user);

        courseGroupService.addUserInCourse(courseGroup);

//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "redirect:/course";
    }

}

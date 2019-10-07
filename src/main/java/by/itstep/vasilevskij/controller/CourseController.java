package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String courseList(Model model){
        model.addAttribute("courseList", courseService.coursesAll());
        return "course";
    }

    @GetMapping("{course}")
    public String courseDetails(@PathVariable Course course, @AuthenticationPrincipal User user, Model model){
        model.addAttribute("course", course);
        model.addAttribute("user", user.getUsername());

        return "courseDetails";
    }

}

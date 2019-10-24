package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyUserCourseController {
    @Autowired
    CourseGroupService courseGroupService;

    @GetMapping("myUserCourse")
    public String myCourse(Model model,
                           @AuthenticationPrincipal User user
                           ) {

        List<CourseGroup> allCourseInUser = courseGroupService.findAllCourseInUser(user.getId());
        model.addAttribute("allCourseInUser", allCourseInUser);

        return "myUserCourse";
    }
}

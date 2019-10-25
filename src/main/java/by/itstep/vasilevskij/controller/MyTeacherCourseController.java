package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseService;
import by.itstep.vasilevskij.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("myTeacherCourse")
public class MyTeacherCourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping
    public String main(
            Model model,
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") Course deactivationCourse,
            @RequestParam(required = true, defaultValue = "") Course activationCourse
    ) {
        Iterable<Course> teachersCourses = courseService.teachersCourses(user.getId());
        model.addAttribute("teachersCourses", teachersCourses);

        List<User> allTeacher = userService.findAllTeacher();
        model.addAttribute("allTeacher", allTeacher);
        model.addAttribute("url", "/myTeacherCourse");

        /*
        Remove exists car
         */
        if (deactivationCourse != null) {
            courseService.deactivationCourse(deactivationCourse);
        }
        /*
        Reaper exists car
         */
        if (activationCourse != null) {
            courseService.activationCourse(activationCourse);
        }

        return "myTeacherCourse";
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping("{course}&{teacher}")
    public String changeTeacher(
            Model model,
            @PathVariable Course course,
            @PathVariable User teacher

    ) {
        course.setTeacherId(teacher);
        model.addAttribute("url", "/myTeacherCourse");

        return "myTeacherCourse";
    }
}

package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("MyTeacherCourse")
public class MyTeacherCourseController {
    @Autowired
    CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping
    public String main(
            Model model,
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") Course removeCourse,
            @RequestParam (required = true, defaultValue = "") Course reaperCourse
    ){
        Iterable<Course> teachersCourses = courseService.teachersCourses(user.getId());

        model.addAttribute("teachersCourses",teachersCourses);

        /*
        Remove exists car
         */
        if (removeCourse != null){
            courseService.remove(removeCourse);
        }
        /*
        Reaper exists car
         */
        if (reaperCourse != null) {
            courseService.reaper(reaperCourse);
        }

        return "MyTeacherCourse";
    }
}

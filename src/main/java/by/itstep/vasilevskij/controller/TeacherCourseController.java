package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("TeacherCourse")
public class TeacherCourseController {
    @Autowired
    CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping
    public String main(
            Model model
            ){
        return "TeacherCourse";
    }

    @PostMapping
    public String addTeacherCourse(
            Course course,
            BindingResult bindingResult,
            Model model,
            @RequestParam("startDay") String startDay,
            @RequestParam("EndDay") String endDay
            ) {
        Iterable<Course> courses = courseService.coursesAll();

        model.addAttribute("course", course);
        model.addAttribute("courses", courses);


        if (!startDay.isEmpty()){
            course.setStartDate(LocalDate.parse(startDay));
        }
        if (!endDay.isEmpty()){
            course.setEndDate(LocalDate.parse(endDay));
        }
//        courseService.addCourse(course);

        if (bindingResult.hasErrors() || startDay.isEmpty() || endDay.isEmpty()){

            if (startDay.isEmpty()){
                model.addAttribute("startDateError", "Please fill the correct date");
            } else {
                model.addAttribute("startDateError", null);
            }
            if (endDay.isEmpty()){
                model.addAttribute("endDateError", "Please fill the correct date");
            } else {
                model.addAttribute("endDateError", null);
            }


            model.addAttribute("startDay", course.getStartDate());
            model.addAttribute("endDay", course.getEndDate());
            model.addAttribute("courses", courses);
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("course", course);

            return "TeacherCourse";

        } else {
            courseService.addCourse(course);
            return "redirect:/TeacherCourse";
        }



//        courseService.addCourse(course);
//        return "redirect:/TeacherCourse";
    }

}
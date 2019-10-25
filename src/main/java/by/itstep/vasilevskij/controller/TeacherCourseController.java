package by.itstep.vasilevskij.controller;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("teacherCourse")
public class TeacherCourseController {
    @Autowired
    CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping
    public String main(
            Model model,
            @AuthenticationPrincipal User user
            ){
        Iterable<Course> teachersCourses = courseService.teachersCourses(user.getId());

        model.addAttribute("teachersCourses",teachersCourses);
        return "teacherCourse";
    }

    @PostMapping
    public String addTeacherCourse(
            @Valid Course course,
            BindingResult bindingResult,
            Model model,
            @AuthenticationPrincipal User user,
            @RequestParam("startDay") String startDay,
            @RequestParam("EndDay") String endDay
            ) {

        model.addAttribute("course", course);
        model.addAttribute("user", user);

        if (!startDay.isEmpty()){
            course.setStartDate(LocalDate.parse(startDay));
        }
        if (!endDay.isEmpty()){
            course.setEndDate(LocalDate.parse(endDay));
        }

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
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("course", course);

            return "teacherCourse";

        } else {
            if (course.getStartDate().isAfter(course.getEndDate())){
                model.addAttribute("savingReport", "Ошибка записи данныйх");
                return "teacherCourse";
            } else {
                course.setTeacherId(user);
                courseService.addCourse(course);
                return "redirect:/teacherCourse";
            }
        }
    }
}

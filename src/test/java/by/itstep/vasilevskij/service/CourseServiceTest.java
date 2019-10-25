package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.repository.CourseRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @MockBean
    CourseRepo courseRepo;

    private Course courseOne;
    private Course courseTwo;
    private List<Course> courseList;
    private List<Course> courseListNull;
    private User teacherOne;
    private User teacherTwo;


    @Before
    public void setUp() throws Exception {
        teacherOne = new User();
        teacherOne.setId((long) 1);
        teacherTwo = new User();
        teacherTwo.setId((long) 2);


        courseOne = new Course();
        courseOne.setId((long) 1);
        courseOne.setCourseName("Course One");
        courseOne.setDescription("");
        courseOne.setActive(true);
        courseOne.setStartDate(LocalDate.of(2018, 7, 28));
        courseOne.setEndDate(LocalDate.of(2018, 9, 5));
        courseOne.setTeacherId(teacherOne);


        courseTwo = new Course();
        courseTwo.setId((long) 2);
        courseTwo.setCourseName("Course Two");
        courseTwo.setDescription("");
        courseTwo.setActive(false);
        courseTwo.setStartDate(LocalDate.of(2017, 2, 23));
        courseTwo.setEndDate(LocalDate.of(2017, 6, 17));
        courseTwo.setTeacherId(teacherOne);

        courseList = null;
        courseList = Arrays.asList(courseOne, courseTwo);
    }


    @Test
    public void teachersCoursesFindPositive() {
        Mockito.when(courseRepo.findByTeacherId_Id(teacherOne.getId(), Sort.by("courseName"))).thenReturn(courseList);
        Assert.assertEquals(2, courseList.size());
        Assert.assertEquals(courseList.get(0),courseOne);
        Assert.assertEquals(courseList.get(1),courseTwo);
    }
    @Test(expected=NullPointerException.class)
    public void teachersCoursesFindNegative() {
        Mockito.when(courseRepo.findByTeacherId_Id(teacherTwo.getId(), Sort.by("courseName"))).thenReturn(null);
        Assert.assertEquals(0, courseListNull.size());
    }

    @Test
    public void coursesActivePositive() {
        List<Course> courseActiveTrue = new ArrayList<Course>();
        courseActiveTrue.add(courseList.get(0));
        Mockito.when(courseRepo.findByIsActiveTrue()).thenReturn(courseActiveTrue);
        Assert.assertEquals(1, courseActiveTrue.size());
    }

    @Test
    public void coursesActiveNegative() {
        List<Course> courseActiveTrue = new ArrayList<Course>();
        Mockito.when(courseRepo.findByIsActiveTrue()).thenReturn(courseActiveTrue);
        Assert.assertEquals(0, courseActiveTrue.size());
    }

    @Test
    public void coursesAllPositive() {
        Mockito.when(courseRepo.findAll()).thenReturn(courseList);
        Assert.assertEquals(2, courseList.size());
    }

    @Test
    public void coursesAllNegative() {
        Mockito.when(courseRepo.findAll()).thenReturn(courseListNull);
        Assert.assertNull(null);
    }

    @Test
    public void addCoursePositive() {
        boolean addCourse = courseService.addCourse(courseOne);
        Assert.assertTrue(addCourse);
    }

    @Test
    public void deactivationCourse() {
        courseService.deactivationCourse(courseOne);
        Assert.assertFalse(courseOne.isActive());
    }

    @Test
    public void activationCourse() {
        courseService.activationCourse(courseTwo);
        Assert.assertTrue(courseTwo.isActive());
    }
}

package by.itstep.vasilevskij.service;

import by.itstep.vasilevskij.domain.Course;
import by.itstep.vasilevskij.domain.CourseGroup;
import by.itstep.vasilevskij.domain.User;
import by.itstep.vasilevskij.repository.CourseGroupRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseGroupServiceTest {

    @Autowired
    CourseGroupService courseGroupService;

    @MockBean
    CourseGroupRepo courseGroupRepo;

    private CourseGroup courseGroupOneUserOne;
    private CourseGroup courseGroupTwoUserOne;
    private CourseGroup courseGroupOneUserTwo;
    private Course courseOne;
    private Course courseTwo;
    private User userOne;
    private User userTwo;
    private User teacherOne;
    private User teacherTwo;

    @Before
    public void setUp() throws Exception {
        teacherOne = new User();
        teacherOne.setId((long) 1);
        teacherTwo = new User();
        teacherTwo.setId((long) 2);

        userOne = new User();
        userOne.setId((long) 3);
        userTwo = new User();
        userTwo.setId((long) 4);

        courseOne = new Course();
        courseOne.setCourseName("CourseOne");
        courseOne.setTeacherId(teacherOne);

        courseTwo = new Course();
        courseTwo.setCourseName("CourseTwo");
        courseTwo.setTeacherId(teacherTwo);

        courseGroupOneUserOne = new CourseGroup();
        courseGroupOneUserOne.setCourseId(courseOne);
        courseGroupOneUserOne.setUserId(userOne);

        courseGroupOneUserTwo = new CourseGroup();
        courseGroupOneUserTwo.setCourseId(courseOne);
        courseGroupOneUserTwo.setUserId(userTwo);

        courseGroupTwoUserOne = new CourseGroup();
        courseGroupTwoUserOne.setCourseId(courseTwo);
        courseGroupTwoUserOne.setUserId(userTwo);
    }


    @Test
    public void addUserInCourse() {
        boolean addUserInCourse = courseGroupService.addUserInCourse(courseGroupOneUserOne);
        Assert.assertTrue(addUserInCourse);
    }

    @Test
    public void findAllUserInCoursePositive() {
        List<CourseGroup> courseGroupList = Arrays.asList(courseGroupOneUserOne, courseGroupOneUserTwo);
        Mockito.when(courseGroupRepo.findByCourseId_Id(courseOne.getId())).thenReturn(courseGroupList);
        Assert.assertEquals(courseGroupList.get(0), courseGroupOneUserOne);
        Assert.assertEquals(courseGroupList.get(1), courseGroupOneUserTwo);
        Assert.assertEquals(2, courseGroupList.size());
    }

    @Test
    public void findAllUserInCourseNegative() {
        List<CourseGroup> courseGroupList = null;
        Mockito.when(courseGroupRepo.findByCourseId_Id(courseOne.getId())).thenReturn(courseGroupList);
        Assert.assertNull(courseGroupList);
    }

    @Test
    public void findAllCourseInUser() {
        List<CourseGroup> courseGroupList = Arrays.asList(courseGroupOneUserOne, courseGroupTwoUserOne);
        Mockito.when(courseGroupRepo.findByUserId_Id(userOne.getId())).thenReturn(courseGroupList);
        Assert.assertEquals(courseGroupList.size(), 2);
        Assert.assertEquals(courseGroupList.get(0), courseGroupOneUserOne);
        Assert.assertEquals(courseGroupList.get(1), courseGroupTwoUserOne);
    }
}

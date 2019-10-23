<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">teacher</th>
            <th scope="col">courseName</th>
            <th scope="col">startDate</th>
            <th scope="col">endDate</th>
            <th>isActive</th>
            <th>edit</th>
        </tr>
        </thead>
        <tbody>

        <#list teachersCourses as tCourse>
            <tr>
                <th scope="row">${tCourse.id}</th>
                <td>${tCourse.teacherId.firstName} ${tCourse.teacherId.lastName} ${tCourse.teacherId.surName}</td>
                <td>${tCourse.courseName}</td>
                <td>${tCourse.startDate}</td>
                <td>${tCourse.endDate}</td>
                <td>${tCourse.active?then("true","false")}</td>
                <td>${tCourse.active?then(
                    '<a href="MyTeacherCourse?removeCourse=${tCourse.id}"  class="badge badge-pill badge-danger">remove</a>',
                    '<a href="MyTeacherCourse?reaperCourse=${tCourse.id}"  class="badge badge-pill badge-success">reaper</a>'
                    )}
                </td>
            </tr>
        </#list>

        </tbody>
    </table>

</@pt.page>
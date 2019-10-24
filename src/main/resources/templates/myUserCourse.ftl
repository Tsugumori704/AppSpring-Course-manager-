<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>


    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">courseName</th>
                <th scope="col">startDate</th>
                <th scope="col">endDate</th>
                <th scope="col">Grade</th>

            </tr>
        </thead>
        <tbody>
            <#list allCourseInUser as MyCourse>
                <tr>
                    <th scope="row">${MyCourse.id}</th>
                    <td>${MyCourse.courseId.courseName}</td>
                    <td>${MyCourse.courseId.startDate}</td>
                    <td>${MyCourse.courseId.endDate}</td>
                    <td>
                        <#if MyCourse.gradeOnCourse?? >
                            ${MyCourse.gradeOnCourse}
                        </#if>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>

</@pt.page>
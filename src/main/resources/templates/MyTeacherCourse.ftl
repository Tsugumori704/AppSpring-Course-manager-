<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <#if teachersCourses?? >
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">teacher</th>
            <th scope="col">courseName</th>
            <th scope="col">startDate</th>
            <th scope="col">endDate</th>
            <th scope="col">isActive</th>
            <th scope="col">edit</th>
            <th scope="col">changeTeacher</th>
            <th scope="col">group</th>
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
                    '<a href="myTeacherCourse?deactivationCourse=${tCourse.id}"  class="badge badge-pill badge-danger">deactivation</a>',
                    '<a href="myTeacherCourse?activationCourse=${tCourse.id}"  class="badge badge-pill badge-success">activation</a>'
                    )}
                </td>

                <td>
                    <!-- Split dropleft button -->
                    <div class="btn-group">
                        <div class="btn-group dropleft" role="group">
                            <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="sr-only">Toggle Dropleft</span>
                            </button>
                            <div class="dropdown-menu">
                                <#list allTeacher as Teacher>
                                    <a class="dropdown-item" href="myTeacherCourse/${tCourse.id}&${Teacher.id}">${Teacher.firstName} ${Teacher.lastName} ${Teacher.surName}</a>
                                </#list>
                            </div>
                        </div>
                        <button type="button" class="btn btn-secondary">
                            Change Teacher
                        </button>
                    </div>
                </td>

                <td>
                    <a href="courseGroup/${tCourse.id}" class="btn btn-primary">group</a>
                </td>
            </tr>
        </#list>
        <#else>

            <div class="alert alert-success" role="alert">
                Teacher changed
            </div>
        <a class="btn btn-primary" href="/myTeacherCourse" >Return</a>
        </#if>

        </tbody>
    </table>



</@pt.page>
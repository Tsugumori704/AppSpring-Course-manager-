<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Course name</th>
            <th scope="col">User</th>
            <th scope="col">Grade</th>
            <th scope="col">addGrade</th>
        </tr>
        </thead>

        <tbody>
            <#list allUserInCourse as userCour>
                <tr>
                    <th scope="row">${userCour.id}</th>
                    <td>${userCour.courseId.courseName}</td>
                    <td>${userCour.userId.firstName} ${userCour.userId.lastName} ${userCour.userId.surName}</td>
                    <td>
                        <#if userCour.gradeOnCourse??>
                            ${userCour.gradeOnCourse}
                        </#if>
                    </td>
                    <td>
                        <div class="btn-group">
                            <div class="btn-group dropleft" role="group">
                                <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="sr-only">Toggle Dropleft</span>
                                </button>
                                <div class="dropdown-menu">

                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${1}">1</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${2}">2</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${3}">3</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${4}">4</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${5}">5</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${6}">6</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${7}">7</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${8}">8</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${9}">9</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=${10}">10</a>
                                    <a class="dropdown-item" href="?courseGroupMark=${userCour.id}&Mark=">null</a>

                                </div>
                            </div>
                            <button type="button" class="btn btn-secondary">
                                AddGrade
                            </button>
                        </div>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>



</@pt.page>
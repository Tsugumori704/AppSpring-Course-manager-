<#include "security.ftl">
<#import "login.ftl" as l>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Spring Boot App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/course">Course</a>
            </li>
            <#if isAdmin || isTeacher>
                <li class="nav-item dropdown">
<#--                    <a class="nav-link" href="/TeacherCourse">Teacher Course</a>-->

                    <a class="nav-link dropdown-toggle" href="MyTeacherCourse" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Teacher Course
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/TeacherCourse">Add Teacher Course</a>
                        <a class="dropdown-item" href="/MyTeacherCourse">Teacher Course</a>
                    </div>

                </li>
            </#if>
<#--            <#if isAdmin || isTeacher>-->
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3"><#if user??>${name}<#else>Please, login</#if></div>
        <@l.logout />
    </div>
</nav>
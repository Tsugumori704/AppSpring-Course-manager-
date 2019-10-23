<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

    Описание курса
    ${course.courseName}
    ${course.description}
    course.ID=
    ${course.id}

    ${user.email}
    ${user.firstName}
    user.ID=
    ${user.id}

    <a class="btn btn-secondary" href="#" role="button">sign up</a>

    <div class="form-group mt-3">
        <form method="post">

            <input type="hidden" name="id" value="<#if course?? && course.id??>${course.id}</#if>">

            <div class="form-group mt-2">
                <button type="submit" class="btn btn-primary">
                    sign up
                </button>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>

</@pt.page>
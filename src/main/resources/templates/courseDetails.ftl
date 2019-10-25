<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

<#--    Описание курса-->
<#--    ${course.courseName}-->
<#--    ${course.description}-->
<#--    course.ID=-->
<#--    ${course.id}-->

<#--    ${user.email}-->
<#--    ${user.firstName}-->
<#--    user.ID=-->
<#--    ${user.id}-->

    <div class="card text-center">
        <div class="card-header">
            Course teacher: ${user.firstName} ${user.lastName} ${user.surName}
        </div>
        <div class="card-body">
            <h5 class="card-title">${course.courseName}</h5>
            <p class="card-text">${course.description}</p>
            <div class="form-group mt-3">
                <form method="post">

                    <input type="hidden" name="id" value="<#if course?? && course.id??>${course.id}</#if>">

                    <div class="form-group mt-2">
                        <button type="submit" class="btn btn-primary">
                            join the course
                        </button>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form>
            </div>
        </div>
        <div class="card-footer text-muted">
<#--            2 days ago-->
        </div>
    </div>


<#--    <div class="form-group mt-3">-->
<#--        <form method="post">-->

<#--            <input type="hidden" name="id" value="<#if course?? && course.id??>${course.id}</#if>">-->

<#--            <div class="form-group mt-2">-->
<#--                <button type="submit" class="btn btn-primary">-->
<#--                    sign up-->
<#--                </button>-->
<#--            </div>-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--        </form>-->
<#--    </div>-->

</@pt.page>
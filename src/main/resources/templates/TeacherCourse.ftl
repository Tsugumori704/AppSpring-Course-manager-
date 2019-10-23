<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

<#--    Редактирование курса-->
<#--    ${user.firstName}-->
<#--    ${user.lastName}-->
<#--    ${user.surName}-->
<#--    ${user.id}-->

    <h3>Add Course</h3>
    <#if savingReport??><div class="alert alert-danger" role="alert">${savingReport}</div></#if>

    <div class="form-group mt-3">
        <form method="post">

            <input type="hidden" name="id" value="<#if course?? && course.id??>${course.id}</#if>">
<#--            <input type="hidden" name="teacherId" value="<#if user.id??>${user.id}</#if>">-->


            <div class="form-group">
                <input type="text" name="courseName"
                       class="form-control ${(courseNameError??)?string('is-invalid', '')}"
                       value="<#if course??>${course.courseName}</#if>" placeholder="Enter the courseName">
                <#if courseNameError??>
                    <div class="invalid-feedback">
                        ${courseNameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" name="description"
                       class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                       value="<#if course??>${course.description}</#if>" placeholder="Enter the description">

<#--                <textarea name="description" class="form-control" cols="40" rows="3" placeholder="Enter the description"></textarea>-->

                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="date" name="startDay"
                       class="form-control ${(startDateError??)?string('is-invalid', '')}"
                       value="<#if course?? && course.startDate??>${course.startDate}</#if>" placeholder="Enter the startDate">
                <#if startDateError??>
                    <div class="invalid-feedback">
                        ${startDateError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="date" name="EndDay"
                       class="form-control ${(endDateError??)?string('is-invalid', '')}"
                       value="<#if course?? && course.endDate??>${course.endDate}</#if>" placeholder="Enter the endDate">
                <#if endDateError??>
                    <div class="invalid-feedback">
                        ${endDateError}
                    </div>
                </#if>
            </div>

            <div class="form-group mt-2">
                <button type="submit" class="btn btn-primary">
                    <#if !course??>
                        Create
                    <#else>
                        Update
                    </#if>
                </button>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>

</@pt.page>
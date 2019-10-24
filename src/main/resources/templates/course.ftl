<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

    <style>
        p.clip {
            white-space: nowrap; /* Запрещаем перенос строк */
            overflow: hidden; /* Обрезаем все, что не помещается в область */
            text-overflow: ellipsis; /* Добавляем многоточие */
        }
    </style>

    <div class="card-columns">

            <#list courseList as course>
                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header">Course
                        <p class="card-text">Started: ${course.startDate} - ${course.endDate}</p>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${course.courseName}</h5>
                        <p class="clip">${course.description}</p>
                        <p><a class="btn btn-secondary" href="/course/${course.id}" role="button">View details »</a></p>
                    </div>
                </div>
            </#list>




        </div>

        <hr>

    </div>

</@pt.page>
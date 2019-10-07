<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

    Описание курса
    ${course.courseName}
    ${course.description}

    ${user.email}
    ${user.firstName}

</@pt.page>
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <h1>User editor</h1>

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@pt.page>
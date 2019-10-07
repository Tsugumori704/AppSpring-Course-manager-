<#import "parts/pageTemplate.ftl" as pt>


<@pt.page>
    <h2>${username}</h2>
    ${message?ifExists}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-6">
                <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
            </div>
        </div>
<#--        <div class="form-group row">-->
<#--            <label class="col-sm-2 col-form-label">LastName:</label>-->
<#--            <div class="col-sm-6">-->
<#--                <input type="text" name="lastName" class="form-control" placeholder="lastName" value="${lastName!''}"/>-->
<#--            </div>-->
<#--        </div>-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Save</button>
    </form>
</@pt.page>
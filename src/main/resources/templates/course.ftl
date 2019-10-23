<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>

    <div class="card-columns">
        <!-- Example row of columns -->
<#--        <div class="row">-->
<#--            <div class="col-md-4">-->
<#--                <h2>Heading</h2>-->
<#--                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>-->
<#--                <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>-->
<#--            </div>-->
<#--            <div class="col-md-4">-->
<#--                <h2>Heading</h2>-->
<#--                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>-->
<#--                <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>-->
<#--            </div>-->
<#--            <div class="col-md-4">-->
<#--                <h2>Heading</h2>-->
<#--                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>-->
<#--                <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>-->
<#--            </div>-->

            <#list courseList as course>
<#--                <div class="col-md-4">-->
<#--                    <h2>${course.courseName}</h2>-->
<#--                    <p>Started: ${course.startDate} - ${course.endDate}</p>-->
<#--                    <p>${course.description}</p>-->
<#--                    <p><a class="btn btn-secondary" href="/course/${course.id}" role="button">View details »</a></p>-->
<#--                </div>-->
                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header">Course
                        <p class="card-text">Started: ${course.startDate} - ${course.endDate}</p>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${course.courseName}</h5>
                        <p>${course.description}</p>
                        <p><a class="btn btn-secondary" href="/course/${course.id}" role="button">View details »</a></p>
                    </div>
                </div>
            </#list>




        </div>

        <hr>

    </div>

</@pt.page>
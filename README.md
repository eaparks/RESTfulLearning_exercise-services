# Time for REST-fresher course.

This is my exercise code from Pluralsight course:
    https://app.pluralsight.com/library/courses/restful-services-java-using-jersey/table-of-contents
    
## TODO:
    1. check out `PATCH` - new to JAX since ??
    2. [Spring Fundamentals](http://pluralsight.com/training/Courses/TableOfContents/spring-fundamentals)
    3. [Spring JPA with Hibernate](http://pluralsight.com/training/Courses/TableOfContents/spring-jpa-hibernate)
    3. [Spring MVC](http://pluralsight.com/training/Courses/TableOfContents/springmvc-intro)
    
Uses Jersey. Visit <a href="http://jersey.java.net">Project Jersey website</a>
                 for more information on Jersey!

###`GET`

###`POST`

###`PUT`

###`DELETE`

-Like PUT, not supported in early browsers  
-url example:
        http://localhost:8080/exercise-services/webapi/activities/1234  
-**Careful!** - can be recursive  
-Idempotent (can call repeatedly without messing anything up)
    
###`Searching`

Two approaches
1. query params on url (typically with GET)  
-Using GET allows for cacheing  
-No constraints eg >, <  
-No DSL  
2. make searching a top level object  
-less RESTful  
-typically used with POST  
        



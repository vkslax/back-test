# Nabenik's Java EE basic test

Hi and welcome to this test. As many technical interviews, main test objective is to determine your actual EE skill, being:

- General Java knowledge
- General toolkits, SDK's and other usages
- Java EE general skills

To complete this test, please create a fork of this repository, commit the solutions/answers to YOUR copy and finally do a pull request to the original repo.

The document is structured using [GitHub Markdown Flavor](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#code).

## General questions

1. How should you answer these questions?

> Like this

Or maybe with code

```kotlin
fun hello() = "world"
```

2. Please enumerate al least 3 Java EE APIs being used at this project, also define it's main objective
     ```
     Java Persistance API: Manage database operations, creates a mapping between relational data and Java objects.
     
     JAX-RS: Provides support to develop REST Web Services.
     
     Dependency injection: Allow the injection of functionalities coded in other classes,
     so it give us a better order in classes responsabilities. 
     ```
    
3. Which of the following is not an application server?

    * Tomcat
    * Undertow
    * Grizzly
    * Netty
    ```
    Tomcat is not an application server, only a web server, a servlet container, works well with JSP.
    ```
    
4. This project defines two main profiles. Which one will be the default if -P argument is not used on Maven?
    ```
    arquillian-payara-embedded, indicated by the tag "activeByDefault"
    ```

5. Could you guess if this project will be supported on many application servers? Which ones? Why is this possible?
    ```
    Base project should be supported by those servers who have JavaEE capabilities, 
    like Glassfish or Payara. Some servers will need to have extra libraries 
    added to the project in order to obtain that capability. However, it's important 
    to notice than without changes, payara-embedded-web and arquillian-payara-server 
    are added so, project will run on payara.
    ```

6. If no database is configured? Will you be able to run this project? Why?
    ```
    Yes, in persistance.xml, the create-source and drop-source its defined as metadata, 
    the action it's drop and create, so an instance in memory is created in every deployment.
    In case full database is needed, it's possible to set a glassfish-resources.xml file to payara-embedded
    ```

## Development tasks

1. (easy) Please include a screenshot of this project building on a regular CLI
![](p1.JPG?raw=true)
2. (easy) Please include a screenshot of this project running on an IDE of your choice
![](p2.JPG?raw=true)
    ```
    IntelliJ was choosen.
    ```
3. (medium) Please deploy this project to a compatible application server, later include the screenshot of the list Movies endpoint
![](p3.JPG?raw=true)
    ```
    It was used Payara Micro.
    ```
3. (medium) Include a screenshot of each of the endpoint operations, if needed please also check/fix the code
![post](post.JPG?raw=true)
![put](put.JPG?raw=true)
![get1](get1.JPG?raw=true)
![delete](delete.JPG?raw=true)
![getall](getall.JPG?raw=true)
4. (medium) Add support to Bean Validation for the entity Movie and validate nulls on REST layer
    ```
    Not Null was added to movie title, year and duration.
    ```

5. (hard) Please identify the Integration Testing for `MovieRepository`, after that implement each of the non-included CRUD methods
![](p5.JPG?raw=true)

6. (hard) This project includes support for [Oracle Weblogic](https://www.oracle.com/technetwork/middleware/weblogic/downloads/wls-main-097127.html), please include a screenshot with your modifications being tested with Weblogic 
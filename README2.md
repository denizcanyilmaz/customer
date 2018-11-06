# Customer Management Assessment

# What I used? 
* IntelliJ Idea(Ultimate Version) for development.
* Spring Boot and Java Maven in backend
* Vue.js in HTML page to connect end sides.
* Bootstrap to design. (Found templates in https://bootsnipp.com/)
* Effective usage of Css to change bootstrap templates.
    - Effective usage of JS in Vue.Js part
* Axios to send requests backend side.
* H2 Embedded Relational Database Management System. 
    - I used H2, because of easy usage. It does not require any extra download process.
* Unit tests.
    
# Lacks, How to improve?

* H2 was enough to do basic operations in  customer management project. 
    - However, in complex projects, other RDMS can use for complicated SQL queries.
    
* Customer entity has name, surname, identity number, phone nuber and job information. All of them are String attributes.
    - ID number can change Primary Key, and it can limited to 11 digits -for Turkey-.
    
* Usage of Vue.JS
    - I used Vue.js script in my HTML page because of time. Therefore, there are several warnings about Vue.js function usage, but they are working properly.
    - Vue.JS can develop like any other project. Spring Boot and Vue.JS can connect.
    
* Usage of Unittest
    - I didnot use Unit test before, so I wrote unit test codes for just controllers in spring boot.
    
* <b> Frontend side: </b> In customer management page:("localhost:8081/customersapp")  
    - Add and Update Forms accept empty inputs. But, User can handle this problem with Update or Delete operation in project.
        * To solve, system can do restrictions in Input tags.
    - Page refresh after click a button to update new information in page.
        * I used location.reload() in JS,not good. It can solve with other JS functions for efficient solution.
    - There is no search and sort features for table.
        * Datatable can use for a better user interface
    - Main page doesnot have authorization operation to show page. I just developed a mechanism to ask users for credentials in LOGIN page.
    

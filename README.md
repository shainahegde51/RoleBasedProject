# RoleBasedProject


Role based project is a springboot project which includes spring security and JPA implementation aswell.

Prerequisites to run this project

*Intellij IDE(IntelliJ IDEA 2022.1.4 (Community Edition)
Runtime version: 11.0.15+10-b2043.56 amd64)

*Mysql Database(Server version: 8.0.30 MySQL Community Server - GPL)

*Postman (for api testing)


Steps to run the apis

1. "/addUser" (This api will help us to register new user and this can be accessed by anyUser (admin/user))

*Open PostMan

*Mention the end point "http://localhost:8080/addUser"

*Select the POST call

*Add the requestbody in json format and hit the send button

*If its successful, we will get the message saying "New User Added"

check this out :https://drive.google.com/file/d/1WeS9I6Iehv8LfDbP_siuCyUWwSBauevx/view?usp=share_link


2."/welcome" (Its a public api which is accessible by anyUser (admin/user))

*Open PostMan

*Mention the end point "http://localhost:8080/welcome"

*Select the GET call

*If its successful, we will get the message saying "Welcome to our website"

check this out : https://drive.google.com/file/d/1fNXSoCBGQzOUYy7yW5dHMxv6JqzPqXEy/view?usp=share_link


3. "/admin" (Its a private api which can only be accessed by the person with admin role)

*Open PostMan

*Mention the end point "http://localhost:8080/admin"

*Select the GET call

*Go to "Authorization" section and select the type as BASIC AUTH 

*add credentials(username & password) in its respective field and hit send button

*If its successful, we will get the message saying "Hi welcome to the Admin Page"

check this : https://drive.google.com/file/d/15BjuAhxH9ndm6QSYism6qWgx-knoeOJ8/view?usp=share_link


4."/user" (Its a private api which can only be accessed by the person with user role)

*Open PostMan

*Mention the end point "http://localhost:8080/user"

*Select the GET call

*Go to "Authorization" section and select the type as BASIC AUTH 

*add credentials(username & password) in its respective field and hit send button

*If its successful, we will get the message saying "Hi welcome to the Home Page"

check this out : https://drive.google.com/file/d/1pWVoeiv5obRb9zg8YeDii9iENizDsNfu/view?usp=share_link



The passwords in database displays in encrypted manner
check this out :
https://drive.google.com/file/d/1k5MvIpuWZ15Ni8N8x0xKoLlr4Fd6LrJT/view?usp=share_link





# nals-todo
My java test at NALS - REST API for Todo App.

Enviroment :
  JDK 8
  MySQL 5.7
  Spring Boot 2.2.1

Functions :
  1. Sign up user
  2. Login
  3. Show profile user
  4. Show work list with pagination
  5. CRUD work

Tutorial :
  1. Sign up user
     - API path : http://localhost:8888/api/auth/signup
     - Method : POST
     - Request Body : 
        Ex : 
          {
            "name":"Tran Phuc Vinh",
            "username":"admin",
            "email":"vinhtranphuc@gmail.com",
            "password":"111111"
          }
     ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/signup.png)
  2. Login
    - API path : http://localhost:8888/api/auth/signin
    - Method : POST
    - Request Body : 
        Ex : 
          {
            "usernameOrEmail":"admin",
            "password":"111111"
          }
    - If login is valid then get access token response use for another request !
    ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/accessToken.png)
  3. Show profile user
    - API path : http://localhost:8888/api/users/{username}
    - Method : GET
    - Path Variables :
        Ex : username = admin => http://localhost:8888/api/users/admin
    ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/profile.png)
  

# nals-todo
My java test at NALS - REST API for Todo App.

Enviroment :
  * JDK 8
  * MySQL 5.7
  * Spring Boot 2.2.1

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
  4. Show work list with pagination
     - API path : http://localhost:8888/api/todo/works?page=1&sizeOfPage=2
     - Method : GET
    ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/todoListPagination.png)
  5. CRUD work
     - create work : 
        + API path : http://localhost:8888/api/todo/create-work
        + Method : POST
        + Request Body :
          Ex:
            {
              "work_name":"xxxxxx",
              "description":"xxxxx1231 1231321321321",
              "start_date":"2020-04-08 10:01:32",
              "end_date":"2020-04-20 10:01:32"
            }
    ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/createWork.png)
      - edit work : 
        + API path : http://localhost:8888/api/todo/edit-work
        + Method : PUT
        + Request Body :
          Ex:
            {
              "id":"2",
              "work_name":"Work 2 edited",
              "description":"Work 2 edited",
              "start_date":"2020-02-08 10:01:32",
              "end_date":"2020-04-20 10:01:32"
            }
     ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/editWork.png)
      - delete work : 
        + API path : http://localhost:8888/api/todo/delete-work/{work_id}
        + Method : DELETE
        + Path Variables : Ex work_id = 10 => http://localhost:8888/api/todo/delete-work/10
    ![alt text](https://github.com/vinhtranphuc/nals-todo/blob/master/tutorial-img/deleteWork.png)

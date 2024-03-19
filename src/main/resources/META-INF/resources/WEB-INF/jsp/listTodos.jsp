<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html
   <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.css" rel="stylesheet">

        <title> Web App</title>
   </head>
   <body>
        <div class ="container">
            <h1>Welcome ${name}</h1>
   <hr>

   <h2>Your Todos</h2>
   <table>
       <thead>
          <tr>
              <th>id</th>
              <th>Description</th>
              <th>Target Date</th>
              <th>Is Done?</th>
          </tr>
       </thead>
       <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>
   </table>

    <a href="add-Todo" class="btn btn-success">Add Todo</a>

       </div>

       <script src= "webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
       <script src= "\webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>

   </body>
</html>

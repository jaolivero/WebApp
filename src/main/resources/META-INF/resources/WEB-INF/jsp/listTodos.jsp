<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

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
              <th></th>
              <th></th>
          </tr>
       </thead>
       <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>

                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href ="update-Todo?id=${todo.id}" class="btn btn-warning">UPDATE</a> </td>
                    <td><a href ="delete-Todo?id=${todo.id}" class="btn btn-Danger">DELETE</a> </td>

                </tr>
            </c:forEach>
        </tbody>
   </table>

    <a href="add-Todo" class="btn btn-success">Add Todo</a>

       </div>

      <%@ include file="common/footer.jspf" %>


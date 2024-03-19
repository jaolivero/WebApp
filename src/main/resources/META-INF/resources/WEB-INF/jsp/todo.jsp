<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <html>
       <head>
       <title>Add Todo</title>
       </head>

       <body>
           <div class="container">
               <h1> ${greetings} ${name}</h1>
               <h2> Enter your todo</h2>
               <form:form method="post" modelAttribute="todo">
                        Description:<form:input type="text" path="description"/>
                        <form:input type="hidden" path="id" required="required"/>
                        <form:input type="hidden" path="done" required="required"/>
                    <input type="submit" class="btn btn-success" />
               </form:form>
           </div>

           <script src= "webjars\bootstrap\5.1.3\js\bootstrap.min.js"> </script>
           <script src= "\webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        </body
   </html>


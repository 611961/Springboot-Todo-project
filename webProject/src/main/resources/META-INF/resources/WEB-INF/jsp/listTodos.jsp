<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Project 1</title>
</head>
<body>

 	
	<%@ include file="common/Navigation.jspf" %>   <!-- for access the navgtn jspf page here -->
	
    <div class="container">
   <h1>${name} , your todos are : </h1>
   
   <hr>
   
   
   <table class ="table">
      <thead>
         <tr>
   
         <th>Description</th>
         <th>Target date</th>
         <th>Done</th>
    </tr>
    </thead>
      <tbody>
   <c:forEach items="${todos}" var="todo">
   		<tr>
  			
   			<td>${todo.description}</td>
   			<td>${todo.date }</td>
   			<td>${todo.done}</td>
   			<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
   			<td><a href="update-todo?id=${todo.id}" class ="btn btn-warning">Update</a></td>
   		</tr>
   		</c:forEach>
      </tbody>
   </table>
   <a href="add-todo" class=" btn btn-success">Add Todo</a>
   </div>
   <script src ="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
   <script src ="webjars/jquery/3.6.0/jquery.min.js"></script>
   
</body>
</html>

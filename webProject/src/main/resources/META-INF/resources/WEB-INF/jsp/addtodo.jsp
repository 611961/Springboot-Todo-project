<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
	 <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	 <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
     <title>Project 1</title>
  </head>
  
<body>

	<%@ include file="common/Navigation.jspf" %>   <!-- for access the navgtn jspf page here -->
	
 	

    <div class ="container">
    <h1>Enter Todo Details: </h1>
    
   
    <form:form method="post" modelAttribute="todo">  <!-- frm frm allow mdl atbt to direct bind dscrptn + todo without param -->
    
    	<fieldset class ="mb-3">
		 <!-- maping dscrptn with todo clas dscrptn using frm librry \|/   !-->
		 
    	 <form:label path ="description">Description</form:label>  <!-- path always should match some of getter str -->
		 <form:input type ="text" path="description" name="description" required="required"/>
		 <form:errors  path="description" cssClass ="text-warning" />
		 </fieldset>
    
    
    <fieldset class ="mb3">
    <form:label path ="date">Target Date</form:label> 
		 <form:input type ="text" path="date" name="description" required="required"/>
		 <form:errors  path="date" cssClass ="text-warning" />
		 </fieldset>
         
		 
		 
		 <form:input type ="hidden" path="id"/>
		 <form:input type ="hidden" path="done" />
		 
		<input type ="submit" class ="btn btn-success" >   
    </form:form>
    
    	</div>
    	
   		<%@ include file="common/footer.jspf" %>   <!-- for access the footer jspf page here -->
   
</body>
</html>

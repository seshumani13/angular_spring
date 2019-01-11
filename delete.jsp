<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
</head>
<body>
<div ng-app="myApp">
 <h2>Record to be Deleted</h2>
       <form name="StudentForm" method = "GET" action = "http://localhost:8080/Angular_SpringMVC/deletestudent/{id}">
 
         <table>
           
            <tr>
                <td>id</td><td><input type="text" name="id" ng-model="id"  path="id" required></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form>
      </div>
</body>
</html>
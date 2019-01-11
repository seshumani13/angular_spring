<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Record</title>
</head>
<body>
 <h2>Student Record to be updated</h2>
      <form name="StudentForm" method = "GET" action = "http://localhost:8080/Angular_SpringMVC/editsave">
         <table>
            <tr>
            <td>Name</td>
            	 <td><input type="text" name="name" ng-model="name" required></td>
            </tr>
            <tr>
                <td>Age</td><td><input type="text" name="age" ng-model="age" required></td>
            </tr>
            <tr>
                <td>id</td><td><input type="text" name="id" ng-model="id" required></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form>
</body>
</html>
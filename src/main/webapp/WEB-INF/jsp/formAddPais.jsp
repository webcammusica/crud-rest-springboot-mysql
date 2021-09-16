<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
 
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
    <link rel="shortcut icon" type="image/png" href="/favicon.png">
 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <title>Bienvenida</title>
 
</head>
 
<body>
 
      <form method="get" action="http://localhost:9090/countries/addPais">
            Nombre: <input type = "text" name = "name" />
            Población: <input type = "text" name = "population" />
        	input:<input type="submit"/>
     </form>
      
 
</body>
 
</html>
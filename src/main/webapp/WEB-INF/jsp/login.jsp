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
   
    <title>Bienvenida</title>
 
</head>
 
<body>
 
     <form id="form1" name="myform" method="get" action="http://localhost:9090/countries/input">
                 Usuario: <input type = "text" name = "yonghu" />
                 Contraseña: <input type = "password" name = "mima" />
        input:<input type="submit"/>
     </form>
      
 
</body>
 
</html>
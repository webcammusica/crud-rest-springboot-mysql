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
    <title>Listado de países</title>
 
</head>
 
<body>
 
   <div class="container">
 
      <div class="title">
        <h1>Reporte 1</h1>
      </div>
 
      <c:choose>
 
            <c:when test="${not empty tuplasR1}">
     
                <ul>
                    <c:forEach var="tupla" items="${tuplasR1}">
                        <li> ${tupla.nombrePersona} 
                        , id: ${tupla.idPersona}, 
                        viene de ${tupla.pais}</li>
                    </c:forEach>
                </ul>
     
            </c:when>
             
            <c:otherwise>
                <b>No hay registros para este reporte.</b>
            </c:otherwise>
             
        </c:choose>
    </div>
 
    <footer class="footer">
      <div class="container">
        <p class="text-muted"><a href="https://webcammusica.blogspot.com">webcam música</a></p>
      </div>
    </footer>
 
</body>
 
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="InicioEstudiantes">Estudiantes</a></p>
        <p><a href="InicioInscripciones">Inscripciones</a></p>
        <h1>Cursos</h1>
        
        <p><a href="InicioCurso?action=add">Nuevo Curso</a></p>
        <table border = "1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Modificar</th>
                <th>Elimimar</th>
            </tr>

            <tr><c:forEach var="item" items="${cursos}">

                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td><a href="InicioCurso?action=edit&id=${item.id}">Modificar</a></td>
                    <td><a href="InicioCurso?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

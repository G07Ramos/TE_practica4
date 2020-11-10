<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="InicioCurso">Curso</a></p>
        <p><a href="InicioEstudiantes">Estudiantes</a></p>
        <h1>Inscripciones</h1>
        <p><a href="InicioInscripciones?action=add">Nuevo Inscripcion</a></p>
        <table border = "1">
            <tr>
                <th>Curso</th>
                <th>Nombre</th>
                <th>Nota final</th>
                <th>Modificar</th>
                <th>Elimimar</th>
            </tr>

            <tr><c:forEach var="item" items="${inscripcion}">

                    <td>${item.curso}</td>
                    <td>${item.nombre}</td>
                    <td>${item.nota_final}</td>
                    <td><a href="InicioInscripciones?action=edit&id=${item.id}">Modificar</a></td>
                    <td><a href="InicioInscripciones?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

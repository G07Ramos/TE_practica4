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
        <p><a href="InicioInscripciones">Inscripciones</a></p>
        <h1>Estudiantes</h1>

        <p><a href="InicioEstudiantes?action=add">Nuevo Estudiante</a></p>
        <table border = "1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th>Modificar</th>
                <th>Elimimar</th>
            </tr>

            <tr><c:forEach var="item" items="${estudiantes}">

                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.correo}</td>
                    <td><a href="InicioEstudiantes?action=edit&id=${item.id}">Modificar</a></td>
                    <td><a href="InicioEstudiantes?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

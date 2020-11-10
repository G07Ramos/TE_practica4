<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${estudiantes.id==0}">Nuevo</c:if>
            <c:if test="${estudiantes.id!=0}">Editar</c:if>
            Estudiantes
        </h1>
            <form action="InicioEstudiantes" method="post">
                <input type="hidden" name="id" value="${estudiantes.id}"/>
                <table>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="${estudiantes.nombre}"/></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="${estudiantes.apellidos}"/></td>
                    </tr>
                    <tr>
                        <td>Correo:</td>
                        <td><input type="text" name="correo" value="${estudiantes.correo}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit"/></td>
                    </tr>
                </table>
            </form>
    </body>
</html>

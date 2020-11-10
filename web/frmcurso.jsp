<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${cursos.id==0}">Nuevo</c:if>
            <c:if test="${cursos.id!=0}">Editar</c:if>
            Curso
        </h1>
            <form action="InicioCurso" method="post">
                <input type="hidden" name="id" value="${cursos.id}"/>
                <table>
                    <tr>
                        <td>Descripcion:</td>
                        <td><input type="text" name="descripcion" value="${cursos.descripcion}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit"/></td>
                    </tr>
                </table>
            </form>
    </body>
</html>

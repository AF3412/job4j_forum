<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <c:if test="${post.id == -1}">
                    Новая тема.
                </c:if>
                <c:if test="${post.id != -1}">
                    Редактирование темы.
                </c:if>
            </div>
        </div>
    </div>
</div>
<h1>Создание новой темы</h1>
<form  action="<c:url value='save' />" method='POST'>
    <table>
        <tr>
            <td><label for="post_name">Название</label></td>
            <td><input id="post_name" type='text' name='name'></td>
        </tr>
        <tr>
            <td><label for="post_desc">Текст</label></td>
            <td><input id="post_desc" type='text' name='desc'></td>
        </tr>

        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>

    </table>
</form>
</body>
</html>
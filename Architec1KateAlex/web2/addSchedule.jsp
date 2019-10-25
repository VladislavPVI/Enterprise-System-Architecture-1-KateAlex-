<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: otori
  Date: 25-Oct-19
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>
<form action="addSchedule" method="post">
    Название хобби: ${hobby_name}
    <select name="hobbyid" required>
        <option value="${schedule.hobbyid}">Изменить</option>
        <c:forEach items="${allHobby}" var="hobby">
            <option value="${hobby.id}"><c:out value="${hobby.name}" /></option>
        </c:forEach>
    </select>
   <br />
    <label for="datetime">Дата и время:
        <input type="datetime-local" id="datetime" value="${schedule.localDateTime}" name="localDateTime"  />
    </label>  <br />
    <label for="mark">Введите оценку:
        <input type="number" id="mark" value="${schedule.mark}" name="mark" />
    </label>  <br />

    Выполнено?:
       ${schedule.complete}  <select name="complete">
    <option value="${schedule.complete}">Изменить</option>
    <option value="true">Да</option>
    <option value="false">Нет</option>

</select>
     <br />

    <input type="hidden" name="id" value="${schedule.id}" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>

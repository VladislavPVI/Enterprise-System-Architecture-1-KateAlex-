<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: otori
  Date: 25-Oct-19
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<h3>Все хобби</h3>
(<a href="addHobby">добавить</a>)
<c:forEach items="${allHobby}" var="hobby">
    <li>
        Название: ${hobby.name}
        Часы в неделю: ${hobby.hoursperweek}
        Приоритет: ${hobby.priority}
        <a href="addHobby?edit=${hobby.id}">редактировать</a> | <a href="deleteHobby?id=${hobby.id}">удалить</a>

    </li>
</c:forEach>
<h3>Все расписание</h3>
(<a href="addSchedule">добавить</a>)
<c:forEach items="${allSchedule}" var="one">
    <li>
        Хобби: ${one.hobbyid}
        Дата и время: ${one.localDateTime}
        Оценка: ${one.mark}
        Завершено?: ${one.complete}
        <a href="addSchedule?edit=${one.id}">редактировать</a> | <a href="deleteS?id=${one.id}">удалить</a>

    </li>
</c:forEach>
</body>
</html>

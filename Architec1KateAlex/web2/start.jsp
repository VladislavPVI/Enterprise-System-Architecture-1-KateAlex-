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
<style>

    .note{
        background: url(img/note.png) no-repeat;
        width: 561px;
        height: 657px;
        position: absolute;
        right: 400px;
        bottom: 200px;
        box-sizing: border-box;
        padding: 20px 56px 20px 70px;
       }
    body {
        background: url(img/back2.jpg);
        background-size: 100%;
        font-size:20px;
    }

</style>
<head>
    <title>Start page</title>
</head>

<header>

    <details>
        <summary style="font-size:30px">
            Все хобби
        </summary>
(<a href="addHobby">добавить</a>)
<c:forEach items="${allHobby}" var="hobby">
    <li>
        Название: ${hobby.name}
        Часы в неделю: ${hobby.hoursperweek}
        Приоритет: ${hobby.priority}
        <a href="addHobby?edit=${hobby.id}">редактировать</a> | <a href="deleteHobby?id=${hobby.id}">удалить</a>

    </li>
</c:forEach>
    </details>

<details>
    <summary style="font-size:30px">
    Все расписание
    </summary>
(<a href="addSchedule">добавить</a>)
<c:forEach items="${allSchedule}" var="one">
    <li>
        Хобби:
        <c:forEach items="${allHobby}" var="hobby">
        <c:if test="${hobby.id==one.hobbyid}">
            ${hobby.name}
        </c:if>
        </c:forEach>
        Дата и время: ${one.localDateTime}
        Оценка: ${one.mark}
        Завершено?: ${one.complete}
        <a href="addSchedule?edit=${one.id}">редактировать</a> | <a href="deleteS?id=${one.id}">удалить</a>

    </li>
</c:forEach>
</details>


    </header>
<body>
<div class="note">
    <p align="center" style="font-size:30px">
        Привет!
        Это твой планировщик дня!</p>
    <p align="center" style="font-weight: bold;">
        ${now}</p>

    <p align="center" style="font-size:20px">Все дела на сегодня:

        (<a href="addSchedule">добавить</a>)
    </p>
    <c:if test="${!empty schedule_today}">
        <c:forEach items="${schedule_today}" var="today">
            <li>
                    ${today}
            </li>
        </c:forEach>
    </c:if>
    <c:if test="${empty schedule_today}">


        Сегодня дел нет
    </c:if>
</div>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="addHobby" method="post">
    <label for="name">Введите название:
        <input type="text" id="name" value="${hobby.name}" name="name" />
    </label>  <br />
    <label for="hoursperweek">Введите часы/неделю:
        <input type="number" id="hoursperweek" value="${hobby.hoursperweek}" name="hoursperweek" />
    </label>  <br />
    <label for="priority">Введите приоритет:
        <input type="number" id="priority" value="${hobby.priority}" name="priority" />
    </label>  <br />
    <input type="hidden" name="id" value="${hobby.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>

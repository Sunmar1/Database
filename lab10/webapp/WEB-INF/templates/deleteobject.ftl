<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Лабораторная работа 12</title>
</head>
<body>

<div class="menu-bar">
    <ul>
        <li><a class="active" href='${model["app_path"]}'>Главная</a></li>


        <li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
    </ul>
</div>

<div class="c-wrapper">

    <H2>
        удаление объектов
    </H2>


    <h3>
        Удаление диагноза
    </h3>
    <form method="post" action='${model["app_path"]}/diagnose/delete'>
        ID Диагноза <input name="diagnoseid"/>
        <input type="submit" value="Удалить"/>
    </form>

    <h3>
        Удаление участка
    </h3>
    <form method="post" action='${model["app_path"]}/area/delete'>
        ID участка <input name="areaid"/>
        <input type="submit" value="Удалить"/>
    </form>

    <h3>
        Удаление клиники
    </h3>
    <form method="post" action='${model["app_path"]}/clinic/delete'>
        ID клиники <input name="clinicid"/>
        <input type="submit" value="Удалить"/>
    </form>
    <h3>
        Удаление врача
    </h3>
    <form method="post" action='${model["app_path"]}/doctor/delete'>
        ID врача <input name="doctorid"/>
        <input type="submit" value="Удалить"/>
    </form>
    <h3>
        Удаление пациента
    </h3>
    <form method="post" action='${model["app_path"]}/patient/delete'>
        ID пациента <input name="patientid"/>
        <input type="submit" value="Удалить"/>
    </form>



</div>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Лабораторная работа 10</title>
</head>
<body>

<div class="menu-bar">
    <ul>
        <li><a class="active" href='${model["app_path"]}'>Главная</a></li>
        <li><a href='${model["app_path"]}/area/'>Участки</a></li>
        <li><a href='${model["app_path"]}/clinic/'>Клиники</a></li>

        <li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
    </ul>
</div>

<div class="c-wrapper">

    <H2>
        Врачи
    </H2>


    <table>
        <thead>
        <th>id</th><th>ФИО</th>
        </thead>
        <tbody>
        <#if model["doctorsByView"]??>
            <#list model["doctorsByView"] as doctorsByView>
                <tr>
                    <td>
                        <#if doctorsByView.id??>${doctorsByView.id}</#if>
                    </td>
                    <td>
                        <#if doctorsByView.name??>${doctorsByView.name}</#if>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

</div>
</body>
</html>
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
        Добавление объектов
    </H2>

    <H3>
        Добавление диагноза
    </H3>

    <form action='${model["app_path"]}/diagnose/add' method="post">

        <input type="hidden" name="id" />
        <div style="width:30%">Название     <input type="text" name="name" /></div>
        <input type="submit" value="Сохранить"/>
    </form>

    <H3>
        Добавление участка
    </H3>

    <form action='${model["app_path"]}/area/add' method="post">

        <input type="hidden" name="id" />
        <div style="width:30%">Название     <input type="text" name="name" /></div>
        <input type="submit" value="Сохранить"/>
    </form>

    <H3>
        Добавление Клиники

    </H3>

    <form action='${model["app_path"]}/clinic/add' method="post">

        <input type="hidden" name="id" />
        <div style="width:30%">Адрес     <input type="text" name="address" /></div>
        <div style="width:30%">Название     <input type="text" name="name" /></div>
        <input type="submit" value="Сохранить"/>
    </form>

    <H3>
        Добавление Врача
    </H3>

    <form action='${model["app_path"]}/doctor/add' method="post">
        <input type="hidden" name="id" />
        <div style="width:30%">ФИО     <input type="text" name="name" /></div>
        <div style="width:30%">Специальность     <input type="text" name="specialty" /></div>
        <div style="width:30%">Дата рождения     <input type="text" name="birthDate" /></div>
        <div style="width:30%">Номер участка     <input type="text" name="area" /></div>
        <input type="submit" value="Сохранить"/>
    </form>

    <H3>
        Добавление Пациента
    </H3>

    <form action='${model["app_path"]}/patient/add' method="post">

        <input type="hidden" name="id"  />
        <div style="width:30%">ФИО     <input type="text" name="name" /></div>
        <div style="width:30%">Дата рождения     <input type="text" name="birthDate" /></div>
        <div style="width:30%">Номер участка     <input type="text" name="area" /></div>
        <input type="submit" value="Сохранить"/>
    </form>

<#--    <h3>Список диагнозов клиента</h3>-->

<#--    <table id="diagnosestable">-->
<#--        <thead>-->
<#--        <th>id</th><th>Название</th>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--        <#if model["diagnoses"]??>-->
<#--            <#list model["diagnoses"] as diagnose>-->
<#--                <tr>-->
<#--                    <td>-->
<#--                        <#if diagnose.id??>${diagnose.id}</#if>-->
<#--                    </td>-->
<#--                    <td><#if diagnose.name??>${diagnose.name}</#if></td>-->
<#--                    <td>-->
<#--                        <#if diagnose.id??><button-->
<#--                            onclick="document.location = '${model['app_path']}//diagnose/delete?id=${diagnose.id}'">X</button></#if>-->
<#--                    </td>-->
<#--                </tr>-->
<#--            </#list>-->
<#--        </#if>-->
<#--        </tbody>-->
<#--    </table>-->


<#--        <form action='${model["app_path"]}/adddiagnose' method="post">-->
<#--            <div style="width:30%">-->
<#--                <input type="hidden" name="id" value='${model["patient"].id!}'/>-->
<#--                <input type="text" name="numb" placeholder="Укажите номер диагноза"/>-->
<#--            </div>-->
<#--            <input type="submit" value="Добавить диагноз"/>-->
<#--        </form>-->


</div>
</body>
</html>

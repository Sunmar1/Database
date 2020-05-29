<thead>
<th>id</th><th>Номер</th>
</thead>
<tbody>
<#if model["diagnoses"]??>
    <#list model["diagnoses"] as diagnose>
        <tr>
            <td>
                <#if diagnose.id??>${diagnose.id}</#if>
            </td>
            <td><#if diagnose.name??>${diagnose.name}</#if></td>
            <td>
                <#if diagnose.id??><button onclick="delete_account(${diagnose.id})">X</button></#if>
            </td>
        </tr>
    </#list>
</#if>
</tbody>

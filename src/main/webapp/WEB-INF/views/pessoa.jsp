<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Pessoas</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar a Pessoa
</h1>

<c:url var="addAction" value="/pessoa/add" ></c:url>

<form:form action="${addAction}" commandName="pessoa">
<table>
	<c:if test="${pessoa.id != 0}">
	<tr>
		<td>
			ID
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			Nome
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td>
			Cidade
		</td>
		<td>
			<form:input path="cidade" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${pessoa.id != 0}">
				<input type="submit"
					value="Editar Pessoa" />
			</c:if>
			<c:if test="${pessoa.id == 0}">
				<input type="submit"
					value="Adicionar Pessoa" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Pessoas Cadastradas</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Nome</th>
			<th width="120">Cidade</th>
			<th width="60">Editar</th>
			<th width="60">Excluir</th>
		</tr>
		<c:forEach items="${listPersons}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nome}</td>
			<td>${p.cidade}</td>
			<td><a href="<c:url value='/edit/${p.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/remove/${p.id}' />" >Excluir</a></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>

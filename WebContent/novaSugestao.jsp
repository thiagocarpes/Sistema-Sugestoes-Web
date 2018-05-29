<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
	<c:import url="icon.jsp"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>USJT - SISTEMA SUGESTÕES - NOVA SUGESTÃO</title>
</head>

<body>
    <body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Nova Sugestão</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    <div class="limitHome">
        <form action="controller.do"  method="post">
        <div class="conteudo">
        <input type="hidden" name="idUsuario" value="${idusuario }">
        <ul>
            <li>
                <div class="sT">Qual a sua sugestão?</div>
            </li>
            <li>
                <select name="categoria">
                	<option value="#">*Selecione o Departamento*</option>
                <c:if test="${not empty lista}">
                <c:forEach var="categoria" items="${lista}">                    
                    <option value="${categoria.id }">${categoria.categoria }</option>
                </c:forEach>
                </c:if>
                </select>
            <li>
            	<div class="sT">Título:</div>
            </li>
            <li>
            	<input name="titulo" type="text" placeholder=" Título">
            </li>
            <li>
            	<div class="sT">Sugestão:</div>
            </li>
            <li>
            	<input name="sugestao" type="text" placeholder=" Sugestão" class="sugestao">
            </li>
            <li>
                <button type="submit" class="botao" name="command" value="CriarSugestao">SALVAR</button>
            </li>
        </ul>    
        </div>
        </form>
    </div>
</body>

</html>
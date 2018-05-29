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
    <title>USJT - SISTEMA SUGESTÕES - NOVA CATEGORIA</title>
</head>

<body>
    <body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Editando Categoria</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    <div class="limitHome">
        <form action="controller.do"  method="post">
        	<div class="conteudo">
        	<input type="hidden" name="idCategoria" value="${categoria.id }">
        	<ul>
            	<li>
                	<input name="categoria" type="text" value="${categoria.categoria }"> </li>
            	<li>
                	<input name="cor"  type="text" value="${categoria.cor }"> </li>
            	<li>
                	<button type="submit" class="botao" name="command" value="AlteraCategoria">SALVAR</button>
            	</li>
        	</ul>    
        	</div>
        </form>
    </div>
    
</body>

</html>
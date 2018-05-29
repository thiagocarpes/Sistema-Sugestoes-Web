<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
	<c:import url="icon.jsp"/>
    <link rel="stylesheet" href="css/styleHome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>USJT - SISTEMA SUGESTÕES - NOVO AVALIADOR</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Novo Avaliador</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    <div class="limitHome">
    <form action="controller.do" name="form" method="post">    
        <div class="conteudo">
        <ul>
            <li>
                <input name="nome" type="text" placeholder=" Nome Completo"> </li>
            <li>
                <select name="categoria">
                	<option value="#">*Selecione a Categoria do avaliador*</option>
                <c:if test="${not empty lista}">
                <c:forEach var="categoria" items="${lista}">                    
                    <option value="${categoria.id }">${categoria.categoria }</option>
                </c:forEach>
                </c:if>
                </select>
            <li>
            <li>
                <input name="email"  type="text" placeholder=" Email"> </li>
            <li>
                <input name="senha" type="text" placeholder=" Senha"> </li>
            <li>
                <input name="cpf" type="text" placeholder=" CPF"> </li>                
            <li>
                <button type="submit" class="botao" name="command" value="CriarAvaliador">SALVAR</button>
            </li>
        </ul>    
        </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
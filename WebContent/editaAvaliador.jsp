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
                <div class="col-md-9"><div id="tituloHome">Editando Avaliador</div></div>
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
            	<input type="hidden" name="idUsuario" value="${usuario.id }">
            	Nome:
                <input name="nome" type="text" value="${usuario.nome }"> </li>
             
            <li>
            	Categoria:
                <select name="categoria" required="">
                	<option value="">*Selecione a Categoria do avaliador*</option>
                <c:if test="${not empty lista}">
                <c:forEach var="categoria" items="${lista}">                    
                    <option
                    
                    <c:if test="${categoria.id == idEspecialidade}"> SELECTED </c:if>
                    
                     value="${categoria.id}">${categoria.categoria}</option>
                </c:forEach>
                </c:if>
                </select>
            <li>
            <li>
            	E-mail:
                <input name="email"  type="text" value="${usuario.email }"> </li>
            <li>
            	CPF:
                <input name="cpf" type="text" value="${usuario.cpf }"> </li>                
            <li>
                <button type="submit" class="botao" name="command" value="AlteraAvaliador">SALVAR</button>
            </li>
        </ul>    
        </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
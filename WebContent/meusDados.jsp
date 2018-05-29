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
    <title>USJT - SISTEMA SUGESTÕES - MEUS DADOS</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Meus Dados</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    <div class="limitHome">
    <form action="controller.do" name="form" method="post">    
        <div class="conteudo">
        <input type="hidden" name="idUsuario" value="${idusuario }">
        <ul>
            <li>
                <input name="nome" type="text" value=${usuario.nome }> </li>
            <li>
                <input name="email"  type="text" value=${usuario.email }> </li>
            
            <li>
                <input name="cpf" type="text" value=${usuario.cpf }> </li>                
            
            <li>
                <input name="senha" type="password" placeholder=" Senha"> 
            </li>
            <li>
                <button type="submit" class="botao" name="command" value="AlteraUsuario">SALVAR</button>
            </li>
        </ul>    
        </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
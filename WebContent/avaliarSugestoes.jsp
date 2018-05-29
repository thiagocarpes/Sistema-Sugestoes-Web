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
    <title>USJT - SISTEMA SUGESTÕES - AVALIAR SUGESTÃO</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Avaliar Sugestão</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    <div class="limitHome">
    	<div class="vSugestao">
    	<div class="container-fluid">
    		<div class="col-md-8" id=sugestao>
    			<div class="tPopulares">
    				Título
    			</div>
    			<div class="vsTitulo">
    			${sugestao.titulo }
    			</div>
    			<div class="tPopulares">
    				Sugestão
    			</div>
    			<div class="vsSugestao">
    			${sugestao.sugestao }
    			</div>
    			<div class="vsSugestao">
    			Status: ${sugestao.status } 
    			</div>
    			<div class="vsSugestao">
    			FeedBack: ${sugestao.feedback } 
    			</div>
    			<div class="vsAcao">
    				<form action="controller.do"  method="post">
    					<input type="hidden" name="idSugestao" value="${sugestao.idSugestao }">
    					<input type="hidden" name="idUsuario" value="${idusuario }">
    				</form>
    			</div>
    		</div>
    		<div class="col-md-4">
    			<div class="tPopulares">
    				Ações<br>
    			</div>
    			<a href="controller.do?command=AprovaSugestao&idSugestao=${sugestao.idSugestao }"><button type="button" class="botaoVerde">APROVAR</button></a></spam>
    			<a href="controller.do?command=InativaSugestao&idSugestao=${sugestao.idSugestao }"><button type="button" class="botaoCinza">INATIVAR</button></a><br>
    			<div class="tPopulares">
    				Recusar<br>
    			</div>
    			<div class="avaliacao">
    				<form action="controller.do" name="form" method="post">    		
    					<input type="hidden" name="idSugestao" value="${sugestao.idSugestao }">
    					<textarea placeholder=" Deixe um feedback para o colaborador" name="feedback" class="feedback"></textarea> <br>
    					<button type="submit" name="command" value="RecusaSugestao" class="botaoVermelho">RECUSAR</button><br></a>
    				</form>	
    			</div>
    		</div>
    	</div>
    	</div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
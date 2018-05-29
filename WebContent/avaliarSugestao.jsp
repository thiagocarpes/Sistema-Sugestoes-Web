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
    <title>USJT - SISTEMA SUGESTÕES - AVALIAR SUGESTÕES</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Avaliar Sugestões</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    <div class="limitHome">
        <div class="container-fluid">
            <div class="menuSugestoes">
            <div class="col-md-10">
                 <select name="categoria">
                	        <option value="*">*Selecione o Departamento*</option>
                    <c:if test="${not empty lista}">
                        <c:forEach var="categoria" items="${lista}">                    
                            <option value="${categoria.id }">${categoria.categoria }</option>
                        </c:forEach>
                    </c:if>
                </select>
                <button class="bOk">OK</button>
            </div>
            </div>    
        </div>
            <div class="limitSugestao">
                <div class="container-fluid">
                    <div class="col-md-12" id=sugestaoAvalia>
                                 <c:if test="${not empty listaSugestaoAvalia}">
                                    <c:forEach var="sugestao" items="${listaSugestaoAvalia}">                    
                                        <div style="border-left: 3px solid  ${sugestao.corEspecialidade }; " class="boxSugestao">
                                        <div class="titulo">
                                            ${sugestao.titulo } 
                                        </div>
                                        <div class="lSugestao">
                                            ${sugestao.sugestao }
                                        </div>
                                        <div class="pData">
                                            ${sugestao.data } | ${sugestao.nomeEspecialidade } | Status atual: ${sugestao.status } | <spam class="pVerMais"><a href="controller.do?command=CarregaSugestaoPAvalia&id=${sugestao.idSugestao }"><button type="button"">Avaliar a Sugestão</button></a></spam> <br><br>
                                        </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                    </div>           
            </div>  
            </div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
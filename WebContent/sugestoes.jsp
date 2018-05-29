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
    <title>USJT - SISTEMA SUGESTÕES - SUGESTÕES</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Sugestão</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    <div class="limitHome">
        <div class="container-fluid">
            <div class="menuSugestoes">
            <div class="col-md-10">
                 <form action="controller.do"  method="post">
                 	<select name="categoria">
                	        <option value=" > 0">*Selecione o Departamento*</option>
                    	<c:if test="${not empty lista}">
                        	<c:forEach var="categoria" items="${lista}">                    
                            	<option
                            	
                            	<c:if test="${categoria.id == pIdEspecialidade}">
                            	 SELECTED
                            	</c:if>
                            	
                            	 value="= ${categoria.id}">${categoria.categoria }</option>
                        	</c:forEach>
                    	</c:if>
                	</select>
              	  	<button type="submit" name="command" value="CarregaHomeCategoria" class="bOk">OK</button>
                 </form>
            </div>
                <div class="col-md-2">
                    <c:if test="${tipousuario == 1 }"><a href="novaSugestao.jsp"><button class="botao">+ NOVA SUGESTÃO</button></a></c:if>
                </div>
            </div>    
        </div>
            <div class="limitSugestao">
                <div class="container-fluid">
                    <div class="col-md-8" id=sugestao>
                                 <c:if test="${not empty listaSugestao}">
                                    <c:forEach var="sugestao" items="${listaSugestao}">                    
                                        <div style="border-left: 5px solid  ${sugestao.corEspecialidade }; " class="boxSugestao">
                                        <div class="titulo">
                                            ${sugestao.titulo } 
                                        </div>
                                        <div class="lSugestao">
                                            ${sugestao.sugestao }
                                        </div>
                                        <div class="pData">
                                            ${sugestao.data } | ${sugestao.nomeEspecialidade } | <spam class="pVerMais"><a href="controller.do?command=CarregaSugestao&id=${sugestao.idSugestao }"><button type="button"">Ver Mais</button></a></spam> <br><br>
                                        </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                    </div>
                    <div class="col-md-4">
                        <div class="boxPopulares">
                            <div class="tPopulares">
                                Populares<br>
                            </div>
                                 <c:if test="${not empty listaTop}">
                                    <c:forEach var="sugestao" items="${listaTop}">                    
                                        <div class="subPopulares">
                                            ${sugestao.titulo } 
                                        </div>
                                        <div class="pSugestao">
                                            ${sugestao.sugestao }
                                        </div>
                                        <div class="pData">
                                            ${sugestao.data } | ${sugestao.nomeEspecialidade } | <spam class="pVerMais"><a href="controller.do?command=CarregaSugestao&id=${sugestao.idSugestao }"><button type="button"">Ver Mais</a></spam> <br><br>
                                        </div>
                                    </c:forEach>
                                </c:if>
                        </div>
                    </div>            
            </div>  
            </div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
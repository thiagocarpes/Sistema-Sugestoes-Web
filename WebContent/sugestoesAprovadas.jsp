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
    <title>USJT - SISTEMA SUGESTÕES - SUGESTÕES APROVADAS</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Sugestões Aprovadas</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/> 
    
    <div class="container-fluid">
    <div class="limitHome">
        <div class="conteudoCadastro">
        
        
        	<c:if test="${not empty listaSugestoesAprovadasCategoria}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Categorias</th>
                                    <th>Quantidade de Sugestões Aprovadas</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="sugestao" items="${listaSugestoesAprovadasCategoria}">
                                       <tr>
                                            <td>
                                               ${sugestao.nomeEspecialidade }
                                            </td>
                                            <td>
                                                ${sugestao.aprovadas }
                                            </td>
                                </tr>             
                            </c:forEach>

                            </tbody>
                        </table>                 </div>
                </div>
                <!-- /#list -->
               </c:if>
    
        </div>
    </div>
    </div>
    <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
</body>

</html>
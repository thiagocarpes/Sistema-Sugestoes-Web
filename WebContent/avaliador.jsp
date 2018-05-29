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
    <title>USJT - SISTEMA SUGESTÕES - AVALIADOR</title>
</head>

<body>
    <div class="container-fluid">
        <div class="top">
            <div class="limitHome">
                <div class="col-md-9"><div id="tituloHome">Avaliadores</div></div>
                <c:import url="logoInterno.jsp"/>

			</div>
		</div>
	</div>
                <c:import url="menu.jsp"/>
    
    
    <div class="container-fluid">
    <div class="limitHome">
        <div class="conteudoCadastro">
        <div class="menuSugestoes">
            <div class="col-md-10">
                 <form action="controller.do"  method="post">
                 	<select name="status">
                	        <option value=" = 'ativo'">*Selecione o Status*</option>        
                            <option value=" = 'ativo'">Ativas</option>
                            <option value=" = 'inativo'">Inativas</option>
                            <option value=" <> ''">Todos</option>
                	</select>
              	  	<button type="submit" name="command" value="ListarAvaliador" class="bOk">OK</button>
                 </form>
            </div>
            </div> 
        
        <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>E-mail</th>
                                    <th>Especialidade</th>
                                    <th class="actions">Opções</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="usuario" items="${lista}">
                                       <tr>
                                            <td>
                                               ${usuario.id }
                                            </td>
                                            <td>
                                                ${usuario.nome }
                                            </td>
                                            <td>
                                                ${usuario.email }
                                            </td>
                                            <td>
                                                ${usuario.nomeEspecialidade } 
                                            </td>
                                            <td class="actions">
                                                <a href="controller.do?command=CarregaAvaliador&idUsuario=${usuario.id }"><button class="alerta">EDITAR</button></a>
                                                <c:if test="${usuario.status == 'ativo' }"><a href="controller.do?command=InativaAvaliador&idUsuario=${usuario.id }"><button class="perigo">INATIVAR</button></a></c:if>
                                                <c:if test="${usuario.status == 'inativo' }"><a href="controller.do?command=AtivaAvaliador&idUsuario=${usuario.id }"><button class="pPerigo">ATIVAR</button></a></c:if>
                                            </td>
                                        </tr>             
                            </c:forEach>

                            </tbody>
                        </table>
                        <a href="controller.do?command=ListarCategoriaAvaliador"><input type="submit" value="NOVO AVALIADOR" class="botao"></a>
                    </div>
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
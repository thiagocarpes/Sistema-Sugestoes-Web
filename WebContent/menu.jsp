 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         
    <div id="barraMenuHome">    
        <div class="limitHome">            
            <ul>
                <li><a href="controller.do?command=CarregaHome">SUGESTÕES</a></li>
                <li><a href="controller.do?command=CarregaUsuario&idUsuario=${idusuario }">MEUS DADOS</a></li>
                <c:if test="${tipousuario == 1 }"><li><a href="controller.do?command=CarregaMinhaSugestao&idUsuario=${idusuario }">MINHAS SUGESTÕES</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="controller.do?command=CarregaSugestaoAvalia&IdEspecialidade=${idespecialidade }">AVALIAR SUGESTÕES</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="controller.do?command=CarregaRelRanking&IdEspecialidade=${idespecialidade }">RANKING</a></li></c:if>
                <c:if test="${tipousuario == 2 }"><li><a href="controller.do?command=CarregaRelIndeceGeralAvaliador">INDICE DE APROVAÇÃO</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=ListarAvaliador&status= in ('ativo')">AVALIADOR</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=ListarCategoria&status= in ('ativo')">CATEGORIAS</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=CarregaRelParticipacao">PARTICIPAÇÃO</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=CarregaRelSugestoesAprovadas">SUGESTÕES APROVADAS</a></li></c:if>
                <c:if test="${tipousuario == 3 }"><li><a href="controller.do?command=CarregaRelIndeceGeral">ÍNDICE GERAL</a></li></c:if>
                <li><a href="controller.do?command=Logout">SAIR</a></li>
            </ul>
        </div>
    </div>
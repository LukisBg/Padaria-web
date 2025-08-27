<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Fazer Pedido - Padaria Cachoeiro</title>
  <link rel="stylesheet" href="css/style.css" />
  <script src="js/validacao.js" defer></script>
</head>
<body>
  <header>
    <h1>Faça seu Pedido</h1>
    <nav>
      <a href="index.html">Início</a> |
      <a href="produtos.html">Produtos</a> |
      <a href="pedido.jsp">Fazer Pedido</a> |
      <a href="produto.jsp">Gerenciar</a> |
      <a href="contato.html">Contato</a>
    </nav>
  </header>

  <main>
    <c:if test="${not empty msgSucesso}">
      <p style="color: green; font-weight: bold;">${msgSucesso}</p>
    </c:if>

    <form action="enviarPedido" method="post" onsubmit="return validarFormularioPedido()">
      <label for="nome">Nome:</label>
      <input type="text" id="nome" name="nome" />
      <br />
      <label for="produto">Produto:</label>
      <select id="produto" name="produto">
        <option value="">Selecione</option>
        <option value="pao">Pão Francês</option>
        <option value="bolo">Bolo de Chocolate</option>
        <option value="salgado">Salgado Assado</option>
        <option value="cafe">Café Expresso</option>
      </select>
      <br />
      <label for="quantidade">Quantidade:</label>
      <input type="number" id="quantidade" name="quantidade" min="1" />
      <br />
      <button type="submit">Enviar Pedido</button>
    </form>
  </main>

  <footer>
    <p>© 2025 Padaria Cachoeiro</p>
  </footer>
</body>
</html>

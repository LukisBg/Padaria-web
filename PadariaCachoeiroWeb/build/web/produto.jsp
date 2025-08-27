<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Verifica se o usuário está logado
    String usuarioLogado = (String) session.getAttribute("usuarioLogado");

    if (usuarioLogado == null) {
        
        response.sendRedirect("login.jsp");
        return; // interrompe o carregamento do resto da página
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Gerenciar Produtos</title>
   <link rel="stylesheet" href="css/style.css" />
</head>
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
<body>
  <h1>Cadastro de Produtos</h1>

  <% if (request.getAttribute("msgErro") != null) { %>
    <p style="color: red;"><%= request.getAttribute("msgErro") %></p>
  <% } %>

  <% if (request.getAttribute("msgSucesso") != null) { %>
    <p style="color: green;"><%= request.getAttribute("msgSucesso") %></p>
  <% } %>

  <form action="ProdutoServlet" method="post">
    <input type="hidden" name="acao" value="cadastrar">
    Nome: <input type="text" name="nome" required><br>
    Categoria: <input type="text" name="categoria" required><br>
    Preço: <input type="number" step="0.01" name="preco" required><br>
    Estoque: <input type="number" name="estoque" required><br>
    <button type="submit">Cadastrar</button>
  </form>

  <p><a href="index.html">Voltar ao Início</a></p>
</body>
</html>

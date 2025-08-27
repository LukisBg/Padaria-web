<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msgErro = "";
    if(request.getParameter("senha") != null) {
        String senha = request.getParameter("senha");
        if(senha.equals("1234")) {
            session.setAttribute("usuarioLogado", "admin");
            response.sendRedirect("produto.jsp");
            return;
        } else {
            msgErro = "Senha incorreta!";
        }
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
     <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <h1>Login</h1>
    <% if(!msgErro.isEmpty()) { %>
        <p style="color:red;"><%= msgErro %></p>
    <% } %>
    <form method="get">
        Senha: <input type="password" name="senha" required>
        <button type="submit">Entrar</button>
    </form>
</body>
</html>

package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PedidoDAO;

import java.io.IOException;


public class PedidoServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String produto = request.getParameter("produto");
    int quantidade;

    try {
        quantidade = Integer.parseInt(request.getParameter("quantidade"));
    } catch (NumberFormatException e) {
        request.setAttribute("msgErro", "Quantidade inválida.");
        request.getRequestDispatcher("pedido.jsp").forward(request, response);
        return;
    }

    PedidoDAO dao = new PedidoDAO();
    dao.inserirPedido(nome, produto, quantidade);

    request.setAttribute("msgSucesso", "Pedido realizado com sucesso!");
    request.getRequestDispatcher("pedido.jsp").forward(request, response);
}
}

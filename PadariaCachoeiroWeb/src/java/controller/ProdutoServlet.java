package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutoDAO;

import java.io.IOException;

public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        ProdutoDAO dao = new ProdutoDAO();

        try {
            if ("cadastrar".equals(acao)) {
                String nome = request.getParameter("nome");
                String categoria = request.getParameter("categoria");
                double preco = Double.parseDouble(request.getParameter("preco"));
                int estoque = Integer.parseInt(request.getParameter("estoque"));

                dao.adicionarProduto(nome, categoria, preco, estoque);
                request.setAttribute("msgSucesso", "Produto cadastrado com sucesso!");

            } else if ("atualizar".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String categoria = request.getParameter("categoria");
                double preco = Double.parseDouble(request.getParameter("preco"));
                int estoque = Integer.parseInt(request.getParameter("estoque"));

                dao.atualizarProduto(id, nome, categoria, preco, estoque);
                request.setAttribute("msgSucesso", "Produto atualizado com sucesso!");

            } else if ("excluir".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluirProduto(id);
                request.setAttribute("msgSucesso", "Produto excluído com sucesso!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgErro", "Erro ao processar a operação: " + e.getMessage());
        }

        request.getRequestDispatcher("produto.jsp").forward(request, response);
    }
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void adicionarProduto(String nome, String categoria, double preco, int estoque) {
        String sql = "INSERT INTO produtos (nome, categoria, preco, estoque) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, categoria);
            stmt.setDouble(3, preco);
            stmt.setInt(4, estoque);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProduto(int id, String nome, String categoria, double preco, int estoque) {
        String sql = "UPDATE produtos SET nome=?, categoria=?, preco=?, estoque=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, categoria);
            stmt.setDouble(3, preco);
            stmt.setInt(4, estoque);
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

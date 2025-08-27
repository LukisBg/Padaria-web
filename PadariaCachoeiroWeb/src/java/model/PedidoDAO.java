package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoDAO {

    public void inserirPedido(String nome, String produto, int quantidade) {
        String sql = "INSERT INTO pedidos (nome, produto, quantidade) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, produto);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Venda;

public class VendaDAO {

    private Conexao conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public VendaDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirVenda(Venda venda) {
        query = "INSERT INTO Venda (clienteId, vendedorId, tipoPagamento) VALUES (?, ?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, venda.getClienteId());
            ps.setInt(2, venda.getVendedorId());
            ps.setString(3, venda.getTipoPagamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet listarVendas() {
        query = "SELECT idVenda, clienteId, vendedorId, tipoPagamento FROM Venda";
        try {
            ps = conexao.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public void atualizarVenda(Venda venda) {
        query = "UPDATE Venda SET clienteId = ?, vendedorId = ?, tipoPagamento = ? WHERE idVenda = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, venda.getClienteId());
            ps.setInt(2, venda.getVendedorId());
            ps.setString(3, venda.getTipoPagamento());
            ps.setInt(4, venda.getIdVenda());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para deletar uma venda
    public void deletarVenda(int idVenda) {
        query = "DELETE FROM Venda WHERE idVenda = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idVenda);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

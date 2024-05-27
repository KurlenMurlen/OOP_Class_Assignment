package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProdutoDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProdutoDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void inserirProduto(Produto produto) {
        this.query = "INSERT INTO produto (descricao, quantidade, preco, fornecedorId) VALUES (?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(query);
            this.ps.setString(1, produto.getDescricao());
            this.ps.setInt(2, produto.getQuantidade());
            BigDecimal bdPreco = BigDecimal.valueOf(produto.getPreco());
            this.ps.setBigDecimal(3, bdPreco);
            this.ps.setInt(4, produto.getidFornecedor());
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public ResultSet listarProduto() {
        this.query = "SELECT * FROM produto";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.rs = this.ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.rs;
    }

    public void deleteProduto(int idProduto) {
        this.query = "DELETE FROM produto WHERE idProduto = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idProduto);
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateProduto(Produto produto) {
        String query = "UPDATE produto SET descricao=?, quantidade=?, preco=?, fornecedorId=? WHERE idProduto=?";
        try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            BigDecimal bdPreco = BigDecimal.valueOf(produto.getPreco());
            ps.setBigDecimal(3, bdPreco);
            ps.setInt(4, produto.getidFornecedor());
            ps.setInt(5, produto.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public boolean produtoExists(int idproduto){
        this.query = "SELECT * FROM produto WHERE idproduto = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idproduto);
            this.rs = this.ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }


}

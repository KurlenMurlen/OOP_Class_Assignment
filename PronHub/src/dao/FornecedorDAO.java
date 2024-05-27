package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.Fornecedor; // Importe a classe Fornecedor

public class FornecedorDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public FornecedorDAO() {
        conexao = Conexao.getConexao();
    }

    public ResultSet inserirFornecedor(Fornecedor f) {
        this.query = "INSERT INTO fornecedor (nomeFantasia, razaoSocial, CNPJ, email, telefone, cidade, estado, pais, endereco, numero, dataCadastro, senha) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), ?)";

        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, f.getNomeFantasia());
            this.ps.setString(2, f.getRazaoSocial());
            this.ps.setString(3, f.getCNPJ());
            this.ps.setString(4, f.getEmail());
            this.ps.setString(5, f.getTelefone());
            this.ps.setString(6, f.getCidade());
            this.ps.setString(7, f.getEstado());
            this.ps.setString(8, f.getPais());
            this.ps.setString(9, f.getEndereco());
            this.ps.setInt(10, f.getNumero());
            this.ps.setString(11, f.getSenha());
            this.ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public ResultSet listarFornecedor() {
        this.query = "SELECT * FROM fornecedor";
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

    private void deleteProdutosDoFornecedor(int idFornecedor) {
        String deleteQuery = "DELETE FROM produto WHERE fornecedorId = ?";
        try {
            PreparedStatement deleteStatement = conexao.getConnection().prepareStatement(deleteQuery);
            deleteStatement.setInt(1, idFornecedor);
            deleteStatement.executeUpdate();
            deleteStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateFornecedor(Fornecedor fornecedor, int idFornecedor) {
        String query = "UPDATE fornecedor SET nomeFantasia=?, razaoSocial=?, CNPJ=?, email=?, telefone=?, cidade=?, estado=?, pais=?, endereco=?, numero=?, senha=? WHERE idfornecedor=?";
        try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
            ps.setString(1, fornecedor.getNomeFantasia());
            ps.setString(2, fornecedor.getRazaoSocial());
            ps.setString(3, fornecedor.getCNPJ());
            ps.setString(4, fornecedor.getEmail());
            ps.setString(5, fornecedor.getTelefone());
            ps.setString(6, fornecedor.getCidade());
            ps.setString(7, fornecedor.getEstado());
            ps.setString(8, fornecedor.getPais());
            ps.setString(9, fornecedor.getEndereco());
            ps.setInt(10, fornecedor.getNumero());
            ps.setString(11, fornecedor.getSenha());
            ps.setInt(12, idFornecedor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteFornecedor(int idFornecedor) {
        deleteProdutosDoFornecedor(idFornecedor);

        this.query = "DELETE FROM fornecedor WHERE idFornecedor = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idFornecedor);
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean fornecedorExists(int idfornecedor){
        this.query = "SELECT * FROM fornecedor WHERE idfornecedor = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idfornecedor);
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
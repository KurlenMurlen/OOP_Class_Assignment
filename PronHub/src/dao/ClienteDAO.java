package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ClienteDAO() {
        conexao = Conexao.getConexao();
    }

    public ResultSet inserirCliente(Cliente cliente) {
        this.query = "INSERT INTO cliente (nome, sobrenome, dataNascimento, telefone, CPF, " +
                "cidade, estado, pais, endereco, numero, email, senha, dataCadastro) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, cliente.getNome());
            this.ps.setString(2, cliente.getSobrenome());
            java.sql.Date sqlDateNascimento = new java.sql.Date(cliente.getDataNascimento().getTime());
            this.ps.setDate(3, sqlDateNascimento);
            this.ps.setString(4, cliente.getTelefone());
            this.ps.setString(5, cliente.getCPF());
            this.ps.setString(6, cliente.getCidade());
            this.ps.setString(7, cliente.getEstado());
            this.ps.setString(8, cliente.getPais());
            this.ps.setString(9, cliente.getEndereco());
            this.ps.setInt(10, cliente.getNumero());
            this.ps.setString(11, cliente.getEmail());
            this.ps.setString(12, cliente.getSenha());
            java.sql.Date sqlDateCadastro = new java.sql.Date(cliente.getDataCadastro().getTime());
            this.ps.setDate(13, sqlDateCadastro);
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
        return this.rs;
    }

    public ResultSet listarClientes() {
        this.query = "SELECT * FROM cliente";
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

    public void deleteCliente(int idcliente){
        this.query = "DELETE FROM cliente WHERE idcliente = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idcliente);
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente, int idcliente){
        this.query = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, senha = ? WHERE idcliente = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, cliente.getNome());
            this.ps.setString(2, cliente.getSobrenome());
            java.sql.Date sqlDateNascimento = new java.sql.Date(cliente.getDataNascimento().getTime());
            this.ps.setDate(3, sqlDateNascimento);
            this.ps.setString(4, cliente.getTelefone());
            this.ps.setString(5, cliente.getCPF());
            this.ps.setString(6, cliente.getCidade());
            this.ps.setString(7, cliente.getEstado());
            this.ps.setString(8, cliente.getPais());
            this.ps.setString(9, cliente.getEndereco());
            this.ps.setInt(10, cliente.getNumero());
            this.ps.setString(11, cliente.getEmail());
            this.ps.setString(12, cliente.getSenha());
            java.sql.Date sqlDateCadastro = new java.sql.Date(cliente.getDataCadastro().getTime());
            this.ps.setDate(13, sqlDateCadastro);
            this.ps.setInt(14, idcliente);
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


    public boolean clienteExists(int idcliente){
        this.query = "SELECT * FROM cliente WHERE idcliente = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idcliente);
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
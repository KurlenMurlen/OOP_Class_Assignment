package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

public class AdminDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public AdminDAO() {
        conexao = Conexao.getConexao();
    }

    public ResultSet inserirAdmin(Admin admin) {
        this.query = "INSERT INTO admin(nome, senha, email) VALUES (?,?,?)";

        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, admin.getNome());
            this.ps.setString(2, admin.getSenha());
            this.ps.setString(3, admin.getEmail());
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean autenticarAdmin(String email, String senha) {
        this.query = "SELECT * FROM admin WHERE email=? AND senha=?";

        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, email);
            this.ps.setString(2, senha);
            this.rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}

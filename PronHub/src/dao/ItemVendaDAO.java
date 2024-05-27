package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVendaDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ItemVendaDAO() {
        conexao = Conexao.getConexao();
    }

    public boolean itemVendaExiste(int idItemVenda){
        this.query = "SELECT * FROM itemvenda WHERE idItemVenda = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, idItemVenda);
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
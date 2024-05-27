    package dao;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    import model.Fornecedor;
    import model.Vendedor;

    public class VendedorDAO {

        private Conexao conexao;
        private String query;
        private PreparedStatement ps;
        private ResultSet rs;

        public VendedorDAO() {
            conexao = Conexao.getConexao();
        }

        public ResultSet inserirVendedor(Vendedor v) {
            this.query = "INSERT INTO vendedor (nome, sobrenome, dataNascimento, telefone, CPF, cidade, estado, pais, endereco, dataCadastro, email, senha) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), ?, ?)";
            try {
                this.ps = conexao.getConnection().prepareStatement(this.query);
                this.ps.setString(1, v.getNome());
                this.ps.setString(2, v.getSobrenome());
                java.sql.Date sqlDateNascimento = new java.sql.Date(v.getDataNascimento().getTime());
                this.ps.setDate(3, sqlDateNascimento);
                this.ps.setString(4, v.getTelefone());
                this.ps.setString(5, v.getCPF());
                this.ps.setString(6, v.getCidade());
                this.ps.setString(7, v.getEstado());
                this.ps.setString(8, v.getPais());
                this.ps.setString(9, v.getEndereco());
                this.ps.setString(10, v.getEmail());
                this.ps.setString(11, v.getSenha());
                this.ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }


        public ResultSet listarVendedor() {
            this.query = "SELECT * FROM vendedor";
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

        private void deleteVendasDoVendedor(int idvendedor) {
            String deleteQuery = "DELETE FROM venda WHERE vendedorId = ?";
            try {
                PreparedStatement deleteStatement = conexao.getConnection().prepareStatement(deleteQuery);
                deleteStatement.setInt(1, idvendedor);
                deleteStatement.executeUpdate();
                deleteStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        public void deleteVendedor(int idvendedor) {
            deleteVendasDoVendedor(idvendedor);

            this.query = "DELETE FROM vendedor WHERE idvendedor = ?";
            try {
                this.ps = conexao.getConnection().prepareStatement(this.query);
                this.ps.setInt(1, idvendedor);
                this.ps.executeUpdate();
                this.ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void updateVendedor(Vendedor vendedor, int idVendedor) {
            String query = "UPDATE vendedor SET nome=?, sobrenome=?, dataNascimento=?, telefone=?, CPF=?, cidade=?, estado=?, pais=?, endereco=?, email=?, senha=? WHERE idvendedor=?";
            try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
                ps.setString(1, vendedor.getNome());
                ps.setString(2, vendedor.getSobrenome());
                java.sql.Date sqlDateNascimento = new java.sql.Date(vendedor.getDataNascimento().getTime());
                ps.setDate(3, sqlDateNascimento);
                ps.setString(4, vendedor.getTelefone());
                ps.setString(5, vendedor.getCPF());
                ps.setString(6, vendedor.getCidade());
                ps.setString(7, vendedor.getEstado());
                ps.setString(8, vendedor.getPais());
                ps.setString(9, vendedor.getEndereco());
                ps.setString(10, vendedor.getEmail());
                ps.setString(11, vendedor.getSenha());
                ps.setInt(12, idVendedor);
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        public boolean vendedorExists(int idvendedor){
            this.query = "SELECT * FROM vendedor WHERE idvendedor = ?";
            try {
                this.ps = conexao.getConnection().prepareStatement(this.query);
                this.ps.setInt(1, idvendedor);
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
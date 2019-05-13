package sistema.dao;

import sistema.to.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FornecedorDAO implements IDAO<Fornecedor> {

    @Override
    public void inserir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO FORNECEDOR (NOME, CNPJ, TELEFONE) VALUES (?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTelefone());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE FORNECEDOR SET NOME=?, CNPJ=?, TELEFONE=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTelefone());
        ps.setInt(4, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM FORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Fornecedor> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM FORNECEDOR ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaFornecedors = new ArrayList();
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            fornecedor.setTelefone(rs.getString("TELEFONE"));
            listaFornecedors.add(fornecedor);
        }

        return listaFornecedors;
    }

    @Override
    public Fornecedor recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM FORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        if (rs.next()) {
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            fornecedor.setTelefone(rs.getString("TELEFONE"));
        }

        return fornecedor;
    }
}

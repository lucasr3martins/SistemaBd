package sistema.dao;

import sistema.to.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutoDAO implements IDAO<Produto> {

    @Override
    public void inserir(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO PRODUTO (NOME, QDTE) VALUES (?, ?, 0)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getQdtE());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE PRODUTO SET NOME=?, QDTE=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getQdtE());
        ps.setInt(3, produto.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM PRODUTO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, produto.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Produto> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM PRODUTO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaProdutos = new ArrayList();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setCodigo(rs.getInt("CODIGO"));
            produto.setNome(rs.getString("NOME"));
            produto.setQdtE(rs.getString("QDTE"));
            listaProdutos.add(produto);
        }

        return listaProdutos;
    }

    @Override
    public Produto recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM PRODUTO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Produto produto = new Produto();
        if (rs.next()) {
            produto.setCodigo(rs.getInt("CODIGO"));
            produto.setNome(rs.getString("NOME"));
            produto.setQdtE(rs.getString("QDTE"));
        }

        return produto;
    }
}

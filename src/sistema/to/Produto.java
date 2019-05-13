package sistema.to;


public class Produto {

    private int codigo;
    private String nome;
    private String qtde;

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.qtde = "";
    }

    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.qtde = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        public String getQdtE() {
        return qtde;
    }

    public void setQdtE(String qtde) {
        this.qtde = qtde;
    }

   

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public void setQuantidadeEstoque(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

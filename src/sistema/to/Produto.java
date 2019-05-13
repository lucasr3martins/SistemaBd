package sistema.to;


public class Produto {

    private int codigo;
    private String nome;
    private String quantidade;

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.quantidade = "";
    }

    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.quantidade = "";
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
    
        public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
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
}
package sistema.to;


public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
     private String telefone;

    public Cliente() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
    }

    public Cliente(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

        public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}

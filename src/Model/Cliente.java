package Model;

public class Cliente {

    public static String getStatus;
    private String senha;

    private String status = "cliente";

    private String nome;

    public Cliente(String nome, String senha, String status) {
        this.senha = senha;
        this.nome = nome;
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Senha: " + this.getSenha() +
                "\nNome: " + this.getNome() +
                "\nStatus: " + this.getStatus();
    }

}
package Model;

import Utils.Util;

public class Produto {

    private static int count = 1;

    private int id;
    private String nomeProduto;
    private double valor;

    public Produto(String nomeProduto, Double valor){
        this.id = count;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
    return "Id: " + this.getId() +
    "\nNome: " + this.getNomeProduto() +
    "\nValor: " + Util.doubleToString(this.getValor());
}
}

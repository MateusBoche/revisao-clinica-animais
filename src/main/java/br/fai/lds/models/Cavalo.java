package br.fai.lds.models;

public class Cavalo extends Animal{
    public Cavalo(String nome) {
        super(nome);
        setNome(nome);
        incrementarIdUnico();
        int id = getIdUnico();
        setId(id);
    }
    public String tipo(){
        return "Cavalo";
    }
}

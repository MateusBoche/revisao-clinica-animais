package br.fai.lds.models;

public class Girafa extends Animal{
    public Girafa(String nome) {
        super(nome);
        setNome(nome);
        incrementarIdUnico();
        int id = getIdUnico();
        setId(id);
    }
    public String tipo(){
        return "girafa";
    }
}

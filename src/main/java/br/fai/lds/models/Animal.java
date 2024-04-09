package br.fai.lds.models;

public abstract class Animal {
    private int id ;
    private  String nome;
    private static int idUnico = 0;

    public Animal(String nome) {

        this.nome = nome;
    }

    public static int getIdUnico() {
        return idUnico;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public static void incrementarIdUnico(){
        idUnico+=1;
    }

    public String tipo(){
        return "Animal";
    }


}

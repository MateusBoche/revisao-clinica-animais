package br.fai.lds.program;

import br.fai.lds.models.Animal;
import br.fai.lds.models.Cavalo;
import br.fai.lds.models.Girafa;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    Scanner sc = new Scanner(System.in);
    private List<Animal> animais = new ArrayList<>();

    private HashMap<String, List<Animal>> mapaAnimal = new HashMap<>();
    private void start() {

        while(true){
            menu();
            System.out.println("Opcao");
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    cadastrarCavalo();
                    break;

                case 2:
                    cadastrarGirafa();
                    break;

                case 3:
                    System.out.println("Dados cavalos: ");
                    listarCavalos();
                    break;

                case 4:
                    System.out.println("Dadis Girafas: ");
                    listarGirafasa();
                    break;

                case 5:
                    System.out.println("Dados animais: ");
                    listarAnimais();
                    break;

                case 6:
                    System.out.println("Digite o id do animal que quer remover");
                    int id = sc.nextInt();
                    removerAnimalPorId(id);
                    break;

                case 7:
                    animaisCadastradoPorTipo();
                    break;

            }
        }

    }

    private void animaisCadastradoPorTipo() {
        final String chaveCavalo = "Cavalo";
        final String chaveGirafa = "Girafa";
        mapaAnimal.put(chaveCavalo,new ArrayList());
        mapaAnimal.put(chaveGirafa,new ArrayList());
        List listaCavalo = mapaAnimal.get(chaveCavalo);
        List listaGirafa = mapaAnimal.get(chaveGirafa);
        for(Animal animal:animais){
            if(animal instanceof Cavalo){

                listaCavalo.add(animal);
            }
            if(animal instanceof Girafa){

                listaGirafa.add(animal);

            }

        }
        System.out.println("Quantidade de cavalos cadastrados é " + listaCavalo.size());
        System.out.println("dados cavalos: ");
        if(listaCavalo.isEmpty()){
            System.out.println("lista vazia");
        }
        for (Animal animal:mapaAnimal.get(chaveCavalo)){
            System.out.println(animal.getId() + " " + animal.getNome());
        }

        System.out.println("quantidade de girafas cadastradas é " + listaGirafa.size());
        System.out.println("Dados girafas: ");
        if(listaGirafa.isEmpty()){
            System.out.println("lista vazia");
        }
        for(Animal animal:mapaAnimal.get(chaveGirafa)){
            System.out.println(animal.getId() + " " + animal.getNome());
        }


    }

    private void removerAnimalPorId(int id) {
        Animal remover = null;
        int aprovacao = 2;
        if(animais.isEmpty()){
            System.out.println("LIsta vazia");
        }
        for (Animal animal:animais){
            if(animal.getId() == id){
                remover = animal;
                aprovacao = 1;
                break;
            }
            else {
                aprovacao = -1;
            }

        }
        if(aprovacao ==1) {

            animais.remove(remover);
            System.out.println("Animal de ID: " + remover.getId() + "Nome: " + remover.getNome() + "  removido com sucesso");
        }else if(aprovacao == -1) {
            System.out.println("Animal não existe");
        }
    }

    private void listarAnimais() {
        if(animais.isEmpty()){
            System.out.println("Lista fazia");
        }
        for (Animal animal:animais){
            System.out.println("Tipo: " + animal.tipo() + " Id: " + animal.getId() + " nome: "+ animal.getNome());
        }
    }

    private void listarCavalos() {
        if(animais.isEmpty()){
            System.out.println("Lista fazia");
        }
        for(Animal animal:animais){
            if( animal instanceof Cavalo){
                System.out.println(animal.getId() + " " + animal.getNome());

            }

        }
    }
    private void listarGirafasa() {
        if(animais.isEmpty()){
            System.out.println("Lista fazia");
        }
        for(Animal animal:animais){
            if( animal instanceof Girafa){
                System.out.println(animal.getId() + " " +  animal.getNome());

            }

        }
    }

    private void cadastrarCavalo() {
        System.out.println("Nome do cavalo: ");
        sc.nextLine();
        String nome = sc.nextLine();
        Cavalo cavalo = new Cavalo(nome);
        animais.add(cavalo);
        System.out.println("Cavalo adicionado na lista com sucesso");

    }
    private void cadastrarGirafa() {
        System.out.println("Nome da Girafa: ");
        sc.nextLine();
        String nome = sc.nextLine();
        Girafa girafa = new Girafa(nome);
        animais.add(girafa);
        System.out.println("Girafa adicionado na lista com sucesso");

    }

    private void menu() {
        System.out.println("1.\tCadastrar cavalo\n" +
                "2.\tCadastrar girafa\n" +
                "3.\tListar cavalos\n" +
                "4.\tListar girafas\n" +
                "5.\tListar todos os animais\n" +
                "6.\tRemover um animal por id\n" +
                "7.\tExibir a quantidade de animais cadastrados por tipo\n" +
                "8.\tSair");
    }

}

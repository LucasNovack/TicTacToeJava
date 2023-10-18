package Entities;

public class Jogador {

    private final String nome;
    private int pontuacao = 0;

    public Jogador(String nome) {
        if(!nome.isEmpty()){
        this.nome = nome;}
        else{
            this.nome = this.nomeAleatorio();
        }
    }

    public String getNome() {
        return nome;
    }

    private String nomeAleatorio(){
        return "Jogador " + Math.floor(Math.random() * 100);
    }

    public void marcarPonto(){
        this.pontuacao += 1;
    }

    int getPontucacao(){
        return this.pontuacao;
    }

}

package Entities;

import java.util.Objects;

public class Partida {
    private final Tabuleiro tabuleiro;

    private boolean reJogo = true;
    private int qtJogadas = 0;
    private boolean jogadorDaVez = true;
    private final Jogador[] jogadores;

    public Partida(Jogador[] jogadores, Tabuleiro tabuleiro) {
        this.jogadores = jogadores;
        this.tabuleiro = tabuleiro;
    }

    // Jogador 1 == True
    // Jogador 2 == False
    public void alternarJogador(){
        this.jogadorDaVez = !this.jogadorDaVez;
    }

    public String getNomeJogadorDaVez(){
        return jogadorDaVez ? jogadores[0].getNome() : jogadores[1].getNome();
    }

    private void contabilizarJogada(){
        this.qtJogadas += 1;
    }

    public int getQtJogadas(){
        return this.qtJogadas;
    }

    public void zerarQtJogadas(){
        this.qtJogadas = 0;
    }

    public boolean getReJogo(){
        return this.reJogo;
    }

    public void setReJogo(){
            this.reJogo = false;
    }

    public char getValorJogada(){
        return jogadorDaVez ? 'X' : 'O';
    }

    public boolean verificarJogada(int posicao) throws Exception {
        if(posicao < 0 || posicao > 9){
            throw new Exception("Escolha uma posição válida");
        }

        if(!Objects.equals(this.tabuleiro.quadro[posicao], " ")){
            throw new Exception("Escolha apenas lugares não ocupados");
        }

        return true;
    }

    public Jogador vencedorDaPartida(){
        return jogadorDaVez ? jogadores[0] : jogadores[1];
    }

    public void mostrarPlacar(){
        System.out.println("Placar: ");
        System.out.printf("%s: %d --- %s: %d\n",
                jogadores[0].getNome(),
                jogadores[0].getPontucacao(),
                jogadores[1].getNome(),
                jogadores[1].getPontucacao());
    }

    public void deuVelha(){
            this.zerarQtJogadas();
            System.out.println("Deu velha!");
            System.out.println("O jogo será reiniciado");
            this.tabuleiro.limparQuadro();
            this.tabuleiro.desenharQuadro();
    }

    public void condicoesPosVitoria(){
        this.tabuleiro.limparQuadro();
        this.zerarQtJogadas();
        this.alternarJogador();
    }

    public boolean verificarVitoria(){
        for(int i = 0; i < this.tabuleiro.condicaoVitoria.length; i++){
                if(this.tabuleiro.conferirValoresCondicao(i)){
                    return true;
                }
            }
        return false;
        }

    public void realizarJogada(int posicao){
        try{
        if(this.verificarJogada(posicao-1)){
            this.tabuleiro.quadro[posicao-1] = String.valueOf(this.getValorJogada());
            this.alternarJogador();
            this.contabilizarJogada();
         }}catch (Exception e){
            System.out.println("Erro ao realizar jogada: " + e.getMessage());
        };
    }

}

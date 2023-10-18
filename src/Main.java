import Entities.Jogador;
import Entities.Partida;
import Entities.Tabuleiro;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        int posicao;

        System.out.println("Seja bem vindo(a) ao jogo da velha!");
        System.out.println();
        System.out.println("Para começar digite os seguintes dados: ");

        System.out.print("Nome do jogador(a) 1: ");
        String nome1 = sc.nextLine();
        System.out.print("Nome do jogador(a) 2: ");
        String nome2 = sc.nextLine();

        Jogador jogador1 = new Jogador(nome1.trim());
        Jogador jogador2 = new Jogador(nome2.trim());

        Partida partida = new Partida(new Jogador[]{jogador1,jogador2}, tabuleiro);

        System.out.println("Perfeito! Para começar, segue as coordenadas de cada local do tabuleiro");

        tabuleiro.coordenadasQuadro();

        while(partida.getReJogo()){
            tabuleiro.desenharQuadro();
            if(partida.getQtJogadas() >= 9){
                partida.deuVelha();
            }
            System.out.printf("%s, Escolha a posição: \n", partida.getNomeJogadorDaVez());

            try {
                posicao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }

            try {
                partida.realizarJogada(posicao);
            } catch (Exception e) {
                System.out.println("Erro ao realizar a jogada: " + e.getMessage());
                continue;
            }

            if(partida.verificarVitoria()){

                partida.alternarJogador();
                partida.vencedorDaPartida().marcarPonto();
                System.out.printf("O jogador %s venceu!\n", partida.getNomeJogadorDaVez());
                tabuleiro.desenharQuadro();
                System.out.print("Deseja jogar novamente(S/N):  ");
                String escolha = sc.nextLine();

                if(Objects.equals(escolha, "N") || Objects.equals(escolha, "n")){
                    partida.setReJogo();
                    partida.mostrarPlacar();
                    System.out.println("Final do jogo");
                } else{
                    partida.mostrarPlacar();
                    partida.condicoesPosVitoria();
                }
            }

        }

        sc.close();
    }

}
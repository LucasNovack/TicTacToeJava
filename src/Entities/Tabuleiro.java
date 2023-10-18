package Entities;

import java.util.Arrays;
import java.util.Objects;

public class Tabuleiro {

    public String[] quadro = {" "," ", " "," "," "," "," "," "," "};
    public int[][] condicaoVitoria = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};

    // Retorna um vetor com os três valores que precisam ser verificados para garantir a vitória.
    public int[] getValorCondicaoVitoria(int index){
        return this.condicaoVitoria[index];
    }

    // Retorna um boolean verificando se os valores do quadro estão preenchidos e passíveis de vitória
    public boolean conferirValoresCondicao(int index){

        return Objects.equals(this.quadro[this.getValorCondicaoVitoria(index)[0]], this.quadro[this.getValorCondicaoVitoria(index)[1]])
                && Objects.equals(this.quadro[this.getValorCondicaoVitoria(index)[1]], this.quadro[this.getValorCondicaoVitoria(index)[2]])
                && !Objects.equals(this.quadro[this.getValorCondicaoVitoria(index)[0]], " ")
                && !Objects.equals(this.quadro[this.getValorCondicaoVitoria(index)[1]], " ")
                && !Objects.equals(this.quadro[this.getValorCondicaoVitoria(index)[2]], " ");

    }

    public void limparQuadro(){
        Arrays.fill(quadro, " ");
    }

    public void coordenadasQuadro(){
        System.out.println();
        System.out.println("-----------------------------");
        System.out.print("\n7 | 8 | 9\n");
        System.out.println("__________");
        System.out.print("4 | 5 | 6\n");
        System.out.println("__________");
        System.out.print("1 | 2 | 3\n");
        System.out.println();
        System.out.println("-----------------------------");
    }

    public void desenharQuadro(){
        System.out.printf("\n%s | %s | %s\n", quadro[6], quadro[7], quadro[8]);
        System.out.println("__________");
        System.out.printf("%s | %s | %s\n", quadro[3], quadro[4], quadro[5]);
        System.out.println("__________");
        System.out.printf("%s | %s | %s\n", quadro[0], quadro[1], quadro[2]);
    }

}

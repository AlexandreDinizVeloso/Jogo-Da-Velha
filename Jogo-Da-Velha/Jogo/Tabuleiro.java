package Jogo;

import Jogador.Humano;
import Jogador.Jogador;

public class Tabuleiro {
    //criando variaveis
    private char[][] tabuleiro;

    //metodo construtor fazendo uma matriz 3x3 de char vazio
    public Tabuleiro(){
        tabuleiro = new char[3][3];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                tabuleiro[i][j] = ' ';
            }
        }
    }

    //printa o tabuleiro
    public void mostrarTabuleiro(){
        System.out.println(tabuleiro[0][0]+"|"+tabuleiro[0][1]+"|"+tabuleiro[0][2]);
        System.out.println("-----");
        System.out.println(tabuleiro[1][0]+"|"+tabuleiro[1][1]+"|"+tabuleiro[1][2]);
        System.out.println("-----");
        System.out.println(tabuleiro[2][0]+"|"+tabuleiro[2][1]+"|"+tabuleiro[2][2]);
    }

    //checa se um dos dois jogadores ganhou no turno e retorna uma mensagem e um bool
    public boolean checarVitoria(Jogador jogadorUm, Jogador jogadorDois){
        for (int i=1; i<=2; i++){
            if (linhaVitoria(i, jogadorUm, jogadorDois) || colunaVitoria(i, jogadorUm, jogadorDois) || diagonalVitoria(i, jogadorUm, jogadorDois)){
                System.out.println("Vitoria do jogador "+i+" !!!");
                return true;
            }
        }

        return false;
    }

    //checa linha por linha se existem 3 simbolos iguais
    private boolean linhaVitoria(int num, Jogador jogadorUm, Jogador jogadorDois){
        Jogador tempJogador = new Humano(0, ' ');

        if (num == jogadorUm.getNum()){
            tempJogador = jogadorUm;
        }
        else if (num == jogadorDois.getNum()){
            tempJogador = jogadorDois;
        }

        for (int i=0; i<3; i++){
            int[] temp = {i, 0};
            var pos1 = getPosicao(temp);

            temp[1] = 1;
            var pos2 = getPosicao(temp);

            temp[1] = 2;
            var pos3 = getPosicao(temp);

            if ((pos1 == tempJogador.getSimbolo()) && (pos2 == tempJogador.getSimbolo()) && (pos3 == tempJogador.getSimbolo())) return true;
        }

        return false;
    }

    //checa coluna por coluna se existem 3 simbolos iguais
    private boolean colunaVitoria(int num, Jogador jogadorUm, Jogador jogadorDois){
        var tempJogador = jogadorUm;

        if (num == jogadorUm.getNum()){
            tempJogador = jogadorUm;
        }
        else if (num == jogadorDois.getNum()){
            tempJogador = jogadorDois;
        }

        for (int i=0; i<3; i++){
            int[] temp = {0, i};
            var pos1 = getPosicao(temp);

            temp[0] = 1;
            var pos2 = getPosicao(temp);

            temp[0] = 2;
            var pos3 = getPosicao(temp);

            if ((pos1 == tempJogador.getSimbolo()) && (pos2 == tempJogador.getSimbolo()) && (pos3 == tempJogador.getSimbolo())){
                return true;
            }
        }

        return false;
    }

    //checa as duas diagonais por 3 simbolos iguais
    private boolean diagonalVitoria(int num, Jogador jogadorUm, Jogador jogadorDois) {
        var tempJogador = jogadorUm;

        if (num == jogadorUm.getNum()){
            tempJogador = jogadorUm;
        }
        else if (num == jogadorDois.getNum()){
            tempJogador = jogadorDois;
        }

        int[] temp = {0, 0};
        var pos1 = getPosicao(temp);

        temp[0] = 1;
        temp[1] = 1;
        var pos2 = getPosicao(temp);

        temp[0] = 2;
        temp[1] = 2;
        var pos3 = getPosicao(temp);

        if ((pos1 == tempJogador.getSimbolo()) && (pos2 == tempJogador.getSimbolo()) && (pos3 == tempJogador.getSimbolo())){
            return true;
        }

        temp[0] = 0;
        temp[1] = 2;
        pos1 = getPosicao(temp);

        temp[0] = 1;
        temp[1] = 1;
        pos2 = getPosicao(temp);

        temp[0] = 2;
        temp[1] = 0;
        pos3 = getPosicao(temp);
        
        if ((pos1 == tempJogador.getSimbolo()) && (pos2 == tempJogador.getSimbolo()) && (pos3 == tempJogador.getSimbolo())){
            return true;
        }

        return false;
    }

    //getters e setters
    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public char getPosicao(int[] lugar) {
        return this.tabuleiro[lugar[0]][lugar[1]];
    }

    public void setPosicao(int[] lugar, char valor) {
        this.tabuleiro[lugar[0]][lugar[1]] = valor;
    }
}

package Jogador;
import Jogo.Tabuleiro;

public abstract class Jogador {
    //declarando variaveis
    protected int num;
    protected char simbolo;

    //definindo construtor
    public Jogador(int num, char simbolo){
        this.num = num;
        this.simbolo = simbolo;
    }

    //abstracao de metodos
    public abstract boolean checarPosicao(int[] lugar, Tabuleiro tabuleiro);
    public abstract char[][] fazerJogada(int[] lugar, Tabuleiro tabuleiro);

    //getters e setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}

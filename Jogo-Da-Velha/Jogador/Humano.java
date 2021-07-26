package Jogador;
import Jogo.Tabuleiro;

public class Humano extends Jogador{
    //metodo construtor
    public Humano(int num, char simbolo){
        super(num, simbolo);
    }

    //checando se a posicao do tabuleiro esta aberta e retornando um bool
    @Override
    public boolean checarPosicao(int[] lugar, Tabuleiro tabuleiro){
        if (tabuleiro.getPosicao(lugar) == ' '){
            return true;
        }
        else{
            return false;
        }
    }

    //fazendo a jogada caso a posicao for vazia
    @Override
    public char[][] fazerJogada(int[] lugar, Tabuleiro tabuleiro){
        tabuleiro.setPosicao(lugar, getSimbolo());
        return tabuleiro.getTabuleiro();
    }
}
package Jogador;
import java.util.Random;
import Jogo.Tabuleiro;

public class Computador extends Jogador{
    //metodo construtor
    public Computador(int num, char simbolo){
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

    //Pega dois numeros aleatorios entre 0 e 2 e faz a jogada caso a casa esteja vazia
    @Override
    public char[][] fazerJogada(int[] lugar, Tabuleiro tabuleiro){
        Random random = new Random();

        while (!checarPosicao(lugar, tabuleiro)){
            lugar[0] = random.nextInt(3);
            lugar[1] = random.nextInt(3);
        }

        tabuleiro.setPosicao(lugar, getSimbolo());
        return tabuleiro.getTabuleiro();
    }
}
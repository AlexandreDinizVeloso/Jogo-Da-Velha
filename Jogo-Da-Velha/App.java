import java.util.Scanner;

import Jogador.Computador;
import Jogador.Humano;
import Jogador.Jogador;
import Jogo.Tabuleiro;

public class App {
    public static void main(String[] args) throws Exception {
        //criando as variaveis
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorUm;
        Jogador jogadorDois;
        boolean multijogador = false;
        boolean vitoria = false;
        int counter = 0;

        //criando o jogador 2 de acordo com a opcao selecionada
        System.out.println("Jogar sozinho ou com um amigo? (1-BOT   2-Pessoa):");
        if (scanner.nextInt() == 1) jogadorDois = new Computador(2, ' ');
        else {
            jogadorDois = new Humano(2, ' ');
            multijogador = true;
        }

        //criando o jogador 1 e setando o simbolo do jogador 2 de acordo com a opcao selecionada
        System.out.println("Jogador 1, qual simbolo gostaria? (1-X  2-O):");
        if (scanner.nextInt() == 1) {
            jogadorUm = new Humano(1, 'X');
            jogadorDois.setSimbolo('O');
        }
        else {
            jogadorUm = new Humano(1, 'O');
            jogadorDois.setSimbolo('X');
        }

        //loop enquanto nenhum jogador ganhar
        while (!vitoria){
            //criando o array que ira segurar a localizacao da jogada
            int jogada[] = {0, 0};

            //recebe a posicao da jogada e faz um loop para o caso da jogada ser invalida, mostra o tabuleiro, e checa por uma vitoria
            System.out.println("Jogador 1, insira seu movimento:");
            System.out.print("Linha:");
            jogada[0] = scanner.nextInt();
            System.out.print("Coluna:");
            jogada[1] = scanner.nextInt();
            while (!jogadorUm.checarPosicao(jogada, tabuleiro)){
                System.out.println("Invalido, insira seu movimento:");
                jogada[0] = scanner.nextInt();
                jogada[1] = scanner.nextInt();
            }
            tabuleiro.setTabuleiro(jogadorUm.fazerJogada(jogada, tabuleiro));
            tabuleiro.mostrarTabuleiro();
            vitoria = tabuleiro.checarVitoria(jogadorUm, jogadorDois);

            //recebe a posicao da jogada e faz um loop para o caso da jogada ser invalida se o jogador for humano, caso nao, faz a jogada do computador, mostra o tabuleiro, e checa por uma vitoria
            if (multijogador){
                System.out.println("Jogador 2, insira seu movimento:");
                System.out.print("Linha:");
                jogada[0] = scanner.nextInt();
                System.out.print("Coluna:");
                jogada[1] = scanner.nextInt();
                while (!jogadorDois.checarPosicao(jogada, tabuleiro)){
                    System.out.println("Invalido, insira seu movimento:");
                    System.out.print("Linha:");
                    jogada[0] = scanner.nextInt();
                    System.out.print("Coluna:");
                    jogada[1] = scanner.nextInt();
                }
                tabuleiro.setTabuleiro(jogadorDois.fazerJogada(jogada, tabuleiro));
            }
            else tabuleiro.setTabuleiro(jogadorDois.fazerJogada(jogada, tabuleiro));
            tabuleiro.mostrarTabuleiro();
            vitoria = tabuleiro.checarVitoria(jogadorUm, jogadorDois);

            counter++;

            if (counter == 9){
                System.out.println("Empate !!!");
                vitoria = true;
            }
        }

        scanner.close();
    }
}

package application;

// import java.io.Console;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String player1, player2;
		String word;
		String clue;
		int pending, attempts = 0, missed = 0;
		char guess;
		boolean solved = false, goal = false;
		// char[] word = {' '};
		// Console console = System.console();
		
		System.out.println("~~~~~~~~~ JOGO DA FORCA ~~~~~~~~~~");
		System.out.println("\n\nEste jogo deverá ser jogado em duplas.");
		System.out.println("\nEscreva abaixo o nome dos jogadores:");
		System.out.print("\nJogador 1: ");
		player1 = sc.nextLine();
		System.out.print("Jogador 2: ");
		player2 = sc.nextLine();
		
		System.out.println();
		System.out.print(player1 + ", digite a palavra que " + player2 + " deverá advinhar:\n>> ");
		word = sc.nextLine().toUpperCase();
		// word = console.readPassword();
		
		char wrd[] = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			wrd[i] = '_';
		}
		
		pending = word.length();
		
		System.out.println("\nAgora, insira uma dica:");
		clue = sc.nextLine();
		
		System.out.println("\nTudo pronto, vamos começar!");
				
		while(solved == false) {
			System.out.println("\n");
			System.out.printf("Letras: %d%n", word.length());
			System.out.printf("Dica: %s%n", clue);
			System.out.printf("Tentativas: %d%n", attempts);

			System.out.println("\nDigite uma letra:\n>> ");
			guess = Character.toUpperCase(sc.nextLine().charAt(0));
			attempts ++;
			goal = false;
			
			for(int k = 0; k < word.length(); k++) {
				
				if(guess == word.charAt(k)) {
					wrd[k] = Character.toUpperCase(word.charAt(k));
					pending--;
					goal = true;
				}
				
				if(pending == 0) {
					solved = true;
					break;
				}
			}
			
			if(goal == false) {
				missed++;
			}
			if(missed == (int) (0.7 * word.length())) {
				break;
			}
			
			System.out.println(wrd);
		}
		
		if(solved == true) {
			System.out.println("\nParabéns, " + player2 + "! Você acertou!");
		}
		else {
			System.out.println("\nMais sorte na próxima vez, " + player2 + ". Você foi enforcado(a).\n");
		}
		System.out.println("\n~~~ Estatísticas da partida ~~~\n");
		System.out.printf("Palavra: %s%n", word);
		System.out.printf("Dica: %s%n", clue);
		System.out.printf("Letras: %d%n", word.length());
		System.out.printf("Erros: %d%n", missed);
		System.out.printf("Tentativas: %d%n", attempts);
		System.out.printf("Pontuação: %d", (attempts - missed) * 100);
		
		
		sc.close();
	}

}

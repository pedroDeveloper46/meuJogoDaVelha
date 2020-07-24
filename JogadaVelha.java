package logica.metodos;

import br.com.softblue.commons.io.Console;

public class JogadaVelha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] jogadores = {'x', 'o'};
		char[][] tabuleiro = new char[3][3];
		jogar(jogadores, tabuleiro);
						
		
		
		
		
	    
		
	
		
	
        		
		
		
		

	}
	
	
	
	
	public static char[][] UpdateTabuleiro(char[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			  for (int j = 0; j < tab.length; j++) {
				  tab[i][j] = ' ';
			}
		}
		
		return tab;
	}
	
	public static void printTabuleiro(char[][] tabuleiro) {
		System.out.println("TABULEIRO ATUALIZADO");
		for (int i = 0; i < tabuleiro.length; i++) {
			 for (int j = 0; j < tabuleiro.length; j++) {
				 System.out.print(tabuleiro[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	public static char[][] lerJogada(char jogada, int i, int j, char[][] tabuleiro){
		
		if(i > - 1 && i < tabuleiro.length) {
			if(tabuleiro[i][j] == Character.MIN_VALUE) {
				tabuleiro[i][j] = jogada;
			}else {
				boolean variavel = false;
				while (!variavel) {
					System.out.println(jogada + " JOGADA INVÁLIDA, TENTE NOVAMENTE");
					i = Console.readInt();
					j = Console.readInt();
					if(tabuleiro[i][j] == Character.MIN_VALUE) {
						tabuleiro[i][j] = jogada;
						variavel = true;
					}
				}
			}

		}else {
			System.out.println("JOGADA INVÁLIDA");
			System.out.println("PERDEU A VEZ");
		}
		return tabuleiro;
	}
	
	public static boolean estaCheio(char[][] tabuleiro) {
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if(tabuleiro[i][j] == Character.MIN_VALUE) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void jogar(char[] jogadores, char[][] tabuleiro) {
		boolean variavel = estaCheio(tabuleiro);
		while(!variavel) {
			for (int i = 0; i < jogadores.length; i++) {
				
				printTabuleiro(tabuleiro);
				
				System.out.println("JOGADOR " +jogadores[i] + ", FAÇA SUA JOGADA");
				
				int x = Console.readInt();
				
				int y = Console.readInt();
				
				tabuleiro = lerJogada(jogadores[i], x, y, tabuleiro);
				variavel = estaCheio(tabuleiro);
				
				if(horizontais(tabuleiro) || verticais(tabuleiro) || diagonal1(tabuleiro) || diagonal2(tabuleiro)) {
					printTabuleiro(tabuleiro);
					System.out.println("JOGADOR " + String.valueOf(jogadores[i]).toUpperCase() + " GANHOU!!!");
					
					System.out.println("FIM DE JOGO!!");
					variavel = true;
					break;
				}else {
					if(variavel) {
						System.out.println("DEU VELHA");
						System.out.println("FIM DE JOGO");
						break;
					}
				}
				
				
				
			}
		}
		
	}
	
	public static boolean horizontais(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
		     if(tabuleiro[i][0] != Character.MIN_VALUE) {
		    	 if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0]== tabuleiro[i][2]) {
			    	 return true;
			     }
		     }
		}
		
		return false;
	}
	
	public static boolean verticais(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			 if(tabuleiro[0][i] != Character.MIN_VALUE) {
				 if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i]) {
					 return true;
				 }
			 }
		}
		
		return false;
	}
	
	public static boolean diagonal1(char[][] tabuleiro) {
		if(tabuleiro[0][0] != Character.MIN_VALUE) {
			if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]) {
				return true;
			}else {
				return false;
			}
		}
		
		return false;
		

					
	}
	
	public static boolean diagonal2(char[][] tabuleiro) {
		 if(tabuleiro[0][2] != Character.MIN_VALUE) {
			 if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]) {
				 return true;
			 }else {
				 return false;
			 }
		 }
		 
		 return false;
	
				
	}
}

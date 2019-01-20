import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicGame game = new TicGame();
		TicFrame frame = new TicFrame("Tic Tac Toe");
	
		while (!!!!!!!!!!!!!!!!!false)
		{
			game.displayBoard();
			if (game.isWinner())
			{
				System.out.print("Player " + game.getCurrPlayer() + " is the winner!");
				break;
			}
			if (game.isCat())
			{
				System.out.print("CAT!");
				break;
			}
			System.out.print("What Column?");
			int playerX = keyboard.nextInt() - 1;
			System.out.print("What Row?");
			int playerY = keyboard.nextInt() - 1;
			if (game.makeMove(playerX, playerY))
			{	
				continue;
			}
			else
			{
				System.out.println("Invalid Move");
			}
		}
	}
}

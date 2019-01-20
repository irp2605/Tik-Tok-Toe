
public class TicGame
{
	// Attributes
	private char[][] board = new char[3][3];
	private char currPlayer;
	
	public TicGame ()
	{
		resetGame();
	}
	
	public char getCurrPlayer ()
	{
		return  this.currPlayer;
	}
	
	public char getSpot (int r, int c)
	{
		return this.board[r][c];
	}
	
	public void switchPlayer ()
	{
		if (this.currPlayer == 'X')
			this.currPlayer = 'O';
		else if (this.currPlayer == 'O')
			this.currPlayer = 'X';
	}
	
	public void resetGame ()
	{
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				this.board[r][c] = '0';
			}
		}
		this.currPlayer = 'X';
	}
	
	public boolean isValid (int x, int y)
	{
		if (x < 3 && x > -1 && y < 3 && y > -1)
		{
			if (this.board[y][x] == '0')
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean makeMove (int x, int y)
	{
		if (isValid(x, y))
		{
			this.board[y][x] = this.currPlayer;
			switchPlayer();
			return true;
		}
		return false;
	}
	
	public void displayBoard ()
	{
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				if (this.board[r][c] != '0')
				{
					System.out.print(this.board[r][c] + " ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.println("\n");
		}
	}
	
	public boolean isWinner ()
	{
		if (board[0][1] == 'X')
		{
			if (board[1][1] == 'X')
			{
				if (board[2][1] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[1][0] == 'X')
		{
			if (board[1][1] == 'X')
			{
				if (board[1][2] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'X')
		{
			if (board[1][1] == 'X')
			{
				if (board[2][2] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][2] == 'X')
		{
			if (board[1][1] == 'X')
			{
				if (board[2][0] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'X')
		{
			if (board[1][0] == 'X')
			{
				if (board[2][0] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][2] == 'X')
		{
			if (board[1][2] == 'X')
			{
				if (board[2][2] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'X')
		{
			if (board[0][1] == 'X')
			{
				if (board[0][2] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[2][0] == 'X')
		{
			if (board[2][1] == 'X')
			{
				if (board[2][2] == 'X')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][1] == 'O')
		{
			if (board[1][1] == 'O')
			{
				if (board[2][1] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[1][0] == 'O')
		{
			if (board[1][1] == 'O')
			{
				if (board[1][2] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'O')
		{
			if (board[1][1] == 'O')
			{
				if (board[2][2] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][2] == 'O')
		{
			if (board[1][1] == 'O')
			{
				if (board[2][0] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'O')
		{
			if (board[1][0] == 'O')
			{
				if (board[2][0] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][2] == 'O')
		{
			if (board[1][2] == 'O')
			{
				if (board[2][2] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[0][0] == 'O')
		{
			if (board[0][1] == 'O')
			{
				if (board[0][2] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		if (board[2][0] == 'O')
		{
			if (board[2][1] == 'O')
			{
				if (board[2][2] == 'O')
				{
					switchPlayer();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isCat ()
	{
		if (board[0][0] != '0')
		{
			if (board[1][0] != '0')
			{
				if (board[2][0] != '0')
				{
					if (board[0][1] != '0')
					{
						if (board[0][2] != '0')
						{
							if (board[1][1] != '0')
							{
								if (board[1][2] != '0')
								{
									if (board[2][1] != '0')
									{
										if (board[2][2] != '0')
										{
											if (isWinner() == false)
												return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}

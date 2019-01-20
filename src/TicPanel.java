
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TicPanel extends JPanel implements MouseListener
{
	BufferedImage dog;
	BufferedImage pepe;
	BufferedImage doggoWin;
	BufferedImage pepeWin;
	BufferedImage catto;
	private boolean aboutToReset;
	private TicGame game;
	
	public TicPanel ()
	{
		super();
		setSize(680, 780);
		try
		{
			dog = ImageIO.read(new File("imag//dog.jpg"));
			pepe = ImageIO.read(new File("imag//pep.png"));
			doggoWin = ImageIO.read(new File("imag//DoggoWinner.png"));
			pepeWin = ImageIO.read(new File("imag//PepeWinner.png"));
			catto = ImageIO.read(new File("imag//politeCat.jpg"));
		} catch (Exception e)
		{
			System.out.println("Error Loading Images: " + e.getMessage());
		}
		this.aboutToReset = false;
		game = new TicGame();
		addMouseListener(this);
	}
	
	public void paint (Graphics g)
	{
		if (this.game.isWinner())
		{
			if (this.game.getCurrPlayer() == 'X')
			{
				g.drawImage(doggoWin, 0, 0, null);
			}
			else if (this.game.getCurrPlayer() == 'O')
			{
				g.drawImage(pepeWin, 0, 0, null);
			}
		}
		else if (this.game.isCat())
		{
			g.drawImage(catto, 0, 0, null);
		}
		else
		{
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, 680, 780);
			g.setColor(Color.BLACK);
			g.fillRect(220, 100, 10, 680);
			g.fillRect(450, 100, 10, 680);
			g.fillRect(0, 320, 680, 10);
			g.fillRect(0, 550, 680, 10);
			g.setColor(Color.BLACK);
			
			for (int r = 0; r < 3; r++)
			{
				for (int c = 0; c < 3; c++)
				{
					if (this.game.getSpot(r, c) == 'X')
					{
						g.drawImage(dog, 10 + 230 * c, 110 + 230 * r, null);
					}
					else if (this.game.getSpot(r, c) == 'O')
					{
						g.drawImage(pepe, 10 + 230 * c, 110 + 230 * r, null);
					}
				}
			}
			Font f = new Font("Comic Sans MS", Font.BOLD, 60);
			g.setFont(f);
			if (aboutToReset)
			{
				g.drawString("Confirm Reset", 130, 70);
			}
			else if (this.game.getCurrPlayer() == 'X')
			{
				g.drawString("Doggo's move", 130, 70);
			}
			else if (this.game.getCurrPlayer() == 'O')
			{
				g.drawString("Pepe's move", 130, 70);
			}
			
		}
		
	}
	
	@Override
	public void mouseClicked (MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseEntered (MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseExited (MouseEvent e)
	{
		
	}
	
	@Override
	public void mousePressed (MouseEvent e)
	{
		if (e.getButton() == e.BUTTON1 && aboutToReset == false && !(this.game.isWinner() || this.game.isCat()))
		{
			if (e.getX() >= 0 && e.getX() <= 220)
			{
				if (e.getY() >= 100 && e.getY() <= 320)
				{
					this.game.makeMove(0, 0);
				}
				else if (e.getY() >= 330 && e.getY() <= 550)
				{
					this.game.makeMove(0, 1);
				}
				else if (e.getY() >= 560 && e.getY() <= 780)
				{
					this.game.makeMove(0, 2);
				}
			}
			else if (e.getX() >= 230 && e.getX() <= 450)
			{
				if (e.getY() >= 100 && e.getY() <= 320)
				{
					this.game.makeMove(1, 0);
				}
				else if (e.getY() >= 330 && e.getY() <= 550)
				{
					this.game.makeMove(1, 1);
				}
				else if (e.getY() >= 560 && e.getY() <= 780)
				{
					this.game.makeMove(1, 2);
				}
			}
			else if (e.getX() >= 460 && e.getX() <= 680)
			{
				if (e.getY() >= 100 && e.getY() <= 320)
				{
					this.game.makeMove(2, 0);
				}
				else if (e.getY() >= 330 && e.getY() <= 550)
				{
					this.game.makeMove(2, 1);
				}
				else if (e.getY() >= 560 && e.getY() <= 780)
				{
					this.game.makeMove(2, 2);
				}
			}
		}
		else if(e.getButton() == e.BUTTON3 && game.isWinner())
		{
			game = new TicGame();
			game.displayBoard();
			aboutToReset = false;
		}
		else if (e.getButton() == e.BUTTON3 && !aboutToReset)
		{
			aboutToReset = true;
		}
		else if (e.getButton() == e.BUTTON1 && aboutToReset)
		{
			aboutToReset = false;
		}
		else if (e.getButton() == e.BUTTON3 && aboutToReset)
		{
			game = new TicGame();
			game.displayBoard();
			aboutToReset = false;
		}
		repaint();
	}
	
	@Override
	public void mouseReleased (MouseEvent e)
	{
	}

	
	public void addNotify ()
	{
		super.addNotify();
		requestFocus();
	}
}

/*
 * Draw Image at row & column g.drawImage(dog,10 + 230*c,110 + 230*r,null);
 */

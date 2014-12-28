import java.util.ArrayList;
import java.util.Scanner;


public class Simulation 
{
	private String name;
	private ArrayList<Player> players;
	private Scanner in;
	private int playerNum;
	
	private int winningNumber;
	private int losingNumber;
	private int rollAgain;
	private int noRoll;
	
	boolean onePlaying = true;
	int winner;
	boolean hasWinner = false;
	int bestScore = 0;
	boolean hasBestScore = false;
	
	
	
	Simulation()
	{
		name = null;
		players = new ArrayList<Player>();
		in  = new Scanner(System.in);
		playerNum = 1;
	}
	
	public void runSimulation()
	{
		getPlayers();
		
		if(players.size() > 0)
		{
			runGame();
			pickWinner();
		}
	}
	
	public void pickRules()
	{
		
	}
	
	public void getPlayers()
	{
		System.out.println("Enter the name of Player " + playerNum + " ('done' when finished) : ");
		name = in.next();
		playerNum++;
		
		while(!name.equals("done"))
		{
			players.add(new Player(name, winningNumber, losingNumber));
			System.out.println("Enter the name of Player " + playerNum + " ('done' when finished) : ");
			name = in.next();
			playerNum++;
			
		}
	}
	
	public void runGame()
	{
		while(onePlaying)
		{
			onePlaying = false;
			for(int i = 0 ; i < players.size() ; i++)
			{
				if(players.get(i).isPlaying())
				{
					onePlaying = true;
					players.get(i).rollDie();
					
					if(players.get(i).getScore() > 0 && players.get(i).getScore() > players.get(bestScore).getScore())
					{
						bestScore = i;
						hasBestScore = true;
						
					}
					
					if(players.get(i).hasWon())
					{
						winner = i;
						onePlaying = false;
						hasWinner = true;
						break;
					}
					
				}
			}
		}
			
	}
	
	
	
	private void pickWinner()
	{
		if(hasBestScore)
		{
			players.get(bestScore).setWon(true);
			hasWinner = true;
		}
		
		if(hasWinner)
		{
			for(int i = 0 ; i < players.size() ; i++)
			{
				if(!players.get(i).hasWon())
				{
					System.out.println("LOSER " + i + "," + players.get(i).getName() + " :" + players.get(i).getScore());
				}
				else
				{
					System.out.println("WINNER " + i + "," + players.get(i).getName() + " :" + players.get(i).getScore());
				}
				
			}
		}
		else
		{
			for(int i = 0 ; i < players.size() ; i++)
			{
				if(!players.get(i).hasWon())
				{
					System.out.println("TIE " + i + "," + players.get(i).getName() + " :" + players.get(i).getScore());
				}
			}
		}
		
	}
	

}

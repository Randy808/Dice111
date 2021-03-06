import java.util.Random;


public class Player 
{
	private String name;//name of the player to be inserted into the constructor
	private boolean playing;//bool on whether the player is till playing or not
	private boolean won;//bool indicating whether player one or not
	public static Random die;//a random number generator that represents the dice
	private int score;//the player's score
	private int roll;
	private int winningNumber;
	private int losingNumber;
	
	Player(String name, int winningNumber, int losingNumber)
	{
		this.name = name;
		this.playing = true;
		this.die = new Random();
		this.winningNumber = winningNumber;
	}
	
	public void rollDie()
	{	
		int roll = die.nextInt(6 + 1);
		
		score += roll;
		
		
		
		System.out.println("Roll" + roll + "\tScore" + score);
		
	}
	public boolean isPlaying()
	{
		if(roll == losingNumber)
			playing = false;
		
		return playing;
	}
	public boolean hasWon()
	{
		if(score >= winningNumber)
			won = true;
		
		return won;
	}
	public void setWon(boolean won)
	{
		this.won = won;;
	}
	public int getScore()
	{
		return score;
	}
	public String getName()
	{
		return name;
	}

}

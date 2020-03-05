package Project;

import java.io.IOException;

public class Driver {
	public static void main(String[]args) {
		try {
		 Game game1 = new Game();
		 game1.play();
		 game1.writeToFile("GameLog.txt");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		  
	 }

}

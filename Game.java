package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {
	 private Player player;
	 private Room [] dungeon;
	 Scanner scnr = new Scanner(System.in);
	 String fileName = "PlayerInfo.txt";
	 String line1,line2,line3,line4,line5;
	 int a1,a2,a3;
	 BufferedReader filereader = null;
	 int rid=0;
	 String content="";
	 static int battle_count=1;
	 
	 public Game() throws IOException {
		 try {
			 filereader = new BufferedReader(new FileReader(fileName));
			 line1 = filereader.readLine();
			 line2 = filereader.readLine();
			 line3 = filereader.readLine();
			 a1 = Integer.parseInt(line3);
			 line4 = filereader.readLine();
			 a2 = Integer.parseInt(line4);
			 line5 = filereader.readLine();
			 a3 = Integer.parseInt(line5);
			 player = new Player(line1,line2,a1,a2,a3);
			 
			 
			 
		 }
		 catch(FileNotFoundException excpt) {
			 
			 System.out.println("File Not Found "+fileName);
			 
		 }
		 this.dungeon = new Room [3];
		 Monster monster1 = new Monster("Orc","covered with green blood", 20,5,0);
		 Room room1 = new Room("a room with an unbearable smell",monster1);
		 Monster monster2 = new Monster("Skeleton","funny how it moves",40,10,10);
		 Room room2 = new Room("dark and cold room",monster2);
		 Monster monster3 = new Monster("Fire dragon","spout fire with each breath", 100, 20,40);
		 TreasureRoom room3 = new TreasureRoom("a giant hall with something shiny on the other end",monster3,"a large pile of gold");
		 dungeon[0]= room1;
		 dungeon[1]= room2;
		 dungeon[2]= room3;
	 }

	 public void play() {
		
		 while(player.isAlive() && rid<3){            //3 rooms and player Alive
		
		 content += player.getDescription()+" "+player.getName()+" getting ready for a battle"+battle_count+": "+"\n" ;
	     dungeon[rid].enter(player);         //entering battle 
	     battle_count++;          
		 content+= player.getName()+" is entering into "+dungeon[rid].getDescription()+" that is occupied by "+dungeon[rid].getMonster().getName()+"\n";
		
		 
		 if(dungeon[rid].isComplete())
		 {   
			 content+= "The player: "+player.getName()+" defeated the monster"+"\n";
			 System.out.println("The player: "+player.getName()+" defeated the monster");
			 content += "The monster in room "+(rid+1)+" died."+"\n";
			 System.out.println("The monster "+dungeon[rid].getMonster().getName()+" in room "+(rid+1)+" died.");
			 System.out.println();
		 }
		 if(player.isAlive() && rid ==2)
		 {
			 content+= "GAME OVER"; 
			 System.out.println("GAME OVER");
			 
		 }
		 rid++;
		
		     
	}
		   
}
	  
	 public void writeToFile(String New_fileName){
	       PrintWriter outputs=null;//use the PrintWriter to create our output stream
	       try {
	           outputs = new PrintWriter(New_fileName);//create & connect the output stream to the file using the String fileName
	           outputs.println(content);//write the String to the file
	           System.out.println("Successfully wrote to the file "+New_fileName);      
	       } catch (FileNotFoundException e) {
	         
	           System.out.println(e.getMessage());
	       }
	       finally{
	           if(outputs != null){//if not closed
	               outputs.close(); //close it
	           }
	           
	       }
	   }

	 
	

}

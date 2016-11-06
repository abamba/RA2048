import javax.swing.*;
import processing.core.PApplet;
import java.awt.event.*;
import java.awt.*; 

public class Game extends PApplet {

	/*NOTE: If your class is part of a package other than the default package, you must call PApplet's main using the package name as well, like this:
	
	PApplet.main("packageName.ClassName");
	
	https://processing.org/tutorials/eclipse/
	*/
	int[][] board = new int[4][4]; 
	int pad = 10, block = 100; 
	int length = pad*(board.length+1)+block*board.length; 

	
	public static void main(String[] args) {
		PApplet.main("Game");	
		
		Start jeu = new Start();
	}
		/*Start 2048 = new Start();
		
		JFrame frame = new JFrame(); /* this is a window */
		/*frame.setTitle("This bullshit");
		frame.setResizable(false);
		frame.add(jeu); 
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 600); 
		frame.getContentPane().setBackground(new Color(241,241,241));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		jeu.Game(); //redundant is it not?*/
		
		//FUN STUFF

	public void settings(){
		//size(500, 500);
		size(length, length);
		//Start();
    }

    public void setup(){ 
    	size(length, length); //pour le background
    	//fill(120,50,240); //this tutorial creates ugly shit
    }

    public void draw(){
	    background(241); 
	    //rectt(0, 0, width, height, 10, color(150));
	    //ellipse(width/2,height/2,second(),second());
	    for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board.length; j++)
        	{
        		int x = 10+110*(i);
        		int y = 10+110*(j);
        		int w = block;
        		int h = block;
        		fill(20*i,0,0);
        		rect(x,y,w,h);
        	}
    	}
    }
    /* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ 
}

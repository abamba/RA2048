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
        		int x = 10+110*(i); /* On place les carrés sur un certain x */
        		int y = 10+110*(j); /* On place les carrés sur un certain u */
        		int c = block;		/* Taille du coté des carrés */
        		int r = 205;
        		int g = 193;
        		int b = 180;
        		noStroke();
        		rectangle(x,y,c,c,r,g,b);
        	}
    	}
    }

    public void rectangle(float x, float y, float w, float h, int r, int g, int b)
    {
    	fill(r,g,b);
    	rect(x,y,w,h);
    }
    
    public void texte(String t, float x, float y, float w, float h, int r, int g, int b, float s, int align){
    	fill(r,g,b);
    	textAlign(align);
    	textSize(s);
    	text(t,x,y,w,h);
    }
    
    /* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ /* Revive the dog */ /* Revive the dog again */
}
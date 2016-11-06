import javax.swing.*;
import processing.core.PApplet;
import java.awt.event.*;
import java.awt.*; 

public class Game extends PApplet {

	/*NOTE: If your class is part of a package other than the default package, you must call PApplet's main using the package name as well, like this:

	PApplet.main("packageName.ClassName");
	
	https://processing.org/tutorials/eclipse/
	*/
	
	public static void main(String[] args) {
		PApplet.main("Game");
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
			size(600,600);
	    }

	    public void setup(){ 
	    	fill(120,50,240); //this tutorial creates ugly shit
	    }

	    public void draw(){
	    	ellipse(width/2,height/2,second(),second());
	    	background(241);
	    }
	
		/* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ 
}

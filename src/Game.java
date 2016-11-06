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
	int pad = 10, block = 100, score = 0, dead = 0; 
	int length = pad*(board.length+1)+block*board.length; 
	//int score = 0, lose = 0;
	
	public static void main(String[] args) {
		PApplet.main("Game");	
		
		//Start jeu = new Start();
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
    	Start jeu = new Start();
    	textFont(createFont("Calibri", 38));
    }


    public void draw(){
    	background(241);
    	board[1][1]=8192;
    	board[2][3]=64;
    	for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board.length; j++)
        	{
        		int x = 10+110*(i); /* On place les carr�s sur un certain x */
        		int y = 10+110*(j); /* On place les carr�s sur un certain u */
        		int c = block;		/* Taille du cot� des carr�s */
        		float deltaG = (float)-0.014;
        		float deltaB = (float)-0.055;
        		float r = 255;
        		float g = 245 + board[i][j]*deltaG;
        		float b = 225 + board[i][j]*deltaB;
        		noStroke();
        		int size = 20;
        		rectangle(x,y,c,c,(int)r,(int)g,(int)b);
        		if(board[i][j]!=0){
        			if(board[i][j]>4096){
            			r = 0;
            			g = 0;
            			b = 0;
            			rectangle(x,y,c,c,(int)r,(int)g,(int)b);
            			texte(""+ board[i][j],x,y+55-(size*2)/3,c,c,255,255,255,(size*2)/3,CENTER);
            		}
        			else{
        				texte(""+ board[i][j],x,y+55-(size*2)/3,c,c,100,100,100,(size*2)/3,CENTER);
        			}
        		}
        	}
    	}
    	
    	if(dead==1){
    		fill(color(255,135));
    		rect(0,0,length,length);
    		int size = 20;
    		texte("En tant que personne nulle, vous �tes morte.",0,(length)/2-(size*2)/3,length,length,100,100,100,size,CENTER);
    		texte("Cliquez pour rejouer",0,(length)/2+size,length,length,100,100,100,(size*2)/3,CENTER);
    		texte("Score de fin : "+ score,0,(length)/2+2*size,length,length,100,100,100,(size*2)/3,CENTER);
    		if(mousePressed){
        		restart();
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
    
    public void restart(){
    	int size = 20;
    	texte("Score de fin : "+ score,0,(length)/2+3*size,length,length,100,100,100,(size*2)/3,CENTER);
    }
    /* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ /* Revive the dog */ /* Revive the dog again */
}
import javax.swing.*;
import processing.core.PApplet;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*; 

public class Game extends PApplet {

	/*NOTE: If your class is part of a package other than the default package, you must call PApplet's main using the package name as well, like this:
	
	PApplet.main("packageName.ClassName");
	
	https://processing.org/tutorials/eclipse/
	*/
	
	int[][] board = new int[4][4]; 

	int boo=0;

	int pad = 10, block = 100, score = 0, dead = 0; 
	int length = pad*(board.length+1)+block*board.length; 
	
	public static void main(String[] args) {
		PApplet.main("Game"); 
		
	}		
	//FUN STUFF

	public void settings(){
		size(length, length+15);
    }

    public void setup(){ 
    	size(length, length+15); //besoin des deux envie de pizza
    	textFont(createFont("Calibri", 38));
    	System.out.println("Choisir la taille du jeu : "); 
    	
    	restart();
    }
    
    public void restart(){
    	//TEST pour si jamais on se sent chauds
    	/*Scanner taille = new Scanner(System.in); 
    	int in = taille.nextInt(); // Scans the next token of the input as an int.
    	
    	int[][] board = new int[in][in]; */
    	int[][] board = new int[4][4]; 
    	int score = 0, dead = 0;
    	spawn();
    }
    
    public void spawn(){
    	//colonnes et lignes vides
    	ArrayList<Integer> xpos = new ArrayList<Integer>(), ypos = new ArrayList<Integer>(); 
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board.length; j++)
    			if(board[i][j]==0){
    				xpos.add(j);
    				ypos.add(i);
    			}
    	
    	//array index pour chopper les trucs vides et leur coller des machins 
    	//chopper la taille des array et chopper des positions randoms dans cet array 
    	int rand = (int)random(0, xpos.size()), y = ypos.get(rand), x = xpos.get(rand);
    	board[y][x] = random(0,1) < 0.9? 2 : 4; //90% de chances de tomber sur un 2, sinon un 4
    }

    public void draw(){
    	background(241);

    	if(boo==0)
    	{
    		board[3][3]=2;
    		board[1][3]=2;
    		boo=1;
    	}

    	for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board.length; j++)
        	{
        		int x = 10+110*(i); /* On place les carrés sur un certain x */
        		int y = 25+110*(j); /* On place les carrés sur un certain u */
        		int c = block;		/* Taille du coté des carrés */

        		float deltaG = (float)(197-228)/4096; //transition de couleurs de matheux pour faire des dégradés
        		float deltaB = (float)(1-218)/4096; //différence entre couleur de début et de fin
        		float r = 238;
        		float g = 228 + board[i][j]*deltaG;
        		float b = 218 + board[i][j]*deltaB;

        		noStroke();
        		int size = 40;
        		if(board[i][j]!=0){
        			if(board[i][j]>4096){
            			r = 0;
            			g = 0;
            			b = 0;
            			rectangle(x,y,c,c,(int)r,(int)g,(int)b);
            			texte(""+ board[i][j],x,y+60-(size*2)/3,c,c,255,255,255,(size*2)/3,CENTER);
            		}
        			else{
        				rectangle(x,y,c,c,(int)r,(int)g,(int)b);
        				texte(""+ board[i][j],x,y+60-(size*2)/3,c,c,100,100,100,(size*2)/3,CENTER);
        			}
        		}
        		else{
        			rectangle(x,y,c,c,205,193,180);
        		}
        	}

    	}
    	
    	if(dead==1){
    		fill(color(255,135));
    		rect(0,0,length,length);
    		int size = 20;
    		texte("En tant que personne nulle, vous êtes morte.",0,(length)/2-(size*2)/3,length,length,100,100,100,size,CENTER);
    		texte("Cliquez pour rejouer",0,(length)/2+size,length,length,100,100,100,(size*2)/3,CENTER);
    		texte("Score de fin : "+ score,0,(length)/2+2*size,length,length,100,100,100,(size*2)/3,CENTER);
    		if(mousePressed){
    			restart();
        	}
    	}

    	int size = 30;
        texte("Score : "+ score,10,0,length,length,100,100,100,(size*2)/3,LEFT);

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
    
    public void keyPressed(){
    	if(dead==0){
    		if(keyPressed){
    			int test = 0;	// 1 = mouvement possible. 0 = mouvement impossible.
    			int i, j;
    			switch (keyCode)
    			{
    				case 37:	// Left - On teste tous les mouvements de droite à gauche
    					for(i = board.length-1; i > 0; i--){
    						for (j = 0; j < 4; j++){
    							if(board[i][j]==board[i-1][j]&&board[i][j]!=0)	// Si on peut fusionner deux cases
    								test=1;
    							if(board[i][j]!=0&&board[i-1][j]==0)	// Si on peut bouger car il y a une case vide
    								test=1;
    						}
    					}
    					if(test==1)
    					{
    						KeyMove("left");
    					}
					break;
					
    			  case 38:	// Up - On teste tous les mouvements de bas en haut
  					for(j = board.length-1; j > 0; j--){
						for (i = 0; i < 4; i++){
							if(board[i][j]==board[i][j-1]&&board[i][j]!=0)	// Si on peut fusionner deux cases
								test=1;
							if(board[i][j]!=0&&board[i][j-1]==0)	// Si on peut bouger car il y a une case vide
								test=1;
						}
					}
					if(test==1)
					{
						KeyMove("up");
					}
    			    break;
    			    
    			  case 39:	// Right - On teste tous les mouvements de gauche à droite
  					for(i = 0; i < board.length-1; i++){
						for (j = 0; j < 4; j++){
							if(board[i][j]==board[i+1][j]&&board[i][j]!=0)	// Si on peut fusionner deux cases
								test=1;
							if(board[i][j]!=0&&board[i+1][j]==0)	// Si on peut bouger car il y a une case vide
								test=1;
						}
					}
					if(test==1)
					{
						KeyMove("right");
					}
    			    break;
    			    
    			  case 40:	// Down - On teste tous les mouvements de haut en bas
    				  for(j = 0; j < board.length-1; j++){
  						for (i = 0; i < 4; i++){
  							if(board[i][j]==board[i][j+1]&&board[i][j]!=0)	// Si on peut fusionner deux cases
  								test=1;
  							if(board[i][j]!=0&&board[i][j+1]==0)	// Si on peut bouger car il y a une case vide
  								test=1;
  						}
  					}
  					if(test==1)
  					{
  						KeyMove("down");
  					}
      			    break;
    			  default:
    			    System.out.println("Dude what you're so buffed up right now");
    			}
    		}
    	}
    }
    
    public void KeyMove(String s){
    	int i,j,k,sauve;
    	switch(s)
    	{
	    	case "left":
	    		for (k = 0; k<board.length;k++){
		    		for(i = board.length-1; i > 0; i--){
						for (j = 0; j < 4; j++){
							if(board[i-1][j]==0)
							{
								board[i-1][j]=board[i][j];
								board[i][j]=0;
							}
						}
					}
	    		}
	    	break;
	    	
	    	case "up":
	    		for (k = 0; k<board.length;k++){
		    		for(j = board.length-1; j > 0; j--){
						for (i = 0; i < 4; i++){
							if(board[i][j-1]==0)
							{
								board[i][j-1]=board[i][j];
								board[i][j]=0;
							}
						}
					}
	    		}
	    	break;
	    	
	    	case "right":
	    		for (k = 0; k<board.length;k++){
		    		for(i = 0; i < board.length-1; i++){
						for (j = 0; j < 4; j++){
							if(board[i+1][j]==0)
							{
								board[i+1][j]=board[i][j];
								board[i][j]=0;
							}
						}
		    		}
	    		}
    		break;
	    	
	    	case "down":
	    		for (k = 0; k<board.length;k++){
		    		for(j = 0; j < board.length-1; j++){
							for (i = 0; i < 4; i++){
								if(board[i][j+1]==0)
								{
									board[i][j+1]=board[i][j];
									board[i][j]=0;
								}
							}
						}
	    		}
	    	break;
    	}
    	draw();
    }
    
    /* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ /* Revive the dog */ /*bury the dog*/ /* Revive the dog again */

}
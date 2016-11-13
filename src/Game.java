import processing.core.PApplet;

//https://processing.org/tutorials/eclipse/

public class Game extends PApplet {
	
		// VARIABLES
	
	public static int[][] board = new int[4][4];
	int pad = 10, block = 100;
	public static int score = 0, hiscore = 0;
	public static boolean dead = false, win = false, winyet = false;
	int length = pad*(board.length+1)+block*board.length;
	
		// SETUP
	
	// Main, truc pas mal important d'ailleurs
	public static void main(String[] args) {
		PApplet.main("Game"); 		
	}		

	// Taille de la fenêtre
	public void settings(){
		size(length, length+15);
    }
	// Font, et on lance le jeu
    public void setup(){
    	Misc m = new Misc();
    	textFont(createFont("Calibri", 38));
    	m.restart();
    }
    
    	// DESSIN
    
    // Draw regroupe toutes les fonctions dessin
    public void draw()
    {
    	background(241);// On colore notre joli fond
    	normalDraw();	// Dessin de la nouvelle board
    	dead();			// Dessin de la mort
    	winner();		// Dessin de la victoire
    	// Affichage du score/highscore
    	int size = 30;
        texte("Score : "+ score,10,0,length,length,100,100,100,(size*2)/3,LEFT);
        texte("High-Score : "+ hiscore,-10,0,length,length,100,100,100,(size*2)/3,RIGHT);

    }
    // normalDraw va dessiner le board à chaque mouvement
    public void normalDraw(){
    	for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board.length; j++)
        	{
        		int x = 10+110*(i); /* On place les carrés sur un certain x */
        		int y = 25+110*(j); /* On place les carrés sur un certain y */
        		int c = block;		/* Taille du coté des carrés */
        		
        		float deltaG = (float)(197-228)/12; //transition de couleurs de matheux pour faire des dégradés
        		float deltaB = (float)(1-218)/12; //différence entre couleur de début et de fin
        		float r = 238;
        		float g = 228 + board[i][j]*deltaG;
        		float b = 218 + board[i][j]*deltaB;
        		
        		noStroke();
        		int size = 40;
        		if(board[i][j]!=0){ //mettre à noir au delà de 4096 et texte en blanc
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
    }
    // dead va dessiner l'écran de mort
    public void dead()
    {
    	Misc m = new Misc();
    	if(dead){
    		fill(color(255,135));
    		rect(0,0,length+20,length+20);
    		int size = 20;
    		texte("En tant que personne nulle, vous êtes morte.",0,(length)/2-(size*2)/3,length,length,100,100,100,size,CENTER);
    		texte("Cliquez pour rejouer",0,(length)/2+size,length,length,100,100,100,(size*2)/3,CENTER);
    		texte("Score de fin : "+ score,0,(length)/2+2*size,length,length,100,100,100,(size*2)/3,CENTER);
    		if(mousePressed){
    			m.restart();
        	}
    	}
    }
    // winner va dessiner l'écran de victoire
    public void winner()
    {
    	Misc m = new Misc();
    	m.win();
    	if(win&&winyet==false)
    	{
    		fill(color(255,135));
    		rect(0,0,length+20,length+20);
    		int size = 20;
    		texte("En tant que personne géniale, vous avez gagné.",0,(length)/2-(size*2)/3,length,length,100,100,100,size,CENTER);
    		texte("Cliquez pour rejouer",0,(length)/2+size,length,length,100,100,100,(size*2)/3,CENTER);
    		texte("Appuyez sur entrée pour continuer",0,(length)/2+2*size,length,length,100,100,100,(size*2)/3,CENTER);
    	}
    }
    // rectangle va nous aider à dessiner des rectangles (il regroupe en fait plusieurs méthodes)
    public void rectangle(float x, float y, float w, float h, int r, int g, int b)
    {
    	fill(r,g,b);
    	rect(x,y,w,h);
    }
    // texte va nous aider à faire des textes (il regroupe en fait plusieurs méthodes)
    public void texte(String t, float x, float y, float w, float h, int r, int g, int b, float s, int align){
    	fill(r,g,b);
    	textAlign(align);
    	textSize(s);
    	text(t,x,y,w,h);
    }

    	// MOUVEMENTS

    public void keyPressed()
    {
    	final int left = 37, up = 38, right = 39, down = 40, continuer = 10, restart = 32;	// Correspond aux codes ASCII des touches
    	Misc m = new Misc();
    	if(dead==false){
    		if(keyPressed){
    			int deadornay = m.deadornay(board);
    			String mov = "nope";
    			
    			switch (keyCode)
    			{
    				case left:	// Left - On teste tous les mouvements de droite à gauche
    					mov="left";
					break;
					
					case up:	// Up - On teste tous les mouvements de bas en haut
						mov="up";
					break;
    			    
					case right:	// Right - On teste tous les mouvements de gauche à droite
						mov="right";
					break;
    			    
					case down:	// Down - On teste tous les mouvements de haut en bas
						mov="down";
      			    break;
      			    
					case continuer:	// On continue le jeu
						mov="enter";
					break;
					
					case restart:	// On restart la partie
						mov="space";
					break;
    			  default:		// Le gars se plante de touche miskine
    			    	mov="nope";
    			}
    			if(win==true&&winyet==false)
				{
    				if(mov=="enter")
        			{
    					winyet=true;
    					win=false;
        			}
    				if(mov=="space")
    				{
    					m.restart();
    				}
				}
    			else if(mov!="nope"&&mov!="enter"&&mov!="space")
    			{
   	    			if(deadornay!=0&&win!=true)
	    			{
	    				KeyMove(mov);
	    			}
	    			else if(deadornay==0)
	    			{
	    				dead = true;
	    				dead();
	    			}
    			}
    		}
		}
    }
    
    public void KeyMove(String s)
    {
    	Controles cont = new Controles();
    	Misc m = new Misc();
    	board = cont.KeyMove(board, s);
    	m.spawn();		// Nouvelle tile
    	draw();			// On dessine la grille
    	m.deadornay(board);	// Est-ce qu'on est mort
    	winner();
    	m.hiscore();	// Hi human!
    	m.console(board);	// Mode console
    }

    /* Hello this is dog */ /*everybody say hello to dog*/ /*shoot the dog*/ /* Revive the dog */ /*bury the dog*/ /* Revive the dog again */
}
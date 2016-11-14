import java.util.ArrayList;

public class Misc extends Game{
	
	int deltaI, deltaJ, debI, finI, debJ, finJ, finK, addI, addJ, i, j, k, l;
	
    public int deadornay(int[][] board)
    {
    	int test = 0;	// 1 = mouvement possible. 0 = mouvement impossible.
    	
    	test = deadtest("left",board);
    	test = deadtest("up",board);
    	test = deadtest("right",board);
    	test = deadtest("down",board);
    	return test;
    }

    private int deadtest(String s,int[][] tab)
    {
    	Controles c = new Controles();
    	int i,j,k,retour = 0;
    	int rot = c.Assign(s);
    	tab = c.rotate(tab, rot);
    	
    	for(k=0; k<4; k++) 
			for(i=0; i<3; i++)
				for(j=0; j<4; j++)
					if(tab[i+1][j]==0){
						retour=1;
					}
    	for(i=3; i>0; i--)
			for(j=0; j<4; j++)
				if(tab[i-1][j]==tab[i][j]){
					retour=1;
				}
    	
    	return retour;
    }
    
    public void hiscore()
    {
    	if(score>hiscore)
    		hiscore=score;
    }
    
    public void console(int[][] board)
    {
    	int j;
    	
    	System.out.println("---------");
    	System.out.println("|2048TOS|");
    	System.out.println("---------");
    	for(j=0; j<4; j++)
			System.out.println("|" + board[0][j] + "|" + board[1][j] + "|" + board[2][j] + "|"+ board[3][j] + "|");
    }
    
    public void win(){
    	int i,j;
    	for(i=0;i<board.length;i++){
    		for(j=0;j<board.length;j++){
    			if(board[i][j]==2048&&win==false&&winyet==false)
    				win=true;
    		}
    	}
    }
    
    public void spawn(){
    	if(dead!=true)
    	{
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
	    	if(xpos.size()>0)
	    	{
	    		int rand = (int)random(0, xpos.size()), y = ypos.get(rand), x = xpos.get(rand);
	    	board[y][x] = random(0,1) < 0.9? 2 : 4; //90% de chances de tomber sur un 2, sinon un 4
	    	}
    	}
    }
    
    public void restart(){
    	board = new int[4][4]; 
    	score = 0;
    	dead = false;
    	win = false;
    	winyet = false;
    	spawn();
    	spawn();
    }

}

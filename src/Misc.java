import java.util.ArrayList;

public class Misc extends Game{
	
	int deltaI, deltaJ, debI, finI, debJ, finJ, finK, addI, addJ, i, j, k, l;
	
    public int deadornay(int[][] board)
    {
    	int test = 0;	// 1 = mouvement possible. 0 = mouvement impossible.
		for(l = 0; l<2; l++)
		{
			if(l==0)
			{
				Assign("left",board.length);
			}
			else
			{
				Assign("right",board.length);
			}
			for (k = 0; k<finK;k++)
	    		for(i = debI; i < finI; i=i+addI)
					for (j = debJ; j < finJ; j=j+addJ)
						if(board[i+deltaI][j+deltaJ]==0||board[i+deltaI][j+deltaJ]==board[i][j])
							test = 1;
		}
		for(l = 0; l<2; l++)
		{
			if(l==0)
			{
				Assign("up",board.length);
			}
			else
			{
				Assign("down",board.length);
			}
			for (k = 0; k<finK;k++)
				for (j = debJ; j < finJ; j++)
					for(i = debI; i < finI; i++)
						if(board[i+deltaI][j+deltaJ]==0||board[i+deltaI][j+deltaJ]==board[i][j])
							test = 1;
		}
    	return test;
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
    	//TEST pour si jamais on se sent chauds
    	/*System.out.println("Choisir la taille du jeu : "); 
    	Scanner taille = new Scanner(System.in); 
    	int in = taille.nextInt(); // Scans the next token of the input as an int.
    	texte("Taille du 2048 : ",0,(length)/2+2*size,length,length,100,100,100,(size*2)/3,CENTER);
    	int[][] board = new int[in][in]; */
    	board = new int[4][4]; 
    	score = 0;
    	dead = false;
    	win = false;
    	winyet = false;
    	spawn();
    	spawn();
    }

    public void Assign(String s, int size)
	{
		finK = size+2;
		switch(s)
		{
			case "left":
				deltaI = -1;
				deltaJ = 0;
				debI = 1;
				finI = size;
				debJ = 0;
				finJ = size;
				addI = 1;
				addJ = 1;
			break;
			
			case "up":
				deltaI = 0;
				deltaJ = -1;
				debI = 0;
				finI = size;
				debJ = 1;
				finJ = size;
				addI = 1;
				addJ = -1;
			break;
			
			case "right":
				deltaI = 1;
				deltaJ = 0;
				debI = 0;
				finI = size-1;
				debJ = 0;
				finJ = size;
				addI = 1;
				addJ = 1;
			break;
			
			case "down":
				deltaI = 0;
				deltaJ = 1;
				debI = 0;
				finI = size;
				debJ = 0;
				finJ = size-1;
				addI = 1;
				addJ = 1;
			break;
		}
	}
}

public class Controles extends Game{
	int deltaI, deltaJ, debI, finI, debJ, finJ, finK, addI, addJ;
	
	public int[][] KeyMove(int[][] tab, String s){
		
		// Variables
		
		int[][] tabmod = tab;
		int size = tab.length;
		Assign(s, size);
		
		tabmod = Move(deltaI, deltaJ, debI, finI, debJ, finJ, finK, s, tab);
		// On rend le tableau modifié
		
		return tabmod;
	}
	
	//TO BE DELETED
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
	
	//TO BE DELETED
	public int[][] Move(int deltaI, int deltaJ, int debI, int finI, int debJ, int finJ, int finK, String s, int[][] board)
	{
		int i,j,k;
		int[][] tabtest = new int[4][4];
		
		for(i = 0; i < tabtest.length ; i++)
    		for(j = 0; j < tabtest.length ; j++)
    			tabtest[i][j]=0;
		
		if(s=="left"||s=="right")	// Left ou Right
		{
			for (k = 0; k<finK;k++)
	    		for(i = debI; i < finI; i=i+addI)
					for (j = debJ; j < finJ; j=j+addJ)
					{
						tabtest[i][j]=0;
						if(board[i+deltaI][j+deltaJ]==board[i][j]&&tabtest[i+deltaI][j+deltaJ]!=1&&tabtest[i][j]!=1)
						{
							board[i+deltaI][j+deltaJ]=2*board[i+deltaI][j+deltaJ];
							board[i][j]=0;
							tabtest[i+deltaI][j+deltaJ]=1;
							score = score+board[i+deltaI][j+deltaJ];
						}
						if(board[i+deltaI][j+deltaJ]==0)
						{
							board[i+deltaI][j+deltaJ]=board[i][j];
							board[i][j]=0;
						}
					}
		}
		else	// Up ou Down
		{
			for (k = 0; k<finK;k++)
				for (j = debJ; j < finJ; j++)
					for(i = debI; i < finI; i++)
					{
						if(board[i+deltaI][j+deltaJ]==board[i][j]&&tabtest[i+deltaI][j+deltaJ]!=1&&tabtest[i][j]!=1)
						{
							board[i+deltaI][j+deltaJ]=2*board[i+deltaI][j+deltaJ];
							board[i][j]=0;
							tabtest[i+deltaI][j+deltaJ]=1;
							score = score+board[i+deltaI][j+deltaJ];
						}
						if(board[i+deltaI][j+deltaJ]==0)
						{
							board[i+deltaI][j+deltaJ]=board[i][j];
							board[i][j]=0;
						}
					}
		}
		return board;
	}
	
	public int[][] rotate(int[][] tab, int n)
	{
		int[][] temp = new int[4][4];
		temp = tab; 
		int i, j, k;
		
		for(k=0; k < n; k++)
			for(i=0; i<4; i++)
				for(j=0; j<4; j++)
					tab[3-j][i] = temp[i][j];
		return tab;
	}
}
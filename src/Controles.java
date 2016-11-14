public class Controles extends Game{
	int deltaI, deltaJ, debI, finI, debJ, finJ, finK, addI, addJ;
	
	public int[][] KeyMove(int[][] tab, String s){
		
		// Variables
		
		int[][] tabmod = tab;
		int size = tab.length;
		Assign(s);
		
		tabmod = Move(s, tab);
		// On rend le tableau modifié
		
		return tabmod;
	}
	
	public int Assign(String s)
	{
		int rot=0;
		switch(s)
		{
			case "left":
				rot = 2;
			break;
			
			case "up":
				rot = 1;
			break;
			
			case "right":
				rot = 0;
			break;
			
			case "down":
				rot = 3;
			break;
		}
		return rot;
	}
	
	public int[][] Move(String s, int[][] tab)
	{
		int i, j, k;
		int rot = Assign(s); 
		tab = rotate(tab, rot); 
		
		for(k=0; k<3; k++)
			for(i=0; i<3; i++)
				for(j=0; j<3; j++)
					if(tab[i+1][j]==0){
						tab[i+1][j]=tab[i][j];
						tab[i][j]=0;
					}
		for(k=0; k<3; k++)
			for(i=0; i<3; i++)
				for(j=0; j<3; j++)
					if(tab[i+1][j]==tab[i][j]){
						tab[i+1][j]=2*tab[i+1][j];
						tab[i][j]=0;
					}
		tab=rotate(tab, 4-rot);
		return tab;
	}
	//to make things simple
	public int[][] rotate(int[][] tab, int n)
	{
		int[][] temp = new int[4][4];
		temp = tab; 
		int i, j, k;
		
		for(k=0; k < n; k++)
			for(i=0; i<3; i++)
				for(j=0; j<3; j++)
					tab[3-j][i] = temp[i][j];
		return tab;
	}
}
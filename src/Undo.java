public class Undo extends Game{

	public void addUndo(int[][] tab)
	{
		int i,j,tour = 0;
		int[][] retour = new int[4][4];
		
		for(i = 0; i<4; i++)
			for(j = 0; j<4; j++)
			{
				undo.add(tab[i][j]);
			}
		touractuel = touractuel+1;
		for(i = 0; i<4; i++)
			for(j = 0; j<4; j++)	
			{
				retour[i][j] = undo.get(tour*(touractuel-1));
				tour = tour+1;
			}
		
	}
	
	public int[][] actionUndo(int[][] tab)
	{
		int i,j;
		int[][] retour = tab;
		if(touractuel>0)
		{
			for(i = 3; i>=0; i--)
				for(j = 3; j>=0; j--)
				{
					retour[i][j] = undo.get(undo.size()-1);
					undo.remove(undo.size()-1);
				}
			touractuel = touractuel-1;
		}
		return retour;
	}
}
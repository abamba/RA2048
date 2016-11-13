public class Redo extends Game{

	public void addRedo(int[][] tab)
	{
		int i,j;
		
		for(i = 0; i<4; i++)
			for(j = 0; j<4; j++)
			{
				redo.add(tab[i][j]);
			}
		
		touractuel = touractuel+1;
		
		System.out.println(redo);
		System.out.println(touractuel);
	}
	
	public int[][] actionRedo(int[][] tab)
	{
		int i,j,tour = 0;
		int[][] retour = tab;
		
		for(i = 0; i<4; i++)
			for(j = 0; j<4; j++)
			{
				retour[i][j] = redo.get(16*tour*(touractuel-1));
				redo.remove(16*tour*(touractuel-1));
				tour = tour+1;
			}
		return retour;
	}
}
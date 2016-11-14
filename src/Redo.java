public class Redo extends Game{

	public void addRedo(int[][] tab)
	{
		int i,j;
		
		scoreredo.add(score);
		scoreredo.add(hiscore);
		for(i = 0; i<4; i++)
			for(j = 0; j<4; j++)
			{
				redo.add(tab[i][j]);
			}
	}
	
	public int[][] actionRedo(int[][] tab)
	{
		int i,j;
		int[][] retour = tab;
			if(redo.size()>0)
			{
				hiscore = scoreredo.get(scoreredo.size()-1);
				scoreredo.remove(scoreredo.size()-1);
				score = scoreredo.get(scoreredo.size()-1);
				scoreredo.remove(scoreredo.size()-1);
				for(i = 3; i>=0; i--)
					for(j = 3; j>=0; j--)
					{
						retour[i][j] = redo.get(redo.size()-1);
						redo.remove(redo.size()-1);
					}
			}
		return retour;
	}
	
	public void clearRedo()
	{
		redo.clear();
	}
}
import java.util.Scanner;

public class Bananas {

	public static void main(String[] args)
	{
		int size = 3;
		int numBananas = 0;
		Scanner k = new Scanner(System.in);
		char[][] board = new char[size][size];
		
		for (int i = 0; i < size ; i++)
		{
			String line = k.nextLine();
			for (int j = 0; j < size; j++)
			{
				board[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < size ; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (board[i][j] == 'B')
				{
					Node bLocation = new Node(new int[] {i, j});
					int[][] aLocations1 = findChar(board, i, j, 'A');
					for (int[] aCoords1: aLocations1)
					{
						Node aLocation1 = new Node(aCoords1);
						bLocation.addChild(aLocation1);
						int[][] nLocations1 = findChar(board, aCoords1[0], aCoords1[1], 'N');
						for (int[] nCoords1: nLocations1)
						{
							Node nLocation1 = new Node(nCoords1);
							aLocation1.addChild(nLocation1);
							int[][] aLocations2 = findChar(board, nCoords1[0], nCoords1[1], 'A');
							for (int[] aCoords2: aLocations2)
							{
								Node aLocation2 = new Node(aCoords2);
								if (!nLocation1.hasAncestor(aLocation2))
								{
									nLocation1.addChild(aLocation2);
									int[][] nLocations2 = findChar(board, aCoords2[0], aCoords2[1], 'N');
									for (int[] nCoords2: nLocations2)
									{
										Node nLocation2 = new Node(nCoords2);
										if (!aLocation2.hasAncestor(nLocation2))
										{
											aLocation2.addChild(nLocation2);
											int[][] aLocations3 = findChar(board, nCoords2[0], nCoords2[1], 'A');
											for (int[] aCoords3: aLocations3)
											{
												Node aLocation3 = new Node(aCoords3);
												if (!nLocation2.hasAncestor(aLocation3))
												{
													nLocation2.addChild(aLocation3);
													numBananas++;
													//System.out.println(aLocation3.printBloodline());
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(numBananas);
	}
	
	public static int[][] findChar(char[][] board, int row, int col, char lookFor)
	{
		int[][] spaces = new int[countChar(board, row, col, lookFor)][2];
		int count = 0;
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				try
				{
					if (board[row + i][col + j] == lookFor && !(i == 0 && j == 0))
					{
						 spaces[count][0] = row + i;
						 spaces[count][1] = col + j;
						 count++;
					}
				}
				catch (Exception e)
				{
					
				}
			}
		}
		return spaces;
	}
	
	public static int countChar(char[][] board, int row, int col, char lookFor)
	{
		int count = 0;
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				try
				{
					if (board[row + i][col + j] == lookFor && !(i == 0 && j == 0))
					{
						count++;
					}
				}
				catch (Exception e)
				{
					
				}
			}
		}
		return count;
	}

}

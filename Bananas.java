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
					Node<int[]> bLocation = new Node<int[]>(new int[] {i, j});
					int[][] aLocations1 = findChar(board, i, j, 'A');
					for (int[] aCoords1: aLocations1)
					{
						Node<int[]> aLocation = new Node<int[]>(aCoords1);
						bLocation.addChild(aLocation);
						int[][] nLocations1 = findChar(board, aCoords1[0], aCoords1[1], 'N');
						for (int[] nCoords1: nLocations1)
						{
							
						}
					}
					
					System.out.println(bLocation);
				}
			}
		}
		
		
		/*for (int i = 0; i < size ; i++)
		{
			for (int j = 0; j < size; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}*/
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

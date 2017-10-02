import java.util.ArrayList;

public class Sequence {
	int[] sequence;
	int[][] matrix;
	ArrayList<Integer> allowed;
	int groupOrder;
	
	ZeroSumMatrix zero; 
	
	
	
	public static void main(String[] args)
	{
		int[] seq = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
		Sequence seqr = new Sequence(seq, 9);
		seqr.printMatrix(seqr.getMatrix());
		System.out.println(seqr.getAllowed());
		
	}

	public Sequence(int[] seq, int groupOrder)
	{
		this.groupOrder = groupOrder;
		zero= new ZeroSumMatrix(groupOrder);
		this.sequence = seq;
		this.matrix = calculateMatrix();
		this.allowed = calculateAllowed();
		
	}
	
	public int[] getSequence() {
		return sequence;
	}
	
	public void printSequence() {

		String returnValue = " [ ";
		for(int i = 0; i < sequence.length; i++)
		{
			returnValue += sequence[i] + ",";
			
		}
		
		returnValue += " ]";
		System.out.println(returnValue);
	}
	
	
	public int[][] getMatrix() {
		return matrix;
	}


	public ArrayList<Integer> getAllowed() {
		return allowed;
	}

	public int getGroupOrder() {
		return groupOrder;
	}

	public Sequence(Sequence oldSeq, int num, int groupOrder)
	{
		this.groupOrder= groupOrder;
		zero = new ZeroSumMatrix(groupOrder);
		this.sequence = updateSequence(oldSeq.sequence, num);
		this.matrix = updateMatrix(oldSeq.matrix, num);
		this.allowed = calculateAllowed();
	}
	
	public int[][] calculateMatrix()
	{
		int[][] returnValue = new int[2*groupOrder][2*groupOrder];
		
		for(int i = 0; i < sequence.length; i++)
		{
			returnValue = updateMatrix(returnValue, sequence[i]);
		}
		
		return returnValue;
				
	}
	
	public int[][] updateMatrix(int[][] old, int num)
	{
		int[][] returnValue = new int[2*groupOrder][2*groupOrder];
		for(int i = 0; i < 2*groupOrder; i++)
		{
			for(int j = 0; j< 2*groupOrder; j++)
			{
				returnValue[i][j] = old[i][j];
			}
			
		}
		for(int i = 0; i < 2*groupOrder; i++)
		{
			for(int j = 0; j< 2*groupOrder -1; j++)
			{
				
				if(old[i][j] == 1)
				{
					returnValue[zero.add(i, num)][j+1] = 1;
				}
				
				if(j == 0 && old[num][j] != 1)
				{
					returnValue[num][j] = 1;
					
				}
			}
		}
		return returnValue;
		
	}
	
	public int[] updateSequence(int[] old, int num)
	{
		int[] returnValue = new int[old.length + 1];
		for(int i = 0; i < old.length; i++)
		{
			returnValue[i] = old[i];
			
		}
		
		returnValue[old.length] = num;
		
		return returnValue;
	}
	
	public ArrayList<Integer> calculateAllowed()
	{
		ArrayList<Integer> returnValue = new ArrayList<>();
		
		for(int i = 0; i < 2*groupOrder;i++)
		{
			if(matrix[i][2*groupOrder-2] != 1)
			{
				returnValue.add(zero.getInverse2(i));
			}
		}
		
		return returnValue;
	}
	
	public void printMatrix(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			String printValue = "[";
			for(int j = 0; j < matrix[i].length; j++)
			{
				printValue = printValue + matrix[i][j] + ",";
			}
			printValue += "]";
			System.out.println(printValue);
		}
	}
	
	public ArrayList<Sequence> makeMoreSeq()
	{
		ArrayList<Sequence> branch = new ArrayList<>();
		for(Integer i: allowed)
		{
			
			branch.add(new Sequence(this, i, groupOrder));
		}
		
		return branch;
	}
	
	
}

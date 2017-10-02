import java.util.ArrayList;

public class Calculate {

	public static void main(String[] args)
	{
		int groupOrder = 5;
		
		int seq_length = 0;
		
		
		
		
		int[] array1 = new int[4 * groupOrder];
		
		
		
		for(int i =0; i < 100000; i++)
		{
			int k = (int) (Math.random() * Math.pow(2*groupOrder, 2*groupOrder - 1));
			ArrayList<Sequence> arrayOfSequences = new ArrayList<>();
			Sequence seq = new Sequence(calculateBaseRepresentation(k, groupOrder), groupOrder);
			arrayOfSequences.add(seq);
			
			seq_length = 2 * groupOrder - 1;
			while(arrayOfSequences.size() > 0)
			{
				array1[seq_length] += arrayOfSequences.size();
				
				if(seq_length >= 4*groupOrder-2)
				{
					for(Sequence se: arrayOfSequences)
					{
						se.printSequence();
					}
				}
				
				ArrayList<Sequence> newArrayOfSequences = new ArrayList<>();
				for(Sequence sequence: arrayOfSequences)
				{
					for(Sequence sequ: sequence.makeMoreSeq())
					{
						newArrayOfSequences.add(sequ);
					}
					
				}
				
				arrayOfSequences = newArrayOfSequences;
				seq_length++;
			}
			
		}
		
		for(int j = 2* groupOrder - 1; j < array1.length; j++)
		{
			System.out.println("Number of Sequences of length " + j + ": " + array1[j]);
		}
		
		
		
		
	}
	
	public static int[] calculateBaseRepresentation(int n, int groupOrder)
	{
		int[] returnValue = new int[2*groupOrder - 1];
		int s = n;
		for(int i = 0; i < 2*groupOrder - 1; i++)
		{
			int remainder = s % (2 * groupOrder);
			returnValue[returnValue.length - 1 - i] = remainder;
			s = (s - remainder) / (2 * groupOrder);
		}
		return returnValue;
	}
}

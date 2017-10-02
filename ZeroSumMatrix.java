

public class ZeroSumMatrix {
	int groupOrder;
	int[][] groupTable;
	
	public static void main(String[] args)
	{
		System.out.println((-2)%3);
		ZeroSumMatrix zero = new ZeroSumMatrix(3);
		zero.print();
		System.out.println(zero.add(2, 3));
		System.out.println(zero.getInverse2(5));
	}
	public ZeroSumMatrix(int order)
	{
		this.groupOrder = order;
		groupTable = new int[2*groupOrder][2*groupOrder];
		for(int i = 0; i < 2*groupOrder; i++)
		{
			for(int j = 0; j < 2*groupOrder; j++)
			{
				if(i < groupOrder && j < groupOrder)
				{
					groupTable[i][j] = (i + j) % (groupOrder);
				}
				else if(i < groupOrder && j >= groupOrder)
				{
					groupTable[i][j] = (i + j) % groupOrder + groupOrder;
				}
				
				else if(i >= groupOrder && j < groupOrder)
				{
					groupTable[i][j] = ((i - j) % groupOrder) + groupOrder;
				}
				
				else
				{
					groupTable[i][j] = (((i - j) % (groupOrder)) + groupOrder) % groupOrder;
				}
			}
			
			
		}
		
		
	}
	
	public void print()
	{
		
		for(int i = 0; i < 2*groupOrder; i++)
		{
			String printValue = "[";
			for(int j = 0; j < 2*groupOrder; j++)
			{
				printValue = printValue + groupTable[i][j] + ",";
			}
			printValue += "]";
			System.out.println(printValue);
		}
	}
		
	public int add(int num1, int num2)
	{
		return groupTable[num1][num2];
	}
	
	public int getInverse1(int num1)
	{
		int returnValue = 0;
		for(int i = 0; i < 2*groupOrder; i++)
		{
			if(groupTable[num1][i] == 0)
			{
				returnValue = i;
				break;
			}
		}
		
		return returnValue;
	}
	
	public int getInverse2(int num1)
	{
		int returnValue = 0;
		if(num1 >= groupOrder)
		{
			returnValue = num1;
		}
		else
		{
			returnValue =(groupOrder - num1) % groupOrder;
		}
		
		return returnValue;
	}
	
	}
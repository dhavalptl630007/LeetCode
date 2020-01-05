package Arrangement;

//https://youtu.be/TnZHaH9i6-0
public class StringPermutations {

	public static void main(String[] args) {	
		String str = "ABC";	
		calculate(str,0,str.length()-1);			
	}

	private static void calculate(String str, int left, int right) {

		if(left ==  right) {
			System.out.println(str);
		}
		
		else
		{
			
			for (int i = left; i <=right; i++) {
				
				String swapped = swap(str,left,i);
				calculate(swapped,left+1,right);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		// TODO Auto-generated method stub
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
		return String.valueOf(arr);

	}

}

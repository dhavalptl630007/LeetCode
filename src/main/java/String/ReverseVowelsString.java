package String;

// https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/
// for better code visibility : maintain a list and put the all vowels in that
//further do lookup from the list. However, this will increase the space complexity
public class ReverseVowelsString {

	public static void main(String[] args) {
		
		String str = "leetcode";
		
		System.out.println(reverseVowels(str));

	}

	private static String reverseVowels(String s) {
		
		if(s == null || s.length() == 0 ) {
			return "";
		}
		
		char [] arr = s.toCharArray();
		
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
			
			if( arr[left] == 'a'|| 
				arr[left] == 'i'||
				arr[left] == 'o'||
				arr[left] == 'u'|| 
				arr[left] == 'e'||
				arr[left] == 'A'|| 
				arr[left] == 'I'||
				arr[left] == 'O'||
				arr[left] == 'U'|| 
				arr[left] == 'E')  {
					
				if (arr[right] == 'a'|| 
					arr[right] == 'i'||
					arr[right] == 'o'||
					arr[right] == 'u'|| 
					arr[right] == 'e'||
					arr[right] == 'A'|| 
					arr[right] == 'I'||
					arr[right] == 'O'||
					arr[right] == 'U'|| 
					arr[right] == 'E') 
               {
				
            	   char temp = arr[left];
            	   arr[left++] = arr[right];
            	   arr[right--] = temp;
            	   continue;
               }
				else
				{
					right--;
					continue;
				}
			}
			
			if (arr[right] == 'a'|| 
				arr[right] == 'i'||
				arr[right] == 'o'||
				arr[right] == 'u'|| 
				arr[right] == 'e'||
				arr[right] == 'A'|| 
				arr[right] == 'I'||
				arr[right] == 'O'||
				arr[right] == 'U'|| 
				arr[right] == 'E') 
               {
				
				left++;
			   continue;
			}
			
			left++;
			right--;
			
		}
		
		
		return new String(arr);
	}

}

import java.util.Stack;

//Time Complexity: O(n); where n is length of input string.
//Space Complexity: O(n)
public class RemoveAllAdjacentDuplicatesInString_II {
	/**Approach: Stack**/	
	public String removeDuplicates(String s, int k) {
        Stack<Character> st= new Stack<>();
        Stack<Integer> countSt = new Stack<>();                
        for(char c: s.toCharArray()){                       
            if(st.isEmpty() || c != st.peek()){
                st.push(c);
                countSt.push(1);
            }else{
                int count = countSt.pop();
                count++;                
                if(count == k) st.pop();
                else countSt.push(count);           
            }         
        }        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){ 
            char c = st.pop();
            int freq = countSt.pop();
            for(int i=0; i<freq; i++){
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
		
	/** Driver code to test above **/
	public static void main (String[] args) {			
		RemoveAllAdjacentDuplicatesInString_II ob  = new RemoveAllAdjacentDuplicatesInString_II();
		String s = "deeedbbcccbdaa";//"abcd";
		int k = 3;//2;
								
		System.out.println("String '"+s+"' after removing "+k+" duplicates is: "+ob.removeDuplicates(s, k)); 
	}	
}

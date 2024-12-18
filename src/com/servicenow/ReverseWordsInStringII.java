package com.servicenow;

public class ReverseWordsInStringII {
	
	   public void reverseWords(char[] s) {

	        inplaceReverse(0, s.length - 1, s);

	        for ( int i = 0, j = 0; j <= s.length; ) {
	            char c = j < s.length ? s[j] : ' ';
	            if (c == ' ') {
	                inplaceReverse(i, j - 1, s);
	 
	                j++;
	                i = j;
	            } else {
	            	j++;
	            }
	        }
	         
	    }
	   
		

	    protected void inplaceReverse(int from, int to, char[] s) {
	    

	        int m = ( from + to + 1) / 2;

	        for ( int i = from; i < m; ++i) {
	            inplaceSwap(s, i, from + to - i);
	        }

	    }

	    protected void inplaceSwap(char[] s, int start, int end) {
	        char t = s[start];
	        s[start] = s[end];
	        s[end] = t;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	char[] s =  { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
	    	
	    	
	    	ReverseWordsInStringII instance = new ReverseWordsInStringII();
	    	
	    	instance.reverseWords(s);
	    	
	    
	    }
	    

}

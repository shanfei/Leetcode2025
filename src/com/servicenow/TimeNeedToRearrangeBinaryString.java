package com.servicenow;

/*you are given a binary string s. In one second, all occurrences of "01" are simultaneously replaced with "10". This process repeats until no occurrences of "01" exist.

Return the number of seconds needed to complete this process.

 

Example 1:

Input: s = "0110101"
Output: 4
Explanation: 
After one second, s becomes "1011010".
After another second, s becomes "1101100".
After the third second, s becomes "1110100".
After the fourth second, s becomes "1111000".
No occurrence of "01" exists any longer, and the process needed 4 seconds to complete,
so we return 4.
Example 2:

Input: s = "11100"
Output: 0
Explanation:
No occurrence of "01" exists in s, and the processes needed 0 seconds to complete,
so we return 0.



*/

public class TimeNeedToRearrangeBinaryString {
	
	  public static int secondsToRemoveOccurrences(String s) {
		  
		  int countOfLeadingZero = 0;
		  int seconds = 0;
		  
		  for ( int j = 0; j < s.length(); j++  ) {
			  
			  int i = s.charAt(j) - '0';
			  
			  // when reverse 0001 -> reverse 3 times so count from 0 - 1 => countOfLeadingZero, 111 -> countOfLeadingZero = 0 ,1001 -> countOfLeadingZero 0 + 2 => 2
			  countOfLeadingZero += 1 - i;
			  
			  // seconds is for the times of changes of countOfLeadingZero, when hit 1 and there are already count of zeros happens such as 0001 -> seconds += 3
			  // but for 001,1 -> for the 1st 1, seconds += 2, but for the second 1 => seconds++
			  if ( i == 1 && countOfLeadingZero > 0 ) {
				  seconds = Math.max(seconds + 1, countOfLeadingZero);
			  }
			 
		  }
		  
		  return seconds;
	        
	  }
	  
	  
	  public static void main(String[] args) {
		  System.out.println(secondsToRemoveOccurrences("0110101"));
		  System.out.println(secondsToRemoveOccurrences("11100"));
	  }

}

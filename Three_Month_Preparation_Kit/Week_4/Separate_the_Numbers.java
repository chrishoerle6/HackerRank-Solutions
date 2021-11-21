// Author: Chris Hoerle
// Date: 11/20/2021

/*
	A numeric string, s, is beautiful if it can be split into a sequence 
	of two or more positive integers, a[1], a[2], ..., a[n], satisfying 
	the following conditions:
	1. a[i] - a[i - 1] for any 1 < i <= n (i.e., each element in the sequence
	   is 1 more than the previous element).
	2. No a[i] contains a leading zero. For example, we can split s = 10203 
	   into the sequence {1, 02, 03}, but it is not beautiful because 02 and
	   03 have leading zeroes.
	3. The contents of the sequence cannot be rearranged. For example, we can 
	   split s = 312 into the sequence {3, 1, 2}, but it is not beautiful 
	   because it breaks our first constraint (i.e., 1 - 3 != 1).
	
	The diagram below depicts some beautiful strings:
	"1234" = "1" + "2" + "3" + "4"
	"91011" = "9" + "10" + "11"
	"99100" = "99" + "100"

	Perform q queries where each query consists of some integer string s. For 
	each query, print whether or not the string is beautiful on a new line. If 
	it is beautiful, print YES x, where x is the first number of the increasing 
	sequence. If there are multiple such values of x, choose the smallest. 
	Otherwise, print NO.

	Function Description:
	Complete the separateNumbers function in the editor below.

	separateNumbers has the following parameter:
	s: an integer value represented as a string
	
	Prints:
	string: Print a string as described above. Return nothing.

	Input Format:
	The first line contains an integer q, the number of strings to evaluate.
	Each of the next q lines contains an integer string s to query.

	Constraints:
	1 <= q <= 10
	1 <= |s| <= 32
	s[i] E [0 - 9]
*/

public static void separateNumbers(String s) {
    String firstNum = "";
    boolean isValid = false;
    
    for (int i = 1; i <= s.length() / 2; i++) {
        firstNum = s.substring(0, i);
        long num = Long.parseLong(firstNum);
        String validString = firstNum;
  
        while (validString.length() < s.length()) {
            validString += Long.toString(++num);
        }
        if (s.equals(validString)) {
            isValid = true;
            break;
        }
    }
    if (isValid) {
        System.out.println("YES " + firstNum);
    }
    else {
        System.out.println("NO");
    }
}
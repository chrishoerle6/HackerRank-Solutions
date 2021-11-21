// Author: Chris Hoerle
// Date: 11/20/2021

/*
	Sherlock considers a string to be valid if all characters of the string appear 
	the same number of times. It is also valid if he can remove just 1 character at  
	1 index in the string, and the remaining characters will occur the same number 
	of times. Given a string s, determine if it is valid. If so, return YES, otherwise 
	return NO.

	Example:
	s = abc
	This is a valid string because frequencies are {a : 1, b : 1, c : 1}.

	s = abcc
	This is a valid string because we can remove one c and have 1 of each character 
	in the remaining string.

	s = abccc
	This string is not valid as we can only remove 1 occurrence of c. That leaves 
	character frequencies of {a : 1, b : 1, c : 2}.

	Function Description:
	Complete the isValid function in the editor below.

	isValid has the following parameter(s):
	string s: a string
	
	Returns:
	string: either YES or NO
	
	Input Format:
	A single string s.

	Constraints:
	1 <= |s| <= 10^5
	Each character s[i] E ascii[a-z]
	
	Sample Input:
	aabbcd
	
	Sample Output:
	NO

	Explanation:
	2 is the minimum number of removals required to make it a valid string. It can 
	be done in following two ways:
	- Remove c and d to get aabb.
	- Or remove a and b to get abcd.
*/

public static String isValid(String s) {
    if (s.length() == 1) {
        return "YES";
    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        if (!map.containsKey(s.charAt(i))) {
            map.put(s.charAt(i), 1);
        }
        else {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
    }
    
    int[] arr = new int[map.size()];
    int index = 0;
    for (int value : map.values()) {
        arr[index] = value;
        index++;
    }
    
    Arrays.sort(arr);
    
    int first = arr[0];
    int second = arr[1];
    int last = arr[arr.length - 1];
    int secondLast = arr[arr.length - 2];
    
    // arr = 2 2 2 2 2
    if (first == last) {
        return "YES";
    }
    // arr = 1 2 2 2 2 
    if (first == 1 && second == last) {
        return "YES";
    }
    // arr = 2 2 2 2 3 
    if (first == second && second == secondLast && secondLast == (last - 1)) {
        return "YES";
    }
    
    return "NO";
}
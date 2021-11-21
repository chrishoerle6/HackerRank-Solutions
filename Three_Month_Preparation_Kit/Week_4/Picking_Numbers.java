// Author: Chris Hoerle
// Date: 11/20/2021

/*
	Given an array of integers, find the longest subarray where the absolute 
	difference between any two elements is less than or equal to 1.

	Example:
	a = [1, 1, 2, 2, 4, 4, 5, 5, 5]
	There are two subarrays meeting the criterion: [1, 1, 2, 2] and [4, 4, 5, 5, 5]. 
	The maximum length subarray has 5 elements.

	Function Description:
	Complete the pickingNumbers function in the editor below.

	pickingNumbers has the following parameter(s):
	int a[n]: an array of integers
	
	Returns:
	int: the length of the longest subarray that meets the criterion
	
	Input Format:
	The first line contains a single integer n, the size of the array .
	The second line contains n space-separated integers, each an a[i].

	Constraints:
	2 <= n <= 100
	0 < a[i] < 100

	The answer will be >= 2.
*/

public static int pickingNumbers(List<Integer> a) {
    Collections.sort(a);
    int result = Integer.MIN_VALUE;
    int[] countArray = new int[101];
    
    for (int i = 0; i < a.size(); i++) {
        countArray[a.get(i)]++;
    }
    
    for (int i = 1; i <= 100; i++) {
        result = Math.max(result, countArray[i] + countArray[i - 1]);
    }
    
    return result;
}

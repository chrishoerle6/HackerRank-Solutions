// Author: Chris Hoerle
// Date: 11/20/2021

/*
	Sansa has an array. She wants to find the value obtained by XOR-ing 
	the contiguous subarrays, followed by XOR-ing the values thus obtained.
	Determine this value.

	Example:
	arr = [3, 4, 5]
	Subarray	Operation		Result
	3		    None			3
	4		    None			4
	5		    None			5
	3,4		    3 XOR 4			7
	4,5		    4 XOR 5			1
	3,4,5		3 XOR 4 XOR 5	2

	Now we take the resultant values and XOR them together:
	3 xor 4 xor 5 xor 7 xor 1 xor 2 = 6. Return 6.

	Function Description:
	Complete the sansaXor function in the editor below.

	sansaXor has the following parameter(s):
	int arr[n]: an array of integers
	
	Returns:
	int: the result of calculations
	
	Input Format:
	The first line contains an integer t, the number of the test cases.
	Each of the next t pairs of lines is as follows:
	- The first line of each test case contains an integer n, the number 
	  of elements in arr.
	- The second line of each test case contains n space-separated integers
	  arr[i].

	Constraints:
	1 <= t <= 5
	2 <= n <= 10^5
	1 <= arr[i] <= 10^8

	Sample Input:
	2
	3
	1 2 3
	4
	4 5 7 5

	Sample Output:
	2
	0

	Explanation:
	Test case #00:
	1 xor 2 xor 3 xor (1 xor 2) xor (2 xor 3) xor (1 xor 2 xor 3) = 2

	Test case #01:
	4 xor 5 xor 7 xor 5 xor (4 xor 5) xor (5 xor 7) xor (7 xor 5) xor 
	(4 xor 5 xor 7) xor (5 xor 7 xor 5) xor (4 xor 5 xor 7) = 0
*/

// XOR Logic:
// x ^ x (an even number of times) always equals zero
// x ^ x ^ x (an odd number of times) always equals x (itself)
// Therefore, even length arrays always equal zero and odd length 
// arrays equal the odd numbered indices XOR'd eachother, because in
// this scenario the even numbered indices will occur an even number 
// of times, thus equaling zero, and the odd numbered indicies will
// occur an odd number if times, thus equaling themselves when XOR'd 
public static int sansaXor(List<Integer> arr) {
    if (arr.size() % 2 == 0) {
        return 0;
    }
    
    int result = 0;
    for (int i = 0; i < arr.size(); i += 2) {
        result ^= arr.get(i);
    }

    return result;
}
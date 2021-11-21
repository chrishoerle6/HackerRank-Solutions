// Author: Chris Hoerle
// Date: 11/20/2021

/*
	Given an integer n, find each x such that:
	- 0 <= x <= n
	- n + x = n xor x
	where xor denotes the bitwise XOR operator. Return the number of x's 
	satisfying the criteria.

	Example:
	n = 4 
	There are four values that meet the criteria:
	4 + 0 = 4 xor 0 = 4
	4 + 1 = 4 xor 1 = 5
	4 + 2 = 4 xor 2 = 6
	4 + 3 = 4 xor 3 = 7
	Return 4.

	Function Description:
	Complete the sumXor function in the editor below.

	sumXor has the following parameter(s):
	int n: an integer

	Returns:
	int: the number of values found

	Input Format:
	A single integer, n.

	Constraints:
	0 <= n <= 10^15

	Subtaks:
	0 <= n <= 100 for 60% of the maximum score

	Output Format:
	Sample Input 0:
	5

	Sample Output 0:
	2

	Explanation 0:
	For n = 5, the x values 0 and 2 satisfy the conditions:
	- 5 + 0 = 5, 5 xor 0 = 5
	- 5 + 2 = 7, 5 xor 2 = 7

	Sample Input 1:
	10

	Sample Output 1:
	4

	Explanation 1:
	For n = 10, the x values 0, 1, 4, and 5 satisfy the conditions:
	- 10 + 0 = 10, 10 xor 0 = 10
	- 10 + 1 = 11, 10 xor 1 = 11
	- 10 + 4 = 14, 10 xor 4 = 14
	- 10 + 5 = 15, 10 xor 5 = 15
*/

// Trick: Count the number of 0s after converting
// n to a binary number
public static long sumXor(long n) {
    long count = 0;
    
    while (n != 0) {
        if (n % 2 == 0) {
            count++;
        }
        n /= 2;
    }
    count = (long) Math.pow(2, count);
    return count;
}
// Author: Chris Hoerle
// Date: 11/20/2021

/*
	Julius Caesar protected his confidential information by encrypting it 
	using a cipher. Caesar's cipher shifts each letter by a number of letters. 
	If the shift takes you past the end of the alphabet, just rotate back to 
	the front of the alphabet. In the case of a rotation by 3, w, x, y and z 
	would map to z, a, b and c.

	Original alphabet: abcdefghijklmnopqrstuvwxyz
	Alphabet rotated +3: defghijklmnopqrstuvwxyzabc
	
	Example:
	s = There's-a-starman-waiting-in-the-sky
	k = 3
	The alphabet is rotated by 3, matching the mapping above. The encrypted 
	string is Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb.

	Note: The cipher only encrypts letters; symbols, such as -, remain 
	unencrypted.

	Function Description:
	Complete the caesarCipher function in the editor below.

	caesarCipher has the following parameter(s):
	string s: cleartext
	int k: the alphabet rotation factor
	
	Returns:
	string: the encrypted string
	
	Input Format:
	The first line contains the integer, n, the length of the unencrypted string.
	The second line contains the unencrypted string, s.
	The third line contains k, the number of letters to rotate the alphabet by.

	Constraints:
	1 <= n <= 100
	0 <= k <= 100
	s is a valid ASCII string without any spaces.

	Sample Input:
	11
	middle-Outz
	2
	
	Sample Output:
	okffng-Qwvb
	Explanation

	Original alphabet: abcdefghijklmnopqrstuvwxyz
	Alphabet rotated +2: cdefghijklmnopqrstuvwxyzab
	m -> o
	i -> k
	d -> f
	d -> f
	l -> n
	e -> g
	-    -
	O -> Q
	u -> w
	t -> v
	z -> b
*/

public static String caesarCipher(String s, int k) {
    String result = "";
    k = k % 26;
    int A = (int) 'A';
    int Z = (int) 'Z';
    int a = (int) 'a';
    int z = (int) 'z';
    
    for (char letter : s.toCharArray())
    {
        if (letter >= A && letter <= Z)
        {
            char encrypted = (char)(letter + k);
            if (encrypted > Z)
            {
                encrypted = (char)((encrypted % Z) + (A - 1));
            }
            result += encrypted;
        }
        else if (letter >= a && letter <= z)
        {
            char encrypted = (char)(letter + k);
            if (encrypted > z)
            {
                encrypted = (char)((encrypted % z) + (a - 1));
            }
            result += encrypted;
        }
        else
        {
            result += letter;
        }
    }

    return result;
}
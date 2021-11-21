// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Camel Case is a naming style common in many programming languages. 
	In Java, method and variable names typically start with a lowercase 
	letter, with all subsequent words starting with a capital letter 
	(example: startThread). Names of classes follow the same pattern, 
	except that they start with a capital letter (example: BlueCar).

	Your task is to write a program that creates or splits Camel Case 
	variable, method, and class names.

	Input Format:
	Each line of the input file will begin with an operation (S or C) 
	followed by a semi-colon followed by M, C, or V followed by a semi-colon 
	followed by the words you'll need to operate on. 
	The operation will either be S (split) or C (combine) 
	M indicates method, C indicates class, and V indicates variable
	In the case of a split operation, the words will be a camel case method, 
	class or variable name that you need to split into a space-delimited list 
	of words starting with a lowercase letter.
	In the case of a combine operation, the words will be a space-delimited 
	list of words starting with lowercase letters that you need to combine 
	into the appropriate camel case String. Methods should end with an empty 
	set of parentheses to differentiate them from variable names.
	
	Output Format:
	For each input line, your program should print either the space-delimited 
	list of words (in the case of a split operation) or the appropriate camel 
	case string (in the case of a combine operation).
	
	Sample Input:
	S;M;plasticCup()
	C;V;mobile phone
	C;C;coffee machine
	S;C;LargeSoftwareBook
	C;M;white sheet of paper
	S;V;pictureFrame

	Sample Output:
	plastic cup
	mobilePhone
	CoffeeMachine
	large software book
	whiteSheetOfPaper()
	picture frame

	Explanation:
	Use Scanner to read in all information as if it were coming from the 
	keyboard. Print all information to the console using standard output 
	(System.out.print() or System.out.println()). Outputs must be exact 
	(exact spaces and casing).
*/

public class Solution {
    
	public static String camelCase(String str) {
    	String operation = str.substring(0, 1);
        String type = str.substring(2, 3);
        String word = str.substring(4, str.length());
        StringBuilder output = new StringBuilder();
        int size = word.length();
        
        if (operation.equals("S")) {
        	if (type.equals("M")) {
                for (int i = 0; i < size; i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        output.append(" ");
                        output.append(Character.toLowerCase(word.charAt(i)));
                        continue;
                    }
                    if (word.charAt(i) == '(' || word.charAt(i) == ')') {
                        continue;
                    }
                    output.append(word.charAt(i));
                }
            }
            if (type.equals("C")) {
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        output.append(Character.toLowerCase(word.charAt(0)));
                        continue;
                    }
                    if (Character.isUpperCase(word.charAt(i))) {
                        output.append(" ");
                        output.append(Character.toLowerCase(word.charAt(i)));
                        continue;
                    }
                    output.append(word.charAt(i));
                }
            }
            if (type.equals("V")) {
                for (int i = 0; i < size; i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        output.append(" ");
                        output.append(Character.toLowerCase(word.charAt(i)));
                        continue;
                    }
                    output.append(word.charAt(i));
                }    
            }
        }
        
        if (operation.equals("C")) {
            if (type.equals("M")) {
                for (int i = 0; i < size; i++) {
                    if (word.charAt(i) == ' ') {
                        output.append(Character.toUpperCase(word.charAt(i + 1)));
                        i++;
                        continue;
                    }
                    if (i == size - 1) {
                        output.append(word.charAt(size - 1));
                        output.append("(");
                        output.append(")");
                        break;
                    }
                    output.append(word.charAt(i));
                }
            }
            if (type.equals("C")) {
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        output.append(Character.toUpperCase(word.charAt(0)));
                        continue;
                    }
                    if (word.charAt(i) == ' ') {
                        output.append(Character.toUpperCase(word.charAt(i + 1)));
                        i++;
                        continue;
                    }
                    output.append(word.charAt(i));
                }
            }
            if (type.equals("V")) {
                for (int i = 0; i < size; i++) {
                    if (word.charAt(i) == ' ') {
                        output.append(Character.toUpperCase(word.charAt(i + 1)));
                        i++;
                        continue;
                    }  
                    output.append(word.charAt(i));
                }
            } 
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(camelCase(str));
        }
        scanner.close();
    }
}
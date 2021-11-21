// Author: Chris Hoerle
// Date: 11/19/2021

/*
	Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
	Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
	- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

	Examples:
	s = '12:01:00PM'
	Return '12:01:00'.

	s = '12:01:00AM'
	Return '00:01:00'.

	Function Description:
	Complete the timeConversion function in the editor below. It should return 
	a new string representing the input time in 24 hour format.

	timeConversion has the following parameter(s):
	string s: a time in 12 hour format
	
	Returns:
	string: the time in 24 hour format
	
	Input Format:
	A single string s that represents a time in 12-hour clock format 
	(i.e.: hh:mm:ssAM or hh:mm:ssPM).

	Constraints:
	All input times are valid
	
	Sample Input:
	07:05:45PM

	Sample Output:
	19:05:45
*/

public static String timeConversion(String s) {
    String period = s.substring(8, 10);
    String ss = s.substring(6, 8);
    String mm = s.substring(3, 5);
    String hh = s.substring(0, 2);
    int hour = Integer.parseInt(hh);
        
    if (period.equals("AM")) {
        if (hour == 12) {
            hour = 0;    
        }    
    }
    else {
        if (hour != 12) {
            hour += 12;
        }
    }
        
    hh = String.format("%02d", hour);
    String result = hh + ":" + mm + ":" + ss;
    return result;
}
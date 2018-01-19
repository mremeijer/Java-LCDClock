import java.time.LocalTime;
import java.time.format.*;

public class Clock3 {
	static LocalTime localTime = LocalTime.now(); //Sets time to local time
	static String timeNow = localTime.format(DateTimeFormatter.ofPattern("hh:mm")); //Sets time into wanted format
	static String[] number = new String[5]; //Creates string for format numbers
	static String[][] horDisp = new String[5][3]; //Creates string for horizontal lines
	static String[][] verDisp = new String[10][2]; //Creates string for vertical lines
	static int s; //Creates the integer to change the size of the numbers in the output
	public static void main(String[] args) {
		if (args.length == 0) { //Checks if any arguments are given
			s = 5; //If no arguments are given, size will be 2
		} else {
			s = Integer.valueOf(args[1]); //Converts the second arg of -s option into an int
			s = checkSize(s); 
		}
		createForm();
		createHor();
		createVer();
		printHor(0); //Prints first horizontal line
		printVer(0); //Prints first vertical line
		printHor(1); //Prints second horizontal line
		printVer(1); //Prints second vertical line
		printHor(2); //Prints third horizontal line
	}
	private static int checkSize(int s) { //Checks if the given size is valid
		if (s < 1) {
			return 1;
		} else if (s > 5) {
			return 5;
		} else {
			return s;
		}			
	}
	/* Position of numbers in createForm:
			0
		1		2
			3
		4		5
			6
		Meaning of numbers in position:
		0 = no line
		1 = horizontal line
		2 = vertical line
	*/
	private static void createForm() {
		for (int i = 0; i < timeNow.length(); i++) {
			switch(timeNow.substring(i,i+1)) {
				case ":": number[i] = ("0100100");
					break;
				case "1": number[i] = ("0020020");
					break;
				case "2": number[i] = ("1021201");
					break;
				case "3": number[i] = ("1021021");
					break;
				case "4": number[i] = ("0221020");
					break;
				case "5": number[i] = ("1201021");
					break;
				case "6": number[i] = ("1201221");
					break;
				case "7": number[i] = ("1020020");
					break;
				case "8": number[i] = ("1221221");
					break;
				case "9": number[i] = ("1221021");
					break;
				case "0": number[i] = ("1220221");
					break;
			}
		}
	}
	private static void createHor() { //Fills in the string for horizontal lines
		for (int i = 0; i < number.length; i++) {	
			switch(number[i].substring(0,1)) {
				case "0": horDisp[i][0] = (" ");
					break;
				case "1": horDisp[i][0] = ("-");
					break;
			} switch(number[i].substring(3,4)) {
				case "0": horDisp[i][1] = (" ");
					break;
				case "1": horDisp[i][1] = ("-");
					break;
			} switch(number[i].substring(6,7)) {
				case "0": horDisp[i][2] = (" ");
					break;
				case "1": horDisp[i][2] = ("-");
					break;
			}
		}
	}
	private static void createVer() { //Fills in the string for vertical lines
		int pos = 0;
		for (int i = 0; i < number.length; i++) {	
			switch(number[i].substring(1,2)) {
				case "0": verDisp[pos][0] = (" ");
					break;
				case "1": verDisp[pos][0] = ("-");
					break;
				case "2": verDisp[pos][0] = ("|");
					break;
			} switch(number[i].substring(2,3)) {
				case "0": verDisp[pos+1][0] = (" ");
					break;
				case "1": verDisp[pos+1][0] = ("-");
					break;
				case "2": verDisp[pos+1][0] = ("|");
					break;
			} switch(number[i].substring(4,5)) {
				case "0": verDisp[pos][1] = (" ");
					break;
				case "1": verDisp[pos][1] = ("-");
					break;
				case "2": verDisp[pos][1] = ("|");
					break;
			} switch(number[i].substring(5,6)) {
				case "0": verDisp[pos+1][1] = (" ");
					break;
				case "1": verDisp[pos+1][1] = ("-");
					break;
				case "2": verDisp[pos+1][1] = ("|");
					break;
			} pos += 2;
		}
	}
	private static void printHor(int rowNum) {
		for (int i = 0; i < horDisp.length; i++) { //Prints horizontal line
			System.out.print(" ");
			for (int nLines = 0; nLines < s; nLines++) { //Prints as many lines as s
				System.out.print(horDisp[i][rowNum]);
			}
			if (i != 2) { //No white spaces needed after : in time
				System.out.print("  ");
			} 
		} System.out.print("\n");
	}
	private static void printVer(int rowNum) {
		for (int i = 0; i < s; i++) { //Prints vertical line as often as s
			for (int j = 0; j < verDisp.length; j++) {
				if (j == 4) { //Prints horizontal - of : as ofen as s 
					for (int nLines = 0; nLines < s; nLines++) {
						System.out.print(verDisp[j][rowNum]);
					}
				} else {
					System.out.print(verDisp[j][rowNum]);
				}
				if ( j % 2 == 0 && j!= 4) { //Prints as many white spaces as s between lines of one number
					for (int nLines = 0; nLines < s; nLines++) {
						System.out.print(" ");
					}
				} else if (j % 2 != 0 && j != 5){ //Only one white space needed between lines of different number
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}
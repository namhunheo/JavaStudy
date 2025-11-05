package coding;

import java.util.Scanner;

public class ex5622 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int time = 0;
        
        for (char al : s.toCharArray()){
            switch (al) {
                case 'A': case 'B': case 'C':
                    time += 3;
                    break;
                case 'D': case 'E': case 'F':
                    time += 4;
                    break;
                case 'G': case 'H': case 'I':
                    time += 5;
                    break;
                case 'J': case 'K': case 'L':
                    time += 6;
                    break;
                case 'M': case 'N': case 'O':
                    time += 7;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    time += 8;
                    break;
                case 'T': case 'U': case 'V':
                    time += 9;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    time += 10;
                    break;
                default:
                    time += 11;
            }
        }
        System.out.println(time); 
	}
}

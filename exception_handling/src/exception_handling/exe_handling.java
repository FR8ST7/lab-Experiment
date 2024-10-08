package exception_handling;
import java.util.Scanner;
	public class exe_handling extends Exception {
	    public exe_handling(String message) {
	        super(message);
	    }
	}

	 class VowelArray {
	    public static void checkVowel(char ch) throws exe_handling {
	        if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
	              ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')) {
	            throw new exe_handling("character is consonant");
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the number of characters you want to input: ");
	        int size = scanner.nextInt();
	        char[] vowels = new char[size];
	        
	        try {
	            for (int i = 0; i < size; i++) {
	                System.out.println("Enter a vowel character: ");
	                char inputChar = scanner.next().charAt(0);

	                checkVowel(inputChar);
	                vowels[i] = inputChar;
	            }
	            
	            System.out.println("Vowel array: ");
	            for (char vowel : vowels) {
	                System.out.print(vowel + " ");
	            }
	        } catch (exe_handling e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	        } finally {
	            System.out.println("\nProgram execution completed.");
	        }
	    }
	}



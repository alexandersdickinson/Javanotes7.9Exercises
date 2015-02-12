/**
Main routine of this program is used merely to test recursive functions for factorials and fibonacci sequences.
For the fibonacci sequence, the Nth number in the sequence will be returned. Factorial is N! N is taken from the user by main().
Values returned by these function calls are printed in main().
*/

import java.math.BigInteger;

public class Recursion{
	
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	
	public static void main(String[] args){
		
		String n;
		
		do{
			
			System.out.println("This program prints the results of n! and the nth member of a fibonacci sequence.");
			System.out.print("n = ");
			n = TextIO.getln();
			
			try{
				System.out.println(factorial(new BigInteger(n)));
			}
			catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
			
			try{
				System.out.println(fibonacci(new BigInteger(n)));
			}
			catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
			
		}while(!n.equals(""));
		
	}
	
	/**
		This function finds n! using recursion.
		precondition: A BigInteger that is less than zero.
		postcondition: A BigInteger equal to n!.
		
		@param n n!
		@throws NumberFormatException Prevents the user from inputting numbers that are less than zero.
		@return If n is 1 or 0, returns n. Else, the function returns n multiplied by itself - 1. This is the recursive part.
	*/
	static BigInteger factorial(BigInteger n){
				
		if(n.signum() == -1){
			throw new NumberFormatException("Integer is less than zero.");
		}
		
		if(n.equals(ZERO) || n.equals(ONE)){
			return n;//base case
		}
		else{
			return n.multiply(factorial(n.subtract(ONE)));
		}
		
	}
	
	/**
		This function finds the nth member of the fibonacci sequence using recursion.
		precondition: N must be greater than one.
		postcondition: The nth member of the fibonacci sequence.
		
		@param n The nth member of the fibonacci sequence.
		@throws NumberFormatException Prevents the user from inputting numbers that are less than one.
		@return If n is 1, returns n. Else, the function returns n added to itself - 1. This is the recursive part.
	*/
	static BigInteger fibonacci(BigInteger n){
		
		if(n.signum() == -1){
			throw new NumberFormatException("This is before the first number in the sequence.");
		}
	
		if(n.equals(ONE) || n.equals(ZERO)){
			return ONE;
		}
		else{
			return fibonacci(n.subtract(ONE)).add(fibonacci(n.subtract(new BigInteger("2"))));
		}
		
	}
	
}
/*
 * Game of Craps
 * Machine Learning Assignment 
 * Developed by Sajid R.S.
 * Displayed output at every wager for debugging, commented out for displaying the final output
 */

import java.util.Random;
import java.util.Scanner;

public class GameofCraps {

	public static void main(String[] args) {
		int s;
		
		Scanner in = new Scanner(System.in);
			
		System.out.println("Available wagering strategies:\n1. Even Wager: "
				+ "On every roll, you wager $100, irrespective of previous win or loss.\n"
				+ "2. Martingale System: "
				+ "if you win, in the next bet you wager $100. If you lose, you double previous wager.\n"
				+ "3. Reverse Martingale System: "
				+ "You double your wager in case of win and keep constant in case of loss.\n"
				+ "4. Run 5 Rounds each of all strategies\n"
				+ "Enter the strategy you wish to choose: ");
		
		s= in.nextInt();
		in.close();
		
		if(s==1){
			System.out.println("You've selected Even Wager");
			System.out.println("Strategy\t# of Games\tEnding Balance");
			even_wager();
		}
		else if (s==2){
			System.out.println("You've selected Martingale System strategy");
			System.out.println("Strategy\t# of Games\tEnding Balance");
			martingale();
		}
		else if (s==3){
			System.out.println("You've selected Reverse Martingale System strategy");
			System.out.println("Strategy\t# of Games\tEnding Balance");
			reverse_martingale();
		}
		else {
			for(int i=1;i<6;i++)
			{
				System.out.println("Round "+i);
				System.out.println("Strategy\t# of Games\tEnding Balance");
				even_wager();
				martingale();
				reverse_martingale();
				System.out.println("------------------------------------------------");
			}
		}
	}

	private static int roll_dice(){
		Random rolldice = new Random();
		int min = 2;
    	int max = 12;
    	int randomNum = rolldice.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
	private static void even_wager(){
		int balance=1000;
		int bet=100;
		int i=1;
		
		//System.out.println("The initial wager balance is :"+balance);
		
		while (balance!=0){
		int n= roll_dice();
		//System.out.println("Round Number "+i);
		//System.out.println("Rolled number:"+n);
		if(n==7||n==11)
		{
			//System.out.println("You Win!");
			balance=balance+bet;
			//System.out.println("Your balance is :"+balance);
		}
		else if (n==2||n==3||n==12)
		{
			//System.out.println("You Lose!");
			balance=balance-bet;
			//System.out.println("Your balance is :"+balance);
		}
		else
		{
			int first_roll=n;
			while (n!=7)
			{
				//System.out.println("Rolled number:"+n);
				n=roll_dice();
				if (n==first_roll)
				{
					//System.out.println("You Win!");
					balance=balance+bet;
					//System.out.println("Your balance is :"+balance);
				}
			}//System.out.println("You Lose!");
			balance=balance-bet;
			//System.out.println("Your balance is :"+balance);
			
		}
		i++;
		if(i==11){break;}}
		System.out.println("Even Wager\t"+--i+"\t\t"+balance);
	}
	
	private static void martingale(){
		int balance=1000;
		int bet=100;
		int i=1;
		//System.out.println("The initial wager balance is :"+balance);
		
		while (balance!=0){
		int n= roll_dice();
		//System.out.println("Rolled number:"+n);
		if(n==7||n==11)
		{
			//System.out.println("You Win!");
			balance=balance+bet;
			bet=100;
			//System.out.println("Your balance is :"+balance);
		}
		else if (n==2||n==3||n==12)
		{
			//System.out.println("You Lose!");
			//System.out.println("Your balance is :"+balance);
			balance=balance-bet;
			if (balance<bet*2){bet=balance;}
			else {bet=bet*2;}
		}
		else
		{
			int first_roll=n;
			while (n!=7)
			{
				//System.out.println("Rolled number:"+n);
				n=roll_dice();
				if (n==first_roll)
				{
					//System.out.println("You Win!");
					balance=balance+bet;
					bet=100;
					//System.out.println("Your balance is :"+balance);
				}
			}//System.out.println("You Lose!");
			balance=balance-bet;
			if (balance<bet*2){bet=balance;}
			else {bet=bet*2;}
			//System.out.println("Your balance is :"+balance);
			
		}
		i++;
		if(i==11){break;}}
		System.out.println("Martingale\t"+--i+"\t\t"+balance);
	}	
	private static void reverse_martingale(){
		int balance=1000;
		int bet=100;
		int i=1;
		
		//System.out.println("The initial wager balance is :"+balance);
		
		while (balance!=0){
		int n= roll_dice();
		//System.out.println("Rolled number:"+n);
		if(n==7||n==11)
		{
			//System.out.println("You Win!");
			balance=balance+(bet);
			if (balance<bet*2){bet=balance;}
			else {bet=bet*2;}
			//System.out.println("Your balance is :"+balance);
		}
		else if (n==2||n==3||n==12)
		{
			//System.out.println("You Lose!");
			balance=balance-bet;
			bet=100;
			//System.out.println("Your balance is :"+balance);
		}
		else
		{
			int first_roll=n;
			while (n!=7)
			{
				//System.out.println("Rolled number:"+n);
				n=roll_dice();
				if (n==first_roll)
				{
					//System.out.println("You Win!");
					balance=balance+bet;
					bet=bet*2;
					//System.out.println("Your balance is :"+balance);
				}
			}//System.out.println("You Lose!");
			balance=balance-bet;
			bet=100;
			//System.out.println("Your balance is :"+balance);
			
		}
		i++;
		if(i==11){break;}}
		System.out.println("Rev Martingale\t"+--i+"\t\t"+balance);
	}
	}



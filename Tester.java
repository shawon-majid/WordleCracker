import java.io.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);

		ListCreator lc = new ListCreator();

		System.out.println(lc.getList().size());

		ArrayList <Integer> yellowIndex = new ArrayList <Integer>();
		ArrayList <Integer> greenIndex = new ArrayList <Integer>();
		ArrayList <Integer> colorless = new ArrayList <Integer>();
		yellowIndex.add(1);
		colorless.add(2);
		colorless.add(3);
		colorless.add(4);
		colorless.add(5);

		lc.updateList(yellowIndex, greenIndex, colorless, "rocky");

		System.out.println(lc.getList().size());

		System.out.println(lc.getList().get(0));		

		yellowIndex = new ArrayList <Integer>();
		greenIndex = new ArrayList <Integer>();
		colorless = new ArrayList <Integer>();
		yellowIndex.add(3);
		yellowIndex.add(5);
		colorless.add(1);
		colorless.add(2);
		colorless.add(4);
		lc.updateList(yellowIndex, greenIndex, colorless, "their");	
		System.out.println(lc.getList().get(0));	

		
		yellowIndex = new ArrayList <Integer>();
		greenIndex = new ArrayList <Integer>();
		colorless = new ArrayList <Integer>();
		yellowIndex.add(2);
		yellowIndex.add(3);
		colorless.add(1);
		colorless.add(4);
		greenIndex.add(5);
		lc.updateList(yellowIndex, greenIndex, colorless, "large");	
		System.out.println(lc.getList().get(0));

		yellowIndex = new ArrayList <Integer>();
		greenIndex = new ArrayList <Integer>();
		colorless = new ArrayList <Integer>();	
		colorless.add(1);
		colorless.add(4);
		greenIndex.add(2);
		greenIndex.add(3);
		greenIndex.add(5);
		lc.updateList(yellowIndex, greenIndex, colorless, "brave");	
		System.out.println(lc.getList().get(0));

	}
}
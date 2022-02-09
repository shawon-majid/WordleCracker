import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);

		// welcome
		//define welcome()

		// suggest first Word

		Play p = new Play();
		ListCreator lc = new ListCreator();
		ArrayList <String> eligibleList = lc.getList();


		for(int i = 0; i < 6; i++){

			String suggestedWord = p.suggestedWord(eligibleList);

			if(suggestedWord.equals("No words found")){
				break;
			}

			System.out.println("Suggested Word: " + suggestedWord); // suggests word from eligible list

			System.out.println("How Many yellows you got?");
			int yellows = in.nextInt();
			if(yellows >= 1) System.out.print("Enter the indices: ");
			ArrayList <Integer> yellowIndex = p.getIndices(yellows);
			System.out.println("How Many greens you got?");
			int greens = in.nextInt();

			if(greens == 5){
				System.out.println("Congratulations you've got the word!");
				break;
			}

			else if(greens >= 1) System.out.print("Enter the indices: ");

			ArrayList <Integer> greenIndex = p.getIndices(greens);

			ArrayList <Integer> colorless = p.getIndices(yellowIndex, greenIndex);


			lc.updateList(yellowIndex, greenIndex, colorless, suggestedWord);
			
			eligibleList = lc.getList();

		}


	}
}
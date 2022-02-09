import java.io.*;
import java.util.*;

public class Play {

	public String suggestedWord(ArrayList <String> eligibleList){
		if(eligibleList.size() >= 1) return eligibleList.get(0);
		return "No words found";
	}


	public ArrayList <Integer> getIndices(int total){
		Scanner in = new Scanner(System.in);
		ArrayList <Integer> indices = new ArrayList <Integer>();
		for(int i = 0; i < total; i++){
			int x = in.nextInt();
			indices.add(x);
		}

		return indices;
	}

	public ArrayList <Integer> getIndices(ArrayList <Integer> yellowIndex, ArrayList <Integer> greenIndex){
		ArrayList <Integer> indices = new ArrayList <Integer>();
		for(int ind = 1; ind <= 5; ind++){
			if( (!yellowIndex.contains(ind)) && (!greenIndex.contains(ind)) ){
				indices.add(ind);
			}
		}

		return indices;
	}

}	
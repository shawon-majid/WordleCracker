import java.io.*;
import java.util.*;

public class ListCreator {
	private ArrayList <String> eligibleList;
	private ArrayList <Integer> yellowIndex;
	private ArrayList <Integer> greenIndex;
	private ArrayList <Integer> colorless;
	private String prevWord;

	public ListCreator() throws Exception{
		eligibleList = new ArrayList <String>();

		FileInputStream fstream = new FileInputStream("fiveLetterWords.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String currentWord;

		while((currentWord = br.readLine()) != null){
			eligibleList.add(currentWord);
		}

	}

	public ArrayList <String> getList(){
		return eligibleList;
	}


	public void updateList(ArrayList <Integer> yellowIndex, ArrayList <Integer> greenIndex, ArrayList <Integer> colorless ,  String prevWord){

		this.yellowIndex = yellowIndex;
		this.greenIndex = greenIndex;
		this.colorless = colorless;
		this.prevWord = prevWord;

		// checking out colorless letter
		removeAllColorlessLetters();

		// checking out yellow letters
		configureYellowLetters();


		//checkout the green letters
		keepAllGreenLetters();

	}

	

	private void removeAllColorlessLetters(){
		for(int currentIndex: colorless){ // get each colorless letters
			String currentLetter = Character.toString(prevWord.charAt(currentIndex - 1)); //current colorless letter			
			ommitWordsThatHaveCurrentLetter(currentLetter);
		}
	}

	private void configureYellowLetters(){
		for(int currentIndex: yellowIndex){
			String currentLetter = Character.toString(prevWord.charAt(currentIndex - 1));			
			ommitWordsThatNotContainsCurrentLetter(currentLetter, currentIndex);
		}
	}


	private void keepAllGreenLetters(){
		for(int currentIndex: greenIndex){
			String currentLetter = Character.toString(prevWord.charAt(currentIndex - 1));
			ommitWordsThatMisplacedGreenLetters(currentLetter, currentIndex);
		}
	}


	private void ommitWordsThatHaveCurrentLetter(String currentLetter){
		Iterator <String> itr = eligibleList.iterator();
		while(itr.hasNext()){ 
			String words = itr.next(); // get each words of eligible list
			if(words.contains(currentLetter)){ // the word has the colorless letter
				// check if the letter is on yellow or greenlist
				boolean onYellowOrGreen = isTheLetterOnYellowOrGreen(currentLetter);				
				if(!onYellowOrGreen){ // if its not on yellow or green then remove it
					itr.remove();	
				} 
				//else keep the word
			}
		}
	}

	private boolean isTheLetterOnYellowOrGreen(String currentLetter){
		for(int index: yellowIndex){
			String yellowLetter = Character.toString(prevWord.charAt(index - 1));
			if(yellowLetter.equals(currentLetter)){
				return true;
			}
		}

		for(int index: greenIndex){
			String greenLetter = Character.toString(prevWord.charAt(index - 1));
			if(greenLetter.equals(currentLetter)){
				return true;
			}
		}	
		return false;
	}

	private void ommitWordsThatNotContainsCurrentLetter (String currentLetter, int currentIndex){
		Iterator<String> itr = eligibleList.iterator();
		while(itr.hasNext()){
			String words = itr.next(); // get each word of the eligible list
			int indexOfCurrentLetter = words.indexOf(currentLetter); // check if the letter is in this word
			if( indexOfCurrentLetter == -1 ){ // if the word doesn't contain yellow letter 
				//remove the word from eligible list
				itr.remove();
			}
			else{ // if the word contains yellow letter
				// check if the letter is in the same possition or in the green position
				if(((indexOfCurrentLetter+1) == currentIndex) || (greenIndex.contains(indexOfCurrentLetter+1)) ){
					// if its in the same position or green position then remove it
					itr.remove();
				}
			}
		}
	}

	private void ommitWordsThatMisplacedGreenLetters(String currentLetter, int currentIndex){
		Iterator<String> itr = eligibleList.iterator();
		while(itr.hasNext()){
			String words = itr.next();
			if(words.charAt(currentIndex-1) != currentLetter.charAt(0)){ // the letter is not in the correct position
				// remove from the list
				itr.remove();
			}
		}
	}

}
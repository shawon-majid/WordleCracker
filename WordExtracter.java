import java.io.*;
import java.util.*;

public class WordExtracter {
	public void extractWords() throws Exception {
		FileInputStream fstream = new FileInputStream("wiki-100k.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		FileWriter fout = new FileWriter("fiveLetterWords.txt");
		BufferedWriter bw = new BufferedWriter(fout);

		String s;

		while((s = br.readLine()) != null){
			String currentWord = s;
			
			if(currentWord.length() == 5){
				boolean ok = true;
				for(int i = 0; i < 5; i++){
					char currentChar = currentWord.charAt(i);
					if( ((currentChar >= 'A') && (currentChar <= 'Z')) || ((currentChar >= 'a') && (currentChar <= 'z')) ){
						// do nothing
					}	
					else{
						ok = false;
					}
				}

				if(ok == true){
					currentWord = currentWord.toLowerCase();
					bw.write(currentWord, 0, 5);
					bw.newLine();
				}
				
			}
		}	

		bw.close();
		br.close();

		System.out.println("done");
	}
}
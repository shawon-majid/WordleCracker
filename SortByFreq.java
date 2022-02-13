import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SortByFreq {

	//public static HashMap <St


	

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("letterfreq.txt");
		BufferedReader br = new BufferedReader(fr);

		FileWriter fw = new FileWriter("sortedFiveLetter.txt");
		BufferedWriter bw = new BufferedWriter(fw);


		HashMap <Character, Double> weight = new HashMap <Character, Double>();
		String currentLine;

		while((currentLine = br.readLine()) != null ){
			weight.put( Character.toLowerCase(currentLine.charAt(0)) , Double.parseDouble(currentLine.substring(2)) );
		}

		fr = new FileReader("fiveLetterWords.txt");
		br = new BufferedReader(fr);
		

		HashMap <String, Double> wordWeight = new HashMap <String, Double>();

		String currentWord;

		while( (currentWord = br.readLine()) != null ){
			Double totalWeight = 0.00;

			int uniqueCount = countUniqurLetter(currentWord);

			for(int i = 0; i <  currentWord.length(); i++){
				if(Character.isLetter(currentWord.charAt(i))) totalWeight += weight.get(currentWord.charAt(i));
			}

			totalWeight = totalWeight*uniqueCount;

			wordWeight.put(currentWord, totalWeight);

		}

		System.out.println("Done");

		// now sort the word weight

		wordWeight = sortHashMap(wordWeight);

		for(String word: wordWeight.keySet()){
			bw.write(word+"\n");
		}

		br.close();
		bw.close();



	}





	public static int countUniqurLetter(String str){

		HashSet <Character> charset = new HashSet<Character>();

		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			charset.add(c);
		}

		return charset.size();
	}


	public static HashMap <String, Double> sortHashMap(HashMap <String, Double> hm){
		List<Entry<String, Double>> list = new LinkedList< Entry < String, Double> > (hm.entrySet());		

		Collections.sort(list, new Comparator<Entry<String, Double> > ()
		{
			public int compare(Entry <String, Double> o1, Entry <String, Double> o2){
				return o2.getValue().compareTo(o1.getValue());
			}
		}
		);

		HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Entry<String, Double> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;

	}
}
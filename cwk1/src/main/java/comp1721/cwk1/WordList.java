package comp1721.cwk1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class WordList {
	private List<String> words;
  // TODO: Implement constructor with a String parameter
	public WordList(String filename) {
		try {
			FileReader fileReader =new FileReader(filename);
	        BufferedReader bufferedReader =new BufferedReader(fileReader);
	        List<String> words =new ArrayList<String>();
	        String str=null;
	        while((str=bufferedReader.readLine())!=null) {
	        	if(str.trim().length()!=0) {
	        		words.add(str);
	        	}
	        }
		}
		catch(Exception ex) {
		}
		
	}
  // TODO: Implement size() method, returning an int
	public int size() {
		List<String> words = new ArrayList<String>();
		int size_words = words.size();
		return size_words;
	}
  // TODO: Implement getWord() with an int parameter, returning a String
	public String getWord(int n) {
		String word= words.get(n);
		return word;
	}
}

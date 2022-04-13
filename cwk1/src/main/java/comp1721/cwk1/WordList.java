package comp1721.cwk1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WordList {
	private List<String> words = new ArrayList<String>();;
  // TODO: Implement constructor with a String parameter
	public WordList(String filename) throws IOException {
		FileReader fileReader =new FileReader(filename);
        BufferedReader Reader =new BufferedReader(fileReader);
        String str=null;
        while((str=Reader.readLine())!=null) {
        	if(str.trim().length()>2) {
        		words.add(str);
        	}
        }
        Reader.close();
	}
  // TODO: Implement size() method, returning an int
	public int size() {
		int size_words = words.size();
		return size_words;
	}
  // TODO: Implement getWord() with an int parameter, returning a String
	public String getWord(int n) {
		size();
		if(n>size()) {
			throw new GameException("Invalid game.");
		}
		String word= words.get(n);
		return word;
	}
}

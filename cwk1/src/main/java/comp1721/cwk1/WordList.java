package comp1721.cwk1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class WordList {
	private List<String> words = new ArrayList<String>();;
  // TODO: Implement constructor with a String parameter
	public WordList(String filename) {
		File file = new File(filename);
        InputStreamReader read = null;
        BufferedReader reader = null;
		try {
			read = new InputStreamReader(new FileInputStream(file),"utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
		}catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
 
        }
	}
  // TODO: Implement size() method, returning an int
	public int size() {
		int size_words = words.size();
		return size_words;
	}
  // TODO: Implement getWord() with an int parameter, returning a String
	public String getWord(int n) {
		String word= words.get(n);
		return word;
	}
}

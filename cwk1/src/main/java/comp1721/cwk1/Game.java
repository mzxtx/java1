package comp1721.cwk1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Game {
	private int gameNumber;	
	private String target;	//right answers
	private String out = " ";
  // TODO: Implement constructor with String parameter
	public Game(String filename) throws IOException {
		LocalDate start = LocalDate.of(2021,6,19);//��ʼʱ��
		LocalDate end = LocalDate.now();//today time
		Long ch = end.toEpochDay() - start.toEpochDay();//Number of days difference
		int i = ch.intValue();
	    gameNumber = i;
	    WordList wordlist = new WordList(filename);
	    target = wordlist.getWord(gameNumber);
	}
  // TODO: Implement constructor with int and String parameters
	public Game(int num,String filename) throws IOException {
		gameNumber = num;
		WordList wordlist = new WordList(filename);
	    target = wordlist.getWord(gameNumber);
	}
  // TODO: Implement play() method
	public void play() {
		Guess guess = new Guess(1,"targe");
		System.out.printf("WORDLE %d\n",gameNumber);
		int guessNumber = guess.getGuessNumber();
		StringBuilder st = new StringBuilder();
		while(guessNumber<=6) {
			  System.out.printf("\nEnter guess (%d/6):",guessNumber);
			  String chosenWord = guess.getChosenWord();
			  guess.compareWith(target);
			  System.out.println(guess.compareWith(target));
			  st.append(guess.compareWith(target)+"\n");
			  boolean matches = guess.matches(target);
			  if(matches == true && guessNumber ==1) {
				  System.out.println("Superb - Got it in one!");
				  break;
			  }
			  if(matches == true && guessNumber >=2 && guessNumber<=5) {
				  System.out.println("Well done!");
				  break;}
			  if(matches == true && guessNumber == 6) {
				  System.out.println("That was a close call!");
				  break;}
			  if(matches == false && guessNumber == 6) {
				  System.out.println("Nope  -  Better  luck  next  time! on one line.");
				  System.out.println(target);
			  }
			  guessNumber = guessNumber+1;}
		out = st.toString();
	}
  // TODO: Implement save() method, with a String parameter
	public void save(String filename) throws IOException {
		String[] arr1=filename.split("/");
		String file = arr1[0];
		File fil = new File(file);
		File f = new File(filename);
		if(!fil.exists()) {
			 fil.mkdirs();
		 }
		if(!fil.exists()){
			f.createNewFile();
		}else {
			 try {
				 FileWriter fw = new FileWriter (f);
				 fw.write("");
				 fw.flush();
				 fw.close();
				 Files.writeString(Paths.get(filename), out);
			 }catch (IOException e) {
			     e.printStackTrace();
			 }
		 }
		

    }
	}

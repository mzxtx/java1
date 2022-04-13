package comp1721.cwk1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Game {
	private int gameNumber;	
	private String target;	//right answers
	private String out = " ";
  // TODO: Implement constructor with String parameter
	public Game(String filename) {
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat today= new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(today.format(calendar.getTime()));
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        Date star = dft.parse("2022-04-12");// Start date
	        Date endDay=dft.parse(today.format(calendar.getTime()));//today date
	        Date nextDay=star;
	        int i=0;
	        while(nextDay.before(endDay)){	//Terminates the loop if tomorrow is not before the end time
	        	Calendar cld = Calendar.getInstance();
	 	        cld.setTime(star);
	 	        cld.add(Calendar.DATE, 1);
	 	        star = cld.getTime();
	 	        //Gets the date string for the next day
	 	        nextDay = star; 
	 	        i++;
	        }
	        gameNumber = i;
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    WordList wordlist = new WordList(filename);
	    target = wordlist.getWord(gameNumber);
	}
  // TODO: Implement constructor with int and String parameters
	public Game(int num,String filename) {
		gameNumber = num;
		WordList wordlist = new WordList(filename);
	    target = wordlist.getWord(gameNumber);
	}
  // TODO: Implement play() method
	public void play() {
		Guess guess = new Guess(target.length(),target);
		System.out.printf("WORDLE %d\n",gameNumber);
		int guessNumber = guess.getGuessNumber();
		StringBuilder st = new StringBuilder();
		for(guessNumber = 1;guessNumber<=6;guessNumber++) {
			  System.out.printf("\nEnter guess (%d/6):",guessNumber);
			  String chosenWord = guess.getChosenWord();
			  guess.compareWith(target);
			  System.out.println(guess.compareWith(target));
			  st.append(guess.compareWith(target));
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
				  System.out.println(" Better luck next time!");
			  }}
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

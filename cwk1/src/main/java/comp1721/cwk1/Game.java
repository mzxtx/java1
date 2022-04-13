package comp1721.cwk1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Game {
	private int gameNumber;	
	private String target;	//right answers
  // TODO: Implement constructor with String parameter
	public Game(String filename) {
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat today= new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(today.format(calendar.getTime()));
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        Date star = dft.parse("2022-01-01");// Start date
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
	        gameNumber = i+1;
		    WordList wordlist = new WordList(filename);
		    target = wordlist.getWord(gameNumber);
	       //System.out.println("相差天数为："+i);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    play();
	}
  // TODO: Implement constructor with int and String parameters
	public Game(int num,String filename) {
		gameNumber = num;
		WordList wordlist = new WordList(filename);
	    target = wordlist.getWord(gameNumber);
	    play();
	}
  // TODO: Implement play() method
	public void play() {
		Guess guess = new Guess(gameNumber,target);
		System.out.printf("WORDLE %d\n",gameNumber);
		int guessNumber = guess.getGuessNumber();
		for(guessNumber = 1;guessNumber<=6;guessNumber++) {
			  System.out.printf("\nEnter guess (%d/6):",guessNumber);
			  String chosenWord = guess.getChosenWord();
			  System.out.printf(chosenWord);
			  guess.compareWith(target);
			  boolean matches = guess.matches(target);
			  if(matches == false) {
				  continue;
			  }
			  if(matches == true) {
				  System.out.println("Well done!");
				  break;
			  }
		  }
	}
  // TODO: Implement save() method, with a String parameter
	public void save(String filename) {
		
	}
}

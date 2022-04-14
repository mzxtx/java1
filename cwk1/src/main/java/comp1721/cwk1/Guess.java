package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  private int guessNumber;
  private String chosenWord;

  // TODO: Implement constructor with int parameter
  public Guess(int num) throws GameException{
	  //initialize guessNumber
	  guessNumber = num;
	  if(guessNumber<1 || guessNumber>6) {
		  throw new GameException("The guess number is invalid.");
	  }
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int num,String word) throws GameException{
	  guessNumber = num;
	  if(guessNumber<1 || guessNumber>6) {
		  throw new GameException("The guess number is invalid.");
	  }
	  chosenWord = word;
	  if(chosenWord.length() != 5) {
		  throw new GameException("Please enter a word with five letters.");
	  }
  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber() {//��ǰ�µĵڼ���
	  return guessNumber;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {//��ǰ�û��²�ĵ���
	  readFromPlayer();
	  chosenWord = chosenWord.toUpperCase();
	  return chosenWord;
  }
  // TODO: Implement readFromPlayer()
  public void readFromPlayer() {//��ȡ���û������벢��ֵ��chosenWord
	  chosenWord = INPUT.next();
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target) {
	  int i=0;
	  StringBuilder sb = new StringBuilder();
	  String s_Word= " ";
	  for(i=0;i<target.length();i++) {
		  String ch = String.valueOf("chosenWord.charAt(i)");
		  if(target.charAt(i) == chosenWord.charAt(i)) {
			  //System.out.printf("\033[30;102m %s \033[0m",chosenWord.charAt(i));
			  sb.append("\033[30;102m " +chosenWord.charAt(i)+  " \033[0m") ;
			  continue;
		  }
		  if(target.charAt(i) != chosenWord.charAt(i)) {
			  int n=0,n1=0;
			  for (n=0;n<target.length();n++) {
				  if(chosenWord.charAt(i) == target.charAt(n)) {
					  //System.out.printf("\033[30;103m %s \033[0m",chosenWord.charAt(i));
					  sb.append("\033[30;103m "+ chosenWord.charAt(i)+" \033[0m") ;
					  break;
				  }
				  if(n==target.length()-1) {
					  //System.out.printf("\033[30;107m %s \033[0m",chosenWord.charAt(i));
					  sb.append("\033[30;107m " + chosenWord.charAt(i)+  " \033[0m") ;
				  }
				  }}
		  }
	  s_Word = sb.toString();
	  return s_Word;
  }
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target) {
	  if (target.equals(chosenWord)) {
		  return true;
	  }
	  else return false;
  }
}

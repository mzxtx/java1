package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  private int guessNumber;	//�û��²�Ĵ���
  private String chosenWord;	//��ǰ�û��²�ĵ���

  // TODO: Implement constructor with int parameter
  public Guess(int num) {
	  
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int num,String word) {
	  guessNumber = 0;
  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber() {//��ǰ�µĵڼ���
	  return guessNumber;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {//��ǰ�û��²�ĵ���
	  readFromPlayer();
	  return chosenWord;
  }
  // TODO: Implement readFromPlayer()
  public void readFromPlayer() {//��ȡ���û������벢��ֵ��chosenWord
	  String w = INPUT.next();
	  chosenWord = w.toUpperCase();
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target) {
	  int i=0;
	  for(i=0;i<target.length();i++) {
		  String ch = String.valueOf("chosenWord.charAt(i)");
		  if(target.charAt(i) == chosenWord.charAt(i)) {
			  System.out.printf("\\033[30;102m %s \\033[0m",chosenWord.charAt(i));
			  continue;
		  }
		  if(target.charAt(i) != chosenWord.charAt(i)) {
			  int n=0,n1=0;
			  for (n=0;n<target.length();n++) {
				  if(chosenWord.charAt(i) == target.charAt(n)) {
					  System.out.printf("\\033[30;103m %s \\033[0m",chosenWord.charAt(i));
					  break;
				  }
				  if(n==target.length()-1) {
					  System.out.printf("\\033[30;107m %s \\033[0m",chosenWord.charAt(i));
				  }
				  }}
		  }
	  return chosenWord;
  }
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target) {
	  getChosenWord();
	  if (target.equals(chosenWord)) {
		  return true;
	  }
	  else return false;
  }
}

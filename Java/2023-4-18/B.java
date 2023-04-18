import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
     
      public static void main(String args[]){
    	  Scanner input = new Scanner(System.in);
    	  int codeNum = 0;
    	  long messageNum = 0;
    	  ArrayList<Long> codes = new ArrayList<>();
    	  ArrayList<String> messages = new ArrayList<>();
    	  ArrayList<RandomEncrypt> ciphers = new ArrayList<>();
    	  while(input.hasNextLong()) {
    		  codes.add(input.nextLong());
    		  codeNum ++;
    	  }
    	  codeNum --;
    	  messageNum = codes.get(codeNum);
    	  codes.remove(codeNum);
    	  input.nextLine();
    	  for(int i = 0;i < messageNum;i ++) 
    		  messages.add(input.nextLine());
    	  
    	  for(long key : codes)
    		  for(String message : messages)
    			  ciphers.add(new RandomEncrypt(key,message));
    		  
    	  for(RandomEncrypt obj : ciphers) {
    		  obj.outPut();
    	  }
    	  
    	  
      }
}
class RandomEncrypt{
	String openOne;
	ArrayList<Integer> codedOnes = new ArrayList<>();
	ArrayList<Integer> pseudorandomnums = new ArrayList<>();
	Random random;
	long key;
	int length;
	RandomEncrypt(long key,String openOne){
		this.key = key;
		this.openOne = openOne;
		length = openOne.length();
		this.random = new Random(key);
		for(int i = 0;i < length;i ++)
			pseudorandomnums.add(random.nextInt(32768));
		for(int i = 0;i < length;i ++)
			codedOnes.add(pseudorandomnums.get(i)^(openOne.charAt(i)));
		
		
		
	}
	void outPut() {
		int flag = 0;
		length = openOne.length();
		for(int i = 0;i < length;i++) {
			if(flag < 9&&i != length -1) {
			System.out.printf("%04X ",codedOnes.get(i));
			flag ++;
			}			
			else if(flag == 9 || i == length -1) {
				flag = 0;
				System.out.printf("%04X\n",codedOnes.get(i));
			}
		}
		System.out.println(openOne);
	}
}

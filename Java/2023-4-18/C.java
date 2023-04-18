import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
     
      public static void main(String args[]) throws ParseException  {
    	  Scanner input = new Scanner(System.in);
    	  int num = input.nextInt();
    	  long nowmillis = 0;
    	  long beginmillis = 0;
    	  long endmillis = 0;
    	  ArrayList<Message> messages = new ArrayList<>();
    	  input.nextLine();
    	  for(int i = 0;i < num;i ++) {
    		  
    		  String sender = input.nextLine();
    		  String date = input.nextLine();
    		  String content = input.nextLine();
    		  //System.out.println("1"+sender+"\n2"+date+"\n3"+content);
    		  messages.add(new Message(sender,date,content));
    	  }
    		  
          		
    	  messages.sort(new MessageComparator());
    	  
    	  DateFormat begin = new SimpleDateFormat("yyyy-MM-dd");
    	  DateFormat end = new SimpleDateFormat("yyyy-MM-dd");
    	  begin.parse(input.nextLine());
    	  end.parse(input.nextLine());

    	  beginmillis = begin.getCalendar().getTimeInMillis();
    	  endmillis = end.getCalendar().getTimeInMillis();
    	  endmillis += 86400*1000;
    	  //System.out.println(beginmillis);System.out.println(endmillis);
    	  for(Message element : messages) {
    		  nowmillis = element.milliseconds;
    		  if(nowmillis <= endmillis&&nowmillis >= beginmillis) {
    			  element.outPut();
    		  }	 
    	  }
    		  
      }
}


class Message{
	String sender;
	DateFormat date;//年年年年-月（月）-日（日） 时（时）：分分：秒秒 yyyy-MM-dd HH-mm-ss
	String rawDate;
	String content;
	Calendar dateCalendar;
	Date dateForOutput;
	long milliseconds;
	Message(String sender,String date,String content) throws ParseException{
		this.sender = sender;
		this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date.setLenient(false);
		this.date.parse(date);
		this.rawDate = date;
		this.content = content;
		milliseconds = this.date.getCalendar().getTimeInMillis();
		dateForOutput = this.date.parse(date);
	}
	void outPut() {
		System.out.println(sender+"\n"+date.format(dateForOutput)+"\n"+content);
	}
}
class MessageComparator implements Comparator<Message>{

	@Override
	public int compare(Message o1, Message o2) {
		if(o1.milliseconds > o2.milliseconds) return 1;
		else if(o1.milliseconds < o2.milliseconds) return -1;
		else return 0;
	}
	
}




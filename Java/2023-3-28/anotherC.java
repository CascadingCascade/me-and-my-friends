package homework;

import java.util.Scanner;

public class Main15 {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue queue = new Queue(input.nextInt());
		int operationCode = input.nextInt();
		while(operationCode != 0) {
			if(operationCode == 0) System.exit(0);
			if(operationCode == 1) {
				char c = input.next().charAt(0);
				if(c == 'a')
					queue.addElement(new Student(input.next(),input.next()));
				else if(c == 'b')
					queue.addElement(new Teacher(input.next(),input.next(),input.next()));
			}
			
			if(operationCode == 2) queue.delElement();
			if(operationCode == 3) queue.isExist(input.next());
			if(operationCode == 4) queue.getNum();
			operationCode = input.nextInt();
		}
	}
}

class Queue{
	int length;
	int front;
	int rear;
	private int pointer;
	People[] array;
	Queue(int length){
		this.length = length;
		
		this.array = new People[length];
		this.front = 0;//pointer
		this.rear = front + length - 1;
		this.pointer = 0;
	}
	void getNum() {//4
		int n = 0;
		for(int i = front;i <= rear;i ++)
			if(array[i] != null)
				n ++;
		System.out.println(n);
	}
	void addElement(People people) {//1
		if(pointer <= rear) {
			array[pointer] = people;
			pointer ++;
		}
		else
			System.out.println("queue is full,operation failed");
	}
	void delElement() {//2
		if(array[0] == null) {
			System.out.println("queue is empty,operation failed");
			return;
		}
		array[0].giveInfo();
		array[0] = null;
		System.arraycopy(array, 1, array, 0, length - 1);
		array[length - 1] = null;
		pointer --;
		if(pointer < 0) pointer = 0;
		return;
	}
	boolean isExist(String content) {//3
		boolean flag = false;
		for(int i = 0;i < length;i ++) {
			if(array[i] != null) {
				if(array[i].name.equals(content)) {
					flag = true;
					array[i].giveInfo();
				}
			}
		}
		if(!flag) System.out.println("no found");
		return flag;
	}
	
}
class People{
	String code;
	String name;
	String addr;
	int type;
	People(){
		
	}
	void giveInfo() {
		
	}
}
class Student extends People{
	Student(String code,String name){
		this.code = code;
		this.name = name;
		type = 0;
	}
	void giveInfo() {
		System.out.println(code+","+name);
	}
}
class Teacher extends People{
	Teacher(String code,String name,String addr){
		this.code = code;
		this.name = name;
		this.addr = addr;
		type = 1;
	}
	void giveInfo() {
		System.out.println(code+","+name+","+addr);
	}
}







import java.util.Scanner;
public class TQManager{
	static int Noofquestions=0;
	public static void main(String[] args){
		String question;
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter No Of questions:");
		Noofquestions=scan.nextInt();
		TestQuestion[] arr= new TestQuestion[Noofquestions];
		TestQuestion tq;
		//for(int i=0;i<numchoices;i++){}
					
		
		}}
abstract class TestQuestion{
	String questions;
	abstract void readQuestion();
}
class ShortAnswer extends TestQuestion{
 	int nooflines=1;
	void readquestions(){
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter shortanswer question:");
		this.questions=scan.nextLine();	
	}
	public String toString(){
		return "ShortAnswer Question:"+questions+"\nNo of lines"+nooflines;
	}
}
class LongAnswer extends TestQuestion{
	int numlines;
	void readquestions(){
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter Longanswer question:");
		this.questions=scan.nextLine();	
	}
	public String toString(){
		return "LongAnswer Question:"+questions+"\nNo of lines"+numlines;
	}
}
class MCQ extends TestQuestion{
	int numchoices;
	int[] arr= new int[numchoices];
	void readquestions(){
        		Scanner sc=new Scanner(System.in);
        		System.out.println("Enter the MCQ:");
        		questions=sc.nextLine();
        		System.out.print("Enter the Number of choices:");
       		numchoices=sc.nextInt();
       		arr = new int[numchoices];
        		System.out.println("Enter the choices:");
        		String buffer=sc.nextLine();
        		for(int i=0;i<numchoices;i++){
            			arr[i]=sc.nextInt();
        		}

	}
	public String toString(){
	String a="";
	for (int i=0;i<numchoices;i++){
		a=a+arr[i]+"\n";
	}
	return "MCQ Question:"+questions+"\nOptions"+arr;
	}
}
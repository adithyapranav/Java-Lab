import java.util.Scanner;
public class TQManager
{
	public static void main(String[] args) {
	    Scanner s_obj = new Scanner(System.in);
		System.out.print("Enter the number of questions: ");
		int numquest = s_obj.nextInt();
		TestQuestion[] q_paper = new TestQuestion[numquest];
		int i=0,opt;
		String call;
		while(i<numquest)
		{
		    System.out.print("\nEnter 1 for Short Answer, 2 for Long Answer, 3 for MCQ: ");
		    opt=s_obj.nextInt();
		    switch(opt){
		        case 1: q_paper[i]=new ShortAnswer();
		                q_paper[i].readQuestion();
		                i++;
		                break;
		        case 2: q_paper[i]=new LongAnswer();
		                q_paper[i].readQuestion();
		                i++;
		                break;
		        case 3: q_paper[i]=new MCQ();
		                q_paper[i].readQuestion();
		                i++;
		                break;
		        default: System.out.println("Invalid option, choose again");
		    }
		}
		System.out.println("\nQuestion Paper");
		for(int j=0;j<numquest;j++)
		{
		    call=q_paper[j].toString();
		}
	}
}

abstract class TestQuestion{
	String question;
    	abstract void readQuestion();
	}

class ShortAnswer extends TestQuestion{
    	int numLines = 1;

    	void readQuestion(){
        	System.out.println("Enter the Short Question:");
        	Scanner sc=new Scanner(System.in);
        	question=sc.nextLine();
    	}

   	 public String toString(){
        	return "Short Answer \n Question: "+question;
    	}
	}

class LongAnswer extends TestQuestion
{
    	int numLines;
    	void readQuestion()
    	{
		Scanner s_obj2=new Scanner(System.in);
        		System.out.print("Enter question: ");
        		question=s_obj2.nextLine();
        		System.out.print("Enter number of lines: ");
        		numLines=s_obj2.nextInt();
    	}
    	public String toString()
    	{
        		return "Long Answer Question:"+question+"\nNumberoflines:"+numLines;
    	}
	


}

class MCQ extends TestQuestion{
    	int numChoices;
    	String choices[];

    	void readQuestion(){
        		Scanner sc=new Scanner(System.in);
        		System.out.println("Enter the MCQ:");
        		question=sc.nextLine();
        		System.out.print("Enter the Number of choices:");
       		numChoices=sc.nextInt();
       		choices = new String[numChoices];
        		System.out.println("Enter the choices:");
        		String buffer=sc.nextLine();
        		for(int i=0;i<numChoices;i++){
            			choices[i]=sc.nextLine();
        		}
    	}
    	public String toString(){
        		String a="";
        		for (int i=0;i<numChoices;i++){
           			 a=a+choices[i]+"\n";
        		}
        		return "MCQ\nQuestion: "+question+"\nNumber of Choices:"+numChoices+"\n"+a;
    	}

}
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
		System.out.println("\nQuestion Paper:-");
		for(int j=0;j<numquest;j++)
		{
		    call=q_paper[j].toString();
		}
	}
}

abstract class TestQuestion
{
    	String question;
    	abstract void readQuestion();
}

class ShortAnswer extends TestQuestion
{
    	int numLines;
    	void readQuestion()
    	{
        		numLines=1;
        		Scanner s_obj1=new Scanner(System.in);
        		System.out.print("Enter question: ");
        		question=s_obj1.nextLine();
    	}
   	public String toString()
    	{
        		System.out.println("Short Answer Question - "+question);
        		System.out.println("Number of lines - "+numLines);
        		return "Success";
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
        		System.out.println("Long Answer Question - "+question);
        		System.out.println("Number of lines - "+numLines);
        		return "Success";
    	}
}

class MCQ extends TestQuestion
{
    	int numChoices;
    	String[] choices;
    	void readQuestion()
    	{
        	Scanner s_obj3=new Scanner(System.in);
        	System.out.print("Enter question: ");
        	question=s_obj3.nextLine();
        	System.out.print("Enter number of choices: ");
        	numChoices=s_obj3.nextInt();
        	s_obj3.nextLine(); //as the scanner takes only the integer from the input line but leaves \n
        	choices = new String[numChoices];
        	System.out.println("Enter the choices: ");
        	for(int i=0;i<numChoices;i++)
        	{
            		System.out.print("Choice "+(i+1)+":");
            		choices[i]=s_obj3.nextLine();
        	}
    	}
    	public String toString()
    	{
        	System.out.println("MCQ - "+question);
        	System.out.println("Number of choices - "+numChoices);
        	System.out.println("Choices - ");
        	for(int i=0;i<numChoices;i++)
        	{
            	System.out.println(choices[i]);
        	}
        	return "Success";
    	}
}


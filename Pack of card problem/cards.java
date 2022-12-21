import java.util.Scanner; class Card {
String suit; char value;
public Card(String suit,char value){ this.suit = suit;
this.value = value;
}
public String display(){
return this.suit+" "+this.value;
}
}
class Pile{
private Card arr[]; private int top; private int capacity; Pile() {
this.arr = new Card[10]; this.capacity = 10;
this.top = -1;
}

public void place(Card c){ if(isFull()){
System.out.println("Stack FULL");
}
arr[++top] = c;

}

public Card draw(){ if(isEmpty()){
System.out.println("STACK EMPTY");
}
return arr[top--];
}

public int getSize(){ return top +1;
}

public Boolean isEmpty(){ if(top==-1){
return true;
}
else{
return false;
}
}

public Boolean isFull(){ if(top==capacity-1){
return true;
}
else{
return false;
}
}

public void peek(){ System.out.println("Top of Pile: "); System.out.println(arr[top].display());
}
}

public class Main {
static Scanner sc = new Scanner(System.in); public static void main(String[] args){
Pile stack = new Pile(); while(true){
System.out.println("1)Place"); System.out.println("2)Draw"); System.out.println("3)Peek"); System.out.println("Enter your choice:");
int ch=Main.sc.nextInt();

switch(ch) {
case 1: Card c1 = new Card("Club", '3'); Card c2 = new Card("Diamond", 'A'); Card c3 = new Card("Spade",'K');

stack.place(c1); stack.place(c2);
stack.place(c3); stack.peek(); break;


case 2:
Card d = stack.draw(); System.out.println("Card Drawn:"+d.display()); break;
case 3:
System.out.println("\nAfter Drawing"); stack.peek();
break; default:System.out.println("Invalid option");
break;
}

}

}}

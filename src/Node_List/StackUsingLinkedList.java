package Node_List;
import java.util.Scanner;


class Method2{
	Node head=null;
	Node tail=null;
	
	void push(int num) {
		Node newNode=new Node();
		newNode.data=num;
		newNode.next=null;
		newNode.prev=null;
		if(head==null) {
			head=tail=newNode;
		}
		else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		displayStack();
	}
		
		void pop(){
			Node peek=tail;
			if(head==null) {
				System.out.println("Stack is Empty");
				return;
			}
			System.out.println("Poped Node is ->"+peek.data);
			if(tail==head) {
				head=tail=null;
			}
			else {
				tail.prev.next=null;
				tail=tail.prev;
			}
			displayStack();
		}
		
		void displayStack() {
			if(head==null) {
				System.out.println("Stack is Empty\n");
				return;
			}
			Node t=tail;
			System.out.println(t.data+" -> Peek");
			t=t.prev;
			Node temp=t;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.prev;
			}
		}
		
		
}
public class StackUsingLinkedList extends Method2{
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		StackUsingLinkedList stack=new StackUsingLinkedList();
		int choice=1;
		while(choice==1) {
			System.out.println("Enter Your option :\nPush :1\nPop :2\nDisplay :3\n");
			int option=sc.nextInt();
			switch(option) {
				case 1:	System.out.println("Enter the Element:\n");
						int element=sc.nextInt();
						stack.push(element);
						break;
				case 2:	stack.pop();break;
				case 3:	stack.displayStack();break;
				default:System.out.println("Enter the Valid Option\n");break;
									
			}
			System.out.println("Do you Want to Continue  Press 1 :\n");
			choice=sc.nextInt();
		}sc.close();
	}
}


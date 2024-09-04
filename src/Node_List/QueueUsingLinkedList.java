package Node_List;
import java.util.Scanner;


class Method3{
	Node head=null;
	Node tail=null;
	
	void enqueue(int num) {
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
		displayQueue();
	}
		
		void dequeue(){
			if(head==null) {
				System.out.println("Queue is Empty");
				return;
			}
			System.out.println("Delete Node is ->"+head.data);
			if(head==tail) {
				head=tail=null;
				System.out.println("Now Queue is Empty\n");
			}
			else {
				head=head.next;
				head.prev=null;
			}
			displayQueue();
		}
		
		void displayQueue() {
			if(head==null) {
				System.out.println("Queue is Empty\n");
				return;
			}
			Node temp=head;
			while(temp!=null) {
				if (temp.next == null) {
	                System.out.print(temp.data + " -> Tail");
	            } 
				else {
	                System.out.print(temp.data + " -> ");
	            }
				temp=temp.next;
			}System.out.println();
		}
				
}
public class QueueUsingLinkedList extends Method3{
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		QueueUsingLinkedList queue=new QueueUsingLinkedList();
		int choice=1;
		while(choice==1) {
			System.out.println("Enter Your option :\nInsert :1\nDelete :2\nDisplay :3\n");
			int option=sc.nextInt();
			switch(option) {
				case 1:	System.out.println("Enter the Element:\n");
						int element=sc.nextInt();
						queue.enqueue(element);
						break;
				case 2:	queue.dequeue();break;
				case 3:	queue.displayQueue();break;
				default:System.out.println("Enter the Valid Option\n");break;
									
			}
			System.out.println("Do you Want to Continue  Press 1 :\n");
			choice=sc.nextInt();
		}sc.close();
	}
}


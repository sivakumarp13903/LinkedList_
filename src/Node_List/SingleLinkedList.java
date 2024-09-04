package Node_List;
import java.util.Scanner;


class Method {
	static int count=0;
	Node head=null;
	
	void insertAtBegin(int num) {
		Node newNode=new Node();
		newNode.data=num;
		newNode.next=null;
		count++;
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.next=head;
			head=newNode;
		}displayList();
	}
	
	void insertAtPos(int pos,int num,SingleLinkedList list) {
		if(pos<0 || pos>count) {
			System.out.print("Enter the valid position\n");
			return;
		}
		if(pos==1) {
			insertAtBegin(num);
		}
		else {
		int i=1;
		Node newNode=new Node();
		newNode.data=num;
		newNode.next=null;
		Node posTemp=head;
		while(i<pos-1) {
			posTemp=posTemp.next;
			i++;
		}
		newNode.next=posTemp.next;
		posTemp.next=newNode;
		count++;
		displayList();
		}
	}
	
	void insertAtEnd(int num) {
		Node newNode=new Node();
		newNode.data=num;
		newNode.next=null;
		count++;
		if(head==null) {
			head=newNode;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}displayList();
	}
	
	void deleteAtBegin() {
		if(count==0) {
			System.out.print("List is Empty\n");
			return;
		}
		Node deltemp=head;
		head=head.next;
		System.out.print("Deleted Node  ->  "+deltemp.data+"\n");
		count--;
		if(count==0) {
			System.out.print("List is Empty Now\n");
			return;
		}
		System.out.print("Element in List\n");
		displayList();
	}

	
	void deleteAtPos(int pos,SingleLinkedList list) {
		if(pos<0 || pos>count+1) {
			System.out.print("Enter the valid position\n");
			return;
		}
		if(pos==1) {
			deleteAtBegin();
		}
		else {
			Node delPtemp=head;
			Node dupp=null;
			int i=1;
			while(i<pos) {
				dupp=delPtemp;
				delPtemp=delPtemp.next;
				i++;
			}
			System.out.print("Deleted Node : "+delPtemp.data+"\n");
			if(head==delPtemp) {
				head=null;
			}
			else {
				dupp.next=delPtemp.next;
			}
			count--;
			displayList();
		}
	}
	
	void deleteAtEnd() {
		Node delEtemp=head;
		Node dup=head;
		while(delEtemp.next!=null) {
			dup=delEtemp;
			delEtemp=delEtemp.next;
		}
		if(delEtemp==head) {
			head=null;
		}
		else {
			dup.next=null;
		}
		count--;
		System.out.print("Deleted Node : "+delEtemp.data+"\n");
		displayList();
		
	}
	
	void displayList(){
		Node Dtemp=head;
		if(head==null) {
			System.out.println("List is Empty\n");
		}
		while(Dtemp!=null) {
			System.out.print(Dtemp.data+" ");
			Dtemp=Dtemp.next;
		}System.out.println();
		
	}
}

public class SingleLinkedList extends Method {
	static void insert(SingleLinkedList list) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Where You need to insert:\nBegin : 1\nMiddle : 2\nEnd : 3\n");
		int insert_choice=sc.nextInt();
		switch(insert_choice) {
			case 1: System.out.print("Enter the Element:\n");
					int element_beg=sc.nextInt();
					list.insertAtBegin(element_beg);
					break;
			case 2:	System.out.print("Enter the Position :\n");
					int pos=sc.nextInt();
					System.out.print("Enter the Element:\n");
					int element_Mid=sc.nextInt();
					list.insertAtPos(pos,element_Mid,list);
					break;	
			case 3:	System.out.print("Enter the Element:\n");
					int element_end=sc.nextInt();
					list.insertAtEnd(element_end);
					break;
			default:System.out.print("Enter the valid Choice\n");
					break;
		}
		
	}
	static void display(SingleLinkedList list) {
		list.displayList();
	}
	
	static void delete(SingleLinkedList list) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Where You need to Delete:\nBegin : 1\nMiddle : 2\nEnd : 3\n");
		int delete_choice=sc.nextInt();
		switch(delete_choice) {
			case 1: list.deleteAtBegin();
					break;
			case 2:	System.out.print("Enter the Position :\n");
					int pos=sc.nextInt();
					list.deleteAtPos(pos,list);
					break;	
			case 3:	list.deleteAtEnd();
					break;
			default:System.out.print("Enter the valid Choice\n");
					break;
		}
		
	}
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		SingleLinkedList list=new SingleLinkedList();
		int choice=1,option;
		while(choice==1) {
			System.out.print("Enter Your option \nInsert : 1\nDelete: 2\nDisplay: 3\n");
			option=sc.nextInt();
			switch(option) {
				case 1:	insert(list);
						break;
				case 2:	delete(list);
						break;
				case 3:	display(list);
						break;
				default: System.out.print("Enter the valid option\n");
						break;
			}
			System.out.print("Do you want to Continue 1:\n");
			choice=sc.nextInt();
		}
		sc.close();
	}
}

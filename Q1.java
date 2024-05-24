package Assignment5;
import java.util.Scanner;
class Node{
	int redg;
	float marks;
	Node next;
	Node prev;
	public Node(int redg, float marks) {
		this.redg = redg;
		this.marks = marks;
		this.next=null;
		this.prev=null;
	}
}

public class Q1 {
	static Scanner sc =new Scanner(System.in);
	static Node start;
	static Node end;
	public static  Node create() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the regd and marks: ");
		int redg=sc.nextInt();
		float marks=sc.nextFloat();
			return new Node(redg,marks);
	}
	public static Node insertbeg(Node start,Node end) {

		Node node =create();
		if(start==null) {
			start=end=node;
			
		}else {
			node.next=start;
			node.prev=null;
			start.prev=node;
			start=node;
		}
		return start;
	}
	public static Node insertend(Node start,Node end) {
		Node node =create();
	if(start==null){
		start=end=node;
	}else {
		end.next=node;
		node.prev=end;
		node.next=null;
		end=node;
	}
		return end;
		
	}
	public static void display(Node start,Node end) {
		if(start==null) {
			System.out.println("List is empty");
		}
		Node node =start;
		while(node!=null) {
			System.out.print(node.redg+"->");
			node=node.next;
		}
		System.out.println("null");
		
	}
	public static Node insertany(Node start,Node end) {
		System.out.println("Enter the position");
		int position=sc.nextInt();
		if(position==1) {
			return insertbeg(start,end);
		}else {
			Node node =create();
			Node temp=start;
			for(int i=1;i<position-1;i++) {
				if(temp!=null) {
					temp=temp.next;
				}
			}
			if(temp!=null) {
				node.next=temp.next;
				if(temp.next!=null) {
					temp.next.prev=node;
				}
				temp.next=node;
				node.prev=temp;
				if(node.next==null) {
					end=node;
				}
			}else {
				System.out.println("Previous node is null");
			}
		}
		
		return start;
	}
	public static Node deletefirst(Node start,Node end) {
		if(start==null) {
			System.out.println("List is empty");
			return null;
		}
		if(start.next!=null) {
			start=start.next;
		}
		start.prev=null;
		return start;
	}
	public static  Node deletelast(Node start,Node end) {
		if(end==null) {
			System.out.println("List is empty");
			return null;
		}
		if(end.prev!=null) {
			end=end.prev;
		}
		end.next=null;
		return end;
	}
	public static Node deleteany(Node start,Node end) {
		if(start==null) {
			System.out.println("List is empty");
		}else {
			System.out.println("Enter the position");
			int position=sc.nextInt();
			if(position==1) {
				return deletefirst(start,end);
			}else {
				Node temp=start;
				for(int i=1;i<position-1;i++) {
					if(temp!=null) {
						temp=temp.next;
					}
				}
				if(temp!=null&&temp.next!=null) {
					temp.next=temp.next.next;
					if(temp.next!=null) {
						temp.next.prev=temp;
					}else {
						end=temp;
					}
				}else {
					System.out.println("invalid position");
				}
			}
		}
		return start;
	}
	public static void search(Node start) {
		System.out.println("Enter the redg number:");
		int redg=sc.nextInt();
		Node temp=start;
		while(temp!=null) {
			if(temp.redg==redg) {
				temp.marks=sc.nextFloat();
				return;
			}
			temp=temp.next;
		}
		System.out.println("Not found");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
        while (choice != 9) {
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at any position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from any position");
            System.out.println("7. Search and update mark");
            System.out.println("8. Display list");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    start = InsBeg(start,end);
                    if(end==null){
                        end=start;
                    }
                    break;
                case 2:
                    end = InsEnd(start,end);
                    if(start==null){
                        start=end;
                    }
                    break;
                case 3:
                    start = InsAny(start,end);
                    break;
                case 4:
                    start = DelBeg(start,end);
                    break;
                case 5:
                    end = DelEnd(start,end);
                    break;
                case 6:
                    start = DelAny(start,end);
                    break;
                case 7:
                    search(start,end);
                    break;
                case 8:
                    display(start,end);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        sc.close();
	}

}

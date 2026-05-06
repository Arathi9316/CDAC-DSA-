package practice;

public class Main {
//	public void print(int n) {
//		if(n==0) return;
//		print(n-1);
//		System.out.println("Ashish");
//	}
//	public void printNum(int i,int n) {
//		if(i>n)return;
//		System.out.print(i+" ");
//		printNum(i+1,n);
//	}
//	public void printRev(int i,int n) {
//		if(n==0)return;
//		
//		printRev(i,n-1);
//		System.out.println(n+" ");
//	}
	
	public static void print(int n) {
		if(n==5)return;
		
		print(n+1);
		System.out.println();
		printStar(n);

		
	}
	public static void printStar(int n) {
		if(n==0)return;
		System.out.print("&");
		printStar(n-1);
	}
	
	public static int count(int n,int d) {
		if(n==0)return 0;
		if(n%10==d) 
			return 1+count(n/10,d);
		else 
			return count(n/10,d);
	}
	
	public static int reverse(int d,int rev) {
		if(d==0)return rev;
		rev=rev*10;
		rev+=(d%10);
		d=d/10;
		return reverse(d,rev);
		
		
	}
	public static void main(String[] args) {
		Main m=new Main();
//		m.print(5);
//		m.printNum(1, 15);
//		System.out.println();
//		System.out.println("===N to 1===");
//		m.printRev(1,10);
//		print(1);
		
		System.out.println(count(123222123,2));
		System.out.println(reverse(1234,0));
		
	}

}

package recursion;

public class Starting {
	public static void fun(int n) {
		
		if(n>6) return;
		System.out.println("Before called"+n);
		fun(n+1);
		
		
		System.out.println("After called "+n);
	}
	
	public static int sums(int a[],int i) {
		if(i>9)return 0;
		System.out.println(a[i]);
		return a[i]+sums(a,i+1);
	}
	public static int sum_ofDigit(int n) {
		if(n/10==0) 		return n;
		return n%10+sum_ofDigit(n/10);
	}
	
	
	
	public static int reverseDigit(int n,int rev) {
		
	if(n>0) {
		rev=rev*10+n%10;
		n=n/10;
		reverseDigit(n,rev);
	}
	return rev;
		
	}
	
	
	public static int count(int n) {
		if(n/10==0) return 1;
		return 1+count(n/10);
	}
	
	public static void displayR(int n)
	{
	if(n/10==0)
	{
	System.out.println(n);
	return;
	}
	System.out.print(n%10);             
	displayR(n/10);
	}
	public static int pow(int a,int b) {
		if(b==0)return 1;
		return a*pow(a,b-1);
	}
	
	//pattern
	public static void func1(int n) {
		if(n<1)return;
//		System.out.println(n);
		func1(n-1);
		System.out.println(" ");
		starprint(n);
	}
	public static void starprint(int n) {
		if(n==0)return;
		System.out.print("*");
//		System.out.print(n);
		starprint(n-1);
	}
	
	
	public static void main(String[] args) {
//		phases.fun(0);
		int arr[]= {10,20,30,40,50,60,70,80,90,100};
		//int sum=phases.sums(arr, 0);
		//System.out.println("Sum = "+sum);
//		
//		System.out.println("Sum of digits = "+sum_ofDigit(543));
//		
//		
		System.out.println("Reverse of digits = "+reverseDigit(5438,0));
//		
//		System.out.println("Count digits = "+count(54321));
//		
			displayR(123);
			System.out.println();
			
			func1(5);
	}
}
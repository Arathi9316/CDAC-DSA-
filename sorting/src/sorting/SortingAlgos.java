package sorting;

public class SortingAlgos {

	public static void bubbleSort(int a[]) {
		int flag;
		for(int i=a.length-1;i>0;i--) {
			flag=0;
			for(int j=0;j<i;j++) {
				if(a[j]>a[j+1]) {
				int temp;
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
				flag=1;
			}
			}
			if(flag==0)break;
		}
	}
	
	public static void selectionSort(int a[]) {
	int i,j,min,t;
		for(i=0;i<a.length-1;i++) {
			min=i;
			for(j=i+1;j<a.length;j++) {
				if(a[min]>a[j])
					min=j;
			}
			if(min!=i) {
				t=a[i];
				a[i]=a[min];
				a[min]=t;
			}
		}
	}
	public static void insertSort(int a[]) {
		int i,j,k;
		for(i=1;i<a.length;i++) {
			k=a[i];
			for(j=i-1;j>=0&&k<a[j];j--) {
				a[j+1]=a[j];
			}
			a[j+1]=k;
		}
	}
	//Student
	public static void selectionSort(Student a[]) {
		int i,j,min;
		Student t;
		for(i=0;i<a.length-1;i++) {
			min=i;
			for(j=i+1;j<a.length;j++) {
				if(a[min].getAge()>a[j].getAge())
					min=j;
			}
			if(min!=i) {
				t=a[i];
				a[i]=a[min];
				a[min]=t;
			}
		}
	}
	
	public static void display(int []a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[]=new int[]{2,5,3,7,1,7,9};
		//Student
		Student s[]=new Student[5];
		s[0]=new Student("Ashish",14,22);
		s[1]=new Student("Rohit",62,23);
		s[2]=new Student("Sagar",45,21);
		s[3]=new Student("Tushar",24,25);
		s[4]=new Student("Siddarth",18,24);

		
		display(arr);
//		bubbleSort(arr);
//		selectionSort(arr);
		insertSort(arr);
		display(arr);
		selectionSort(s);
		for(Student s1:s) {
			System.out.println(s1);
		}

	}
	
}

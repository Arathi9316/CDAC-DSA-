package sorting;

public class QuickSort {
	
	private static int partition(int[]arr,int low,int high) {
		int left,right,pivot,t;
		pivot=arr[low];
		left=low;
		right=high;
		while(left<=right) {
			while((arr[left]<=pivot)&&(left<right))
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<right) {
				t=arr[left];
				arr[left]=arr[right];
				arr[right]=t;
				left++;right--;
			}
			else left++;
		}
		arr[low]=arr[right];
		arr[right]=pivot;
		return right;
	}
	private static void quickSort(int arr[],int low,int high) {
		int pivloc;
		if(low>=high) return;
		pivloc=partition(arr,low,high);
		quickSort(arr,low,pivloc-1);
		quickSort(arr,pivloc+1,high);
	}
	public static void quickSort(int arr[]) {
		quickSort(arr,0,arr.length-1);
	}
	
	public static void main(String[] args) {
		int arr[]=new int[] {2,1,5,3,7,9,5,2};
		quickSort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
			
		
	}
}

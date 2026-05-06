package sorting;

public class MergeAlgo {
	public static void mergeVer1(int tar[],int arr1[],int[]arr2) {
		int i=0,j=0,k=0;
		while((i<arr1.length)&&(j<arr2.length)) {
			if(arr1[i]>arr2[j]) {
				tar[k]=arr2[j];
				k++;j++;
			}
			else if(arr1[i]<arr2[j]) {
				tar[k]=arr1[i];
				k++;i++;
			}
			else {
				tar[k]=arr1[i];
				i++;k++;j++;
			}
		}
		while(i<arr1.length) {
			tar[k]=arr1[i];
			k++;i++;
		}
		while(j<arr2.length) {
			tar[k]=arr2[j];
			k++;j++;
		}

	}
	public static void mergeVer2(int arr[],int tar[],int low1,int high1,int low2,int high2) {
		int i=low1,j=low2,k=low1;
		while((i<=high1)&&(j<=high2)) {
			if(arr[i]<arr[j]) {
				tar[k]=arr[i];
				i++;k++;
			}
			else if(arr[j]<arr[i]) {
				tar[k]=arr[j];
				j++;k++;
			}
			else {
				tar[k]=arr[i];
				i++;k++;
			}
		}
		while(i<=high1) {
			tar[k]=arr[i];
			i++;k++;
		}
		while(j<=high2) {
			tar[k]=arr[j];
			j++;k++;
		}
	}
	public static void copy(int arr[],int []temp,int low,int high) {
		int i;
		for(i=low;i<=high;i++) {
			arr[i]=temp[i];
		}
	}
	public static void mergeSort(int arr[],int[] temp,int low,int high) {
		int mid;
		if(low<high) {
			mid=(low+high)/2;
			System.out.println("First half");
			for(int i=low;i<=mid;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			mergeSort(arr,temp,low,mid);
			System.out.println("Second half");
			for(int i
					=mid+1;i<=high;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			mergeSort(arr,temp,mid+1,high);
			
			mergeVer2(arr,temp,low, mid, mid+1, high);
			copy(arr,temp,low,high);
		}
	}
	public static void mergeSorting(int arr[]) {
		int[] temp=new int[arr.length];
		mergeSort(arr,temp,0,arr.length-1);  
	}
	
	public static void main(String[] args) {
		int arr1[]=new int[]{2,3,5,7 ,9};
		int arr2[]=new int[]{0,1,4,5,7};
		int arr3[]=new int[arr1.length+arr2.length];
		mergeVer1(arr3, arr1, arr2);
//		for(int a:arr3) {
//			System.out.print(a+" ");
//		}
		int arr4[]=new int[]{2,4,1,3,8,5};
		mergeSorting(arr4);
		for(int a:arr4) {
			System.out.print(a+" ");
		}
	}
}

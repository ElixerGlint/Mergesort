import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] asd = new int[20];
  
        for(int i = 0; i < asd.length; i++) {
            asd[i] = (int)(Math.random()*asd.length);
        }
        mergesort(asd);
        System.out.println(Arrays.toString(asd));
    }
    
    public static void mergesort(int[] arr) {
        int[] aux = new int[arr.length];

        mergeHelper(arr, aux,0,arr.length-1);
    }

    public static void mergeHelper(int[] arr, int[] aux, int start, int end) {
        if(start >= end) {
            return;
        }

        int middle = (start+end)/2;
        mergeHelper(arr, aux, start, middle); //first section
        mergeHelper(arr, aux, middle+1, end); //second section

        merge(arr,aux,start,end); //putting the two pieces back together


    }

    public static void merge(int[] arr, int[] aux, int start, int end) {
        int middle = (start+end)/2;
        int left = start;
        int right = middle + 1;

        for(int i = start; i<=end; i++) {
            if(right > end) { //take from eft
                aux[i] = arr[left++];
            }
            else if (left > middle) {
                aux[i] = arr[right++];
            }
            else if(arr[left] < arr[right]) {
                aux[i] = arr[left++];
            }
            else {
                aux[i] = arr[right++];
            }
        }
        
        for(int i = start; i <= end; i++) {
            arr[i] = aux[i];
        }
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

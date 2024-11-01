/* 
QUICKSORT
Bagabaldo
Gutierrez
Rojo
Pacatan
Valdez
Waga
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Java program for implementation of QuickSort

class QuickSort
{
    int partition(int a[], int low, int high)
    {
        int pivot = a[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
          
            // If current element is smaller than or
            // equal to pivot
            if (a[j] <= pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      a[] --> Array to be sorted,
      l  --> Starting index,
      h  --> Ending index */
    void sort(int a[], int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);

            // Recursively sort elements before
            // partition and after partition
            sort(a, l, pi-1);
            sort(a, pi+1, h);
        }
    }

    // Driver program
    public static void main(String args[]) throws FileNotFoundException
    {
        // fetches elements from input.txt
        int textFileLength;
        Scanner infile = new Scanner (new File("input.txt"));
        textFileLength = infile.nextInt();

       int [] a = new int [textFileLength];

        for (int i = 0; i < textFileLength; i++) {
            a[i] = infile.nextInt();
        }
        infile.close();
        int n = a.length;

        // Display unsorted array
        System.out.println("Unsorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        //sort the array
        QuickSort ob = new QuickSort();
        ob.sort(a, 0, n-1);

        //display sorted array
        System.out.println("Array sorted using QuickSort:");
        for (int i=0; i<n; ++i) 
            System.out.print(a[i]+" ");
    }
}



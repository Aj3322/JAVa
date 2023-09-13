import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hii Aj (^_^):");
        System.out.println("Enter the no of elements: \n");
        int n =sc.nextInt();
        int array[]=new int[n];
         int  k, PTR, swap;
          System.out.println("Enter"+n+ "integers: ");
    for(k = 0; k < n; k++){
        array[k] =sc.nextInt();}
    for(k = 0; k < n-1; k++) {
        for(PTR = 0; PTR < n-k-1; PTR++) {
            if (array[PTR] > array[PTR+1]) {
                swap = array[PTR];
                array[PTR] = array[PTR+1];
                array[PTR+1] = swap;
            }
        }
    }

    System.out.println("Elements are in sorted format: \n");
    for(k = 0; k < n; k++){
        System.out.println( array[k]);}

    }
}

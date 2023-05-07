package busquedasecuencialbinaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusquedaSecuencialBinaria {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int vector[];
        int numero=0;
        int valor=0;
        boolean salir=true;
        String str=new String();
        System.out.println("Ingrese un vector numerico: ");
        str=br.readLine();
        vector=new int[str.length()]; 
        for(int i=0;i<str.length();i++) {
            vector[i]=Character.getNumericValue(str.charAt(i));        
        }
        System.out.println("¿Que numero quiere encontrar?");
        valor=Integer.parseInt(br.readLine());
    do {
            System.out.println("\n______________________________________________");
            System.out.print("El vector ingresado es: ");
            System.out.print("|");
            for(int i=0;i<vector.length;i++) {
                System.out.print(vector[i]+"|");           
            }
            System.out.println("\nEl numero a encontrar es: "+valor);
            System.out.println("1) Secuancial");
            System.out.println("2) Binario");
            System.out.println("3) Ordenar");
            System.out.println("4) Salir");
            System.out.println("Ingrese el numero:");        
            System.out.println("______________________________________________");
            numero=Integer.parseInt(br.readLine());
            switch(numero) {
                case 1:
                    System.out.println("Esta en la posicion "+(busquedaSecuencial(vector, valor)+1));
                break;

                case 2:
                    System.out.println("Esta en la posicion "+(busquedaBinaria(vector,valor)+1));
                break;

                case 3:
                   HeapSort(vector);
                   System.out.print("El vector ordenado es: ");
                   System.out.print("|");
                   for(int i=0;i<vector.length;i++) {
                        System.out.print(vector[i]+"|");           
                   }
                break;
                
                case 4:
                    salir=false;
                break;
                
                default:
                    System.out.println("No sea pendejo, eso ni esta entre las opciones");
                break;
            }
        }while(salir);         
    }
    
    static public  int busquedaSecuencial(int []arreglo,int dato){
        int posicion = -1;
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == dato){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
    public static int busquedaBinaria(int  vector[], int dato){
    int n = vector.length;
    int centro,inf=0,sup=n-1;
        while(inf<=sup){
            centro=(sup+inf)/2;
            if(vector[centro]==dato) return centro;
            else if(dato < vector [centro] ){
                sup=centro-1;
            }
            else {
                inf=centro+1;
            }
        }
    return -1;
 }
    
    static public void HeapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }        
    } 
    
    static public void  heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }    
}

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Task {

    static ArrayList data = new ArrayList();

    public static void main(String[] args)
    {
        createData();

        quickSort(data);

        printData();
    }


    public static void createData()
    {
        for(int i = 0; i < 10; i++)    //add 10 random doubles
        { data.add(Math.floor(Math.random()*100)/1.0); }
    }

    public static void printData()
    {
        for(int i = 0; i < data.size(); i++)   //print out elements
        { System.out.print(data.get(i).toString().substring(0,data.get(i).toString().indexOf(".")) + " "); }
    }

    public static ArrayList<Double> quickSort(ArrayList<Double> data)
    {
        quickSortHelper(data, 0, data.size()-1);
        return data;
    }

    public static void quickSortHelper(ArrayList<Double> data, int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            quickSortHelper(data, low, pivot - 1);
            quickSortHelper(data, pivot + 1, high);
        }
    }

    private static int partition(ArrayList<Double> data, int low, int high) {
        double pivot = data.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                double temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        double temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);
        return i + 1;
    }

    //Helper method that swaps two elements in an array
    //@param data: ArrayList where elements are
    //@param index1 and index2: indeces of the two elements to be swapped
    public static void swapElements(ArrayList<Double> data, int index1, int index2)
    {
        double temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }

}

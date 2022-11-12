import java.lang.reflect.Array;
import java.util.ArrayList;

public class Task {

    static ArrayList data = new ArrayList();

    public static void main(String[] args)
    {
        createData();

        mergeSort(data);

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

    public static ArrayList<Double> mergeSort(ArrayList<Double> data)
    {
        mergeSortHelper(data, 0, data.size()-1);
        return data;
    }


    public static void mergeSortHelper(ArrayList<Double> data, int start, int end)
    {
        if(start < end)
        {
            int mid = (start + end) / 2;
            mergeSortHelper(data, start, mid);
            mergeSortHelper(data, mid+1, end);
            merge(data, start, mid, end);
        }

    }

    private static void merge(ArrayList<Double> data, int start, int mid, int end) {
        ArrayList<Double> temp = new ArrayList<Double>();
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (data.get(i) < data.get(j)) {
                temp.add(data.get(i));
                i++;
            } else {
                temp.add(data.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(data.get(i));
            i++;
        }
        while (j <= end) {
            temp.add(data.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            data.set(start + k, temp.get(k));
        }
    }


}

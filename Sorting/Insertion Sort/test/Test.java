import org.junit.Assert;

import java.util.ArrayList;

public class Test {

    @org.junit.Test public void testSorting() {

        //make testing data
        ArrayList<Double> testData = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        { testData.add(Math.random()); }

        //make sure resulting array is sorted
        ArrayList<Double> sorted = Task.insertionSort((ArrayList<Double>) testData.clone());

        for(int i = 1; i < sorted.size(); i++)
        {
            if(sorted.get(i-1) > sorted.get(i))
            {   Assert.fail("Insertion Sort Failed");}
        }


    }

}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestFindValues {
    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][] {
                {{1,1,1,4,4,1,1,4},{1,4},{1}},
                {{2,2,5,5,6,6},{2,5,6},{1}},
                {{2,2,5,5},{2,5,6},{0}},
        });
    }
    Task_2 obj;

    private int[] arr;
    private int[] values;
    private boolean result;

    public TestFindValues(int[] arr, int[] values, int[] result) {
        this.arr = arr;
        this.values = values;
        this.result = result[0] == 1;
    }

    @Before
    public void init() {
        obj = new Task_2();
    }

    @Test
    public void testFind() {
        Assert.assertEquals(result, obj.findValuesInArray(arr, values));
    }


}

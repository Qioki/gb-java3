import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArrayCopy {
    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][] {
                {{1,2,3,4,6,8,3,6},{6,8,3,6}},
                {{7,5,43,7,4,2,78,3,7},{2,78,3,7}},
                {{5,7,9,4,5,7,5,3,8,2},{5,7,5,3,8,2}},
        });
    }
    Task_1 obj;

    private int[] arr;
    private int[] checkArr;

    public TestArrayCopy(int[] arr, int[] checkArr) {
        this.arr = arr;
        this.checkArr = checkArr;
    }
    @Before
    public void init() {
        obj = new Task_1();
    }

    @Test
    public void testCopy() {
        Assert.assertArrayEquals(checkArr, obj.copyArray(arr,4));
    }


}

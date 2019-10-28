package com.huawei;

import org.junit.Assert;
import org.junit.Test;

public class SolTest {

    @Test
    public void one() {
       int res = new Solution().findMinumumSteps("aaa", "bbb");
        Assert.assertEquals(1, res);
    }

    @Test
    public void two() {
        int res = new Solution().findMinumumSteps("aa", "bc");
        Assert.assertEquals(-1, res);
    }

    @Test
    public void three() {
        int res = new Solution().findMinumumSteps("abc", "bcd");
        Assert.assertEquals(3, res);
    }

    @Test
    public void four() {
        int res = new Solution().findMinumumSteps("ab", "ba");
        Assert.assertEquals(3, res);
    }

}

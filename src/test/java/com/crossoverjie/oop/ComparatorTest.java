package com.crossoverjie.oop;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    private String[] list = {"apple", "application", "adam", "available"};

    @Test
    public void DefaultCompareTest() {
        // 正常排序
        Arrays.sort(list);

        for (String li : list) {
            System.out.println(li);
        }

        Assert.notNull(list, "集合不为空");
    }

    @Test
    public void CustomCompareTest(){
        // 正常排序
        lengthComparator lc = new lengthComparator();
        Arrays.sort(list,lc);

        for (String li : list) {
            System.out.println(li);
        }

        Assert.notNull(list, "集合不为空");
    }
}

class lengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}

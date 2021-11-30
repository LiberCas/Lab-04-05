package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    private ListFilterer filterer;
    private List<Integer> lis;
    @BeforeEach
    public void helper(){
    lis = Arrays.asList(1, 2, 4, -6, 1, -17, 16, 15, -13, 90, -8);
    }
    @Test
    public void positivetest(){
        filterer = new ListFilterer(new PositiveFilter());
        List<Integer> ans = filterer.filter(lis);

        Assertions.assertEquals(Arrays.asList(1, 2, 4, 1, 16, 15, 90), ans);
    }
    @Test
    public void div2test(){
        filterer = new ListFilterer(new DivisibleByFilter(2));
        List<Integer> ans = filterer.filter(lis);

        Assertions.assertEquals(Arrays.asList(2, 4, -6, 16, 90, -8), ans);
    }
    @Test
    public void div3test(){
        filterer = new ListFilterer(new DivisibleByFilter(3));
        List<Integer> ans = filterer.filter(lis);

        Assertions.assertEquals(Arrays.asList(-6, 15, 90), ans);
    }
    public void div13test(){
        filterer = new ListFilterer(new DivisibleByFilter(13));
        List<Integer> ans = filterer.filter(lis);

        Assertions.assertEquals(Arrays.asList( -13), ans);
    }


}

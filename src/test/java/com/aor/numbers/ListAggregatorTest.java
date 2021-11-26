package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
    public void helper(){
    list = Arrays.asList(1,2,4,2,5);
    }
    public void helper(List<Integer> list){
        this.list = list;
    }
    @Test
    public void sum() {
        helper();
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        helper();
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }
    @Test
    public void max_bug_7263(){
        helper(Arrays.asList(-1, -4, -5));
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        helper();
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        helper();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, new ListDeduplicator());

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        class StubListDeduplicator implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list){
                return Arrays.asList(1,4,2);
            }
        }
        StubListDeduplicator dedup = new StubListDeduplicator();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, dedup);
        Assertions.assertEquals(3, distinct);
    }
}

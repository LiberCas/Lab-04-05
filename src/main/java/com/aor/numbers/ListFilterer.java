package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;



public class ListFilterer {
    private GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {this.filter = filter;};
    public List<Integer> filter(List<Integer> list){
        List<Integer> ans= new ArrayList<Integer>();
        for(Integer elem : list){
            if(filter.accept(elem))
                ans.add(elem);
        }
        return ans;
    };

}

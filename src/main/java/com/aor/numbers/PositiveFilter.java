package com.aor.numbers;

public class PositiveFilter implements GenericListFilter{
    PositiveFilter(){};
    public boolean accept(Integer number){
        return (number > 0);
    };
}

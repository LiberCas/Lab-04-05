package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    Integer divisor;
    DivisibleByFilter(Integer divisor){
        this.divisor = divisor;
    }
    public boolean accept(Integer number){
        if (number%divisor == 0)
            return (true);
        else return false;};}

package net.devk.util;


/**
 * Created by sArshad on 2/28/2018.
 */
public class SQLFunction {

    private final Function function;
    private final String field;

    public SQLFunction(Function function, String field){
        this.function = function;

        this.field = field;
    }

    public Function getFunction() {
        return function;
    }

    public String getField() {
        return field;
    }

    public enum Function {
        COUNT, SUM, COUNT_DISTINCT
    }
}
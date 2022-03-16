package customClass;

public class Expression {
    private String key;
    private Expression[] values;
    private Integer val;

    public Expression(String key, Expression[] values) {
        this.key = key;
        this.values = values;
    }

    public Expression(String key, int[] values) {
        this.key = key;
        this.values = new Expression[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = new Expression(values[i]);
        }
    }

    public Expression(int val) {
        this.val = val;
    }

    public boolean isInteger() {
        if (val != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPair() {
        if (values != null && values.length > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBase() {
        // if values are all int
        if (values != null) {
            for (Expression v : values) {
                if (!v.isInteger())
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public Expression[] getValues() {
        return values;
    }

    public int getVal() {
        if (!isInteger())
            throw new IllegalArgumentException("now a integer");
        return this.val;
    }

    public String getKey() {
        if (!isPair())
            throw new IllegalArgumentException("not a pair");
        return this.key;
    }

    public int[] getIntArray() {
        if (!isBase())
            throw new IllegalArgumentException("not base, can not convert to int array");
        int[] res = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            res[i] = values[i].getVal();
        }
        return res;
    }
}
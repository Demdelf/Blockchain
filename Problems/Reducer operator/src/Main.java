/**
 * The operator combines all values in the given range into one value
 * using combiner and initial value (seed)
 */
public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator = (a, fun) -> (b, c) ->{
        int answer=fun.applyAsInt(a,b);
        int r=b+1;
        while(r<=c){
        answer=fun.applyAsInt(answer,r++);}
        return answer;
        };

/**
 * The operator calculates the sum in the given range (inclusively)
 */
public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);// write your code here

/**
 * The operator calculates the product in the given range (inclusively)
 */
public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);// write your code here
public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
        lst -> {
        UnaryOperator<List<Integer>> uOp = new UnaryOperator<List<Integer>>() {
@Override
public List<Integer> apply(List<Integer> integers) {
final int[] curFunct = new int[1];
        List<Integer> newLst = integers;
        for (int i = 0; i < lst.size(); i++) {
        curFunct[0] = i;
        newLst = newLst.stream().map(curInt -> lst.get(curFunct[0]).applyAsInt(curInt)).collect(Collectors.toList());
        }
        return newLst;
        }
        };
        return uOp;
        };

/**
 * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
 *
 * It returns a list of the same numbers.
 */
public static final UnaryOperator<List<Integer>> identityTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

/**
 * The operator accepts an integer list.
 * It multiplies by two each integer number and then add one to its.
 *
 * The operator returns transformed integer list.
 */
public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x*2, x -> x + 1));

/**
 * The operator accepts an integer list.
 * It squares each integer number and then get the next even number following it.
 *
 * The operator returns transformed integer list.
 */
public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
        multifunctionalMapper.apply(Arrays.asList(x -> x*x, x -> x % 2 == 0 ? x + 2 : x + 1));
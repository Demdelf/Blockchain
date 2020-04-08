public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return Stream.iterate(fromIncl, x -> x + 1).limit(toExcl - fromIncl).
        reduce(0, (acc, elem) -> acc + elem*elem);
}
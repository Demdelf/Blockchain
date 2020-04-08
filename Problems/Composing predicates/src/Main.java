/**
 * The method represents a disjunct operator for a list of predicates.
 * For an empty list it returns the always false predicate.
 */
public static IntPredicate disjunctAll(List<IntPredicate> predicates) {

        if (predicates.isEmpty()){
        return n -> n > Integer.MAX_VALUE;
        }
        IntPredicate predicate = predicates.get(0);
        for (IntPredicate ip: predicates
        ) {
        predicate = predicate.or(ip);
        }
        return predicate;
}
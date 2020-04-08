public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
    return // write your stream here
        IntStream.concat(evenStream, oddStream).filter(x -> x % 3 == 0 &&  x % 5 == 0).sorted().skip(2);
}
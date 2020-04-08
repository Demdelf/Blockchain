public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

    // your implementation here
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()){
        minMaxConsumer.accept(null, null);
        }else {
        minMaxConsumer.accept((T)list.stream().min(order), (T)list.stream().max(order));
        }
}
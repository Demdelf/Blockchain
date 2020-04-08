import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<String>();
        String s = scanner.nextLine();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            String result = matcher.group();
            strings.add(result);
        }

        Map<String, Long> counts =
                strings.stream().map(e -> e.toLowerCase()).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Map<String, Long> topTen =
                counts.entrySet().stream()
                        .sorted( new Comparator<Map.Entry<String, Long>>() {
                            @Override
                            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                                if (o1.getValue() == o2.getValue()){
                                    return o1.getKey().compareTo(o2.getKey());
                                }
                                return (int) (o2.getValue() - o1.getValue());
                            }
                        })
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        topTen.entrySet().stream().forEach(m -> System.out.println(m.getKey()));
    }



}
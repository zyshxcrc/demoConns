import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by liuziyang on 2017/8/1.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        int[] sortNo = {1,2,5,3,6,4,8,9,7,10,12,11};
        List<Integer> sortList = new ArrayList<>();
        for (int s : sortNo) {
            sortList.add(s);
        }
        List<Integer> max = sortList.stream().filter(a->a>5).sorted(Integer::compare)
                .collect(Collectors.toList());
        System.out.println(max);

        List<String> menuNames = menu.parallelStream().filter(a->a.getCalories()>500)
                .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
                .skip(1).limit(2)
                .collect(Collectors.toList());
        System.out.println(menuNames);

        String[] arrayOfWords = {"Goodbye", "World"};
        Arrays.stream(arrayOfWords).map(a->a.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> numList = numbers1.stream().flatMap(a->numbers2.stream().map(b->new int[]{a,b})).collect(Collectors.toList());
        System.out.println(numList);

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(d-> System.out.println(d.getName()));

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        IntStream.range(1,100).sum();


        IntStream.rangeClosed(1,100).boxed()
                .flatMap(a->IntStream.rangeClosed(a,100)
                        .filter(b->Math.sqrt(a*a+b*b)%1==0)
                        .mapToObj(b->new int[]{a,b, (int) Math.sqrt(a*a+b*b)}))
                .limit(4)
                .forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));
    }


}

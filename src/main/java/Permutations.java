import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Permutations {
    public static List<String> singlePermutations(String s) {

//        List<String> result = new ArrayList<>();
//
////        int n = s.length();
////        List<int[]> permutationsList = permutationsListGenerator(s.length());
////        permutationsList.forEach(ints -> System.out.println(Arrays.toString(ints)));
//
////        Stream<String> stringStream = permutationsList.stream().map(ints -> {
////            StringBuilder stringBuilder = new StringBuilder();
////            for (int anInt : ints) {
////                stringBuilder.append(s.charAt(anInt - 1));
////            }
////            return stringBuilder.toString();
////        });
//
//        result = permutationsListGenerator(s.length()).stream().map(ints -> {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int anInt : ints) {
//                stringBuilder.append(s.charAt(anInt - 1));
//            }
//            return stringBuilder.toString();
//        }).distinct().collect(Collectors.toList());
        return permutationsListGenerator(s.length()).stream().map(ints -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int anInt : ints) {
                stringBuilder.append(s.charAt(anInt - 1));
            }
            return stringBuilder.toString();
        }).distinct().collect(Collectors.toList());
    }
//    public static void main(String[] args) {
//        singlePermutations("abba");
//    }
//
    private static List<int[]> permutationsListGenerator(int n) {
        List<int[]> permutationsList = new ArrayList<>();

//        int[] a = new int[n+2];
//        for (int e = 1; e <= n; e++) a[e] = e;
        int[] a = IntStream.range(0, n+2).map(operand -> operand < n+1 ? operand : 0).toArray();

        int j;
        do {
            int[] b = new int[a.length-2];
            System.arraycopy(a, 1, b, 0, b.length);
            permutationsList.add(b);
            int i = n;
            while (a[i - 1] > a[i]) i--;
            j = i - 1;
            while (a[i + 1] > a[j]) i++;
            swap(a, i, j);
            int o = j + 1;
            int k = n;
            while (o < k) swap(a, o++, k--);
        } while (j != 0);

        return permutationsList;
    }

private static void permutationsListGenerator2(int n) {
//        List<int[]> permutationsList = new ArrayList<>();

//    IntStream intStream = IntStream.range(0, n+2).map(operand -> operand < n+1 ? operand : 0);//.forEach(System.out::println);
    int[] a = IntStream.range(0, n+2).map(operand -> operand < n+1 ? operand : 0).toArray();
    System.out.println(Arrays.toString(a));

    int j = 0;
    Stream<int[]> stream = Stream.iterate(a, new Predicate<int[]>() {
        @Override
        public boolean test(int[] ints) {
            return false;
        }
    }, new UnaryOperator<int[]>() {
        @Override
        public int[] apply(int[] ints) {

            return ints;
        }
    });

    stream.forEach(System.out::println);

//        int[] a = new int[n+2];
//        for (int e = 1; e <= n; e++) a[e] = e;
//        int j;
//
//        do {
//            int[] b = new int[a.length-2];
//            System.arraycopy(a, 1, b, 0, b.length);
//            permutationsList.add(b);
//            int i = n;
//            while (a[i - 1] > a[i]) i--;
//            j = i - 1;
//            while (a[i + 1] > a[j]) i++;
//            swap(a, i, j);
//            int o = j + 1;
//            int k = n;
//            while (o < k) swap(a, o++, k--);
//        } while (j != 0);

//        return ;
    }

    public static void main(String[] args) {
        permutationsListGenerator2(4);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
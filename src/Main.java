import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}

import java.util.ArrayList;
import java.util.List;

class HotDrink {
    private String name;
    private int volume;
    private int temperature;

    public HotDrink(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", temperature=" + temperature +
                '}';
    }
}

interface VendingMachine {
    HotDrink getProduct(String name, int volume, int temperature);
}

class HotDrinkVendingMachine implements VendingMachine {
    private List<HotDrink> drinks;

    public HotDrinkVendingMachine() {
        this.drinks = new ArrayList<>();
    }

    public void addDrink(HotDrink drink) {
        drinks.add(drink);
    }

    @Override
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink drink : drinks) {
            if (drink.getName().equals(name) && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrink coffee = new HotDrink("Кофе", 200, 80);
        HotDrink tea = new HotDrink("Чай", 150, 75);
        HotDrink hotChocolate = new HotDrink("Горячий шоколад", 250, 85);

        HotDrinkVendingMachine vendingMachine = new HotDrinkVendingMachine();
        vendingMachine.addDrink(coffee);
        vendingMachine.addDrink(tea);
        vendingMachine.addDrink(hotChocolate);

        HotDrink requestedDrink = vendingMachine.getProduct("Чай", 150, 75);
        if (requestedDrink != null) {
            System.out.println("Распределенно: " + requestedDrink);
        } else {
            System.out.println("Запрошенный напиток не найден.");
        }
    }
}

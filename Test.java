import jdk.dynalink.linker.support.CompositeGuardingDynamicLinker;

public class Test {

    public static void main(String[] args) {
       Dog d = new Dog("Steve", 11, 1000, "s", 10);
       Cat c = new Cat("lori", 2, 800, true, false);
       Fish f = new Fish("Addy", 11, 30, true, 50);
        System.out.println(d.toString());
        System.out.println(d.humanYears() + " years");
        System.out.println(d.lifeExpectancy() + " years");
        System.out.println(d.value() + " dollars");

        System.out.println(c.isNice());
        System.out.println(c.compareTo(d));
        System.out.println(c.isVaccinatedAndDiseaseFree());

        System.out.println(f.lifeExpectancy() + " years");
        System.out.println(f.isVaccinatedAndDiseaseFree());
        System.out.println(f.lengthOfTimeWithoutWater() + " minutes");

    }
}


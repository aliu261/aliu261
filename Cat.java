public class Cat extends Pet implements Comparable<Cat>, TerrestrialAnimal{

    private boolean isSleeping;
    private boolean indoorCat;


    public Cat(String name, int age, double sellingPrice, boolean isSleeping, boolean indoorCat) {
        super(name, age, sellingPrice);
        this.isSleeping = isSleeping;
        this.indoorCat = indoorCat;
    }

    public Cat(String[] token){
        super(token);
    }

    @Override
    public void speak(){
        System.out.println("Meow");
    }

    public boolean isNice(){
       return false;
    }
    @Override
    public int humanYears() {
        if(age == 1)
            return 15;
        if(age == 2)
            return 24;
        if(age > 2)
            return 24 + 4 * (age -2);
        return 0;
    }

    @Override
    public int lifeExpectancy() {
        return 15;
    }

    @Override
    public double dailyFoodNeeds() {
        if(indoorCat)
        return 0;
        return 1;
    }

    @Override
    public double dailyExerciseTime() {
        if(isSleeping){
            System.out.println("Let the cat sleep! It will be mean if you wake it up!");
            return 0;
        }
        return 30;
    }

    @Override
    public String toText(){
        return "Cat\t" + name + "\t" + age + "\t" + sellingPrice;
    }

    public String toString() {
        return "Cat\n" + super.toString() + "\nIs it an indoor cat?(Enter 'True' or 'False'): "
                + indoorCat;
    }

    public double swimTime(){
        return 5;
    }

    public double getSwimTime(){
        return swimTime();
    }

    public int compareTo(Cat o) {
        if (getSwimTime() > o.getSwimTime())
            return 1;
        else if (getSwimTime() < o.getSwimTime())
            return -1;
        else
            return 0;
    }
}

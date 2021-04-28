import java.util.Date;

public abstract class Pet {
    protected static int numberOfPets;
    protected String name;
    protected int age;
    protected double sellingPrice;

    int x = Pet.getNumberOfPets();

    public Pet(String name, int age, double sellingPrice) {
        this.name = name;
        this.age = age;
        this.sellingPrice = sellingPrice;
    }

    public Pet(String[] token) {
    }

    public static int getNumberOfPets() {
        return numberOfPets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double value(){
        return sellingPrice - (age * 0.06*(sellingPrice));
    }

    public boolean isVaccinatedAndDiseaseFree(){
        return true;
    }

    public double getValue(){
        return value();
    }

    public double compareTo(Pet that) {
        return this.sellingPrice - that.sellingPrice;
    }

    public abstract int humanYears();

    public abstract int lifeExpectancy();

    public abstract double dailyFoodNeeds();

    public abstract double dailyExerciseTime();

    public abstract void speak();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet that = (Pet) o;
        return sellingPrice == that.sellingPrice;
    }

    public abstract String toText();



    @Override
    public String toString() {
        return "{" +
                "Name = " + name +
                ", Age = " + age +
                ", Selling Price = $" + sellingPrice +
                '}';
    }
}



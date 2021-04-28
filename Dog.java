public class Dog extends Pet implements Comparable<Dog>, TerrestrialAnimal{
    private String breed;
    private double size;


    public Dog(String name, int age, double sellingPrice, String breed, double size){
        super(name, age, sellingPrice);
        this.breed = breed;
        this.size = size;
    }

    public Dog(String[] token){
        super(token);
    }

    @Override
    public void speak() {
        System.out.println("Woof");
    }

    public void yell(){
        System.out.println("WOOF WOOF WOOF");
    }

    @Override
    public int humanYears() {
        if(age < 1)
            return 0;
        if(age == 1)
            return 15;
        if(age == 2)
            return 24;
        if(age == 3)
            return 28;
        if(age == 4)
            return 32;
        if(age == 5)
            return 36;
        if(age == 6)
            if(breed.equals("b"))
                return 45;
            if(breed.equals("s"))
                return 40;
            if(breed.equals("m"))
                return 42;
        if( age > 6 && age < 16)
            if(breed.equals("b"))
                return age *= 5.5;
            if(breed.equals("s"))
                return age *= 4;
            if(breed.equals("m"))
                return age *= 4.5;

            else
                return age * 7;


    }

    @Override
    public int lifeExpectancy() {
        if(breed.equals("s"))return 16;
        if(breed.equals("b"))return 10;
        return 13;
    }

    @Override
    public double dailyFoodNeeds() {

        if(size >= 3 && size <= 6 )return (1.0/3);
        if(size > 6 && size <= 9 ) return (2.0/3);
        if(size > 9 && size <= 13) return 1;

        if(size > 13 && size <= 15.5 ) return (1 + 1.0/9);
        if(size > 15.5 && size <= 18) return (1 + 1.0/6);
        if(size > 18 && size <= 21 ) return (1+ 1.0/3);

        if(size > 21 && size <= 25.5) return (1 + 2.0/3);
        if(size > 25.5 && size <= 30) return (1 + 3.0/4);
        if(size > 30 && size <= 35) return (2);

        if(size > 35 && size <= 40 )return (2 + 1.0/4);
        if(size > 40 && size <= 45) return (2 + 1.0/3);
        if(size > 45 && size <= 50) return (2 + 2.0/3) ;

        if(size > 50 && size <= 58 ) return (3);
        if(size > 58 && size <= 66) return (3 + 1.0/3);
        if(size > 66 && size <= 75) return (3 + 2.0/3);

        if(size > 76 && size <= 84) return (3 + 3.0/4);
        if(size > 84 && size <= 92) return (4);
        if(size > 92 && size <= 100) return ( 4 + 1.0/4);

        if(size > 100) return (4.25 + 0.025 * (size - 100));

        else return 0;
    }

    @Override
    public double dailyExerciseTime() {
        if(breed.equals("b")) return 60;
        return 30;
    }

    @Override
    public String toText(){
        return "Dog\t" + name + "\t" + age + "\t" + sellingPrice;
    }

    public String toString() {
        return "Dog\n" + super.toString() + "\nSize: "
                + size + " lbs";
    }

    public double swimTime(){
        return 10;
    }

    public double getSwimTime(){
        return swimTime();
    }

    public int compareTo(Dog o) {
        if (getSwimTime() > o.getSwimTime())
            return 1;
        else if (getSwimTime() < o.getSwimTime())
            return -1;
        else
            return 0;
    }


}

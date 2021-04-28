public class Fish extends Pet {
    private boolean freshWater;
    private double waterVolume;

    public Fish(String name, int age, double sellingPrice, boolean freshWater, double waterVolume){
        super(name, age, sellingPrice);
        this.freshWater = freshWater;
        this.waterVolume = waterVolume;
    }

    public Fish(String[] token){
        super(token);
    }

    @Override
    public void speak(){
        System.out.println("Purrr");
    }

    @Override
    public int humanYears() {
        return age * 5;
    }

    @Override
    public int lifeExpectancy() {
        return 4;
    }

    @Override
    public double dailyFoodNeeds() {
        return 0.01;
    }

    @Override
    public double dailyExerciseTime() {
        return 0;
    }

    public int lengthOfTimeWithoutWater(){
        return (int)((Math.random() * (10 - 3)) + 3);
    }

    public int waterChangeFrequency(){
        return (int)((Math.random() * (14 - 7)) + 7);
    }

    public double waterChangeAmount(double waterVolume){
        if(freshWater)
            return 0.25 * waterVolume;
        return 0.15 * waterVolume;
    }

    @Override
    public String toText(){
        return "Fish\t" + name + "\t" + age + "\t" + sellingPrice;
    }


        public String toString() {
        return "Fish\n" + super.toString() + "\nSurvival Time Without Water:  "
                + lengthOfTimeWithoutWater() + " minutes";
    }
}

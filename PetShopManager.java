import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class PetShopManager {

    private static PetShop store = new PetShop(4);

    public static void main(String[] args) {
        char command;
        Scanner input = new Scanner(System.in);
        printMenu();


        do {
            System.out.print("Please enter a command or type ?: ");
            command = input.nextLine().charAt(0);
            //System.out.println();

            switch (command) {
                case 'a':

                    int typeOfPet = -1;
                    while (typeOfPet < 1 || typeOfPet > 3) {
                        System.out.print("Enter 1 for dog, 2 for cat, 3 for fish: ");
                        typeOfPet = Integer.parseInt(input.nextLine());
                    }

                    System.out.print("Name: ");
                    String name = input.nextLine();
                    if (name.equals("true")) {
                    }

                    System.out.print("Age: ");
                    int age = Integer.parseInt(input.nextLine());

                    System.out.print("Price: $");
                    int price = Integer.parseInt(input.nextLine());

                    Pet b = null;

                    if (typeOfPet == 1) {
                        System.out.print("Breed(Enter 's' for small, 'b' for big, 'm' for medium): ");
                        String breed = input.nextLine();

                        System.out.print("Size(# of pounds): ");
                        double size = Double.parseDouble(input.nextLine());
                        b = new Dog(name, age, price, breed, size);

                    } else if (typeOfPet == 2) {
                        System.out.print("Is it sleeping?(Enter 'true' or 'false'): ");
                        boolean sleeping = Boolean.parseBoolean(input.nextLine());

                        System.out.print("Is it an indoor cat?(Enter 'true' or 'false'): ");
                        boolean indoor = Boolean.parseBoolean(input.nextLine());


                        b = new Cat(name, age, price, sleeping, indoor);

                    } else if (typeOfPet == 3) {
                        System.out.print("Is the water fresh?(Enter 'true' or 'false'): ");
                        boolean fresh = Boolean.parseBoolean(input.nextLine());

                        System.out.println("How much water is in the tank?(# of liters): ");
                        double volume = Double.parseDouble(input.nextLine());

                        b = new Fish(name, age, price, fresh, volume);
                    }
                    store.add(b);
                    System.out.println("Pet successfully added!");
                    break;

                case 'b':

                    System.out.print("Price: $");
                    double currentValue = Double.parseDouble(input.nextLine());
                    Pet temp = store.find(currentValue);

                    if (temp != null) {
                        store.sell(temp);
                        System.out.println("Pet successfully sold!");
                        System.out.println("Money made: $" + store.getMoneyMade());
                    }

                    break;

                case 'c':
                    System.out.println(store.toString());
                    break;

                case 'd':
                    System.out.printf("House contains %d pets.\n", store.getCount());
                    break;

                case 'e':
                    printMenu();
                    break;

                case 'f':
                    System.out.println("Goodbye!");
                    break;

            }
            System.out.println();

        } while (command != 'f');

    }

    private static void printMenu() {
        String output = "Pet Store Options\n---------------\n\n";
        output += "a: add a pet\n";
        output += "b: sell a pet\n";
        output += "c: display house\n";
        output += "d: house count\n";
        output += "e: print menu\n";
        output += "f: quit\n";
        System.out.println(output);
    }

    public static int readPets(String filename) throws FileNotFoundException {
        Scanner fileScan = new Scanner(filename);
        int count = 0;
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            try {
                store.add(parsePet(line));
                count++;
            } catch (PetFileFormatException e) {
                System.out.println("Horrible pet info, line skipped");
            } catch (ParseException e) {
                System.out.println("Invalid format detected, line skipped.");
            }
        }
        fileScan.close(); //closes the scanner
        return count;
    }

    public static Pet parsePet(String data) throws PetFileFormatException, ParseException {
        String[] tokens = data.split("\t");
        if (tokens.length != 3) throw new PetFileFormatException("Pet data format invalid");
        if (tokens[0].equals("Dog")) {
            return new Dog(tokens) {
            };
        }

        if (tokens[0].equals("Cat")) {
            return new Cat(tokens) {
            };
        }

        if (tokens[0].equals("Fish")) {
            return new Fish(tokens) {
            };
        }


        return null;
    }
}




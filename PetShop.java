import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PetShop {

    private Pet[] Store;

    private int count;

    private double moneyMade;

    public PetShop(int number)
    {
        count = 0;
        Store = new Pet[number];
        moneyMade = 0;
    }

    public int getCount(){
        return count;
    }

    public double getMoneyMade(){
        return moneyMade;
    }


    public boolean sell(Pet b){

        if(!contains(b)) return false;

        int loc = indexOf(b); // must be >= 0
        Store[loc] = Store[count-1];
        Store[count-1] = null;
        moneyMade += b.getValue();
        count--;
        return true;
    }

    public int indexOf(Pet b){
        for(int i = 0; i < count; i++){
            if(Store[i].equals(b))
                return i;
        }
        return -1;
    }

    public boolean contains(Pet b){
        return indexOf(b) != -1;
    }

    public boolean add(Pet b){

        if(contains(b)) return false;
        if (full()) doubleCapacity();
        Store[count++] = b;
        return true;
    }

    public Pet find(double sellingPrice) {
        for (int i = 0; i < count; i++)
            if (Store[i].sellingPrice == sellingPrice) return Store[i];
        return null;
    }

    private void doubleCapacity() {
        Pet[] b = new Pet[Store.length * 2];
        System.arraycopy(Store, 0, b, 0, count);
        Store = b;
    }

    private boolean greater(Pet temp, Pet j) {
        return temp.getValue() > j.getValue();
    }

    private boolean full() {
        return count == Store.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; i++){

            sb.append(Store[i].toString() + "\n");
        }

        return sb.toString();
    }

    public int writePets(String filename) throws FileNotFoundException {
        int petN = 0;

        File file = new File(filename);
        PrintWriter output = new PrintWriter(file);

        for (Pet pet : Store) {
            output.println(pet.toText());
            petN++;
        }
        output.close();
        return petN;
    }


}

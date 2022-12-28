import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name,double initial) {
        this.name = name;
        this.transactions=new ArrayList<Double>();
        transactions.add(initial);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }
    public void addTransaction(double transaction){
        transactions.add(transaction);
    }
}

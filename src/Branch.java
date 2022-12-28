import java.util.ArrayList;

public class Branch {
    private  String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<Customer>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
    public boolean newCustomer(String name,double initial){
        Customer customer=findCustomer(name);
        if(customer!=null){
            return false;
        }else{
            Customer c=new Customer(name,initial);
            customers.add(c);
            return true;
        }
    }
    public  boolean addCustomerTransaction(String name,double transaction){
        Customer find=findCustomer(name);
        if(find!=null){
            find.addTransaction(transaction);
            return true;
        }else{
            return false;
        }

    }
    private Customer findCustomer(String name){
        for(int i=0;i<customers.size();i++){
            Customer c=customers.get(i);
            if(c.getName()==name) {
                return c;
            }
        }
        return null;
    }
}

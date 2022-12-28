import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches=new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName){
        Branch branch=findBranch(branchName);
        if(branch!=null){
            return false;
        }else{
            Branch b1=new Branch(branchName);
            branches.add(b1);
            return true;
        }
    }
    public boolean addCustomer(String branchName,String customerName,double initTransaction){
        Branch find=findBranch(branchName);
        if(find!=null){
            return find.newCustomer(customerName,initTransaction);
        }else{
            return false;
        }
    }
    public boolean addCustomerTransaction(String branchName,String customerName,double transaction){
        Branch find=findBranch(branchName);
        if(find!=null){
            return find.addCustomerTransaction(customerName,transaction);
        }else{
            return false;
        }
    }
    private Branch findBranch(String name){
        for(int i=0;i<branches.size();i++){
            Branch b=branches.get(i);
            if(b.getName()==name){
                return b;
            }
        }
        return null;
    }
    public boolean listCustomers(String branchName,boolean print){
        Branch find=findBranch(branchName);
        if(find!=null){
            System.out.println("Customer details for branch "+branchName);
            ArrayList<Customer> customer=find.getCustomers();
            if(print){
                for(int i=0;i<customer.size();i++){
                    System.out.println("Customer: "+customer.get(i).getName()+"["+(i+1)+"]");
                    ArrayList<Double> transaction=customer.get(i).getTransactions();
                    System.out.println("Transactions");
                    for(int j=0;j<transaction.size();j++){

                        System.out.println("["+(j+1)+"] "+" Amount "+transaction.get(j));
                    }
                }
            }
            else
            {
                for(int i=0;i<customer.size();i++)
                {
                    System.out.println("Customer: "+customer.get(i).getName()+"["+(i+1)+"]");
                }
            }
            return true;
        }
        return false;
    }
}

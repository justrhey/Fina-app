package  com.example.fina;



public class Transaction {
    public int id;

    public String description;
    public double amount;
    public String date;

    public Transaction(String description, double amount, String date){
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

}

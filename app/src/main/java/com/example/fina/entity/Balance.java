package com.example.fina.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "balance")
public class Balance {
    @PrimaryKey(autoGenerate = true)
    public int id = 1;

    public double totalBalance;

    public double current_balance;

    public Balance() {}
    @Ignore
    public Balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public double setCurrenttBalance(){
        return  current_balance;
    }
    public void getCurrentBalance(double current_balance){
        this.current_balance = current_balance;
    }

    public int getId(){
        return  id;
    }
    public void  setId(int id){
        this.id = id;
    }
    public double getTotalBalance(){
        return totalBalance;
    }
    public void setTotalBalance(double totalBalance){
        this.totalBalance = totalBalance;
    }

    @Entity(tableName = "transactions")
    public static class Transaction {

        @PrimaryKey(autoGenerate = true)
        public int id;

        public String description;
        public String date;
        public String category;
        public double amount;

        public Transaction() {
        }

        public Transaction(String description, String date, String category, double amount) {
            this.description = description;
            this.date = date;
            this.category = category;
            this.amount = amount;
        }

        //Getters
        public  int getId() {
            return id;

        }
        public String getDescription(){
            return description;
        }
        public String getCategory(){
            return category;
        }
        public double getAmount(){
            return amount;
        }


        //setters
        public void setDescription(String description){
            this.description = description;
        }
        public void setCategory(String category){
            this.category = category;
        }
        public void setAmount(double amount){
            this.amount = amount;
        }


        //parsing
        public String toString(){
            return "Transaction{" +
                    "transactionId=" + id +
                    ", description='" + description  +  '\'' +
                    ", category='" + category + '\'' +
                    ", amount='" + amount + '\''  +
                    '}';
            }
        }
}

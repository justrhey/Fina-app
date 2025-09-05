package com.example.fina.main_function;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fina.Balance;
import com.example.fina.R;
import com.example.fina.Transaction;
import com.example.fina.data_processing.Balance_data_access_object;
import com.example.fina.data_processing.Transaction_data_access_object;
import com.example.fina.database.Fina_DB;

public class MainActivity extends AppCompatActivity {

    EditText inputAmount;
    Button button_add_transaction;
    TextView balanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        inputAmount = findViewById(R.id.inputAmount);
        button_add_transaction = findViewById(R.id.button_add_transaction);
        balanceText = findViewById(R.id.balanceText);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button_add_transaction.setOnClickListener(v -> {
            String amount_txt = inputAmount.getText().toString().trim();


            try {
                double amount = Double.parseDouble(amount_txt);

                // Show loading indicator
                button_add_transaction.setEnabled(false);
                button_add_transaction.setText("Adding...");

                new Thread(() -> {
                    try {
                        Fina_DB database = Fina_DB.getInstance(getApplicationContext());

                        Transaction_data_access_object tdao = database.transactionDao();
                        Balance_data_access_object bdao = database.balanceDao();



                        // Insert balance (for testing)
                        bdao.insert(new Balance(amount));

                        Double total = bdao.getAllBalance();
                        if (total == null) total = 0.0;
                        double finalTotal = total;

                        runOnUiThread(() -> {
                            balanceText.setText("₱" + String.format("%.2f", finalTotal));
                            inputAmount.setText("");
                            button_add_transaction.setEnabled(true);
                            button_add_transaction.setText("Add Transaction");
                            Toast.makeText(this, "Transaction added successfully", Toast.LENGTH_SHORT).show();
                        });

                    } catch (Exception e) {
                        Log.e("DB-ERROR", "Database error: " + e.getMessage());
                        runOnUiThread(() -> {
                            button_add_transaction.setEnabled(true);
                            button_add_transaction.setText("Add Transaction");
                            Toast.makeText(this, "Error adding transaction", Toast.LENGTH_SHORT).show();
                        });
                    }
                }).start();

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
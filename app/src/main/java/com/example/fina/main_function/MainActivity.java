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

        setContentView(R.layout.login_page);


    }
}
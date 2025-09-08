package com.example.fina.log_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fina.R;
import com.example.fina.main_function.MainActivity;

public class LogInPage extends AppCompatActivity {

    // Inner class for user credentials
    public static class UserCredentials {
        private String email;
        private String password;

        public UserCredentials(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getUserEmail() {
            return email;
        }

        public String getUserPassword() {
            return password;
        }
    }

    private UserCredentials validUser;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.login_page);

        // Initialize the valid user credentials (this would normally come from a database)
        validUser = new UserCredentials("Justine@fina.app.com", "Trixie123");

        // Find the UI elements from the layout
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Set up the login button click listener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered email and password
                String enteredEmail = editTextEmail.getText().toString().trim();
                String enteredPassword = editTextPassword.getText().toString().trim();

                // Validate the credentials
                if (validateCredentials(enteredEmail, enteredPassword)) {
                    // Login successful - navigate to main activity
                    Toast.makeText(LogInPage.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                    // Intent to navigate to MainActivity (replace with your actual main activity)
                    Intent intent = new Intent(LogInPage.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Close the login activity

                } else {
                    // Login failed - show error message
                    Toast.makeText(LogInPage.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to validate user credentials
    private boolean validateCredentials(String email, String password) {
        // Check if fields are not empty
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check if credentials match the valid user
        return email.equals(validUser.getUserEmail()) && password.equals(validUser.getUserPassword());
    }
}
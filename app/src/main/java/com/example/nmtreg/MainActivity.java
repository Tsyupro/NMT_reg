package com.example.nmtreg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etSurname, etEmail;
    private DatePicker datePicker;
    private CheckBox cbMath, cbPhysics, cbChemistry;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        datePicker = findViewById(R.id.datePicker);
        cbMath = findViewById(R.id.cbMath);
        cbPhysics = findViewById(R.id.cbPhysics);
        cbChemistry = findViewById(R.id.cbChemistry);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            String name = etName.getText().toString();
            String surname = etSurname.getText().toString();
            String email = etEmail.getText().toString();
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();

            StringBuilder subjects = new StringBuilder();
            if (cbMath.isChecked()) subjects.append("Математика ");
            if (cbPhysics.isChecked()) subjects.append("Фізика ");
            if (cbChemistry.isChecked()) subjects.append("Хімія ");

            String message = "Ім'я: " + name + "\nПрізвище: " + surname + "\nEmail: " + email +
                    "\nДата народження: " + day + "/" + month + "/" + year +
                    "\nПредмети: " + subjects.toString();

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });
    }
}

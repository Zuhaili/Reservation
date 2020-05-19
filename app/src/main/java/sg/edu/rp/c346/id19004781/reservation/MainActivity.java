package sg.edu.rp.c346.id19004781.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, pax;
    DatePicker dp;
    TimePicker tp;
    CheckBox ckSmoke;
    Button btnConfirm, btnReset;
    TextView tvDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        phone = findViewById(R.id.editPhoneNum);
        pax = findViewById(R.id.editSizeGroup);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        ckSmoke = findViewById(R.id.checkBoxSmoking);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.editTextMessage1);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Personname = name.getText().toString();
                String phonenum = phone.getText().toString();
                String numPax = pax.getText().toString();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();


                tvDisplay.setText("Name: " + Personname + "Mobile number: " + phonenum + "Pax: " + numPax + "Date is " + day + "/" + month + "/" + year);
                tvDisplay.setText("Time is " + hour + ":" + minute);

                if (ckSmoke.isChecked()) {
                    tvDisplay.setText("Smoking Area");
                    Toast.makeText(MainActivity.this, "Hi, Sir/Mdm " + Personname + " , you have book a reservation table for " + numPax + " person(s) at this date " + day + "/" + month + "/" + year + " and this time " + hour + ":" + minute , Toast.LENGTH_SHORT).show();
                } else {
                    tvDisplay.setText("Non-Smoking Area");
                    Toast.makeText(MainActivity.this, "Hi, Sir/Mdm " + Personname + " , you have book a reservation table for " + numPax + " person(s) at this date " + day + "/" + month + "/" + year + " and this time " + hour + ":" + minute , Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 0, 1);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                name.setText("");
                phone.setText("");
                pax.setText("");
                tvDisplay.setText("");
            }
        });
    }
}

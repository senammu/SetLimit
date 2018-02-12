package com.example.sentha.setlimit;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button button;
    Calendar calendar ;
    TimePickerDialog timePickerDialog ;
    int CalendarHour, CalendarMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        calendar = Calendar.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);

                CalendarMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = TimePickerDialog.newInstance(MainActivity.this, CalendarHour, CalendarMinute, true);

                timePickerDialog.setThemeDark(false);

                timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                        Toast.makeText(MainActivity.this, "Time Not Selected", Toast.LENGTH_SHORT).show();
                    }
                });

                timePickerDialog.show(getFragmentManager(), "Material Design TimePicker Dialog");


            }
        });
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

        int Hour = 0 ;

        if(hourOfDay > 12)
        {
            switch (hourOfDay)
            {
                case 13 :
                    Hour = 1 ;
                    break;

                case 14 :
                    Hour = 2 ;
                    break;

                case 15 :
                    Hour = 3 ;
                    break;

                case 16 :
                    Hour = 4 ;
                    break;

                case 17 :
                    Hour = 5 ;
                    break;

                case 18 :
                    Hour = 6 ;
                    break;

                case 19 :
                    Hour =  7;
                    break;

                case 20 :
                    Hour = 8 ;
                    break;

                case 21 :
                    Hour = 9 ;
                    break;

                case 22 :
                    Hour = 10 ;
                    break;

                case 23 :
                    Hour = 11 ;
                    break;

                case 24 :
                    Hour = 12 ;
                    break;
            }

        }
        else {

            Hour = hourOfDay ;
        }

        String SelectedTime = "Selected Time is " + Hour + " : " + minute ;


        Toast.makeText(MainActivity.this, SelectedTime, Toast.LENGTH_LONG).show();
    }

}

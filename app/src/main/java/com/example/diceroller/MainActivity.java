package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int Score = 0;
    int userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void On_Button_Click (View view) {
       TextView tv = this.findViewById(R.id.textView);
       TextView congrats = this.findViewById(R.id.textViewCon);
       TextView score = this.findViewById(R.id.textViewScore);

       Random r = new Random();
       int number = 0;

       while (true){
           number = r.nextInt(7);
           if(number !=0) break;
       }
       tv.setText(Integer.toString(number));
       score.setText("Score: "+Score);

       EditText Input;
       Input = this.findViewById(R.id.UserInput);
       userChoice = Integer.valueOf(Input.getText().toString());

       if(userChoice == number){
           Score = Score + 1;
           score.setText("Score: " +Score);
           congrats.setText("Congratulations!");
       }
       else{
           congrats.setText("Wrong");
       }
    }


}

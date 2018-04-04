package balta.sports_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interface1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface1);
        Button i1Button = (Button) findViewById(R.id.i1button);

        //Passer à l'activité suivante en appuyant sur start
        i1Button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                connectUser();
            }
        });

    }

    //Procédure pour aller à l'activité suivante
    private void connectUser(){
        Intent intent = new Intent(interface1.this, interface2.class);
        startActivity(intent);
    }

}

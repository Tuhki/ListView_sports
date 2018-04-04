package balta.sports_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class interface4 extends AppCompatActivity {

    private final String EXTRA_NOM = "nom";
    private final String EXTRA_PRENOM = "prénom";
    private final Integer EXTRA_SPORT = 0;
    private TextView titre;
    private ListView myList;
    private Button accueil;
    private TextView donnees;

    /* Tableau contenant les noms de sports */
    private String[] sportsArray = new String[]{
            "Badmiton", "Escrime", "Escalade"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface4);

        titre = (TextView) findViewById(R.id.i4titre);
        myList = (ListView) findViewById(R.id.i4listSports);
        accueil = (Button)  findViewById(R.id.i4accueil);
        donnees = (TextView) findViewById(R.id.i4donnees);
        final Intent currentIntent = getIntent();
        currentIntent.getStringExtra(EXTRA_NOM);
        currentIntent.getStringExtra(EXTRA_PRENOM);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(interface4.this,
                android.R.layout.simple_list_item_1, sportsArray);

        /* On affiche l'identité de l'utilisateur */
        donnees.setText(EXTRA_PRENOM + " " + EXTRA_PRENOM);

        /* On affiche la liste des sports */
        myList.setAdapter(adapter);

        /* On regarde si l'utilisateur appuie sur un des sports */
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) myList.getItemAtPosition(position);
                /* On va vers l'autre activité concernant le sport sélectionné */
                final Intent sportIntent = new Intent(interface4.this, interface5.class);
                sportIntent.putExtra("EXTRA_SPORT", position);
                startActivity(sportIntent);
            }
        });

        /* Si on clique sur le bouton accueil, on retourne à l'activité précédente */
        accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            //En cas de clic sur le bouton
            public void onClick(View view){
                //Créer une procédure pour passer à l'activité suivante
                goToActivity(interface3.class);
            }
        });

    }

    private void goToActivity (Intent currentIntent, Class activity) {
        Intent intent = new Intent(interface4.this, activity);
        intent.putExtra(EXTRA_NOM, currentIntent.getStringExtra(EXTRA_NOM));
        intent.putExtra(EXTRA_PRENOM, currentIntent.getStringExtra(EXTRA_PRENOM));
        startActivity(intent);
    }

}

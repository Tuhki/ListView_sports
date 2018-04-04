package balta.sports_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class interface3 extends AppCompatActivity {

    //Constantes de transfert de données
    private final String EXTRA_CIVIL = "civilité";
    private final String EXTRA_NOM = "nom";
    private final String EXTRA_PRENOM = "prénom";
    private final String EXTRA_JOURN = "jourN";
    private final String EXTRA_MOISN = "moisN";
    private final String EXTRA_ANN = "anN";
    private final String EXTRA_MAIL = "mail";
    private final String EXTRA_ADRESSE = "adresse";
    private final String EXTRA_COMMENT = "comment";

    //Widgets
    private TextView infos;
    private Button sports;
    private Button accueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface3);

        infos = (TextView) findViewById(R.id.i3infos);
        sports = (Button) findViewById(R.id.i3sports);
        accueil = (Button) findViewById(R.id.i3accueil);

        //On récupère les informations saisies par l'utilisateur
        final Intent currentIntent = getIntent();
        currentIntent.getStringExtra(EXTRA_CIVIL);
        currentIntent.getStringExtra(EXTRA_NOM);
        currentIntent.getStringExtra(EXTRA_PRENOM);
        currentIntent.getStringExtra(EXTRA_JOURN);
        currentIntent.getStringExtra(EXTRA_MOISN);
        currentIntent.getStringExtra(EXTRA_ANN);
        currentIntent.getStringExtra(EXTRA_MAIL);
        currentIntent.getStringExtra(EXTRA_ADRESSE);
        currentIntent.getStringExtra(EXTRA_COMMENT);

        //On affiche les infos dans le texte
        infos.setText(EXTRA_CIVIL + " " + EXTRA_NOM + " " + EXTRA_PRENOM + "\n");
        infos.append("Né(e) le " + EXTRA_JOURN + "/" + EXTRA_MOISN + "/" + EXTRA_ANN + "\n");
        infos.append(EXTRA_MAIL + "\n");
        infos.append(EXTRA_ADRESSE + "\n");
        infos.append(EXTRA_COMMENT);

        //On se dirige vers l'écran des sports
        sports.setOnClickListener(new View.OnClickListener() {

            @Override
            //En cas de clic sur le bouton
            public void onClick(View view){
                //Créer une procédure pour passer à l'activité suivante
                goSports(currentIntent);

            }

        });

    }

    public void goSports(Intent currentIntent){
        //Passer à l'interface 4
        Intent nextIntent = new Intent(interface3.this, interface4.class);
        nextIntent.putExtra(EXTRA_NOM, currentIntent.getStringExtra(EXTRA_NOM));
        nextIntent.putExtra(EXTRA_PRENOM, currentIntent.getStringExtra(EXTRA_PRENOM));
        startActivity(nextIntent);
    }
}

package balta.sports_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class interface2 extends AppCompatActivity {

    //Constantes de transfert de données
    private final String EXTRA_CIVIL    = "civilité";
    private final String EXTRA_NOM      = "nom";
    private final String EXTRA_PRENOM   = "prénom";
    private final String EXTRA_JOURN    = "jourN";
    private final String EXTRA_MOISN    = "moisN";
    private final String EXTRA_ANN      = "anN";
    private final String EXTRA_MAIL     = "mail";
    private final String EXTRA_ADRESSE  = "adresse";
    private final String EXTRA_COMMENT  = "comment";

    //Widgets
    private TextView    civil;
    private RadioButton btnMme;
    private RadioButton btnMr;
    private EditText    nom;
    private EditText    prenom;
    private EditText    jour;
    private EditText    mois;
    private EditText    an;
    private EditText    mail;
    private EditText    adresse;
    private EditText    comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface2);

        //Associer physiquement les objets de la classe java aux objets de l'interface
        btnMme      = (RadioButton) findViewById(R.id.i2madame);
        btnMr       = (RadioButton) findViewById(R.id.i2monsieur);
        nom         = (EditText)    findViewById(R.id.i2nom);
        prenom      = (EditText)    findViewById(R.id.i2prenom);
        jour        = (EditText)    findViewById(R.id.i2jour);
        mois        = (EditText)    findViewById(R.id.i2mois);
        an          = (EditText)    findViewById(R.id.i2an);
        mail        = (EditText)    findViewById(R.id.i2mail);
        adresse     = (EditText)    findViewById(R.id.i2adresse);
        comment     = (EditText)    findViewById(R.id.i2comment);
        Button btnValider = (Button) findViewById(R.id.i2valider);
        final Intent intent = new Intent(interface2.this, interface1.class);

        //Passer à l'activité suivante en appuyant sur le bouton valider
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationFormulaire(intent);
            }
        });
    }

    // On vérifie quel bouton est sélectionné et on récupère sa valeur
    public void onRadioButtonClicked(Intent intent) {
        if (btnMme.isChecked()) {
            intent.putExtra(EXTRA_CIVIL, btnMme.getText().toString());
        }
        if (btnMr.isChecked()) {
            intent.putExtra(EXTRA_CIVIL, btnMr.getText().toString());
        }
    }

    //Procédure pour aller à l'activité suivante
    private void validationFormulaire(Intent intent){
        intent.putExtra(EXTRA_NOM, nom.getText().toString());
        intent.putExtra(EXTRA_PRENOM, prenom.getText().toString());
        intent.putExtra(EXTRA_JOURN, jour.getText().toString());
        intent.putExtra(EXTRA_MOISN, mois.getText().toString());
        intent.putExtra(EXTRA_ANN, an.getText().toString());
        intent.putExtra(EXTRA_MAIL, mail.getText().toString());
        intent.putExtra(EXTRA_ADRESSE, adresse.getText().toString());
        intent.putExtra(EXTRA_COMMENT, comment.getText().toString());
        startActivity(intent);
    }
}

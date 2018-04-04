package balta.sports_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class interface5 extends AppCompatActivity {

    private final String EXTRA_NOM = "nom";
    private final String EXTRA_PRENOM = "prénom";
    private final Integer EXTRA_SPORT = 0;
    private Button sports;
    private Button accueil;
    private TextView donnees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface5);

        Button sports = (Button) findViewById(R.id.i5sports);
        Button accueil = (Button) findViewById(R.id.i5accueil);
        TextView donnees = (TextView) findViewById(R.id.i5donnees);
        final Intent currIntent = getIntent();
        ArrayList<SportsClass> sportList = new ArrayList<>();

        initList(sportList);
        currIntent.getStringExtra(EXTRA_NOM);
        currIntent.getStringExtra(EXTRA_PRENOM);
        currIntent.getStringExtra(EXTRA_SPORT.toString());
        Integer position = (Integer) EXTRA_SPORT;

        /* On affiche l'identité de l'utilisateur */
        donnees.setText(EXTRA_PRENOM + " " + EXTRA_PRENOM);

        /* On affiche les infos sur le sport */
        final SportsAdapter adapter = new SportsAdapter(this, android.R.layout.simple_list_item_1, sportList);
        final ListView list = (ListView) findViewById(R.id.myList);
        list.setAdapter(adapter);
        adapter.getView(position,R.layout.interface5);

        /* Si on clique sur le bouton accueil, on retourne à l'interface 2 */
        accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            //En cas de clic sur le bouton
            public void onClick(View view){
                goToActivity(currIntent, interface3.class);
            }
        });

         /* Si on clique sur le bouton sports, on retourne à l'interface de choix des sports */
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            //En cas de clic sur le bouton
            public void onClick(View view){
                goToActivity(currIntent, interface4.class);
            }
        });
    }

    private void goToActivity (Intent currentIntent, Class activity) {
        Intent intent = new Intent(interface5.this, activity);
        intent.putExtra(EXTRA_NOM, currentIntent.getStringExtra(EXTRA_NOM));
        intent.putExtra(EXTRA_PRENOM, currentIntent.getStringExtra(EXTRA_PRENOM));
        startActivity(intent);
    }

    private void initList(ArrayList<SportsClass> List) {
        SportsClass Badminton = new SportsClass();
        Badminton.setSportImage("@mipmap/badminton");
        Badminton.setSportName("Badminton");
        Badminton.setSportDescription("Le badminton Écouter est un sport de raquette qui oppose " +
                "soit deux joueurs ou joueuses (simples), soit deux paires (doubles), " +
                "placés dans deux demi-terrains séparés par un filet. Les joueurs et joueuses, " +
                "appelés badistes, marquent des points en frappant un volant à l'aide d'une" +
                " raquette afin de le faire tomber dans le terrain adverse. " +
                "L'échange se termine dès que le volant touche le sol ou reste accroché dans le filet.");
        List.add(Badminton);

        SportsClass Escrime = new SportsClass();
        Escrime.setSportImage("@mipmap/escrime");
        Escrime.setSportName("Escrime");
        Escrime.setSportDescription("L’escrime est un sport de combat. " +
                "Il s’agit de l’art de toucher un adversaire avec la pointe " +
                "ou le tranchant (estoc et taille) d’une arme blanche sur " +
                "les parties valables sans être touché.");
        List.add(Escrime);

        SportsClass Escalade = new SportsClass();
        Escalade.setSportImage("@mipmap/escalade");
        Escalade.setSportName("Escalade");
        Escalade.setSportDescription("L’escalade, ou grimpe, parfois appelée varappe (vieilli)," +
                " est une pratique et un sport consistant à se déplacer le long d'une paroi " +
                "pour atteindre le haut d'un relief ou d'une structure artificielle, " +
                "par un cheminement appelé voie et avec ou sans aide de matériel.");
        List.add(Escalade);
    }
}

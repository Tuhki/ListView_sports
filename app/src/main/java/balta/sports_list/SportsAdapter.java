package balta.sports_list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SportsAdapter extends ArrayAdapter<SportsClass> {

    private ArrayList<SportsClass> sportList;
    private Context context;
    private int viewRes;
    private Resources res;

    protected SportsAdapter(Context context, int textViewResourceId,
                             ArrayList<SportsClass> versions) {

        super(context, textViewResourceId, versions);
        this.sportList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        /* Si la vue n'existe pas, on la crée */
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        /* On récupère l'élément de la liste à modifier */
        final SportsClass mySport = sportList.get(position);

        /* S'il y a bien un élément à modifier... */
        if (mySport != null) {

            /* On initialise les objets */
            final ImageView image = (ImageView) view.findViewById(R.id.i5image);
            final TextView name = (TextView) view.findViewById(R.id.i5nom);
            final TextView description = (TextView) view.findViewById(R.id.i5desc);

            /* On récupère les informations à afficher et on les affiche */
            final String myImage = mySport.getSportImage();
            image.setBackgroundResource(Drawable.createFromPath(myImage);
            final String myName = mySport.getSportName();
            name.setText(myName);
            final String myDesc = mySport.getSportDescription();
            description.setText(myDesc);
        }

        return view;
    }

}
package rosemak.weekthreev2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevierose on 8/17/14.
 */
public class CustomListAdapter extends ArrayAdapter {

    private Activity activity;
    private ArrayList data;
    public  Resources res;
    FantasyTeam tempValues = null;
    LayoutInflater inflater;

    //Custom adapter Constructor
    public CustomListAdapter(Main mainContext, int resource, ArrayList objects, Resources resLocal) {
        super(mainContext, resource, objects);

        activity = mainContext;
        data     = objects;
        res      = resLocal;

        inflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.row_layout, parent, false);

        tempValues = null;
        tempValues = (FantasyTeam) data.get(position);



        TextView nameLabel     = (TextView) row.findViewById(R.id.textViewPlayersName);
        TextView teamLabel     = (TextView) row.findViewById(R.id.textViewPlayersTeam);
        TextView positionLabel = (TextView) row.findViewById(R.id.textViewPlayersPosition);

        if(position == 0) {

            //Default Text
            nameLabel.setText("Fantasy Football");

        } else {

            nameLabel.setText(tempValues.getPlayerName());
            teamLabel.setText(tempValues.getPlayerTeam());
            positionLabel.setText(tempValues.getPlayerPosition());
        }


        return row;
    }
}

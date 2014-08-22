package rosemak.weekthreev2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stevierose on 8/21/14.
 */
public class SpinnersAdapter extends BaseAdapter {

    private Activity activity;
    private HashMap data;
    public Resources res;
    FantasyTeam tempValues = null;
    LayoutInflater inflater;

    public SpinnersAdapter(Main mainContext, int resource, HashMap objects, Resources resLocal ) {

        activity = mainContext;
        data     = objects;
        res      = resLocal;

        inflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        tempValues = null;
        tempValues = (FantasyTeam) data.get(position);

        TextView nameLabel     = (TextView) row.findViewById(R.id.textViewPlayersName);
        TextView teamLabel     = (TextView) row.findViewById(R.id.textViewPlayersTeam);
        TextView playerPosition = (TextView) row.findViewById(R.id.textViewPlayersPosition);

        if(position == 0) {

            //Default Text
            nameLabel.setText("Fantasy Football");

        } else {

            nameLabel.setText(tempValues.getPlayerName());
            teamLabel.setText(tempValues.getPlayerTeam());
            playerPosition.setText(tempValues.getPlayerPosition());
        }


        return row;
    }
}

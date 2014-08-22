package rosemak.weekthreev2;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class Main extends Activity {
    int key = 0;
    public ArrayList<FantasyTeam> playerDetails = new ArrayList<FantasyTeam>();
    public HashMap<Integer , FantasyTeam>  otherDetails = new HashMap<Integer,FantasyTeam>();
    TextView output = null;
    SpinnersAdapter adapter;
    Main activity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            ListView listView = (ListView) findViewById(R.id.listView);
            final TextView name     = (TextView) findViewById(R.id.textViewFPlayersName);
            final TextView team     = (TextView) findViewById(R.id.textViewFPlayersTeam);
            final TextView lPosition = (TextView) findViewById(R.id.textViewFPlayersPosition);
            activity = this;
            setListData();
            Resources res = getResources();
            CustomListAdapter listAdapter = new CustomListAdapter(activity, R.layout.spinner_rows, playerDetails, res);
            listView.setAdapter(listAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {

                    String tName = ((TextView) v.findViewById(R.id.textViewPlayersName)).getText().toString();
                    String tTeam = ((TextView) v.findViewById(R.id.textViewPlayersTeam)).getText().toString();
                    String pPosition = ((TextView) v.findViewById(R.id.textViewPlayersPosition)).getText().toString();


                    String msg = "Selected Player: \n\n" + tName + "\n" + tTeam;
                   name.setText(tName);
                    team.setText(tTeam);
                    lPosition.setText(pPosition);


                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                }
            });

        } else {
            activity = this;

            Spinner fantasyTeamSpinner = (Spinner) findViewById(R.id.spinner);
            output = (TextView) findViewById(R.id.output);

           setSpinnerData();



            Resources res = getResources();

            adapter = new SpinnersAdapter(activity, R.layout.spinner_rows, otherDetails, res);

            fantasyTeamSpinner.setAdapter(adapter);

           fantasyTeamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> parentView, View v, int position, long id) {

                   String name = ((TextView) v.findViewById(R.id.textViewPlayersName)).getText().toString();
                   String team = ((TextView) v.findViewById(R.id.textViewPlayersTeam)).getText().toString();
                   String pPosition = ((TextView) v.findViewById(R.id.textViewPlayersPosition)).getText().toString();

                   String msg = "Selected Player: \n\n" + name + "\n" +  team + "\n" + pPosition + "\n";
                   output.setText(msg);


                   Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
               }

               @Override
               public void onNothingSelected(AdapterView<?> adapterView) {

               }
           });
        }



    }

    private void setSpinnerData() {
        otherDetails.put( 1 ,new FantasyTeam ("Drew Brees", "New Orleans", "QB", 8));
        otherDetails.put( 2 ,new FantasyTeam ("Brandon Marshall", "Bears", "WR", 15));
        otherDetails.put( 3, new FantasyTeam ("Jordy Nelson", "Green Bay", "WR", 87));
        otherDetails.put( 4, new FantasyTeam  ("Antonio Brown", "Steelers", "WR", 84));
        otherDetails.put( 5, new FantasyTeam  ("Dough Martin", "Tampa Bay", "RB", 22));

    }


    private void setListData() {

        playerDetails.add(new FantasyTeam("Robert Griffin", "Washington", "QB", 86));
        playerDetails.add(new FantasyTeam("DeSean Jackson", "Washington", "WR", 92));
        playerDetails.add(new FantasyTeam("Pierre Garcon", "Washington", "WR", 88));
        playerDetails.add(new FantasyTeam("Jordan Reed", "Washington", "TE", 82));
        playerDetails.add(new FantasyTeam("Alfred Morris", "Washington", "RB", 87));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

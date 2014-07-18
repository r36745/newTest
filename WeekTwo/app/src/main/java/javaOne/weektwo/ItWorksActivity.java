package javaOne.weektwo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;


public class ItWorksActivity extends Activity {

    private Button doneButton, clickButton;
    private TextView totalTextView,medianAvgTextView, selectionTextView;
    private ArrayList usernameArrayList;
    private EditText numSelectEditText, inputNameEditText;
    private  int personNameCount = 0, medianCalc;
    private String personName, personNameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_works);

        inputNameEditText = (EditText) findViewById(R.id.inputNameEditText);
        numSelectEditText = (EditText) findViewById(R.id.numSelectEditText);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        medianAvgTextView = (TextView) findViewById(R.id.medianAvgTextView);
        selectionTextView = (TextView) findViewById(R.id.selectionTextView);

        usernameArrayList = new ArrayList<String>();



        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personName = String.valueOf(inputNameEditText.getText());

                if (personName.length() != 0) {
                    usernameArrayList.add(personName);
                    personNameCount = usernameArrayList.size();

                    personNameString = Integer.toString(personNameCount);


                    totalTextView.setText(personNameString);


                    Collections.sort(usernameArrayList);
                    Log.i("Collections","array =" +usernameArrayList);

                    onCalc(personNameCount);

                } else {
                    String noResponse = "Need Input";
                    Toast.makeText(ItWorksActivity.this, noResponse, Toast.LENGTH_LONG).show();;
                }

                inputNameEditText.setText("");
            }
        });
        clickButton = (Button) findViewById(R.id.clickButton);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ItWorksActivity.this);
                alertDialog.setTitle("Alert window");
                alertDialog.setIcon(R.drawable.ic_launcher);
                alertDialog.setMessage("The Median Name You Requested ");
                final TextView personsName = new TextView(ItWorksActivity.this);
                personsName.setText(personName);
                alertDialog.setView(personsName);
                alertDialog.setPositiveButton("Remove", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int buttonID){
                            final String removedName = String.valueOf(usernameArrayList.get(medianCalc).toString());
                            usernameArrayList.remove(medianCalc);
                            selectionTextView.setText(removedName);
                        ArrayList tempList = usernameArrayList;
                        Log.i("TempList","New Array" +tempList);

                        return;
                    }
                });
                alertDialog.setNegativeButton("OK", new
                        DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int buttonID){
                            return;
                        }
            });
            alertDialog.show();
                numSelectEditText.setText("");
            }
        });

    }




    public int onCalc(int personNameCount) {

        if((usernameArrayList.size() > 2) && (usernameArrayList.size() % 2 == 1)){

             medianCalc = (personNameCount / 2);


            medianAvgTextView.setText(usernameArrayList.get(medianCalc).toString());

        } else {

            medianAvgTextView.setText("No Median");
        }
        return personNameCount;
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

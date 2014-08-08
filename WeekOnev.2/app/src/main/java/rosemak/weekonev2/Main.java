package rosemak.weekonev2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class Main extends Activity {

    private EditText editTextName, editTextIndex;
    private TextView textViewName, textViewIndex, textViewAvg;
    private Button buttonClick, buttonPush;
    private String outPut;
    private ArrayList namesArrayList;
    private int nCount = 0, collectionCount, stringLength, counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextIndex = (EditText) findViewById(R.id.editTextIndex);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAvg = (TextView) findViewById(R.id.textViewAvg);
        textViewIndex = (TextView) findViewById(R.id.textViewIndex);
        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonPush = (Button) findViewById(R.id.buttonPush);
        namesArrayList = new ArrayList<String>();


        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outPut = String.valueOf(editTextName.getText());
                stringLength = outPut.length();

                if(stringLength != 0) {
                    namesArrayList.add(outPut);
                    nCount = namesArrayList.size();
                    Log.i("Array Count", "Num Count =" +nCount);
                    String convertToString = Integer.toString(nCount);
                    textViewName.setText(convertToString);
                    Collections.sort(namesArrayList);
                    Log.i("Collections", "Name Array =" + namesArrayList);
                    collectionAvg();


                }
                    editTextName.setText("");
            }

        });

        buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempStr = String.valueOf(editTextIndex.getText());
                int tempInt = Integer.parseInt(tempStr);

                String indexString = String.valueOf(namesArrayList.get(tempInt).toString());

                if (tempInt != 0) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main.this);
                    alertDialog.setTitle("Alert Window");
                    alertDialog.setIcon(R.drawable.ic_launcher);
                    alertDialog.setMessage("Team Requested");
                    final TextView teamName = new TextView(Main.this);
                    teamName.setText(indexString);
                    alertDialog.setView(teamName);
                    alertDialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;

                        }
                    });

                    alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    alertDialog.show();
                }

                textViewIndex.setText(indexString);

                editTextIndex.setText("");
            }

        });


    }

    public int collectionAvg() {

        collectionCount = counter +=stringLength ;
        int calc = collectionCount / nCount;

        String stringCollection = Integer.toString(calc);
        textViewAvg.setText(stringCollection);


        return collectionCount ;
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

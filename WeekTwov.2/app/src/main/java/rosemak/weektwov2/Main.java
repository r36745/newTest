package rosemak.weektwov2;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;




public class Main extends Activity {

    private EditText editTextName, editTextIndex;
    private TextView textViewName, textViewIndex, textViewAvg, textViewCollection;
    private Button buttonClick, buttonPush, buttonRemove, buttonCollection;
    private String inPut;
    private ArrayList namesArrayList;
    private int nCount = 0, collectionCount, stringLength, counter=0;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextIndex = (EditText) findViewById(R.id.editTextIndex);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewName.setTypeface(null, Typeface.BOLD);
        textViewAvg = (TextView) findViewById(R.id.textViewAvg);
        textViewAvg.setTypeface(null, Typeface.BOLD);
        textViewIndex = (TextView) findViewById(R.id.textViewIndex);
        textViewIndex.setTypeface(null, Typeface.BOLD);
        textViewCollection = (TextView) findViewById(R.id.textViewCollection);
        textViewCollection.setTypeface(null, Typeface.BOLD);
        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonPush = (Button) findViewById(R.id.buttonPush);
        buttonRemove = (Button) findViewById(R.id.buttonRemove);
        buttonCollection = (Button) findViewById(R.id.buttonCollection);

        namesArrayList = new ArrayList<String>();


        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inPut = String.valueOf(editTextName.getText());
                stringLength = inPut.length();
                Log.i("Test", "test =" + stringLength);
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                    if (stringLength < 3){
                        String nameLength = "Invalid Name";
                        Toast.makeText(Main.this, nameLength, Toast.LENGTH_LONG).show();

                    }else if (namesArrayList.contains(inPut)){



                        String dupResponse = "Duplicate Response";
                        Toast.makeText(Main.this, dupResponse, Toast.LENGTH_LONG).show();


                        Log.i("Dup", "Final Response =" + namesArrayList);



                    } else {
                        Toast.makeText(Main.this, inPut, Toast.LENGTH_LONG).show();
                        namesArrayList.add(inPut);
                        nCount = namesArrayList.size();
                        Log.i("Array Count", "Num Count =" +nCount);

                        String convertToString = Integer.toString(nCount);
                        textViewName.setText(convertToString);
                        Collections.sort(namesArrayList);
                        Log.i("Collections", "Name Array =" + namesArrayList);
                        collectionAvg();
                    }






                editTextName.setText("");

                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }

        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inPut = String.valueOf(editTextName.getText());
                int position = namesArrayList.indexOf(inPut);

                if (position == -1)
                {
                    String noValue = "No Value";
                    Toast.makeText(Main.this, noValue, Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(Main.this,inPut, Toast.LENGTH_LONG).show();
                    Log.i("Position", "Position =" + position);
                    namesArrayList.remove(inPut);
                    Log.i("Log", "Positions! =" + namesArrayList);
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

                if (tempInt < namesArrayList.size() || tempInt >= 0){


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
                    textViewIndex.setText(indexString);
                }else  {
                    String noIndex = "Index does not exist";
                    Toast.makeText(Main.this, noIndex, Toast.LENGTH_LONG);
                }



                editTextIndex.setText("");
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }

        });

        buttonCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String collection = String.valueOf(namesArrayList);

                




                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main.this);
                    alertDialog.setTitle("Alert Window");
                    alertDialog.setIcon(R.drawable.ic_launcher);
                    alertDialog.setMessage("Team Requested");
                    final TextView teamName = new TextView(Main.this);
                    teamName.setText(collection);
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
                    textViewIndex.setText(collection);

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

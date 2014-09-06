package rosemak.weekonev33;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    private TextView textViewName, textViewIndex, textViewAvg, foodName;
    private Button click, push;
    private String input;
    private ArrayList foodArrayList;
    private int foodCount = 0, collectCount, stringLength, counter=0;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextIndex = (EditText) findViewById(R.id.editTextIndex);
        foodName = (TextView) findViewById(R.id.foodName);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAvg = (TextView) findViewById(R.id.textViewAvg);
        textViewIndex = (TextView) findViewById(R.id.textViewIndex);
        click = (Button) findViewById(R.id.buttonClick);
        push = (Button) findViewById(R.id.buttonPush);
        foodArrayList = new ArrayList<String>();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input = String.valueOf(editTextName.getText());
                stringLength = input.length();
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                if (stringLength == 0) {

                    Toast.makeText(Main.this, "Add Ingredient", Toast.LENGTH_LONG).show();
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                } else if(stringLength != 0) {

                    foodArrayList.add(input);
                    foodCount = foodArrayList.size();
                    foodName.setText(input);
                    Log.i("Array Count", "Num Count =" + foodCount);
                    String convertToString = Integer.toString(foodCount);
                    textViewName.setText(convertToString);
                    Collections.sort(foodArrayList);
                    Log.i("Collections", "Name Array =" + foodArrayList);
                    foodCollection();
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                }

                editTextName.setText("");
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tempStr = String.valueOf(editTextIndex.getText());
                int foodInt = Integer.parseInt(tempStr);
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                String indexString = String.valueOf(foodArrayList.get(foodInt).toString());


                if (foodInt != 0) {
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
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

            }
        });


    }

    public int foodCollection() {

        collectCount = counter +=stringLength ;
        int calc = collectCount / foodCount;

        String stringCollection = Integer.toString(calc);
        textViewAvg.setText(stringCollection);


        return collectCount ;
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

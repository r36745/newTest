package com.sextyles.weekone;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;


public class MyActivity extends Activity {
    private Button doneButton,clickButton;
    private  EditText textwindow, secondTextWindow;
    private ArrayList list;
    private TextView entryViewText, avgSizeText, selText;
    private int userCount = 0, calc, usernameSize, secondCalc;
    private String username, selString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        textwindow = (EditText) findViewById(R.id.users_name_text);
        secondTextWindow = (EditText) findViewById(R.id.numSelection);
        doneButton = (Button) findViewById(R.id.done_button);
        clickButton = (Button) findViewById(R.id.buttonClick);

        entryViewText = (TextView) findViewById(R.id.entryView);
        avgSizeText = (TextView) findViewById(R.id.avgSize);
        selText = (TextView) findViewById(R.id.selectionText);


        list = new ArrayList<String>();


    }

    private  void  displayAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setCancelable(
                false).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setNegativeButton("Remove",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public  int onCalc(int userCount)
    {
        return userCount / 2;
    }



    public void onDone(View view) {
     username = String.valueOf(textwindow.getText());


        if (username.length() != 0){
            list.add(username);
            System.out.println(username);
            usernameSize = list.size();
            Log.i("UsernameSize", "Variable c =" +usernameSize);
            String finalString = Integer.toString(usernameSize);
            entryViewText.setText(finalString);
            System.out.println(list.size());

            userCount = username.length();
            Log.i("UserCount", "Variable a =" +userCount);

            System.out.println(userCount);
            //calc = userCount / usernameSize;
            onCalc(userCount);
            Log.i("UserCount","Variable finalCount =" +onCalc(userCount));
            //secondCalc = userCount / 2;
           // Log.i("Second Calc", "Variable med =" +secondCalc);
            String totalAvg = Integer.toString(onCalc(userCount));
            avgSizeText.setText(totalAvg);
            textwindow.setText("");

        } else {
            String noResponse = "Need Input";
            Toast.makeText(this, noResponse, Toast.LENGTH_LONG).show();
        }
    }


    public void buttonClick(View view) {
        selString = String.valueOf(secondTextWindow.getText());
        Log.i("String", "Variable myString =" +selString);
        int myInt = Integer.parseInt(selString);
        displayAlert();
        list.get(myInt);

        secondTextWindow.setText("");

        Toast.makeText(this, list.get(myInt).toString(), Toast.LENGTH_LONG).show();



    }
}

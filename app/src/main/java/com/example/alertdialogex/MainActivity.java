package com.example.alertdialogex;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/*
    className : MainActivity
    createdBy : PCQ197
    UpdatedBy : 17:12
    Purpose : Hi
*/
public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    String text = "";
    String txt = "";
    String array[] = {"India", "US", "Australia", "japan", "America", "Thialend"};
    ArrayList<String> selectedItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialogInflater();

    }

    private void dialogInflater() {

        btn1 = findViewById(R.id.material_button1);
        btn2 = findViewById(R.id.material_button2);
        btn3 = findViewById(R.id.material_button3);
        btn4 = findViewById(R.id.material_button4);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialogbuilder1 = new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder1.setTitle("this is simple alert").create().show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialogbuilder2 = new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder2.setTitle("choose faviorate country");
                alertdialogbuilder2.setItems(array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
                alertdialogbuilder2.create().show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialogbuilder3 = new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder3.setTitle("choose faviorate country");
                alertdialogbuilder3.setMultiChoiceItems(array, null, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            selectedItems.add(array[which]);
                        }
                    }
                });
                alertdialogbuilder3.create().show();

            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertdialogbuilder4 = new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder4.setTitle("for authentication");
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.dialog_view, null);
                alertdialogbuilder4.setView(view);
                alertdialogbuilder4.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText edt1 = view.findViewById(R.id.editTextpassword);

                        if (edt1.getText().toString().equals("1111")) {
                            startActivity(new Intent(MainActivity.this, Ontheractivity.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "you have entered wrong password", Toast.LENGTH_SHORT).show();

                        }
                        // sign in the user ...
                    }
                })
                        .setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        }).create().show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.snakebar:
                // Toast.makeText(this, "You clicked about", Toast.LENGTH_SHORT).show();
                Snackbar snackbar1 = Snackbar.make(getWindow().getDecorView(), "you are selected the snakebar", Snackbar.LENGTH_SHORT);
                snackbar1.show();
                break;

            case R.id.logout:
                Toast.makeText(this, "You clicked logout", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("welcome");
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();

                break;


        }
        return true;


    }

}

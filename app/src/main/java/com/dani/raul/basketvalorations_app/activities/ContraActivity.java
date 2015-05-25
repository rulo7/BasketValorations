package com.dani.raul.basketvalorations_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dani.raul.basketvalorations_app.R;
import com.dani.raul.basketvalorations_app.model.TransferJugador;
import com.dani.raul.basketvalorations_app.persistance.XMLPersistance;


import java.util.ArrayList;

public class ContraActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        LinearLayout l = (LinearLayout) this.findViewById(R.id.linearLayoutPlayers);

        boolean load = false;

        if (l.getChildCount() > 0) {


            int[] jugs = new int[l.getChildCount()];
            for (int i = 0; i < l.getChildCount(); i++) {

                if(l.getChildAt(i) instanceof  EditText) {
                    EditText e = (EditText) l.getChildAt(i);
                    jugs[i] = Integer.valueOf(e.getText().toString());
                }else{
                    load = true;
                }

            }

            if(!load) {
                outState.putIntArray("jugs", jugs);
            }
        }

        outState.putBoolean("load", load);

        EditText vs = (EditText) this.findViewById(R.id.editTextVS);
        outState.putString("vs", vs.getText().toString());

        DatePicker date = (DatePicker) this.findViewById(R.id.editTextDate);
        outState.putString("date", String.valueOf(date.getDayOfMonth()) + "/" + String.valueOf(date.getMonth()) + "/" + String.valueOf(date.getYear()));

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        this.findViewById(R.id.imageButtonLoad).setOnClickListener(this);


        if (savedInstanceState != null) {

            LinearLayout l = (LinearLayout) this.findViewById(R.id.linearLayoutPlayers);

            l.removeAllViews();

            if(savedInstanceState.getIntArray("jugs") != null) {
                int[] jugs = savedInstanceState.getIntArray("jugs");
                for (int i : jugs) {
                    // Añado un campo para añadir el numero
                    EditText e = new EditText(this);
                    e.setInputType(InputType.TYPE_CLASS_NUMBER);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(10,10,10,10);
                    lp.gravity = Gravity.CENTER;
                    e.setText((l.getChildCount() + 4) + "");
                    e.setGravity(Gravity.CENTER);
                    e.setBackgroundColor(Color.WHITE);
                    //Añado al layout el edittext
                    l.addView(e, lp);
                }

                if (l.getChildCount() > 0) {
                    this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.VISIBLE);
                }

                //Cuando he añadido al menos 6 jugadores activo el boton de empezar el partido
                if (l.getChildCount() >= 5) {
                    this.findViewById(R.id.imageButtonPlay).setVisibility(View.VISIBLE);
                }
            }else if(savedInstanceState.getBoolean("load")){
                this.onClick(this.findViewById(R.id.imageButtonLoad));
            }



            EditText vs = (EditText) this.findViewById(R.id.editTextVS);
            vs.setText(savedInstanceState.getString("vs"));


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contra);

        //Añado el listener
        this.findViewById(R.id.imageButtonAdd).setOnClickListener(this);
        this.findViewById(R.id.imageButtonDeletePlayer).setOnClickListener(this);
        this.findViewById(R.id.imageButtonPlay).setOnClickListener(this);
        this.findViewById(R.id.imageButtonLoad).setOnClickListener(this);


        if (savedInstanceState != null) {

            LinearLayout l = (LinearLayout) this.findViewById(R.id.linearLayoutPlayers);

            l.removeAllViews();

            if(!savedInstanceState.getBoolean("load") && savedInstanceState.getIntArray("jugs") != null) {
                int[] jugs = savedInstanceState.getIntArray("jugs");
                for (int i : jugs) {
                    // Añado un campo para añadir el numero
                    EditText e = new EditText(this);
                    e.setInputType(InputType.TYPE_CLASS_NUMBER);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(10,10,10,10);
                    lp.gravity = Gravity.CENTER;
                    e.setText((l.getChildCount() + 4) + "");
                    e.setGravity(Gravity.CENTER);
                    e.setBackgroundColor(Color.WHITE);
                    //Añado al layout el edittext
                    l.addView(e, lp);
                }

                if (l.getChildCount() > 0) {
                    this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.VISIBLE);
                }

                //Cuando he añadido al menos 6 jugadores activo el boton de empezar el partido
                if (l.getChildCount() >= 5) {
                    this.findViewById(R.id.imageButtonPlay).setVisibility(View.VISIBLE);
                }
            }else if(savedInstanceState.getBoolean("load")){
                this.onClick(this.findViewById(R.id.imageButtonLoad));
            }


            if(savedInstanceState.getString("vs") != null) {
                EditText vs = (EditText) this.findViewById(R.id.editTextVS);
                vs.setText(savedInstanceState.getString("vs"));
            }

        }

    }

   
    @Override
    public void onClick(View v) {
        LinearLayout l = (LinearLayout) this.findViewById(R.id.linearLayoutPlayers);
        switch (v.getId()) {

            case R.id.imageButtonAdd:

                //Si es la primera vez que añado un jugador habilito el quitar jugador
                if (l.getChildCount() == 0) {
                    this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.VISIBLE);
                } else if (!(l.getChildAt(0) instanceof EditText)) {
                    l.removeAllViews();
                    this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.VISIBLE);
                }

                // Añado un campo para añadir el numero
                EditText e = new EditText(this);
                e.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10,10,10,10);
                lp.gravity = Gravity.CENTER;
                e.setText((l.getChildCount() + 4) + "");
                e.setGravity(Gravity.CENTER);
                e.setBackgroundColor(Color.WHITE);
                //Añado al layout el edittext
                l.addView(e, lp);

                //Cuando he añadido al menos 6 jugadores activo el boton de empezar el partido
                if (l.getChildCount() == 5) {
                    this.findViewById(R.id.imageButtonPlay).setVisibility(View.VISIBLE);
                }

                break;
            case R.id.imageButtonDeletePlayer:

                if (l.getChildCount() == 5) {
                    this.findViewById(R.id.imageButtonPlay).setVisibility(View.GONE);
                }

                l.removeViewAt(l.getChildCount() - 1);

                //Si elimino el ultimo campo, oculto el boton
                if (l.getChildCount() == 0) {
                    this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.GONE);
                }
                break;
            case R.id.imageButtonLoad:

                this.findViewById(R.id.imageButtonPlay).setVisibility(View.GONE);
                this.findViewById(R.id.imageButtonDeletePlayer).setVisibility(View.GONE);


                //Carga los partidos guardados en la base de datos en players


                l.removeAllViews();

                ArrayList<String> files = XMLPersistance.getFiles(this);



                // si hay partidos guardados
                if (files.isEmpty()) {
                    TextView t = new TextView(this);
                    ViewGroup.LayoutParams lpt = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    t.setText(R.string.nothing_save);
                    //Añado al layout el edittext
                    l.addView(t, lpt);
                } else {
                    for(String x: files) {
                        Button bu = new Button(this);
                        ViewGroup.LayoutParams lpt = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        bu.setText(x);
                        bu.setOnClickListener(this);
                        //Añado al layout el edittext
                        l.addView(bu, lpt);
                    }
                }

                break;

            case R.id.imageButtonPlay:

                EditText vs = (EditText) this.findViewById(R.id.editTextVS);

                DatePicker date = (DatePicker) this.findViewById(R.id.editTextDate);

                if (vs.getText().toString().matches("")) {
                    Toast.makeText(this.getApplicationContext(), "VS", Toast.LENGTH_LONG).show();
                } else {
                    int[] players = new int[l.getChildCount()];

                    for (int i = 0; i < l.getChildCount(); i++) {
                        EditText ed = (EditText) l.getChildAt(i);
                        players[i] = Integer.valueOf(ed.getText().toString());
                    }

                    Intent i = new Intent(this, ValorationsActivity.class);
                    i.putExtra("players", players);


                    i.putExtra("vs", vs.getText().toString());
                    i.putExtra("date", String.valueOf(date.getDayOfMonth()) + "/" + String.valueOf(date.getMonth()) + "/" + String.valueOf(date.getYear()));


                    this.startActivity(i);
                }

                break;

            default:
                //carga un partido guardado


                Intent i = new Intent(this, ValorationsActivity.class);
                Button b = (Button) v;


                ArrayList<TransferJugador> tjs = XMLPersistance.getPlayersFromXML(this, b.getText().toString());


                int k = 0;
                for (TransferJugador t : tjs) {
                    i.putExtra("jug" + k, t.getValues());
                    k++;
                }


                String txt = b.getText().toString();

                i.putExtra("size", k);
                i.putExtra("vs",txt.substring(0,txt.length()-4 - 10 - 1));
                i.putExtra("date",txt.substring(txt.length()-4 - 10,txt.length() - 4).replace("-","/"));

                this.startActivity(i);

                break;

        }
    }

}

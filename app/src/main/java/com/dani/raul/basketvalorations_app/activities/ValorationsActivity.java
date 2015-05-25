package com.dani.raul.basketvalorations_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dani.raul.basketvalorations_app.R;
import com.dani.raul.basketvalorations_app.model.TransferJugador;
import com.dani.raul.basketvalorations_app.persistance.XMLPersistance;
import com.dani.raul.basketvalorations_app.presentation.GUIValorations;
import com.dani.raul.basketvalorations_app.model.ObservableValorationsListener;

import java.io.File;
import java.util.ArrayList;

public class ValorationsActivity extends Activity {

    private ArrayList<TransferJugador> l;
    private TransferJugador e;
    private ObservableValorationsListener observableValorationsListener;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("size", this.l.size());
        int i = 0;
        for (TransferJugador t : l) {
            outState.putIntArray("jug" + i, t.getValues());
            i++;
        }

        outState.putIntArray("equipo", this.e.getValues());
        outState.putIntArray("tits", this.observableValorationsListener.getIdTitulares());
        outState.putInt("selected", this.observableValorationsListener.getSelected());
        outState.putBoolean("onExec", this.observableValorationsListener.isTimeOnExec());
        outState.putBoolean("isEditar", this.observableValorationsListener.isEditar());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        try {
            boolean onExec = false;

            //Carga los jugadores
            this.l = new ArrayList<>();
            if (savedInstanceState == null) {

                int[] p = this.getIntent().getIntArrayExtra("players");

                for (int i : p) {
                    this.l.add(new TransferJugador(i));
                }

                this.e = new TransferJugador(-1);


                this.observableValorationsListener = new ObservableValorationsListener(this.l, this.e);
            } else {
                //Carga los jugadores
                for (int i = 0; i < savedInstanceState.getInt("size"); i++) {
                    this.l.add(new TransferJugador(savedInstanceState.getIntArray("jug" + i)));
                }

                this.e = new TransferJugador(savedInstanceState.getIntArray("equipo"));

                int[] tits = savedInstanceState.getIntArray("tits");
                int selected = savedInstanceState.getInt("selected");

                onExec = savedInstanceState.getBoolean("onExec");


                this.observableValorationsListener = new ObservableValorationsListener(this.l, this.e, tits, selected, onExec);
            }


            //Añadimos listener
            this.findViewById(R.id.t2v).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t2x).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t3v).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t3x).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tlv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tlx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tapv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tapx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.falv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.falx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rebOf).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rebDef).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rec).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.as).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.per).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.time).setOnClickListener(this.observableValorationsListener);

            this.findViewById(R.id.tit1).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit2).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit3).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit4).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit5).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.equipo).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.sust).setOnClickListener(this.observableValorationsListener);


            //Inicia el servicio de la aplicacion
            GUIValorations gui = new GUIValorations(this);
            this.observableValorationsListener.addObserver(gui);

            if(savedInstanceState != null) {
                this.observableValorationsListener.setEditar(savedInstanceState.getBoolean("isEditar"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        try {
            //  Carga la vista
            setContentView(R.layout.activity_valorations);

            boolean onExec = false;

            //Carga los jugadores
            this.l = new ArrayList<>();


            if(savedInstanceState != null) {


                    //Carga los jugadores
                    for (int i = 0; i < savedInstanceState.getInt("size"); i++) {
                        this.l.add(new TransferJugador(savedInstanceState.getIntArray("jug" + i)));
                    }

                    this.e = new TransferJugador(savedInstanceState.getIntArray("equipo"));

                    int[] tits = savedInstanceState.getIntArray("tits");
                    int selected = savedInstanceState.getInt("selected");

                    onExec = savedInstanceState.getBoolean("onExec");



                this.observableValorationsListener = new ObservableValorationsListener(this.l, this.e, tits, selected, onExec);

            }else if (this.getIntent().getIntExtra("size",0) < 5) {

                int[] p = this.getIntent().getIntArrayExtra("players");

                for (int i : p) {
                    this.l.add(new TransferJugador(i));
                }

                this.e = new TransferJugador(-1);


                this.observableValorationsListener = new ObservableValorationsListener(this.l, this.e);
            } else {
                //Carga los jugadores
                for (int i = 0; i < this.getIntent().getIntExtra("size",0); i++) {
                    if(this.getIntent().getIntArrayExtra("jug" + i)[0] > 0) {
                        this.l.add(new TransferJugador(this.getIntent().getIntArrayExtra("jug" + i)));
                    }else{
                        this.e = new TransferJugador(this.getIntent().getIntArrayExtra("jug" + i));
                    }
                }

                this.observableValorationsListener = new ObservableValorationsListener(this.l, this.e);

            }


            //Añadimos listener
            this.findViewById(R.id.t2v).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t2x).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t3v).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.t3x).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tlv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tlx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tapv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tapx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.falv).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.falx).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rebOf).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rebDef).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.rec).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.as).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.per).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.time).setOnClickListener(this.observableValorationsListener);

            this.findViewById(R.id.tit1).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit2).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit3).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit4).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.tit5).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.equipo).setOnClickListener(this.observableValorationsListener);
            this.findViewById(R.id.sust).setOnClickListener(this.observableValorationsListener);


            //Inicia el servicio de la aplicacion
            GUIValorations gui = new GUIValorations(this);
            this.observableValorationsListener.addObserver(gui);
            if(savedInstanceState != null) {
                this.observableValorationsListener.setEditar(savedInstanceState.getBoolean("isEditar"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_valorations, menu);


        if(this.observableValorationsListener.isEditar()) {
            MenuItem it = menu.getItem(1);
            it.setTitle(R.string.action_volver);
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String title = "";

        switch (id) {
            case R.id.guardar:

                title = this.getIntent().getStringExtra("vs") + "_" + this.getIntent().getStringExtra("date").replace("/", "-") + ".xml";
                XMLPersistance.escribirXML(this, this.l, this.e, title);

                break;
            case R.id.editar:
                if (this.observableValorationsListener.isEditar()) {
                    item.setTitle(R.string.action_editar);
                    this.observableValorationsListener.setEditar(false);
                } else {
                    item.setTitle(R.string.action_volver);
                    this.observableValorationsListener.setEditar(true);
                }
                break;

            case R.id.compartir:

                title = this.getIntent().getStringExtra("vs") + "_" + this.getIntent().getStringExtra("date").replace("/", "-") + ".xml";
                XMLPersistance.sendXML(this, this.l, this.e, title);

                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public ObservableValorationsListener getObservableValorationsListener() {
        return this.observableValorationsListener;
    }
}

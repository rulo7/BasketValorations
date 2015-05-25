package com.dani.raul.basketvalorations_app.presentation;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dani.raul.basketvalorations_app.R;
import com.dani.raul.basketvalorations_app.activities.ValorationsActivity;
import com.dani.raul.basketvalorations_app.model.TransferJugador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GUIValorations implements Observer{

    protected ValorationsActivity ac;
    protected int i;

    private Button t2v;
    private Button t2x;
    private Button t3v;
    private Button t3x;
    private Button tlv;
    private Button tlx;
    private Button tapv;
    private Button tapx;
    private Button falv;
    private Button falx;
    private Button rebOf;
    private Button rebDef;
    private Button rec;
    private Button as;
    private Button per;
    private Button time;

    private Button tit1;
    private Button tit2;
    private Button tit3;
    private Button tit4;
    private Button tit5;
    private Button equipo;


    private ArrayList<Button> susts;

    public GUIValorations(ValorationsActivity ac) {

        this.ac = ac;

        this.t2v = (Button) ac.findViewById(R.id.t2v);
        this.t2x = (Button) ac.findViewById(R.id.t2x);
        this.t3v = (Button) ac.findViewById(R.id.t3v);
        this.t3x = (Button) ac.findViewById(R.id.t3x);
        this.tlv = (Button) ac.findViewById(R.id.tlv);
        this.tlx = (Button) ac.findViewById(R.id.tlx);
        this.tapv = (Button) ac.findViewById(R.id.tapv);
        this.tapx = (Button) ac.findViewById(R.id.tapx);
        this.falv = (Button) ac.findViewById(R.id.falv);
        this.falx = (Button) ac.findViewById(R.id.falx);
        this.rebOf = (Button) ac.findViewById(R.id.rebOf);
        this.rebDef = (Button) ac.findViewById(R.id.rebDef);
        this.rec = (Button) ac.findViewById(R.id.rec);
        this.as = (Button) ac.findViewById(R.id.as);
        this.per = (Button) ac.findViewById(R.id.per);
        this.time = (Button) ac.findViewById(R.id.time);

        this.tit1 = (Button) ac.findViewById(R.id.tit1);
        this.tit2 = (Button) ac.findViewById(R.id.tit2);
        this.tit3 = (Button) ac.findViewById(R.id.tit3);
        this.tit4 = (Button) ac.findViewById(R.id.tit4);
        this.tit5 = (Button) ac.findViewById(R.id.tit5);
        this.equipo = (Button) ac.findViewById(R.id.equipo);
    }

    @Override
    public void update(Observable observable, Object data) {

        if(data instanceof TransferJugador) {

            TransferJugador tj = (TransferJugador) data;

            this.t2v.setText(tj.getT2v() + "");
            this.t2x.setText(tj.getT2x() + "");
            this.t3v.setText(tj.getT3v() + "");
            this.t3x.setText(tj.getT3x() + "");
            this.tlv.setText(tj.getTlv() + "");
            this.tlx.setText(tj.getTlx() + "");
            this.tapv.setText(tj.getTapv() + "");
            this.tapx.setText(tj.getTapx() + "");
            this.falv.setText(tj.getFalv() + "");
            this.falx.setText(tj.getFalx() + "");
            this.rebOf.setText("Of:" + tj.getRebOf() + "");
            this.rebDef.setText("De:" + tj.getRebDef() + "");
            this.rec.setText(tj.getRec() + "");
            this.as.setText(tj.getAs() + "");
            this.per.setText(tj.getPer() + "");
            this.time.setText(tj.getTime().getTiempoAplicacion());

        }else if (data instanceof ArrayList) {

            this.tit1.setText(((ArrayList<TransferJugador>) data).get(0).getId() + "");
            this.tit2.setText(((ArrayList<TransferJugador>) data).get(1).getId() + "");
            this.tit3.setText(((ArrayList<TransferJugador>) data).get(2).getId() + "");
            this.tit4.setText(((ArrayList<TransferJugador>) data).get(3).getId() + "");
            this.tit5.setText(((ArrayList<TransferJugador>) data).get(4).getId() + "");

        }else if(data instanceof Integer){

            this.tit1.setTextColor(Color.BLACK);
            this.tit2.setTextColor(Color.BLACK);
            this.tit3.setTextColor(Color.BLACK);
            this.tit4.setTextColor(Color.BLACK);
            this.tit5.setTextColor(Color.BLACK);
            this.equipo.setTextColor(Color.BLACK);

            switch((int)data){
                case 1:
                    this.tit1.setTextColor(Color.RED);
                    break;
                case 2:
                    this.tit2.setTextColor(Color.RED);
                    break;
                case 3:
                    this.tit3.setTextColor(Color.RED);
                    break;
                case 4:
                    this.tit4.setTextColor(Color.RED);
                    break;
                case 5:
                    this.tit5.setTextColor(Color.RED);
                    break;
                case -1:
                    this.equipo.setTextColor(Color.RED);
                    break;
            }

        }else if(data instanceof String){


            if(data.toString().equals("SHOW")) {
                this.ac.findViewById(R.id.horizontalScrollViewSustitutos).setVisibility(View.GONE);
                this.ac.findViewById(R.id.scrollViewTitulares).setVisibility(View.VISIBLE);
                this.ac.findViewById(R.id.layoutPpalValoration).setVisibility(View.VISIBLE);
            }else if(data.toString().equals("editar")){

                this.t2v.setBackgroundColor(Color.CYAN);
                this.t2x.setBackgroundColor(Color.BLUE);
                this.t3v.setBackgroundColor(Color.CYAN);
                this.t3x.setBackgroundColor(Color.BLUE);
                this.tlv.setBackgroundColor(Color.CYAN);
                this.tlx.setBackgroundColor(Color.BLUE);
                this.tapv.setBackgroundColor(Color.CYAN);
                this.tapx.setBackgroundColor(Color.BLUE);
                this.falv.setBackgroundColor(Color.CYAN);
                this.falx.setBackgroundColor(Color.BLUE);
                this.rebOf.setBackgroundColor(Color.CYAN);
                this.rebDef.setBackgroundColor(Color.CYAN);
                this.rec.setBackgroundColor(Color.CYAN);
                this.as.setBackgroundColor(Color.CYAN);
                this.per.setBackgroundColor(Color.BLUE);

            }else if(data.toString().equals("no_editar")){
                this.t2v.setBackgroundColor(Color.GREEN);
                this.t2x.setBackgroundColor(Color.RED);
                this.t3v.setBackgroundColor(Color.GREEN);
                this.t3x.setBackgroundColor(Color.RED);
                this.tlv.setBackgroundColor(Color.GREEN);
                this.tlx.setBackgroundColor(Color.RED);
                this.tapv.setBackgroundColor(Color.GREEN);
                this.tapx.setBackgroundColor(Color.RED);
                this.falv.setBackgroundColor(Color.GREEN);
                this.falx.setBackgroundColor(Color.RED);
                this.rebOf.setBackgroundColor(Color.GREEN);
                this.rebDef.setBackgroundColor(Color.GREEN);
                this.rec.setBackgroundColor(Color.GREEN);
                this.as.setBackgroundColor(Color.GREEN);
                this.per.setBackgroundColor(Color.RED);
            }else{
                this.time.setText((String) data);
            }
        }else if(data instanceof  Boolean){
            if((Boolean)data){
                this.time.setTextColor(Color.MAGENTA);
            }else{
                this.time.setTextColor(Color.BLACK);
            }

        }else if(data instanceof int[]){

            View h = this.ac.findViewById(R.id.horizontalScrollViewSustitutos);
            LinearLayout l2 = (LinearLayout) this.ac.findViewById(R.id.linearLayoutSustitutos);
            l2.removeAllViews();

            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            for(int n: (int[])data){

                Button b = new Button(this.ac);
                this.i = n;
                b.setText(i+"");

                b.setOnClickListener(new SustituirJugador(this.ac));

                l2.addView(b,lp);
            }

            Button q = new Button(this.ac);
            q.setText("BACK");

            q.setOnClickListener(new SustituirJugador(this.ac));

            l2.addView(q, lp);


            this.ac.findViewById(R.id.layoutPpalValoration).setVisibility(View.GONE);
            this.ac.findViewById(R.id.scrollViewTitulares).setVisibility(View.GONE);
            this.ac.findViewById(R.id.horizontalScrollViewSustitutos).setVisibility(View.VISIBLE);

        }

    }
}


class SustituirJugador implements View.OnClickListener {

    private ValorationsActivity ac;

    public SustituirJugador(ValorationsActivity ac){
        this.ac = ac;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        this.ac.getObservableValorationsListener().sustituirJugador(b.getText().toString());
    }
}
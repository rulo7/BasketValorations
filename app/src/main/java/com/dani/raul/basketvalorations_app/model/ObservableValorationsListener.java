package com.dani.raul.basketvalorations_app.model;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.dani.raul.basketvalorations_app.R;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ObservableValorationsListener extends Observable implements View.OnClickListener {

    private TimerController timer;
    protected ArrayList<TransferJugador> tjs;
    protected ArrayList<TransferJugador> tits;
    private TransferJugador equipo;
    private TransferJugador tjSelected;
    private int selected;
    protected boolean editar;

    public ObservableValorationsListener(ArrayList<TransferJugador> tjs, TransferJugador e) throws Exception {

        this.editar = false;

        if (tjs.size() < 5) {
            throw new Exception("Un equipo ha de ser minimo de 5");
        }

        this.tjs = tjs;
        this.tits = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.tits.add(this.tjs.get(i));
        }

        this.equipo = e;
        this.tjSelected = this.equipo;
        this.selected = -1;

        Handler puente = new Handler() {

            public void handleMessage(Message msg) {
                for (TransferJugador t : tits) {
                    if(!editar) {
                        t.getTime().ejecutar();
                    }else{
                        t.getTime().decrementar();
                    }
                }
                if(!editar) {
                    equipo.getTime().ejecutar();
                }else{
                    equipo.getTime().decrementar();
                }

                setChanged();
                notifyObservers(tjSelected.getTime().getTiempoAplicacion());
            }
        };

        this.timer = new TimerController(puente);
        timer.start();

    }

    public ObservableValorationsListener(ArrayList<TransferJugador> tjs, TransferJugador e, int[] idTitus, int selected, boolean onExec) throws Exception {

        this.editar = false;

        if (tjs.size() < 5) {
            throw new Exception("Un equipo ha de ser minimo de 5");
        }

        this.tjs = tjs;
        this.tits = new ArrayList<>();

        for (int i : idTitus) {
            this.tits.add(this.getTJugadorByID(i));
        }

        this.equipo = e;
        this.selected = selected;
        if (this.selected > -1) {
            this.tjSelected = this.tits.get(this.selected - 1);
        } else {
            this.tjSelected = this.equipo;
        }

        Handler puente = new Handler() {

            public void handleMessage(Message msg) {
                for (TransferJugador t : tits) {
                    if(!editar) {
                        t.getTime().ejecutar();
                    }else{
                        t.getTime().decrementar();
                    }
                }
                if(!editar) {
                    equipo.getTime().ejecutar();
                }else{
                    equipo.getTime().decrementar();
                }

                setChanged();
                notifyObservers(tjSelected.getTime().getTiempoAplicacion());
            }
        };

        this.timer = new TimerController(puente);
        this.timer.start();

        if (onExec) {
            this.timer.action();
        }

    }

    @Override
    public void addObserver(Observer observer) {
        super.addObserver(observer);

        this.setChanged();
        this.notifyObservers(this.tits);

        this.setChanged();
        this.notifyObservers(this.selected);

        this.setChanged();
        this.notifyObservers(this.tjSelected);

        this.setChanged();
        this.notifyObservers(this.timer.isRunning());

    }

    @Override
    public void onClick(View v) {

        if (this.tjSelected != this.equipo) {

            if (v.getId() == R.id.sust) {
                if (this.tjs.size() - 5 > 0) {
                    int[] sust = new int[this.tjs.size() - 5];

                    int i = 0;
                    for (TransferJugador t : this.tjs) {
                        if (!this.esTitular(t.getId())) {
                            sust[i] = t.getId();
                            i++;
                        }
                    }

                    this.setChanged();
                    this.notifyObservers(sust);
                }


            } else if (this.editar) {
                switch (v.getId()) {
                    case R.id.t2v:
                        this.tjSelected.setT2v(this.tjSelected.getT2v() - 1);
                        this.equipo.setT2v(this.equipo.getT2v() - 1);

                        break;
                    case R.id.t2x:
                        this.tjSelected.setT2x(this.tjSelected.getT2x() - 1);
                        this.equipo.setT2x(this.equipo.getT2x() - 1);

                        break;
                    case R.id.t3v:
                        this.tjSelected.setT3v(this.tjSelected.getT3v() - 1);
                        this.equipo.setT3v(this.equipo.getT3v() - 1);

                        break;
                    case R.id.t3x:
                        this.tjSelected.setT3x(this.tjSelected.getT3x() - 1);
                        this.equipo.setT3x(this.equipo.getT3x() - 1);

                        break;
                    case R.id.tlv:
                        this.tjSelected.setTlv(this.tjSelected.getTlv() - 1);
                        this.equipo.setTlv(this.equipo.getTlv() - 1);

                        break;
                    case R.id.tlx:
                        this.tjSelected.setTlx(this.tjSelected.getTlx() - 1);
                        this.equipo.setTlx(this.equipo.getTlx() - 1);

                        break;
                    case R.id.falv:
                        this.tjSelected.setFalv(this.tjSelected.getFalv() - 1);
                        this.equipo.setFalv(this.equipo.getFalv() - 1);

                        break;
                    case R.id.falx:
                        this.tjSelected.setFalx(this.tjSelected.getFalx() - 1);
                        this.equipo.setFalx(this.equipo.getFalx() - 1);

                        break;
                    case R.id.tapv:
                        this.tjSelected.setTapv(this.tjSelected.getTapv() - 1);
                        this.equipo.setTapv(this.equipo.getTapv() - 1);

                        break;
                    case R.id.tapx:
                        this.tjSelected.setTapx(this.tjSelected.getTapx() - 1);
                        this.equipo.setTapx(this.equipo.getTapx() - 1);

                        break;
                    case R.id.rebOf:
                        this.tjSelected.setRebOf(this.tjSelected.getRebOf() - 1);
                        this.equipo.setRebOf(this.equipo.getRebOf() - 1);

                        break;
                    case R.id.rebDef:
                        this.tjSelected.setRebDef(this.tjSelected.getRebDef() - 1);
                        this.equipo.setRebDef(this.equipo.getRebDef() - 1);

                        break;
                    case R.id.rec:
                        this.tjSelected.setRec(this.tjSelected.getRec() - 1);
                        this.equipo.setRec(this.equipo.getRec() - 1);

                        break;
                    case R.id.per:
                        this.tjSelected.setPer(this.tjSelected.getPer() - 1);
                        this.equipo.setPer(this.equipo.getPer() - 1);

                        break;
                    case R.id.as:
                        this.tjSelected.setAs(this.tjSelected.getAs() - 1);
                        this.equipo.setAs(this.equipo.getAs() - 1);

                        break;
                }
            } else {
                switch (v.getId()) {
                    case R.id.t2v:
                        this.tjSelected.setT2v(this.tjSelected.getT2v() + 1);
                        this.equipo.setT2v(this.equipo.getT2v() + 1);

                        break;
                    case R.id.t2x:
                        this.tjSelected.setT2x(this.tjSelected.getT2x() + 1);
                        this.equipo.setT2x(this.equipo.getT2x() + 1);

                        break;
                    case R.id.t3v:
                        this.tjSelected.setT3v(this.tjSelected.getT3v() + 1);
                        this.equipo.setT3v(this.equipo.getT3v() + 1);

                        break;
                    case R.id.t3x:
                        this.tjSelected.setT3x(this.tjSelected.getT3x() + 1);
                        this.equipo.setT3x(this.equipo.getT3x() + 1);

                        break;
                    case R.id.tlv:
                        this.tjSelected.setTlv(this.tjSelected.getTlv() + 1);
                        this.equipo.setTlv(this.equipo.getTlv() + 1);

                        break;
                    case R.id.tlx:
                        this.tjSelected.setTlx(this.tjSelected.getTlx() + 1);
                        this.equipo.setTlx(this.equipo.getTlx() + 1);

                        break;
                    case R.id.falv:
                        this.tjSelected.setFalv(this.tjSelected.getFalv() + 1);
                        this.equipo.setFalv(this.equipo.getFalv() + 1);

                        break;
                    case R.id.falx:
                        this.tjSelected.setFalx(this.tjSelected.getFalx() + 1);
                        this.equipo.setFalx(this.equipo.getFalx() + 1);

                        break;
                    case R.id.tapv:
                        this.tjSelected.setTapv(this.tjSelected.getTapv() + 1);
                        this.equipo.setTapv(this.equipo.getTapv() + 1);

                        break;
                    case R.id.tapx:
                        this.tjSelected.setTapx(this.tjSelected.getTapx() + 1);
                        this.equipo.setTapx(this.equipo.getTapx() + 1);

                        break;
                    case R.id.rebOf:
                        this.tjSelected.setRebOf(this.tjSelected.getRebOf() + 1);
                        this.equipo.setRebOf(this.equipo.getRebOf() + 1);

                        break;
                    case R.id.rebDef:
                        this.tjSelected.setRebDef(this.tjSelected.getRebDef() + 1);
                        this.equipo.setRebDef(this.equipo.getRebDef() + 1);

                        break;
                    case R.id.rec:
                        this.tjSelected.setRec(this.tjSelected.getRec() + 1);
                        this.equipo.setRec(this.equipo.getRec() + 1);

                        break;
                    case R.id.per:
                        this.tjSelected.setPer(this.tjSelected.getPer() + 1);
                        this.equipo.setPer(this.equipo.getPer() + 1);

                        break;
                    case R.id.as:
                        this.tjSelected.setAs(this.tjSelected.getAs() + 1);
                        this.equipo.setAs(this.equipo.getAs() + 1);

                        break;
                }
            }

        }

        switch (v.getId()) {
            case R.id.time:
                this.timer.action();
                this.setChanged();
                this.notifyObservers(this.timer.isRunning());
                break;

            case R.id.tit1:
                this.tjSelected = this.tits.get(0);
                this.selected = 1;
                break;
            case R.id.tit2:
                this.tjSelected = this.tits.get(1);
                this.selected = 2;
                break;
            case R.id.tit3:
                this.tjSelected = this.tits.get(2);
                this.selected = 3;
                break;
            case R.id.tit4:
                this.tjSelected = this.tits.get(3);
                this.selected = 4;
                break;
            case R.id.tit5:
                this.tjSelected = this.tits.get(4);
                this.selected = 5;
                break;
            case R.id.equipo:
                this.selected = -1;
                this.tjSelected = this.equipo;
                break;
        }


        this.setChanged();
        this.notifyObservers(this.selected);


        this.setChanged();
        this.notifyObservers(this.tjSelected);

    }

    public Boolean esTitular(int id) {
        for (TransferJugador ti : this.tits) {
            if (ti.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public TransferJugador getTJugadorByID(int id) {
        for (TransferJugador ti : this.tjs) {
            if (ti.getId() == id) {
                return ti;
            }
        }

        return null;
    }

    public void sustituirJugador(String txt) {


        if (!txt.equalsIgnoreCase("BACK")) {
            this.tits.remove(this.selected - 1);
            this.tits.add(this.selected - 1, this.getTJugadorByID(Integer.valueOf(txt)));
            this.tjSelected = this.getTJugadorByID(Integer.valueOf(txt));

            this.setChanged();
            this.notifyObservers(this.tits);

        }

        this.setChanged();
        this.notifyObservers("SHOW");

        this.setChanged();
        this.notifyObservers(this.selected);


        this.setChanged();
        this.notifyObservers(this.tjSelected);


    }

    public int[] getIdTitulares() {
        int[] r = new int[5];

        int i = 0;
        for (TransferJugador t : this.tits) {
            r[i] = t.getId();
            i++;
        }

        return r;
    }

    public int getSelected() {
        return this.selected;
    }

    public boolean isTimeOnExec() {
        return this.timer.isRunning();
    }

    public boolean isEditar() {
        return this.editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;

        if(this.editar){
            this.setChanged();
            this.notifyObservers("editar");

            if(this.timer.isRunning()){
                this.timer.action();
                this.setChanged();
                this.notifyObservers(this.timer.isRunning());
            }

        }else{
            this.setChanged();
            this.notifyObservers("no_editar");

            if(this.timer.isRunning()){
                this.timer.action();
                this.setChanged();
                this.notifyObservers(this.timer.isRunning());
            }
        }

    }
}

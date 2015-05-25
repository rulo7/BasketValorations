package com.dani.raul.basketvalorations_app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.dani.raul.basketvalorations_app.reloj.Reloj;

import java.util.Observable;

public class TransferJugador {

    private int id;
    private int t2v;
    private int t2x;
    private int t3v;
    private int t3x;
    private int tlv;
    private int tlx;
    private int tapv;
    private int tapx;
    private int falv;
    private int falx;
    private int rebOf;
    private int rebDef;
    private int rec;
    private int as;
    private int per;
    private Reloj time;

    public TransferJugador(int id) {
        this.id = id;
        this.t2v = 0;
        this.t2x = 0;
        this.t3v = 0;
        this.t3x = 0;
        this.tlv = 0;
        this.tlx = 0;
        this.tapv = 0;
        this.tapx = 0;
        this.falv = 0;
        this.falx = 0;
        this.rebOf = 0;
        this.rebDef = 0;
        this.rec = 0;
        this.as = 0;
        this.per = 0;
        this.time = new Reloj();
    }

    public TransferJugador(int id, int t2v, int t2x, int t3v, int t3x, int tlv, int tlx, int tapv, int tapx, int falv, int falx, int rebOf, int rebDef, int rec, int as, int per, Reloj time) {
        this.id = id;
        this.t2v = t2v;
        this.t2x = t2x;
        this.t3v = t3v;
        this.t3x = t3x;
        this.tlv = tlv;
        this.tlx = tlx;
        this.tapv = tapv;
        this.tapx = tapx;
        this.falv = falv;
        this.falx = falx;
        this.rebOf = rebOf;
        this.rebDef = rebDef;
        this.rec = rec;
        this.as = as;
        this.per = per;
        this.time = time;
    }

    public TransferJugador(int[] values) {
        this.id = values[0];
        this.t2v = values[1];
        this.t2x = values[2];
        this.t3v = values[3];
        this.t3x = values[4];
        this.tlv = values[5];
        this.tlx = values[6];
        this.tapv = values[7];
        this.tapx = values[8];
        this.falv = values[9];
        this.falx = values[10];
        this.rebOf = values[11];
        this.rebDef = values[12];
        this.rec = values[13];
        this.as = values[14];
        this.per = values[15];
        this.time = new Reloj();
        this.time.setHoras(values[16]);
        this.time.setMinutos(values[17]);
        this.time.setSegundos(values[18]);
        this.time.setDecimas(values[19]);
    }

    public int getId() {
        return id;
    }

    public int getT2v() {
        return t2v;
    }

    public int getT2x() {
        return t2x;
    }

    public int getT3v() {
        return t3v;
    }

    public int getT3x() {
        return t3x;
    }

    public int getTlv() {
        return tlv;
    }

    public int getTlx() {
        return tlx;
    }

    public int getTapv() {
        return tapv;
    }

    public int getTapx() {
        return tapx;
    }

    public int getFalv() {
        return falv;
    }

    public int getFalx() {
        return falx;
    }

    public int getRebOf() {
        return rebOf;
    }

    public int getRebDef() {
        return rebDef;
    }

    public int getRec() {
        return rec;
    }

    public int getAs() {
        return as;
    }

    public int getPer() {
        return per;
    }

    public Reloj getTime() {
        return time;
    }


    public void setId(int id) {
        if (id >= 0)
            this.id = id;
    }

    public void setT2v(int t2v) {
        if (t2v >= 0)
            this.t2v = t2v;
    }

    public void setT2x(int t2x) {
        if (t2x >= 0)
            this.t2x = t2x;
    }

    public void setT3v(int t3v) {
        if (t3v >= 0)
            this.t3v = t3v;
    }

    public void setT3x(int t3x) {
        if (t3x >= 0)
            this.t3x = t3x;
    }

    public void setTlv(int tlv) {
        if (tlv >= 0)
            this.tlv = tlv;
    }

    public void setTlx(int tlx) {
        if (tlx >= 0)
            this.tlx = tlx;
    }

    public void setTapv(int tapv) {
        if (tapv >= 0)
            this.tapv = tapv;
    }

    public void setTapx(int tapx) {
        if (tapx >= 0)
            this.tapx = tapx;
    }

    public void setFalv(int falv) {
        if (falv >= 0)
            this.falv = falv;
    }

    public void setFalx(int falx) {
        if (falx >= 0)
            this.falx = falx;
    }

    public void setRebOf(int rebOf) {
        if (rebOf >= 0)
            this.rebOf = rebOf;
    }

    public void setRebDef(int rebDef) {
        if (rebDef >= 0)
            this.rebDef = rebDef;
    }

    public void setRec(int rec) {
        if (rec >= 0)
            this.rec = rec;
    }

    public void setAs(int as) {
        if (as >= 0)
            this.as = as;
    }

    public void setPer(int per) {
        if (per >= 0)
            this.per = per;
    }

    public void setTime(Reloj time) {
        this.time = time;
    }


    public int[] getValues() {
        return new int[]{
                this.id,
                this.t2v,
                this.t2x,
                this.t3v,
                this.t3x,
                this.tlv,
                this.tlx,
                this.tapv,
                this.tapx,
                this.falv,
                this.falx,
                this.rebOf,
                this.rebDef,
                this.rec,
                this.as,
                this.per,
                this.time.getHoras(),
                this.time.getMinutos(),
                this.time.getSegundos(),
                this.time.getDecimasDeSegundo()
        };
    }


}

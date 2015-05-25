package com.dani.raul.basketvalorations_app.persistance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Xml;
import android.widget.Toast;

import com.dani.raul.basketvalorations_app.R;
import com.dani.raul.basketvalorations_app.model.TransferJugador;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;


public class XMLPersistance {


    public static File sendXML(Activity ac, ArrayList<TransferJugador> players, TransferJugador team, String fileName) {
        FileOutputStream fout;
        File f = new File(ac.getExternalCacheDir() + "/" + fileName);



        try {

            f.createNewFile();

            fout = new FileOutputStream(f);

            XmlSerializer serializer = Xml.newSerializer();
            try {


                //_______________________________

                serializer.setOutput(fout, "UTF-8");
                serializer.startDocument(null, true);
                serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

                serializer.startTag(null, "MATCH");


                for (TransferJugador t : players) {
                    // jugador
                    serializer.startTag(null, "player");
                    serializer.attribute(null, "id", t.getId() + "");

                    // valores
                    serializer.startTag(null, "t2v");
                    serializer.text(t.getT2v() + "");
                    serializer.endTag(null, "t2v");

                    serializer.startTag(null, "t2x");
                    serializer.text(t.getT2x() + "");
                    serializer.endTag(null, "t2x");

                    serializer.startTag(null, "t3v");
                    serializer.text(t.getT3v() + "");
                    serializer.endTag(null, "t3v");

                    serializer.startTag(null, "t3x");
                    serializer.text(t.getT3x() + "");
                    serializer.endTag(null, "t3x");

                    serializer.startTag(null, "tlv");
                    serializer.text(t.getTlv() + "");
                    serializer.endTag(null, "tlv");

                    serializer.startTag(null, "tlx");
                    serializer.text(t.getTlx() + "");
                    serializer.endTag(null, "tlx");

                    serializer.startTag(null, "rebOf");
                    serializer.text(t.getRebOf() + "");
                    serializer.endTag(null, "rebOf");

                    serializer.startTag(null, "rebDef");
                    serializer.text(t.getRebDef() + "");
                    serializer.endTag(null, "rebDef");

                    serializer.startTag(null, "falv");
                    serializer.text(t.getFalv() + "");
                    serializer.endTag(null, "falv");

                    serializer.startTag(null, "falx");
                    serializer.text(t.getFalx() + "");
                    serializer.endTag(null, "falx");

                    serializer.startTag(null, "tapv");
                    serializer.text(t.getTapv() + "");
                    serializer.endTag(null, "tapv");

                    serializer.startTag(null, "tapx");
                    serializer.text(t.getTapx() + "");
                    serializer.endTag(null, "tapx");

                    serializer.startTag(null, "rec");
                    serializer.text(t.getRec() + "");
                    serializer.endTag(null, "rec");

                    serializer.startTag(null, "per");
                    serializer.text(t.getPer() + "");
                    serializer.endTag(null, "per");

                    serializer.startTag(null, "as");
                    serializer.text(t.getAs() + "");
                    serializer.endTag(null, "as");

                    serializer.startTag(null, "horas");
                    serializer.text(t.getTime().getHoras() + "");
                    serializer.endTag(null, "horas");

                    serializer.startTag(null, "minutos");
                    serializer.text(t.getTime().getMinutos() + "");
                    serializer.endTag(null, "minutos");

                    serializer.startTag(null, "segundos");
                    serializer.text(t.getTime().getSegundos() + "");
                    serializer.endTag(null, "segundos");

                    serializer.startTag(null, "decimas");
                    serializer.text(t.getTime().getDecimasDeSegundo() + "");
                    serializer.endTag(null, "decimas");

                    serializer.endTag(null, "player");
                }


                //__TEAM_______________


                serializer.startTag(null, "player");
                serializer.attribute(null, "id", team.getId() + "");

                // valores
                serializer.startTag(null, "t2v");
                serializer.text(team.getT2v() + "");
                serializer.endTag(null, "t2v");

                serializer.startTag(null, "t2x");
                serializer.text(team.getT2x() + "");
                serializer.endTag(null, "t2x");

                serializer.startTag(null, "t3v");
                serializer.text(team.getT3v() + "");
                serializer.endTag(null, "t3v");

                serializer.startTag(null, "t3x");
                serializer.text(team.getT3x() + "");
                serializer.endTag(null, "t3x");

                serializer.startTag(null, "tlv");
                serializer.text(team.getTlv() + "");
                serializer.endTag(null, "tlv");

                serializer.startTag(null, "tlx");
                serializer.text(team.getTlx() + "");
                serializer.endTag(null, "tlx");

                serializer.startTag(null, "rebOf");
                serializer.text(team.getRebOf() + "");
                serializer.endTag(null, "rebOf");

                serializer.startTag(null, "rebDef");
                serializer.text(team.getRebDef() + "");
                serializer.endTag(null, "rebDef");

                serializer.startTag(null, "falv");
                serializer.text(team.getFalv() + "");
                serializer.endTag(null, "falv");

                serializer.startTag(null, "falx");
                serializer.text(team.getFalx() + "");
                serializer.endTag(null, "falx");

                serializer.startTag(null, "tapv");
                serializer.text(team.getTapv() + "");
                serializer.endTag(null, "tapv");

                serializer.startTag(null, "tapx");
                serializer.text(team.getTapx() + "");
                serializer.endTag(null, "tapx");

                serializer.startTag(null, "rec");
                serializer.text(team.getRec() + "");
                serializer.endTag(null, "rec");

                serializer.startTag(null, "per");
                serializer.text(team.getPer() + "");
                serializer.endTag(null, "per");

                serializer.startTag(null, "as");
                serializer.text(team.getAs() + "");
                serializer.endTag(null, "as");

                serializer.startTag(null, "horas");
                serializer.text(team.getTime().getHoras() + "");
                serializer.endTag(null, "horas");

                serializer.startTag(null, "minutos");
                serializer.text(team.getTime().getMinutos() + "");
                serializer.endTag(null, "minutos");

                serializer.startTag(null, "segundos");
                serializer.text(team.getTime().getSegundos() + "");
                serializer.endTag(null, "segundos");

                serializer.startTag(null, "decimas");
                serializer.text(team.getTime().getDecimasDeSegundo() + "");
                serializer.endTag(null, "decimas");

                serializer.endTag(null, "player");

                //__FIN__ TEAM_________


                serializer.endTag(null, "MATCH");


                //_____________________

                serializer.endDocument();
                serializer.flush();
                fout.close();

            } catch (Exception e) {
                Toast.makeText(ac.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(ac.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/xml");

        String tit = ac.getIntent().getStringExtra("vs") + "_" + ac.getIntent().getStringExtra("date").replace("/", "-") + ".xml";
        intent.putExtra(Intent.EXTRA_SUBJECT, "Valoration from " + tit);
        intent.putExtra(Intent.EXTRA_TEXT, ac.getString(R.string.send_message) + ": " + tit);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + f));

        ac.startActivity(intent);

        Toast.makeText(ac.getApplicationContext(), "saved in: " + f.getAbsolutePath(), Toast.LENGTH_LONG).show();

        return f;

    }

    public static File escribirXML(Activity ac, ArrayList<TransferJugador> players, TransferJugador team, String fileName) {
        FileOutputStream fout;

        try {
            fout = ac.openFileOutput(fileName, Context.MODE_PRIVATE);

            XmlSerializer serializer = Xml.newSerializer();
            try {


                //_______________________________

                serializer.setOutput(fout, "UTF-8");
                serializer.startDocument(null, true);
                serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

                serializer.startTag(null, "MATCH");


                for (TransferJugador t : players) {
                    // jugador
                    serializer.startTag(null, "player");
                    serializer.attribute(null, "id", t.getId() + "");

                    // valores
                    serializer.startTag(null, "t2v");
                    serializer.text(t.getT2v() + "");
                    serializer.endTag(null, "t2v");

                    serializer.startTag(null, "t2x");
                    serializer.text(t.getT2x() + "");
                    serializer.endTag(null, "t2x");

                    serializer.startTag(null, "t3v");
                    serializer.text(t.getT3v() + "");
                    serializer.endTag(null, "t3v");

                    serializer.startTag(null, "t3x");
                    serializer.text(t.getT3x() + "");
                    serializer.endTag(null, "t3x");

                    serializer.startTag(null, "tlv");
                    serializer.text(t.getTlv() + "");
                    serializer.endTag(null, "tlv");

                    serializer.startTag(null, "tlx");
                    serializer.text(t.getTlx() + "");
                    serializer.endTag(null, "tlx");

                    serializer.startTag(null, "rebOf");
                    serializer.text(t.getRebOf() + "");
                    serializer.endTag(null, "rebOf");

                    serializer.startTag(null, "rebDef");
                    serializer.text(t.getRebDef() + "");
                    serializer.endTag(null, "rebDef");

                    serializer.startTag(null, "falv");
                    serializer.text(t.getFalv() + "");
                    serializer.endTag(null, "falv");

                    serializer.startTag(null, "falx");
                    serializer.text(t.getFalx() + "");
                    serializer.endTag(null, "falx");

                    serializer.startTag(null, "tapv");
                    serializer.text(t.getTapv() + "");
                    serializer.endTag(null, "tapv");

                    serializer.startTag(null, "tapx");
                    serializer.text(t.getTapx() + "");
                    serializer.endTag(null, "tapx");

                    serializer.startTag(null, "rec");
                    serializer.text(t.getRec() + "");
                    serializer.endTag(null, "rec");

                    serializer.startTag(null, "per");
                    serializer.text(t.getPer() + "");
                    serializer.endTag(null, "per");

                    serializer.startTag(null, "as");
                    serializer.text(t.getAs() + "");
                    serializer.endTag(null, "as");

                    serializer.startTag(null, "horas");
                    serializer.text(t.getTime().getHoras() + "");
                    serializer.endTag(null, "horas");

                    serializer.startTag(null, "minutos");
                    serializer.text(t.getTime().getMinutos() + "");
                    serializer.endTag(null, "minutos");

                    serializer.startTag(null, "segundos");
                    serializer.text(t.getTime().getSegundos() + "");
                    serializer.endTag(null, "segundos");

                    serializer.startTag(null, "decimas");
                    serializer.text(t.getTime().getDecimasDeSegundo() + "");
                    serializer.endTag(null, "decimas");

                    serializer.endTag(null, "player");
                }


                //__TEAM_______________


                serializer.startTag(null, "player");
                serializer.attribute(null, "id", team.getId() + "");

                // valores
                serializer.startTag(null, "t2v");
                serializer.text(team.getT2v() + "");
                serializer.endTag(null, "t2v");

                serializer.startTag(null, "t2x");
                serializer.text(team.getT2x() + "");
                serializer.endTag(null, "t2x");

                serializer.startTag(null, "t3v");
                serializer.text(team.getT3v() + "");
                serializer.endTag(null, "t3v");

                serializer.startTag(null, "t3x");
                serializer.text(team.getT3x() + "");
                serializer.endTag(null, "t3x");

                serializer.startTag(null, "tlv");
                serializer.text(team.getTlv() + "");
                serializer.endTag(null, "tlv");

                serializer.startTag(null, "tlx");
                serializer.text(team.getTlx() + "");
                serializer.endTag(null, "tlx");

                serializer.startTag(null, "rebOf");
                serializer.text(team.getRebOf() + "");
                serializer.endTag(null, "rebOf");

                serializer.startTag(null, "rebDef");
                serializer.text(team.getRebDef() + "");
                serializer.endTag(null, "rebDef");

                serializer.startTag(null, "falv");
                serializer.text(team.getFalv() + "");
                serializer.endTag(null, "falv");

                serializer.startTag(null, "falx");
                serializer.text(team.getFalx() + "");
                serializer.endTag(null, "falx");

                serializer.startTag(null, "tapv");
                serializer.text(team.getTapv() + "");
                serializer.endTag(null, "tapv");

                serializer.startTag(null, "tapx");
                serializer.text(team.getTapx() + "");
                serializer.endTag(null, "tapx");

                serializer.startTag(null, "rec");
                serializer.text(team.getRec() + "");
                serializer.endTag(null, "rec");

                serializer.startTag(null, "per");
                serializer.text(team.getPer() + "");
                serializer.endTag(null, "per");

                serializer.startTag(null, "as");
                serializer.text(team.getAs() + "");
                serializer.endTag(null, "as");

                serializer.startTag(null, "horas");
                serializer.text(team.getTime().getHoras() + "");
                serializer.endTag(null, "horas");

                serializer.startTag(null, "minutos");
                serializer.text(team.getTime().getMinutos() + "");
                serializer.endTag(null, "minutos");

                serializer.startTag(null, "segundos");
                serializer.text(team.getTime().getSegundos() + "");
                serializer.endTag(null, "segundos");

                serializer.startTag(null, "decimas");
                serializer.text(team.getTime().getDecimasDeSegundo() + "");
                serializer.endTag(null, "decimas");

                serializer.endTag(null, "player");

                //__FIN__ TEAM_________


                serializer.endTag(null, "MATCH");


                //_____________________

                serializer.endDocument();
                serializer.flush();
                fout.close();

                Toast.makeText(ac.getApplicationContext(), "Escrito correctamente", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(ac.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(ac.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        File f = new File(ac.getFilesDir().getPath() + "/" + fileName);

        return f;

    }

    public static String leerXML(Activity ac, String xmlFile) {
        FileInputStream fin;

        String txt = "";

        try {
            fin = ac.openFileInput(xmlFile);

            XmlPullParser parser = Xml.newPullParser();
            try {
                parser.setInput(fin, "UTF-8");

                int event = parser.next();
                while (event != XmlPullParser.END_DOCUMENT) {
                    if (event == XmlPullParser.START_TAG) {
                        txt += "<" + parser.getName();
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            txt += "\t" + parser.getAttributeName(i) + "=\"" + parser.getAttributeValue(i) + "\" ";
                        }

                        txt+=">";
                    }

                    if (event == XmlPullParser.TEXT && parser.getText().trim().length() != 0)
                        txt += "\t" + parser.getText();
                    else
                        txt += "\n";


                    if (event == XmlPullParser.END_TAG)
                        txt += "</" + parser.getName() + ">\n";

                    event = parser.next();
                }
                fin.close();

                Toast.makeText(ac, "Leido correctamente", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return txt;
    }

    public static ArrayList<String> getFiles(Activity ac) {
        // Array TEXTO donde guardaremos los nombres de los ficheros
        ArrayList<String> item = new ArrayList<>();

        //Defino la ruta donde busco los ficheros
        File f = new File(ac.getFilesDir().getPath());
        //Creo el array de tipo File con el contenido de la carpeta
        File[] files = f.listFiles();


        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
        for (File file : files) {
            //Sacamos del array files un fichero
            //Si es directorio...
            if (file.isDirectory())

                item.add(file.getName() + "/");

                //Si es fichero...
            else

                item.add(file.getName());
        }

        return item;

    }

    public static ArrayList<TransferJugador> getPlayersFromXML(Activity ac, String xmlFile) {

        ArrayList<TransferJugador> tjs = new ArrayList<>();
        FileInputStream fin;


        try {
            fin = ac.openFileInput(xmlFile);

            XmlPullParser parser = Xml.newPullParser();
            try {
                parser.setInput(fin, "UTF-8");

                int event = parser.next();
                TransferJugador tj = new TransferJugador(0);

                while (event != XmlPullParser.END_DOCUMENT) {

                    if(event == XmlPullParser.START_TAG) {
                        switch (parser.getName()) {

                            case "player":

                                tj = new TransferJugador(Integer.valueOf(parser.getAttributeValue(0)));
                                tjs.add(tj);

                                break;
                            case "t2v":
                                parser.next();
                                tj.setT2v(Integer.valueOf(parser.getText()));

                                break;
                            case "t2x":
                                parser.next();
                                tj.setT2x(Integer.valueOf(parser.getText()));

                                break;
                            case "t3v":
                                parser.next();
                                tj.setT3v(Integer.valueOf(parser.getText()));

                                break;
                            case "t3x":
                                parser.next();
                                tj.setT3x(Integer.valueOf(parser.getText()));

                                break;
                            case "tlv":
                                parser.next();
                                tj.setTlv(Integer.valueOf(parser.getText()));

                                break;
                            case "tlx":
                                parser.next();
                                tj.setTlx(Integer.valueOf(parser.getText()));

                                break;
                            case "falv":
                                parser.next();
                                tj.setFalv(Integer.valueOf(parser.getText()));

                                break;
                            case "falx":
                                parser.next();
                                tj.setFalx(Integer.valueOf(parser.getText()));

                                break;
                            case "tapv":
                                parser.next();
                                tj.setTapv(Integer.valueOf(parser.getText()));

                                break;
                            case "tapx":
                                parser.next();
                                tj.setTapx(Integer.valueOf(parser.getText()));

                                break;
                            case "rebOf":
                                parser.next();
                                tj.setRebOf(Integer.valueOf(parser.getText()));

                                break;
                            case "rebDef":
                                parser.next();
                                tj.setRebDef(Integer.valueOf(parser.getText()));

                                break;
                            case "rec":
                                parser.next();
                                tj.setRec(Integer.valueOf(parser.getText()));

                                break;
                            case "per":
                                parser.next();
                                tj.setPer(Integer.valueOf(parser.getText()));

                                break;
                            case "as":
                                parser.next();
                                tj.setAs(Integer.valueOf(parser.getText()));

                                break;

                            case "horas":
                                parser.next();
                                tj.getTime().setHoras(Integer.valueOf(parser.getText()));

                                break;

                            case "minutos":
                                parser.next();
                                tj.getTime().setMinutos(Integer.valueOf(parser.getText()));

                                break;

                            case "segundos":
                                parser.next();
                                tj.getTime().setSegundos(Integer.valueOf(parser.getText()));

                                break;

                            case "decimas":
                                parser.next();
                                tj.getTime().setDecimas(Integer.valueOf(parser.getText()));

                                break;


                        }
                    }

                    event = parser.next();
                }


                fin.close();


            } catch (Exception e) {
                Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG).show();
            }


        } catch (Exception e) {
            Toast.makeText(ac, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return tjs;
    }

    public static void copyFile(File src, File dst) throws IOException {
        FileChannel inChannel = new FileInputStream(src).getChannel();
        FileChannel outChannel = new FileOutputStream(dst).getChannel();
        try
        {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
        finally
        {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    }

}

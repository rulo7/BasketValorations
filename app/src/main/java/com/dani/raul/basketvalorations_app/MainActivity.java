package com.dani.raul.basketvalorations_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dani.raul.basketvalorations_app.activities.ContraActivity;
import com.dani.raul.basketvalorations_app.activities.WebViewActivity;


public class MainActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) this.findViewById(R.id.startbutton);
        start.setOnClickListener(this);

        Button xml = (Button) this.findViewById(R.id.buttonXML);
        xml.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonXML) {
            this.startActivity(new Intent(this, WebViewActivity.class));
        }else{
            this.startActivity(new Intent(this, ContraActivity.class));
        }
    }
}

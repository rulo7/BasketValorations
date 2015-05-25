package com.dani.raul.basketvalorations_app.activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dani.raul.basketvalorations_app.R;
import com.dani.raul.basketvalorations_app.persistance.XMLPersistance;

import org.json.JSONArray;

public class WebViewActivity extends Activity {


    private WebView webView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (this.webView.getUrl().substring(this.webView.getUrl().length() - 3, this.webView.getUrl().length()).equals("xml")) {
            outState.putString("url", this.webView.getUrl());
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);



        if (savedInstanceState!=null && savedInstanceState.getString("url") != null) {
            webView.loadUrl(savedInstanceState.getString("url"));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) this.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "WebViewActivity");


        if (savedInstanceState!=null && savedInstanceState.getString("url") != null) {
            webView.loadUrl(savedInstanceState.getString("url"));
        } else {


            webView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    for (String match : XMLPersistance.getFiles(WebViewActivity.this)) {
                        view.loadUrl("javascript:appendButton('" + match + "')");
                    }
                }
            });

            webView.loadUrl("file:///android_asset/view.html");
        }


    }


    @JavascriptInterface
    public void mostrarValorations(String file) {

        this.webView.loadUrl("file:///" + this.getFilesDir().getPath() + "/" + file);

    }


}

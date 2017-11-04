package com.desafiolatam.pricebtc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.desafiolatam.pricebtc.models.Indicator;
import com.desafiolatam.pricebtc.network.GetAmountByCurrency;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundBtc().execute("1", "CLP");
            }
        });
    }
    private class BackgroundBtc extends GetAmountByCurrency{

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Indicator indicator) {
            if (indicator != null){
                TextView textView = (TextView) findViewById(R.id.btcTv);
                textView.setText(indicator.getCurrency() + ": " + indicator.getValue());


            }
            progressDialog.dismiss();
        }
    }


}

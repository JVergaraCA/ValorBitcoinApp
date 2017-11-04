package com.desafiolatam.pricebtc.network;

import android.os.AsyncTask;
import android.util.Log;

import com.desafiolatam.pricebtc.models.Indicator;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by JuanCarlos on 14-10-17.
 */

public class GetAmountByCurrency extends AsyncTask<String , Void, Indicator> {
    @Override
    protected Indicator doInBackground(String... strings) {

        BitcoinCurrency bitcoinCurrency = new Amount().getBasic();
        Call<Indicator> indicator = bitcoinCurrency.amountByCurrency(strings[0], strings[1]);

        try {
            Response<Indicator> response = indicator.execute();
            Log.d("RESPONSE", String.valueOf(response.code()));
            if (200 == response.code() && response.isSuccessful()){
                return response.body();
            }else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

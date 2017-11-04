package com.desafiolatam.pricebtc.network;


import com.desafiolatam.pricebtc.models.Indicator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JuanCarlos on 14-10-17.
 */

public interface BitcoinCurrency {

    @GET("convert/{amount}/{currency}")
    Call<Indicator> amountByCurrency(@Path("amount") String amount, @Path("currency") String currency);
}

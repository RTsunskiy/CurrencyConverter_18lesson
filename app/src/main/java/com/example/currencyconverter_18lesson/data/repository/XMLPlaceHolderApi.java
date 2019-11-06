package com.example.currencyconverter_18lesson.data.repository;

import com.example.currencyconverter_18lesson.data.model.CurrencyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface XMLPlaceHolderApi {
    @GET("scripts/XML_daily.asp")
    Call<List<CurrencyModel>> loadCurrencies();
}

package com.example.currencyconverter_18lesson.data.repository;


import android.widget.Toast;

import com.example.currencyconverter_18lesson.data.model.CurrencyModel;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CurrencyRepository {

    private static CurrencyRepository mInstance;
    private static final String BASE_URL = "http://www.cbr.ru";
    private Retrofit mRetrofit;
    private final XMLPlaceHolderApi mRatesApi;
    private  List<CurrencyModel> listOfCurrency;
    Strategy strategy = new AnnotationStrategy();
    Serializer serializer = new Persister(strategy);

    public List<CurrencyModel> getListOfCurrency() {
        return listOfCurrency;
    }

    public CurrencyRepository() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .build();
        mRatesApi = mRetrofit.create(XMLPlaceHolderApi.class);
        setCurrencies();
    }

    public static CurrencyRepository getInstance() {
        if (mInstance == null) {
            mInstance = new CurrencyRepository();
        }
        return mInstance;
    }

    public XMLPlaceHolderApi getXMLApi() {
        return mRetrofit.create(XMLPlaceHolderApi.class);
    }

        private void setCurrencies() {
            Call<List<CurrencyModel>> curencies = mRatesApi.loadCurrencies();

            curencies.enqueue(new Callback<List<CurrencyModel>>() {
                @Override
                public void onResponse(Call<List<CurrencyModel>> call, Response<List<CurrencyModel>> response) {
                     listOfCurrency = response.body();
                }

                @Override
                public void onFailure(Call<List<CurrencyModel>> call, Throwable t) {
                }
            });
        }

}

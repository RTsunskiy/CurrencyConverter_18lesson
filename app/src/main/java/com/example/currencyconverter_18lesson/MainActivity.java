package com.example.currencyconverter_18lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.currencyconverter_18lesson.data.model.CurrencyModel;
import com.example.currencyconverter_18lesson.data.repository.CurrencyRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyRepository r = new CurrencyRepository();
       List<CurrencyModel> t =  r.getListOfCurrency();
    }
}

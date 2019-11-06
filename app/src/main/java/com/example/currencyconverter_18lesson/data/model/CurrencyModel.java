package com.example.currencyconverter_18lesson.data.model;



import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;




@Root(name = "Valute", strict = false)
public class CurrencyModel {

    @Attribute(name = "ID")
    private String mId;
    @Element(name = "NumCode")
    private int mNumCode;
    @Element(name = "CharCode")
    private String mCharCode;
    @Element(name = "Nominal")
    private long mNominal;
    @Element(name = "Name")
    private String mName;
    @Element(name = "Value")
    private String mValue;
    public CurrencyModel() {

    }


    public String getId() {
        return mId;
    }

    public int getNumCode() {
        return mNumCode;
    }

    public String getCharCode() {
        return mCharCode;
    }

    public long getNominal() {
        return mNominal;
    }

    public String getName() {
        return mName;
    }


}
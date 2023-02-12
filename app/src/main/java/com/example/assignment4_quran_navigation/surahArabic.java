package com.example.assignment4_quran_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.assignment4_quran_navigation.adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class surahArabic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_arabic);
        String surahNumber,surahName;
        Intent intent = getIntent();
        surahName = intent.getStringExtra("surahName");
        surahNumber = intent.getStringExtra("surahNumber");
        int surahNo = Integer.parseInt(surahNumber);
        TextView txtSurahArabic = findViewById(R.id.txtSurahArabic);
        String surahArabicText = "";
        try{
            JSONArray ary = new JSONArray(loadJSONFromAssets());
            for(int i=0; i<ary.length(); i++)
            {
                JSONObject ArrayObject = ary.getJSONObject(i);
                int objSurahNo = ArrayObject.getInt("surah_number");
                if(objSurahNo==surahNo)
                {
                    Log.d("msg","inside the if statement");
                    surahArabicText = surahArabicText.concat(ArrayObject.getString("text"));

                }
                if(objSurahNo>surahNo)
                {
                    break;
                }

            }
            txtSurahArabic.setText(surahArabicText);



        }
        catch (Exception ex)
        {

        }


    }
    private String loadJSONFromAssets() {
        String json = null;
        try{
            InputStream is = getAssets().open("QuranMetaData.json");
            int size = is.available();
            byte [] buffer =  new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();;
            return null;
        }
        return json;
    }
}
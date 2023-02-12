package com.example.assignment4_quran_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.assignment4_quran_navigation.adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;
        HashSet<SurahNumberAndNames> surahNames = new HashSet<>();
        SurahNumberAndNames object;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try{
            JSONArray ary = new JSONArray(loadJSONFromAssets());
            for(int i=0; i<ary.length(); i++)
            {
                JSONObject ArrayObject = ary.getJSONObject(i);
                object = new SurahNumberAndNames(ArrayObject.getString("surah_name"),ArrayObject.getInt("surah_number"));
                surahNames.add(object);
            }
            ArrayList<SurahNumberAndNames> list = new ArrayList<SurahNumberAndNames>(surahNames);
            Collections.sort(list);
            Log.d("msg","" + list.toString());
            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,list);
            recyclerView.setAdapter(recyclerViewAdapter);

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


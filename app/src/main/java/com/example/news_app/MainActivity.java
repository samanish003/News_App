package com.example.news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String api = "d29d58aab88d4ea0b04ddb245a230068";
    RecyclerView recyclerView;
    Adapter adapter;
    ProgressBar progressBar;
    private ArrayList<ModelClass> modelClassList = new ArrayList<>();
//    ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
//        modelClassArrayList.add(new ModelClass("id1", "name1", "description1", "url1", "category1", "language1", "country1", "title1", "urlToImage1"));
//        modelClassArrayList.add(new ModelClass("id2", "name2", "description2", "url2", "category2", "language2", "country2", "title2", "urlToImage2"));
//        modelClassArrayList.add(new ModelClass("id3", "name3", "description3", "url3", "category3", "language3", "country3", "title3", "urlToImage3"));
//        modelClassArrayList.add(new ModelClass("id4", "name4", "description4", "url4", "category4", "language4", "country4", "title4", "urlToImage4"));
        adapter = new Adapter(this, modelClassList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.VISIBLE);
        findNews();


    }
    public  void findNews()
    {
        ApiUtilities.getApiInterface().getNews(api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {

                Log.d("TAG","Done4");
                if(response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                    modelClassList.addAll(response.body().getSources());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not Done", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });

    }
}
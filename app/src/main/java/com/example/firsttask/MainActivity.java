package com.example.firsttask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firsttask.Adopter.Adopter;
import com.example.firsttask.Model.Data;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends Activity {
ListView list;
    ArrayList<Data> data=new ArrayList<Data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.List);
     new mytask().execute();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Ali",""+position);
                Data d=data.get(position);

                String country=d.getCountry();
                int rank=d.getRank();
                String rank1=Integer.toString(rank);
                String flag=d.getFlag();
                String pupolation=d.getPopulation();
                Intent intent = new Intent(MainActivity.this,ClickList.class);

                intent.putExtra("rank", rank1);
                intent.putExtra("flag", flag);
                intent.putExtra("population", pupolation);
                intent.putExtra("country", country);
                startActivity(intent);


            }
        });
    }
class mytask extends AsyncTask<String,String,String>{
    JSONObject jsonp=null;
    JSONArray jsonA=null;
    JSONParser jsonF=null;
    String url="http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";





    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        jsonF=new JSONParser();
        jsonp=new JSONObject();
        jsonA=new JSONArray();
        jsonp=jsonF.getJSONFromUrl(url);
        try
        {
            jsonA=jsonp.getJSONArray("worldpopulation");
            for (int i=0;i<jsonA.length();i++)
            {  jsonp=jsonA.getJSONObject(i);
                int rank=jsonp.getInt("rank");
                String country=jsonp.getString("country");
                String population=jsonp.getString("population");
                String flag=jsonp.getString("flag");
                Log.d("Ali", "id:" + flag);
                Data d=new Data(country,rank,population,flag);
                data.add(i,d);
             }


        }
        catch (JSONException ex)
        {
ex.printStackTrace();

        }




        return null;

    }
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Adopter adopter=new Adopter(MainActivity.this,data);
        list.setAdapter(adopter);

    }
}

}

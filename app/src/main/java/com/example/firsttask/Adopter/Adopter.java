package com.example.firsttask.Adopter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firsttask.MainActivity;
import com.example.firsttask.Model.Data;
import com.example.firsttask.Model.DownloadImageTask;
import com.example.firsttask.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by HP PROBOOK 450 on 4/27/2015.
 */
public class Adopter extends BaseAdapter {

    Context context;
    ArrayList<Data> data=new ArrayList<Data>();


    public Adopter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.indexOf(getItem(position));
    }
    int con=0;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageLoader img;
        img=ImageLoader.getInstance();




        Holder h=null;

        if (convertView == null) {
            h=new Holder();
            LayoutInflater miflater = LayoutInflater.from(context);
            convertView = miflater.inflate(R.layout.list_item, null);
            h.rank=(TextView)convertView.findViewById(R.id.ranktv);
            h.counytry=(TextView)convertView.findViewById(R.id.countrytv);
            h.population=(TextView)convertView.findViewById(R.id.populationtv);
            h.flag=(ImageView)convertView.findViewById(R.id.imgview);
             convertView.setTag(h);

        }
        else {
            h=(Holder)convertView.getTag();

        }
        Data rowitme=(Data)getItem(position);
        String a= Integer.toString(rowitme.getRank());

        h.rank.setText(a);
        h.counytry.setText(rowitme.getCountry());
        h.population.setText(rowitme.getPopulation());
        img.displayImage(rowitme.getFlag(),h.flag);



        return convertView;

    }



    }

class Holder
{
    TextView rank,counytry,population;
    ImageView flag;
}

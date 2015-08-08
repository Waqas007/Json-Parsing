package com.example.firsttask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firsttask.Model.DownloadImageTask;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by HP PROBOOK 450 on 4/28/2015.
 */
public class ClickList extends Activity {
    ImageView img;
    TextView rank,cuntry,population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_click);
    rank=(TextView)findViewById(R.id.ranktv1);
        cuntry=(TextView)findViewById(R.id.countrytv1);
        population=(TextView)findViewById(R.id.populationtv1);
    img=(ImageView)findViewById(R.id.imgview1);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String rank1 = b.getString("rank");
        String flag1 = b.getString("flag");
        String country1 = b.getString("country");
        String population1 = b.getString("population");
        rank.setText(rank1);
        cuntry.setText(country1);
        population.setText(population1);
        ImageLoader mg;
        mg=ImageLoader.getInstance();
        mg.displayImage(flag1,img);

    }
}

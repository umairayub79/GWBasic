package umairayub.gwbasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import spencerstudios.com.bungeelib.Bungee;
/*Created by Umair Ayub
20 - 12 - 2018
*/
public class ProgramsListActivity extends AppCompatActivity {


    ListView listview;
    String name,code;
    int id;
    ArrayList<Item>list;
    Item mitem;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_list);

        listview = (ListView)findViewById(R.id.listview);
        list = new ArrayList<>();

        MobileAds.initialize(this, "");

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(this.loadJSONFromAsset());

            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);

                name = jSONObject.getString("name");
                id = jSONObject.getInt("id");
                code = jSONObject.getString("code");

                mitem = new Item(id, name, code);
                list.add(mitem);

            }

        } catch (JSONException e) {
        }


        ArrayAdapter<Item> arrayAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1,list);

        sortArray();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item po =  list.get(i);

                String mcode = po.getCode();
                String name = po.getName();

                Bundle bundle = new Bundle();
                bundle.putString("NAME",name);
                bundle.putString("CODE", mcode);

                Intent intent = new Intent(ProgramsListActivity.this,programcode.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Bungee.fade(ProgramsListActivity.this);



            }
        });
        listview.setAdapter(arrayAdapter);

    }



    public void sortArray(){
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.getName().compareTo(t1.getName());

            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("programs.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(this);
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}

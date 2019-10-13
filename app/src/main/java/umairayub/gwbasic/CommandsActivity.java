package umairayub.gwbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;

import spencerstudios.com.bungeelib.Bungee;

/*Created by Umair Ayub
20 - 12 - 2018
*/

public class CommandsActivity extends AppCompatActivity {

    ListView listView;
    private ArrayAdapter<String> listAdapter ;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmd);
        listView = (ListView)findViewById(R.id.ListView);

        MobileAds.initialize(this, "");


        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayList<String> list = new ArrayList<String>();

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);


        listAdapter.add("AUTO \nThis command is used to automatically generate line numbers");
        listAdapter.add("BLOAD \nThis command is used to load an image file anywhere in user memory.");
        listAdapter.add("BSAVE \nThis command is used to save portions of user memory on the specified device.");
        listAdapter.add("CHDIR \nThis command is used to change from one working directory to another.");
        listAdapter.add("CLEAR \nThis command is used to set all numeric variables to zero, all string variables to null, and to close all open files. Options set the end of memory and reserve the amount of string and stack space available for use by GW-BASIC.");
        listAdapter.add("CONT \nThis command is used to continue program execution after a break.");
        listAdapter.add("DELETE \nThis command is used to delete program lines or line ranges.");
        listAdapter.add("EDIT  \nThis command is used to display a specified line,and to position the cursor under the first digit of the line number,so that the line may be edited");
        listAdapter.add("FILES \nThis command is used to print the names of the files residing on the specified memory.");
        listAdapter.add("KILL \nThis command is used to delete a file from disk");
        listAdapter.add("LIST \nThis command is used to list all or part of a program currently in memory.");
        listAdapter.add("LLIST \nThis command is used to list all or part of the program currently in memory to the line printer.");
        listAdapter.add("LOAD \nThis command is used to load a file from diskette into memory.");
        listAdapter.add("MERGE \nThis command is used to merge the lines from an ASCII program file into the program already in memory.");
        listAdapter.add("MKDIR \nThis command is used to create a sub-directory.");
        listAdapter.add("NAME \nThis command is used to change the name of a disk file");
        listAdapter.add("NEW \nThis command is used to clear the memory.");
        listAdapter.add("PCOPY \nThis command is used to copy one screen page to another in all screen modes.");
        listAdapter.add("RENUM \nThis command is used to close all disk files and write the directory information to a diskette before it is removed from a disk drive.");
        listAdapter.add("RESET \nThis command is used to close all disk files and write the directory information to a diskette before it is removed from a disk drive.");
        listAdapter.add("RMDIR \nThis command is used to delete a subdirectory.");
        listAdapter.add("RUN \nThis commmand is used to execute the program currently in memory.");
        listAdapter.add("SAVE \nThis command is used to save a program file on diskette");
        listAdapter.add("TRON/TROFF \nThis command is used to trace the execution of program statements.");
        listAdapter.add("SYSTEM \nThis command is used to close GW-BASIC and return to opearating system");
        // Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter( listAdapter );
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
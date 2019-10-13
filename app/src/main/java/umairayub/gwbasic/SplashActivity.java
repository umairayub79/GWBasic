package umairayub.gwbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spencerstudios.com.bungeelib.Bungee;

/*Created by Umair Ayub
20 - 12 - 2018
*/
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Bungee.slideRight(SplashActivity.this);
        finish();
    }

}
package umairayub.gwbasic;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import spencerstudios.com.bungeelib.Bungee;

/*Created by Umair Ayub
20 - 12 - 2018
*/
public class programcode extends AppCompatActivity {

    TextView tvcode,tvname;
    Button btnC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programcode);
        tvcode = (TextView)findViewById(R.id.code);
        tvname = (TextView)findViewById(R.id.name);
        btnC = (Button) findViewById(R.id.btnC);


        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("NAME");
        String code = bundle.getString("CODE");

        tvcode.setText(code);
        tvname.setText(name);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ccode = tvcode.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Quote", ccode);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(programcode.this, "Code Copied to Clipboard!", Toast.LENGTH_SHORT).show();


            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(this);
    }
}
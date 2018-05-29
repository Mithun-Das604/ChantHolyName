package chant.holyname;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hindu,muslim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar =(android.support.v7.widget.Toolbar)findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);


        hindu = (Button)findViewById(R.id.HinduId);
        muslim = (Button)findViewById(R.id.MuslimId);

        hindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Hindu.class);
                startActivity(intent);

            }
        });

        muslim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Muslim.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.ShareMenuId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "CHANT_HOLY_NAME";
            String body = "CHANT HOLY NAME OF GOD AND MAKE LIFE HAPPY...";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share with others"));




        }
        else if (id == R.id.FeedBackMenuId){

            Intent intent = new Intent(MainActivity.this,FeedBack.class);
            startActivity(intent);
        }
        else if (id == R.id.AboutMenuId){

            AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);
            alertdialogbuilder.setTitle("          About US");

           alertdialogbuilder.setMessage("Developer : Mithun Das\nDepartment of CSE,UAP\nFor any comment or suggestion please contact us (mithuncse404@gmail.com");


            AlertDialog alertDialog = alertdialogbuilder.create();
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }
}

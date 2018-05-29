package chant.holyname;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Hindu extends AppCompatActivity {
    ImageButton countbutton;
    TextView japacount,beatcount;
    private static double  japavalue,beatvalue;
    ImageButton japareset,beatreset;

    private  TextView textView;
    private  float textsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu);

        android.support.v7.widget.Toolbar toolbar =(android.support.v7.widget.Toolbar)findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        countbutton = (ImageButton) findViewById(R.id.countbutton);
        japacount = (TextView)findViewById(R.id.japaroundid);
        beatcount = (TextView)findViewById(R.id.beatcountid);

        japareset = (ImageButton)findViewById(R.id.japareset) ;
        beatreset = (ImageButton)findViewById(R.id.beatreset) ;

     //   textView = (TextView)findViewById(R.id.testtextsize);






        japareset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                japacount.setText("0");
                japareset.setRotation(japareset.getRotation()+240);


            }
        });

        beatreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beatcount.setText("0");
                beatreset.setRotation(beatreset.getRotation()+240);
            }
        });

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);

        countbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mp.start();


                String beat = beatcount.getText().toString();

                beatvalue=Double.parseDouble(beat);

                beatvalue++;
                if(beatvalue < 108){



                    if((int )beatvalue == beatvalue){





                        String value = String.valueOf((int)beatvalue);

                        beatcount.setText(value);




                    }







                }
                else {

                    // Get instance of Vibrator from current Context
                    Vibrator v = (Vibrator) getSystemService(Hindu.VIBRATOR_SERVICE);

                   // Vibrate for 400 milliseconds
                    v.vibrate(400);
                    beatcount.setText("0");

                    String japa = japacount.getText().toString();

                    japavalue=Double.parseDouble(japa);
                    japavalue++;

                    if((int )japavalue == japavalue){



                        String value1 = String.valueOf((int)japavalue);

                        japacount.setText(value1);



                    }




                }


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

            Intent intent = new Intent(Hindu.this,FeedBack.class);
            startActivity(intent);
        }
        else if (id == R.id.AboutMenuId){

            AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Hindu.this);
            alertdialogbuilder.setTitle("          About US");

            alertdialogbuilder.setMessage("Developer : Mithun Das\nDepartment of CSE,UAP\nFor any comment or suggestion please contact us (mithuncse404@gmail.com");


            AlertDialog alertDialog = alertdialogbuilder.create();
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }
}

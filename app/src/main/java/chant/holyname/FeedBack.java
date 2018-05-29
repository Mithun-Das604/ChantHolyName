package chant.holyname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity {

    private Button send, cancel;

    private EditText namefield, messagefield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        send = (Button) findViewById(R.id.sendid);
        cancel =(Button)findViewById(R.id.cancelid);

        namefield = (EditText)findViewById(R.id.nameid);
        messagefield= (EditText)findViewById(R.id.messageid);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = namefield.getText().toString();
                String  message = messagefield.getText().toString();

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"mithuncse404@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Feed back from CHANT HOLY NAME APP");
                    intent.putExtra(Intent.EXTRA_TEXT,"name: "+ name +  "\nmessage: "+ message );

                    startActivity(Intent.createChooser(intent,"Feed Back With "));
                }
                catch (Exception e){
                    Toast.makeText(FeedBack.this,"Please tray again... ",Toast.LENGTH_SHORT).show();
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

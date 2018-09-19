package comp.yukkina.anacex1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {
private static final String MESSAGE="MSG";


    public static void start(Activity main,String msg){
        final Intent intent= new Intent(new Intent(main, PreviewActivity.class));
        intent.putExtra(MESSAGE,msg);
        main.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        final String msg = getIntent().getStringExtra(MESSAGE);
        final TextView previewText = findViewById(R.id.prev_text);
        previewText.setText(msg);
        final Button emButton=findViewById(R.id.em_button);
        emButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*     String[] address = {
                        "androidacademy@gmail.com","ya@ya.ru"
                };*/
                open_Email(msg);
            }
        });
    }

        private void open_Email(String msg) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:andr.academy.msk@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.default_subject));
           // intent.putExtra(Intent.EXTRA_CC,addr);
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            if (intent.resolveActivity(getPackageManager()) == null) {
                Toast.makeText(PreviewActivity.this, R.string.warning_no_email, Toast.LENGTH_LONG).show();
                return;
            }

            startActivity(intent);
        }

    }

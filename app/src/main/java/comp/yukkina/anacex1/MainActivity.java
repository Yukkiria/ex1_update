package comp.yukkina.anacex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button prevbut = findViewById(R.id.preview_button);
        final EditText message=findViewById(R.id.msg_ed);

        prevbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String msg = message.getText().toString();
                if (msg.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.warning, Toast.LENGTH_LONG).show();
                    return;
                }
               PreviewActivity.start(MainActivity.this, msg);

            }

        });
    }
}

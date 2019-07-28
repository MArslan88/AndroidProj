package com.example.muhammadarslan.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech ttsobject;
    Button speakBtn;
    Button StopBtn;
    EditText editText;
    int result;
    String text;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(ttsobject !=null){
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speakBtn=(Button)findViewById(R.id.speakBtn);
        StopBtn=(Button)findViewById(R.id.StopBtn);
        editText=(EditText) findViewById(R.id.editText);

        ttsobject = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    result=ttsobject.setLanguage(Locale.US);
                }else{
                    Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        speakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.speakBtn:
                        if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                            Toast.makeText(getApplicationContext(),"Feature not supported in your device",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            text = editText.getText().toString();
                            ttsobject.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                        }
                        break;
                    case R.id.StopBtn:
                        if(ttsobject !=null){
                            ttsobject.stop();
                        }
                        break;
                }
            }
        });




    }
}

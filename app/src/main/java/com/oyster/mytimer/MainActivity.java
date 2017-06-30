package com.oyster.mytimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 1초마다 텍스트를 갱신하는 타이머예제
 * 출처: http://egloos.zum.com/hiiq/v/1845943
 */
public class MainActivity extends AppCompatActivity {
    private TimerTask sec;
    private TextView timerText;
    private final Handler handler =  new Handler();
    private int timer_sec = 0;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testStart();
            }
        });

    }

    public void testStart(){
        timerText = (TextView)findViewById(R.id.tx);

        timer_sec  = 0;

        sec = new TimerTask() {
            @Override
            public void run() {
                    Update();
                    timer_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(sec, 0, 1000);
    }


    protected void Update(){
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                timerText.setText(timer_sec+"초");
            }
        };
        handler.post(updater);

    }

}

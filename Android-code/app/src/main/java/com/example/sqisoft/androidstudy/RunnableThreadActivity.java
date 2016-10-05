package com.example.sqisoft.androidstudy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RunnableThreadActivity extends AppCompatActivity {

    ProgressBar bar;
    TextView textView01;
    boolean isRunning = false;
    Handler handler;
    ProgressRunnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runable_thread);

        bar = (ProgressBar) findViewById(R.id.progress);
        textView01 = (TextView) findViewById(R.id.textView01);

        handler = new Handler();
        runnable = new ProgressRunnable();

    }

    public void onStart(){
        super.onStart();

        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++){
                        Thread.sleep(1000);
                        handler.post(runnable);
                    }
                }catch (Exception ex){
                    Log.e("SampleThreadActivity", "Exception in processing message.", ex);

                }
            }
        });

        isRunning = true;
        thread1.start();
    }

    public void onStop() {
        super.onStop();

        isRunning = false;
    }


    public class ProgressRunnable implements Runnable {

        public void run() {

            bar.incrementProgressBy(5);

            if (bar.getProgress() == bar.getMax()) {
                textView01.setText("Runnable Done");
            } else {
                textView01.setText("Runnable Working ..." + bar.getProgress());
            }

        }

    }

}




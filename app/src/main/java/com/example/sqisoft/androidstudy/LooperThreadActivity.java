package com.example.sqisoft.androidstudy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 루퍼를 사용하는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 *
 */
public class LooperThreadActivity extends AppCompatActivity {

    TextView textView01,textView02;
    EditText editText01,editText02;

    /**
     * 메인 스레드의 핸들러
     */
    MainHandler mainHandler;

    /**
     * 새로 만든 스레드
     */
    ProcessThread thread1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_thread);

        mainHandler = new MainHandler();
        thread1 = new ProcessThread();//새로운 스레드를 메인에서 만들어줬다.

        textView01 = (TextView) findViewById(R.id.textView01);
        textView02 = (TextView) findViewById(R.id.textView02);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);

        // 버튼 이벤트 처리
        Button processBtn = (Button) findViewById(R.id.processBtn);
        processBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inStr = editText01.getText().toString(); //첫번째 에딧에서 텍스트를 긁는다.
                Message msgToSend = Message.obtain();//메세지 객체 얻어서..
                msgToSend.obj = inStr;//메세지 객체에 넣는다.

                thread1.handler.sendMessage(msgToSend);//새로운 스레드에게 텍스트를 날린다.
            }
        });
    }

    class ProcessThread extends Thread{

        ProcessHandler handler;

        public ProcessThread(){
            handler = new ProcessHandler();
        }

        public  void run(){
            // 루퍼 사용 -->서브 스레드를 만들면 메시지를 받기위해 루퍼를 만들어야함.
            Looper.prepare();
            Looper.loop();
        }

    }

    class ProcessHandler extends Handler{
        public void handleMessage(Message msg){
            Message resultMsg = Message.obtain();
            resultMsg.obj = msg.obj + "Mike!!!";
           // editText02.setText((String)resultMsg.obj);
            mainHandler.sendMessage(resultMsg);
        }
    }

    class MainHandler extends Handler{
        public void handleMessage(Message msg){
            String str = (String) msg.obj;
           editText02.setText(str);
        }
    }

}



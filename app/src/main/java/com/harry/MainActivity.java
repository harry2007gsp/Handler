package com.harry;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NetworkConnection networkConnection;
    MyHandler myHandler;
    static TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        myHandler = new MyHandler();

    }

    public void fetchDataOnButton(View view) {
        networkConnection = new NetworkConnection();
        Runnable runnable = new Runnable() {
            public String runnableString = "abcd";

            @Override
            //this runnable is just like first wait for something to get executed and processed and then this
            // would be displayed after that.
            public void run() {
                Log.d("test", runnableString);
            }
        };
        networkConnection.fetchData(myHandler, runnable);


    }

    public static class MyRunnable implements Runnable {
        private final String message;

        MyRunnable(final String message) {
            this.message = message;
        }
        public void run() {
            Log.d("test",message);
            text.setText(message); // gettting data from background thread and publishing on UI
        }
    }


    static class MyHandler extends Handler {

//        @Override
//        public void handleMessage(Runnable runnable) {
//            super.handleMessage(runnable);
//            Log.d("test", "on Handle message");
//            String s = runnable.getData().getString("string");
//            text.setText(s);
//        }
    }
//    static class MyHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Log.d("test", "on Handle message");
//            String s = msg.getData().getString("string");
//            text.setText(s);
//        }
//    }
}

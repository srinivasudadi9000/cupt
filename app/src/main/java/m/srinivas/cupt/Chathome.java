package m.srinivas.cupt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Chathome extends Activity implements View.OnClickListener {
    TextView logs_tv, operator_tv, chat_tv;
    RecyclerView chat_recyler;

    ArrayList<Chat> chatArrayList;
    ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chathome);

        chat_recyler = findViewById(R.id.chat_recyler);
        chat_recyler.setLayoutManager(new LinearLayoutManager(this));

        chatArrayList = new ArrayList<Chat>();
        chatArrayList.add(new Chat("Profilepic", "Dadi", "whatsup"));
        chatArrayList.add(new Chat("Profilepic", "Dadi", "whatsup"));
        chatArrayList.add(new Chat("Profilepic", "Dadi", "whatsup"));
        chatArrayList.add(new Chat("Profilepic", "Dadi", "whatsup"));
        chatArrayList.add(new Chat("Profilepic", "Dadi", "whatsup"));


        operator_tv = findViewById(R.id.operator_tv);
        logs_tv = findViewById(R.id.logs_tv);
        chat_tv = findViewById(R.id.chat_tv);

        chatAdapter = new ChatAdapter(chatArrayList, R.layout.chatsingle, getApplicationContext());
        chat_recyler.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();

        operator_tv.setOnClickListener(this);
        logs_tv.setOnClickListener(this);
        chat_tv.setOnClickListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.operator_tv:
                operator_tv.setBackground(getResources().getDrawable(R.drawable.green));
                logs_tv.setBackgroundResource(0);
                chat_tv.setBackgroundResource(0);
                operator_tv.setTextColor(getColor(R.color.white));
                logs_tv.setTextColor(getColor(R.color.black));
                chat_tv.setTextColor(getColor(R.color.black));
                chatAdapter = new ChatAdapter(chatArrayList, R.layout.chatsingle, getApplicationContext());
                chat_recyler.setAdapter(chatAdapter);
                chatAdapter.notifyDataSetChanged();

                break;
            case R.id.logs_tv:
                operator_tv.setBackgroundResource(0);
                logs_tv.setBackground(getResources().getDrawable(R.drawable.green));
                chat_tv.setBackgroundResource(0);
                logs_tv.setTextColor(getColor(R.color.white));
                operator_tv.setTextColor(getColor(R.color.black));
                chat_tv.setTextColor(getColor(R.color.black));

                chatAdapter = new ChatAdapter(chatArrayList, R.layout.logsingle, getApplicationContext());
                chat_recyler.setAdapter(chatAdapter);
                chatAdapter.notifyDataSetChanged();
                break;
            case R.id.chat_tv:
                logs_tv.setTextColor(getColor(R.color.black));
                chat_tv.setTextColor(getColor(R.color.white));
                operator_tv.setBackgroundResource(0);
                operator_tv.setTextColor(getColor(R.color.black));
                logs_tv.setBackgroundResource(0);
                chat_tv.setBackground(getResources().getDrawable(R.drawable.green));

                chatAdapter = new ChatAdapter(chatArrayList, R.layout.chatsingle, getApplicationContext());
                chat_recyler.setAdapter(chatAdapter);
                chatAdapter.notifyDataSetChanged();
                break;
        }
    }
}

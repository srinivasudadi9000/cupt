package m.srinivas.cupt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.CheckIn> {


    ArrayList<Chat> chats;
    int Rowlayout;
    Context context;

    public LogAdapter(ArrayList<Chat> Chat, int check_single, Context applicationContext) {
        this.context = applicationContext;
        this.Rowlayout = check_single;
        this.chats = Chat;
    }


    @NonNull
    @Override
    public CheckIn onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(Rowlayout, parent, false);
        return new CheckIn(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CheckIn holder, int position) {
        holder.name_tv.setText(chats.get(position).getName());
        holder.status_tv.setText(chats.get(position).getStatus());


        holder.logsingle_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    whatsappIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(whatsappIntent);

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, "Whatsapp have not been installed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class CheckIn extends RecyclerView.ViewHolder {
        TextView name_tv, status_tv;
        LinearLayout chatsingle_ll, logsingle_ll;

        public CheckIn(View itemView) {
            super(itemView);
            chatsingle_ll = (LinearLayout)itemView.findViewById(R.id.chatsingle_ll);
            logsingle_ll = (LinearLayout)itemView.findViewById(R.id.logsingle_ll);

            name_tv = (TextView) itemView.findViewById(R.id.name_tv);
            status_tv = (TextView) itemView.findViewById(R.id.status_tv);



            Animation animation;
            animation = AnimationUtils.loadAnimation(context,R.anim.slidein);
            logsingle_ll.startAnimation(animation);

        }
    }

    private void openWhatsApp(String phone) {
        String smsNumber = phone; // E164 format without '+' sign
        /* */

        PackageManager packageManager = context.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        try {
            String url = "https://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + URLEncoder.encode("hello", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                context.startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
            sendIntent.setPackage("com.whatsapp");
            context.startActivity(sendIntent);


        }
    }

}

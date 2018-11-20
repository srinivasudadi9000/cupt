package m.srinivas.cupt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.CheckIn> {


    ArrayList<Chat> chats;
    int Rowlayout;
    Context context;

    public ChatAdapter(ArrayList<Chat> Chat, int check_single, Context applicationContext) {
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
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class CheckIn extends RecyclerView.ViewHolder {
        TextView name_tv, status_tv;

        public CheckIn(View itemView) {
            super(itemView);
            name_tv = (TextView) itemView.findViewById(R.id.name_tv);
            status_tv = (TextView) itemView.findViewById(R.id.status_tv);

        }
    }

}

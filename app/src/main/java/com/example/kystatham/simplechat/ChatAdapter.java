package com.example.kystatham.simplechat;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    List<Message> mMessagesList = new ArrayList<>();
    Context mContext;

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_message, parent, false);

        ChatViewHolder vh = new ChatViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.message.setText(mMessagesList.get(position).getBody());
        Glide.with(mContext).load(getProfileUrl(
                mMessagesList.get(position).getUserId()
        )).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mMessagesList.size();
    }

    public void addMessages(List<Message> messages) {
        mMessagesList.addAll(messages);
        this.notifyDataSetChanged();
    }

    private static String getProfileUrl(final String userId) {
        String hex = "";
        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            final byte[] hash = digest.digest(userId.getBytes());
            final BigInteger bigInt = new BigInteger(hash);
            hex = bigInt.abs().toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://www.gravatar.com/avatar/" + hex + "?d=identicon";
    }


    class ChatViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView message;

        public ChatViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.img_avatar);
            message = (TextView) itemView.findViewById(R.id.text_message);
        }
    }
}

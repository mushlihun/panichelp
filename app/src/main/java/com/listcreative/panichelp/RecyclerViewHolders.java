package com.listcreative.panichelp;

/**
 * Created by SONY-VAIO on 3/14/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public TextView personName;
    public TextView personAddress;
    public ImageView personPhoto;

    public RecyclerViewHolders(View itemView) {
        super(itemView);

        personName = (TextView)itemView.findViewById(R.id.list_title);
        personAddress = (TextView)itemView.findViewById(R.id.list_desc);
        personPhoto = (ImageView)itemView.findViewById(R.id.list_avatar);
    }
}

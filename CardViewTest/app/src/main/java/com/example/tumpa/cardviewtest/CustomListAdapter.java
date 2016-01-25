package com.example.tumpa.cardviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tumpa on 1/26/2016.
 */
public class CustomListAdapter extends BaseAdapter {
    Context context;
    String [] result;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomListAdapter(Context context,int[] prgmImages,String[] prgmNameList) {
        this.context = context;
        result=prgmNameList;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.comment,null);
        holder.tv = (TextView) rowView.findViewById(R.id.user_comment);
        holder.img = (ImageView) rowView.findViewById(R.id.user_image);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        return rowView;
    }
}

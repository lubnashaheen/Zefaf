package com.afq.zefaf.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.afq.zefaf.Model.MenuItems;
import com.afq.zefaf.R;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<MenuItems> objects ;

    public CustomListAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View V = LayoutInflater.from(context).inflate(resource,null);

        TextView txttitle = V.findViewById(R.id.txttitle);
        ImageView imgicon = V.findViewById(R.id.imgicon);

        txttitle.setText(objects.get(position).getTitle()+"");
        imgicon.setImageResource(objects.get(position).getIcon());

        return V;

    }
}

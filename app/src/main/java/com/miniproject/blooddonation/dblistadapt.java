package com.miniproject.blooddonation;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by KISHOR K R on 3/8/2017.
 */

public class dblistadapt extends ArrayAdapter<dblist>{
    public dblistadapt(Activity Context, ArrayList<dblist> lista){
        super(Context,0,lista);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview = convertView;
        return super.getView(position, convertView, parent);
    }
}

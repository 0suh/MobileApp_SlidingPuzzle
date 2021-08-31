package edu.skku.map.pa1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class ImageAdapter2 extends BaseAdapter {
    Context context;
    public ImageAdapter2(Context c){
        context = c;
    }

    @Override
    public int getCount(){
        return images44.length;
    }
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView==null){
            imageView=new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }
        else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(images44[position]);
        return imageView;
    }
    static public void shuffle(){
        Collections.shuffle(Arrays.asList(images44));
    }

    static public int getBlank(){
        int r=-1;
        for (int i=0;i<images44.length;i++){
            if(images44[i]==R.drawable.white)
                r=i;
        }
        return r;
    }
    static public void change(int origin, int blk){
        images44[blk]=images44[origin];
        images44[origin]=R.drawable.white;
    }
    static public Integer[] images44={
            R.drawable.s41,
            R.drawable.s42,
            R.drawable.s43,
            R.drawable.s44,
            R.drawable.s45,
            R.drawable.s46,
            R.drawable.s47,
            R.drawable.s48,
            R.drawable.s49,
            R.drawable.s410,
            R.drawable.s411,
            R.drawable.s412,
            R.drawable.s413,
            R.drawable.s414,
            R.drawable.s415,
            R.drawable.white
    };
}

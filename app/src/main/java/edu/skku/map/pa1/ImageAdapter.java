package edu.skku.map.pa1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class ImageAdapter extends BaseAdapter {
    Context context;
    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount(){
        return images33.length;
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
            imageView.setLayoutParams(new ViewGroup.LayoutParams(330,330));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }
        else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(images33[position]);
        return imageView;
    }
    static public void shuffle(){
        Collections.shuffle(Arrays.asList(images33));
    }
    static public int getBlank(){
        int r=-1;
        for (int i=0;i<images33.length;i++){
            if(images33[i]==R.drawable.white)
                r=i;
        }
        return r;
    }
    static public void change(int origin, int blk){
        images33[blk]=images33[origin];
        images33[origin]=R.drawable.white;
    }

    static public Integer[] images33={
            R.drawable.s31,
            R.drawable.s32,
            R.drawable.s33,
            R.drawable.s34,
            R.drawable.s35,
            R.drawable.s36,
            R.drawable.s37,
            R.drawable.s38,
            R.drawable.white
    };
}

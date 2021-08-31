package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //3*3의 정답
    final Integer[] imgs3=new Integer[]{
            R.drawable.s31, R.drawable.s32, R.drawable.s33,
            R.drawable.s34, R.drawable.s35, R.drawable.s36,
            R.drawable.s37, R.drawable.s38, R.drawable.white
    };
    //4*4의 정답
    final Integer[] imgs4=new Integer[]{
        R.drawable.s41, R.drawable.s42, R.drawable.s43, R.drawable.s44,
                R.drawable.s45, R.drawable.s46, R.drawable.s47, R.drawable.s48,
                R.drawable.s49, R.drawable.s410, R.drawable.s411, R.drawable.s412,
                R.drawable.s413, R.drawable.s414, R.drawable.s415, R.drawable.white
    };
    Integer[] imgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);

        GridView gridview = (GridView)findViewById(R.id.grid);
        Puzzle puzzle= new Puzzle();

        //3*3 puzzle open button
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                gridview.setNumColumns(3);
                gridview.setAdapter(new ImageAdapter(getApplicationContext()));
                imgs =new Integer[]{
                        R.drawable.s31, R.drawable.s32, R.drawable.s33,
                        R.drawable.s34, R.drawable.s35, R.drawable.s36,
                        R.drawable.s37, R.drawable.s38, R.drawable.white
                };
                ImageAdapter.images33= imgs;
            }
        });

        //4*4 puzzle open button
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                gridview.setNumColumns(4);
                gridview.setAdapter(new ImageAdapter2(getApplicationContext()));
                imgs =new Integer[]{
                        R.drawable.s41, R.drawable.s42, R.drawable.s43, R.drawable.s44,
                        R.drawable.s45, R.drawable.s46, R.drawable.s47, R.drawable.s48,
                        R.drawable.s49, R.drawable.s410, R.drawable.s411, R.drawable.s412,
                        R.drawable.s413, R.drawable.s414, R.drawable.s415, R.drawable.white
                };
                ImageAdapter2.images44= imgs;
            }
        });

        //shuffle button
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(gridview.getNumColumns()==3){
                    ImageAdapter.shuffle();
                    gridview.setAdapter(new ImageAdapter(getApplicationContext()));
                }
                else if(gridview.getNumColumns()==4){
                    ImageAdapter2.shuffle();
                    gridview.setAdapter(new ImageAdapter2(getApplicationContext()));
                }
            }
        });

        //image click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position;
               // Toast.makeText(getApplicationContext(),""+pos, Toast.LENGTH_SHORT).show();
                if(gridview.getNumColumns()==3){
                    puzzle.setPuzzle(pos, 3);
                    puzzle.Move();
                    gridview.setAdapter(new ImageAdapter(getApplicationContext()));
                    //check answer
                    if(Arrays.equals(imgs3, ImageAdapter.images33))
                        Toast.makeText(getApplicationContext(),"FINISH!", Toast.LENGTH_LONG).show();
                }

                else if(gridview.getNumColumns()==4){
                    puzzle.setPuzzle(pos, 4);
                    puzzle.Move();
                    gridview.setAdapter(new ImageAdapter2(getApplicationContext()));
                    //check answer
                    if(Arrays.equals(imgs4, ImageAdapter2.images44))
                        Toast.makeText(getApplicationContext(),"FINISH!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

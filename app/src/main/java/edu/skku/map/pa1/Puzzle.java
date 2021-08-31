package edu.skku.map.pa1;

public class Puzzle {
    public int x_blk; //blank의 x index
    public int y_blk; //blank의 x index
    public int blk_position; //blank의 position
    public int x_click; //click 한 x index
    public int y_click; //click 한 y index
    public int check; //movable?
    public int pos; //click position
    public int size; //3*3 or 4*4

    public Puzzle(){
        x_click=-1;
        y_click=-1;
        x_blk=-1;
        y_blk=-1;
        pos=-1;
        blk_position=-1;
        check=0;
        size=0;
    }
    public void setPuzzle(int position, int size1){
        pos=position;
        size=size1;
        x_click= X_getIndex(position);
        y_click= Y_getIndex(position);
        if(size==3)
            blk_position=ImageAdapter.getBlank();
        else
            blk_position=ImageAdapter2.getBlank();
        x_blk= X_getIndex(blk_position);
        y_blk= Y_getIndex(blk_position);
        check=Check(x_click,y_click);
    }

    public int Check(int x,int y){
        if(x_blk==x && y_blk==y-1) return 1; //blank가 위에 있으므로 이동가능
        else if(x_blk==x-1 && y_blk==y) return 1; //blank가 오른쪽에 있으므로 이동가능
        else if(x_blk==x+1 && y_blk==y) return 1; //blank가 왼쪽에 있으므로 이동가능
        else if(x_blk==x && y_blk==y+1) return 1; //blank가 아래쪽에 있으므로 이동가능
        else return 0; //못움직임
    }

    public int X_getIndex(int p){
        if(size==3)
            return p%3;
        else
            return p%4;
    }

    public int Y_getIndex(int p){
        if(size==3)
            return p/3;
        else
            return p/4;
    }

    public void Move(){
        if(size==3){
            if(check==1){
                ImageAdapter.change(pos, blk_position);
            }
        }
        else{
            if(check==1){
                ImageAdapter2.change(pos, blk_position);
            }
        }
    }
}

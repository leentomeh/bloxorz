package com.company;

public class State {

//    Floor floor=new Floor(3,4);
//    Mass myMass=new Mass();

    Floor floor;
    Mass myMass;
    public State(){
        floor=new Floor(4,3);
        myMass=new Mass(3,2);
        floor.setTemp();
    }

    public State(State state){
        this.floor = state.floor;
        this.myMass = state.myMass;
    }



    public void setState(int x,int y){

    }



    public void setMyMass(boolean isV, int x1, int y1, int x2, int y2) {
        this.myMass.isV = isV;
        this.myMass.x1 = x1;
        this.myMass.y1 = y1;
        this.myMass.x2 = x2;
        this.myMass.y2 = y2;
    }

    public Floor getFloor() {
        return floor;
    }

    public Mass getMyMass() {
        return myMass;
    }

    public void printState(){
        String floorAsString = "";
        for (int i = 0; i < this.floor.width; i++) {
            String row = "";
            for (int j = 0; j < this.floor.height; j++) {
                row += this.floor.floor[i][j].whoAmI();
            }
            floorAsString += row;
            floorAsString += '\n';
        }
        // System.out.println("move (" +  move + ")");
        System.out.println(floorAsString);
        System.out.println("===========");
    }




    
}

 class Mass {
    int width=1;
    int height=2*width;
    boolean isV=true;
    int x1,y1,x2,y2;

    public Mass(){
        this.x1 = -1;
        this.y1 = -1;
        this.x2 = -1;
        this.y2 = -1;
    }


     public Mass(int x, int y) {
         if(isV){
             this.x1=x;
             this.y1=y;
             this.y2=y;
             this.x2=x;
         }
     }

     public int getWidth() {
         return width;
     }

     public int getHeight() {
         return height;
     }

     public boolean isV() {
         return isV;
     }

     public int getX1() {
         return x1;
     }

     public int getY1() {
         return y1;
     }

     public int getX2() {
         return x2;
     }

     public int getY2() {
         return y2;
     }

}

 class Tiles {
    int x, y, width = 1, height = 1;
    boolean isEmpty = false;
    boolean isWinGap = false;
    boolean hasMass = false;


    public Tiles(){

    }
    public Tiles(Tiles tile) {
        this.x = tile.x;
        this.y = tile.y;
        this.isEmpty = tile.isEmpty;
        this.isWinGap = tile.isWinGap;
        this.hasMass = tile.hasMass;
    }


    public Tiles(int x, int y, boolean isEmpty, boolean isWinGap, boolean hasMass) {
        this.x = x;
        this.y = y;
        this.isEmpty = isEmpty;
        this.isWinGap = isWinGap;
        this.hasMass = hasMass;
    }

     public char whoAmI(){
         char charType = '_';

         if(this.hasMass)
             charType = 'M';
         else if(this.isWinGap)
             charType = 'W';
         else if(this.isEmpty)
             charType = 'G';
         else
             charType = 'T';
         return charType;
     }


}

class Floor {
    int width, height;
    public Tiles[][] floor;
    Tiles tile =new Tiles();


    public Floor(int width, int height) {
        this.width = width;
        this.height = height;
        this.floor = new Tiles[width][height];
    }

    public void setTemp() {
        tile = new Tiles(0, 0, true, false, false);
        floor[0][0] = tile;
        tile = new Tiles(0, 1, false, true, false);
        floor[0][1] = tile;
        tile = new Tiles(0, 2, true, false, false);
        floor[0][2] = tile;


        tile = new Tiles(1, 0, false, false, false);
        floor[1][0] = tile;
        tile = new Tiles(1, 1, false, false, false);
        floor[1][1] = tile;
        tile = new Tiles(1, 2, false, false, false);
        floor[1][2] = tile;


        tile = new Tiles(2, 0, false, false, false);
        floor[2][0] = tile;
        tile = new Tiles(2, 1, false, false, false);
        floor[2][1] = tile;
        tile = new Tiles(2, 2, false, false, false);
        floor[2][2] = tile;


        tile = new Tiles(3, 0, false, false, false);
        floor[3][0] = tile;
        tile = new Tiles(3, 1, false, false, false);
        floor[3][1] = tile;
        tile = new Tiles(3, 2, false, false, true);
        floor[3][2] = tile;


    }



    public Floor(Floor copyFloor) {
        this.width = copyFloor.width;
        this.height = copyFloor.height;
        this.floor = new Tiles[this.width][this.height];

        // copy the same tiles to a new tiles array with different location
        for (int i = 0; i < copyFloor.width; i++) {
            for (int j = 0; j < copyFloor.height; j++) {
                this.floor[i][j] = new Tiles(copyFloor.floor[i][j]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tiles[][] getFloor() {
        return floor;
    }
}







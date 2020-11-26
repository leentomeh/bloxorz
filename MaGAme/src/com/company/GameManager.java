package com.company;

import java.util.ArrayList;

public class GameManager extends State{

    boolean lose = false;
    boolean win = false;
//    State state = new State();
    ArrayList<State> history = new ArrayList<>();
    ArrayList<String> path=new ArrayList<>();


    Tiles tile =new Tiles();


    public boolean canMoveLeft(State state) {
        int x1 = state.getMyMass().x1;
        int y1 = state.getMyMass().y1;

        int x2 = state.getMyMass().x2;
        int y2 = state.getMyMass().y2;
        try {
            if (state.getMyMass().isV) {
                if ((!state.getFloor().floor[x1][y1 - 2].isEmpty) ||
                        (state.getFloor().floor[x1][y1 - 2].isWinGap && state.getFloor().floor[x1][y1 - 1].isEmpty)) {
                    return true;

                }
            } else if (y1 == y2) {
                if ((!state.getFloor().floor[x1][y1 - 1].isEmpty && !state.getFloor().floor[x2][y2 - 1].isEmpty) ||
                        (!state.getFloor().floor[x1][y1 - 1].isEmpty && state.getFloor().floor[x2][y2 - 1].isWinGap) ||
                        (state.getFloor().floor[x1][y1 - 1].isWinGap && !state.getFloor().floor[x2][y2 - 1].isEmpty)) {
                    return true;
                }

            } else if (x1 == x2) {
                if ((!state.getFloor().floor[x1][y1 - 2].isEmpty) || state.getFloor().floor[x1][y1 - 2].isWinGap) {
                    return true;
                }
            }
        } catch ( ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public boolean canMoveRight(State state) {
        int x1 = state.getMyMass().x1;
        int y1 = state.getMyMass().y1;

        int x2 = state.getMyMass().x2;
        int y2 = state.getMyMass().y2;
        try {
            if (state.getMyMass().isV) {
                if ((!state.getFloor().floor[x1][y1 + 2].isEmpty) ||
                        (state.getFloor().floor[x1][y1 + 2].isWinGap && state.getFloor().floor[x1][y1 + 1].isEmpty)) {
                    return true;

                }
            } else if (y1 == y2) {
                if ((!state.getFloor().floor[x1][y1 + 1].isEmpty && !state.getFloor().floor[x2][y2 + 1].isEmpty) ||
                        (!state.getFloor().floor[x1][y1 + 1].isEmpty && state.getFloor().floor[x2][y2 + 1].isWinGap) ||
                        (state.getFloor().floor[x1][y1 + 1].isWinGap && !state.getFloor().floor[x2][y2 + 1].isEmpty)) {
                    return true;
                }

            } else if (x1 == x2) {
                if ((!state.getFloor().floor[x1][y1 + 1].isEmpty) || (state.getFloor().floor[x1][y1 + 2].isWinGap)) {
                    return true;
                }
            }
        } catch ( ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public boolean canMoveUp(State state) {
        int x1 = state.getMyMass().x1;
        int y1 = state.getMyMass().y1;

        int x2 = state.getMyMass().x2;
        int y2 = state.getMyMass().y2;
        try {
            if (state.getMyMass().isV) {
                if ((!state.getFloor().floor[x1 - 2][y1].isEmpty) ||
                        (state.getFloor().floor[x1 - 2][y1].isWinGap && state.getFloor().floor[x1 - 1][y1].isEmpty)) {
                    return true;

                }
            } else if (y1 == y2) {
                if ((!state.getFloor().floor[x1 - 2][y1].isEmpty) || state.getFloor().floor[x1 - 2][y1].isWinGap) {
                    return true;
                }

            } else if (x1 == x2) {
                if ((!state.getFloor().floor[x1 - 1][y1].isEmpty && !state.getFloor().floor[x2 - 1][y2].isEmpty) ||
                        (!state.getFloor().floor[x1 - 1][y1].isEmpty && state.getFloor().floor[x2 - 1][y2].isWinGap) ||
                        (state.getFloor().floor[x1 - 1][y1].isWinGap && !state.getFloor().floor[x2 - 1][y2].isEmpty)) {
                    return true;
                }
            }
        } catch ( ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public boolean canMoveDown(State state) {
        int x1 = state.getMyMass().x1;
        int y1 = state.getMyMass().y1;

        int x2 = state.getMyMass().x2;
        int y2 = state.getMyMass().y2;
        try {
            if (state.getMyMass().isV) {
                if ((!state.getFloor().floor[x1 + 2][y1].isEmpty) ||
                        (state.getFloor().floor[x1 + 2][y1].isWinGap && state.getFloor().floor[x1 + 1][y1].isEmpty)) {
                    return true;

                }
            } else if (y1 == y2) {
                if ((!state.getFloor().floor[x1 + 2][y1].isEmpty) || state.getFloor().floor[x1 + 2][y1].isWinGap) {
                    return true;
                }

            } else if (x1 == x2) {
                if ((!state.getFloor().floor[x1 + 1][y1].isEmpty && !state.getFloor().floor[x2 + 1][y2].isEmpty) ||
                        (!state.getFloor().floor[x1 + 1][y1].isEmpty && state.getFloor().floor[x2 + 1][y2].isWinGap) ||
                        (state.getFloor().floor[x1 + 1][y1].isWinGap && !state.getFloor().floor[x2 + 1][y2].isEmpty)) {
                    return true;
                }
            }
        } catch ( ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public void moveLeft(State state) {
      //  State state= bitch.copyState(bitch);

        if (canMoveLeft(state)) {
            int x1 = state.getMyMass().x1,
                    x2 = state.getMyMass().x2,
                    y1 = state.getMyMass().y1,
                    y2 = state.getMyMass().y2;
            if (state.getMyMass().isV) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.setMyMass(false, x1, y1 - 1, x2, y1 - 2);

                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));


            } else if (state.getMyMass().y1 == state.getMyMass().y2) {

                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(false,x1,y1-1,x2,y2-1);

                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));



            } else if (state.getMyMass().x1 == state.getMyMass().x2) {

                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(true,x1,y1-2,x2,y2-1);

                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                history.add(new State(state));


            }


        } else
            lose();


    }

    public void moveRight(State state) {
     //   State state= bitch.copyState(bitch);

        if (canMoveRight(state)) {

            int x1 = state.getMyMass().x1,
                    x2 = state.getMyMass().x2,
                    y1 = state.getMyMass().y1,
                    y2 = state.getMyMass().y2;
            if (state.getMyMass().isV) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.setMyMass(false,x1,y1+1,x2,y2+2);

                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                    state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;

                history.add(new State(state));



            } else if (state.getMyMass().y1 == state.getMyMass().y2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(false,x1,y1+1,x2,y2+1);

                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));



            } else if (state.getMyMass().x1 == state.getMyMass().x2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(true,x1,y1+1,x2,y2+2);

                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                history.add(new State(state));



            }
        } else
            lose();
    }

    public void moveUp(State state) {
     //   State state= bitch.copyState(bitch);

        if (canMoveUp(state)) {
            int x1 = state.getMyMass().x1,
                    x2 = state.getMyMass().x2,
                    y1 = state.getMyMass().y1,
                    y2 = state.getMyMass().y2;
            if (state.getMyMass().isV) {
                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = false;
                state.setMyMass(false,x1-1,y1,x2-2,y2);

                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                    state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));



            } else if (state.getMyMass().y1 == state.getMyMass().y2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(true,x1-2,y1,x2-1,y2);


                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                history.add(new State(state));



            } else if (state.getMyMass().x1 == state.getMyMass().x2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(false,x1-1,y1,x2-1,y2);


                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                    state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));


            }
        } else
            lose();
    }

    public void moveDown(State state) {
      //  State state= bitch.copyState(bitch);

        if (canMoveDown(state)) {
            int x1 = state.getMyMass().x1,
                    x2 = state.getMyMass().x2,
                    y1 = state.getMyMass().y1,
                    y2 = state.getMyMass().y2;
            if (state.getMyMass().isV) {
                state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = false;

                state.setMyMass(false,x1+1,y1,x2+2,y2);


                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                    state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));




            } else if (state.getMyMass().y1 == state.getMyMass().y2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(true,x1+2,y1,x2+1,y2);

                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                history.add(new State(state));



            } else if (state.getMyMass().x1 == state.getMyMass().x2) {
                state.getFloor().floor[x1][y1].hasMass = false;
                state.getFloor().floor[x2][y2].hasMass = false;
                state.setMyMass(false,x1+1,y1,x2+1,y2);

                    state.getFloor().floor[state.getMyMass().x1][state.getMyMass().y1].hasMass = true;
                    state.getFloor().floor[state.getMyMass().x2][state.getMyMass().y2].hasMass = true;
                history.add(new State(state));


            }
        } else
            lose();
    }

    public void lose() {
        lose = true;
        System.out.println("You Lost BABY!");
    }

    public boolean checkWin(State state) {
        int x1 = state.getMyMass().x1;
        int y1 = state.getMyMass().y1;

        if (state.getFloor().floor[x1][y1].isWinGap && state.getFloor().floor[x1][y1].hasMass) {
            win = true;
            System.out.println("WWWWWWWWIN");
            return true;
        }
        return false;
    }

  /*  public void setTheFloor() {
        tile = new Tiles(0, 0, true, false, false);
        floor.floor[0][0] = tile;
        tile = new Tiles(0, 1, false, false, false);
        floor.floor[0][1] = tile;
        tile = new Tiles(0, 2, false, false, false);
        floor.floor[0][2] = tile;
        tile = new Tiles(0, 3, false, false, false);
        floor.floor[0][3] = tile;
        tile = new Tiles(0, 4, false, false, false);
        floor.floor[0][4] = tile;

        tile = new Tiles(1, 0, false, false, false);
        floor.floor[1][0] = tile;
        tile = new Tiles(1, 1, false, false, false);
        floor.floor[1][1] = tile;
        tile = new Tiles(1, 2, false, false, false);
        floor.floor[1][2] = tile;
        tile = new Tiles(1, 3, false, false, true);
        floor.floor[1][3] = tile;
        tile = new Tiles(1, 4, true, false, false);
        floor.floor[1][4] = tile;

        tile = new Tiles(2, 0, false, false, false);
        floor.floor[2][0] = tile;
        tile = new Tiles(2, 1, false, false, false);
        floor.floor[2][1] = tile;
        tile = new Tiles(2, 2, true, false, false);
        floor.floor[2][2] = tile;
        tile = new Tiles(2, 3, false, false, false);
        floor.floor[2][3] = tile;
        tile = new Tiles(2, 4, true, false, false);
        floor.floor[2][4] = tile;

        tile = new Tiles(3, 0, false, false, false);
        floor.floor[3][0] = tile;
        tile = new Tiles(3, 1, false, false, false);
        floor.floor[3][1] = tile;
        tile = new Tiles(3, 2, false, false, false);
        floor.floor[3][2] = tile;
        tile = new Tiles(3, 3, false, false, false);
        floor.floor[3][3] = tile;
        tile = new Tiles(3, 4, false, false, false);
        floor.floor[3][4] = tile;

        tile = new Tiles(4, 0, true, false, false);
        floor.floor[4][0] = tile;
        tile = new Tiles(4, 1, true, false, false);
        floor.floor[4][1] = tile;
        tile = new Tiles(4, 2, false, false, false);
        floor.floor[4][2] = tile;
        tile = new Tiles(4, 3, true, true, false);
        floor.floor[4][3] = tile;
        tile = new Tiles(4, 4, false, false, false);
        floor.floor[4][4] = tile;

        tile = new Tiles(5, 0, true, false, false);
        floor.floor[5][0] = tile;
        tile = new Tiles(5, 1, true, false, false);
        floor.floor[5][1] = tile;
        tile = new Tiles(5, 2, false, false, false);
        floor.floor[5][2] = tile;
        tile = new Tiles(5, 3, false, false, false);
        floor.floor[5][3] = tile;
        tile = new Tiles(5, 4, true, false, false);
        floor.floor[5][4] = tile;


    }*/



    public boolean checkIfEnd(State state) {

        return checkWin(state) || lose;
    }



    public ArrayList<State> everyPossibleMove(State bitch) {

        State temp= bitch.copyState(bitch);
        ArrayList<State> possibility = new ArrayList<>();



        if (canMoveLeft(temp)) {

            State sLeft=temp.copyState(temp);
           // System.out.println("my temp before move");
           // temp.printState();
           // System.out.println("my sLeft before move");
            //sLeft.printState();
            moveLeft(sLeft);
            //System.out.println("my temp after move");
            //temp.printState();
            //System.out.println("my sLeft after move");
           // sLeft.printState();
            path.add("left");
            possibility.add(sLeft);



        }
        if (canMoveRight(temp)) {
            State sRight=temp.copyState(temp);
          //  boolean left=canMoveLeft(temp);
            //System.out.println(left+"1");
            moveRight(sRight);
            path.add("right");
            possibility.add(sRight);
           // sRight.printState();
            //System.out.println(left);

        }
        if (canMoveUp(temp)) {
            State sUp=temp.copyState(temp);
            //boolean left=canMoveLeft(temp);
            moveUp(sUp);
            //path.add("Up");
            possibility.add(sUp);
           // sUp.printState();
            //System.out.println(left);
        }
        if (canMoveDown(temp)) {
            State sDown=temp.copyState(temp);
            //boolean left=canMoveLeft(temp);
            moveDown(sDown);
            path.add("down");
            possibility.add(sDown);
          //  sDown.printState();
            //System.out.println(left);

        }

        return possibility;

    }



    public boolean isEqual(State state1, State state2){
        Mass mass1 = state1.getMyMass();
        Mass mass2 = state2.getMyMass();


        return mass1.isV == mass2.isV &&
            mass1.x1 == mass2.x1 &&
            mass1.x2 == mass2.x2 &&
            mass1.y1 == mass2.y1 &&
            mass1.y2 == mass2.y2;
    }

    public boolean containState(ArrayList<State> visitedStates , State targetState){
        for(int i = 0 ; i < visitedStates.size(); i++){
            State state = visitedStates.get(i);
            boolean isEquals = isEqual(targetState, state);

            if(isEquals){
                return true;
            }
        }
        return false;
    }



  /*  public void print(){
        for(int i=0;i<floor.width;i++){
            for(int j=0;j<floor.height;j++){
                if(floor.floor[i][j].hasMass)
                    System.out.print("M");
                else if(floor.floor[i][j].isWinGap)
                    System.out.print("W");
                else if(floor.floor[i][j].isEmpty)
                    System.out.print("G");
                else
                    System.out.print("T");

            }
            System.out.println();
        }


    }*/


}




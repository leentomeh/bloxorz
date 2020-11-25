package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    GameManager player = new GameManager();
    State initialState = new State();
    ArrayList<State> visited=new ArrayList<>();

    public  Player(){
        System.out.println("iniState");
        initialState.printState();
    }

    public void input() {
        while (!player.checkIfEnd(initialState)) {
            System.out.println("enter the move:");

            if (!player.lose)
                initialState.printState();

            Scanner sc = new Scanner(System.in);
            char move = sc.next().charAt(0);


            if (move == 'a') {
                 player.moveLeft(initialState);
//                path.add("left");
            } else if (move == 'w') {
                player.moveUp(initialState);

            } else if (move == 's')
                player.moveDown(initialState);
            else if (move == 'd')
                player.moveRight(initialState);


            if (move == 'p') {
                for (int i = 0; i < player.history.size(); i++) {
                    player.history.get(i);
                    System.out.println();
                }
            }



//            // path();
//            if (move == 'l')
//                printhPath();

        }

    }



    public  void dfs(State node)
    {
        node.printState();
        ArrayList<State> neighbours=player.everyPossibleMove(node);
        System.out.println(neighbours.size() + " size ");
        visited.add(node);
        for (int i = 0; i < neighbours.size(); i++) {
            System.out.println("i =" + i);
            State n=neighbours.get(i);
            n.printState();
            if(!player.containState(visited,n))
            {
                System.out.println("lklklk");
                dfs(n);
            }
        }
    }
}

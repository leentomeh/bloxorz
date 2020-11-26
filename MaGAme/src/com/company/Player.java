package com.company;

import java.util.*;

public class Player {
    GameManager player = new GameManager();
    State initialState = new State();
    ArrayList<State> visited=new ArrayList<>();
    ArrayList<String> path=new ArrayList<>();

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



   /* public  void dfs(State node) {
        node.printState();
        if(player.win){
            System.out.println("lalalala");
            return;

        }
        ArrayList<State> neighbours=player.everyPossibleMove(node);
    //    System.out.println(neighbours.size() + " size ");
        visited.add(node);
        for (int i = 0; i < neighbours.size(); i++) {
         //   System.out.println("i =" + i);
            State n=neighbours.get(i);
            n.printState();
            if(!player.containState(visited,n)&&!player.win )
            {
               // System.out.println("lklklk");
                dfs(n);

            }
        }

    }*/

    public void dfsWithoutRecursion(State start) {
        Stack<State> stack = new Stack<>();
       // boolean[] isVisited = new boolean[adjVertices.size()];
        stack.push(start);
        while (!stack.isEmpty()) {
            if(player.win)
                return;
            State current = stack.pop();
            visited.add(current);
            ArrayList<State> s=player.everyPossibleMove(current);
            for (int i = 0; i <s.size() ; i++) {
                State n=s.get(i);
                if (!player.containState(visited,n)&& !player.win)
                    stack.push(n);
            }
        }
    }

    void BFS(State node)
    {


        LinkedList<State> queue = new LinkedList();

        visited.add(node);
        queue.add(node);

        while (queue.size() != 0) {
            node = queue.poll();
            node.printState();
         //   System.out.print(s + " ");

          //  Iterator<Integer> i = adj[s].listIterator();
            ArrayList<State> neighbours=player.everyPossibleMove(node);
            for (int i = 0; i <neighbours.size() ; i++) {

                State n = neighbours.get(i);
                if (!player.containState(visited,n) && !player.checkWin(n)) {
                    visited.add(n);
                    queue.add(n);
                }

            }
    }}

    public void UCS(State state){




    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player player = new Player();
       // player.dfs(player.initialState);
        player.player.everyPossibleMove(new State(player.initialState));
    }
}

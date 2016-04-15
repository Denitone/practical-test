package com.deni.insland.facade;

/**
 * @author Deni Setiawan on 15 April 2016, jakarta
 *         test-currency-api project
 */
public interface IIslandFacade {
    public boolean isSafe(int M[][], int row, int col,
                          boolean visited[][]);

    public void DFS(int M[][], int row, int col, boolean visited[][]);

    public int countIslands(int M[][]);
}

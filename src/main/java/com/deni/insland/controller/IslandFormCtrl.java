package com.deni.insland.controller;

import com.deni.insland.facade.IslandFacadeImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deni Setiawan on 15 April 2016, jakarta
 *         test-currency-api project
 */
@ViewScoped
@ManagedBean
public class IslandFormCtrl {
    private IslandFacadeImpl islandFacade;
    private int mx[][];
    private int numberOfIsland;

    @PostConstruct
    public void init() {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        mx = M;
        islandFacade = new IslandFacadeImpl();
        numberOfIsland = islandFacade.countIslands(M);
        System.out.println("Number of islands is: " + numberOfIsland);
    }

    public int[][] getMx() {
        return mx;
    }

    public void setMx(int[][] mx) {
        this.mx = mx;
    }

    public int getNumberOfIsland() {
        return numberOfIsland;
    }

    public void setNumberOfIsland(int numberOfIsland) {
        this.numberOfIsland = numberOfIsland;
    }
}

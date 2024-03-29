package com.cmlu.algorithm.graph;

import com.cmlu.lang.In;
import com.cmlu.lang.StdOut;

public class GraphClient {

    /**
     * 图中结点v的度（连接的结点数）
     */
    public static int degree(Graph G,int v){
	int degree = 0;
	for(int w:G.adj(v)){
	    degree++;
	}
	return degree;
    }
    
    /**
     * 最大的度值
     * @param G
     * @return
     */
    public static int maxDegree(Graph G){
	int max = 0;
	for(int v=0;v<G.V();v++){
	    if(degree(G, v) > max){
		max = degree(G, v);
	    }
	}
	
	return max;
    }
    
    // average degree
    public static int avgDegree(Graph G) {
        // each edge incident on two vertices
        return 2 * G.E() / G.V();
    }
    
    
 // number of self-loops
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count/2;   // self loop appears in adjacency list twice
    } 

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);


        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree           = " + avgDegree(G));
        StdOut.println("number of self loops     = " + numberOfSelfLoops(G));

    }
    
    
    
}

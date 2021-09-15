package com.tugcantopaloglu;

public class Main {

    public static void main(String[] args) {
        //2. soru yani B-tree
        System.out.println("BTree:");
        BTree btree = new BTree(3);
        btree.insert(3);
        btree.insert(7);
        btree.insert(18);
        btree.insert(34);
        btree.insert(5);
        btree.insert(46);
        btree.insert(98);
        btree.insert(22);
        btree.display();
        System.out.println("\n");
        //4-A Dijkstras Shortest Path
        //Bu graph'ta her 2 aynı değer 2 köşeyi ifade ediyor örneğin iki adet 11 iki köşeyi/noktayı işaret ediyor 0'lar düzlemi belirtiyor.
        System.out.println("Dijkstras Shortest Path:");
        int graphDij[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                         { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                         { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                         { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                         { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                         { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                         { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                         { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                         { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        ShortestPathDij shortestDij = new ShortestPathDij();
        shortestDij.dijkstrasShortestPath(graphDij, 0);
        System.out.println("\n");
        //4-B Prim’s MST (Minimum Spanning Tree)
        /* Alttaki yapıya benzer ve çizgilerle gösterilmiş şekilde ağırlıkları olan bir graph oluşturuyoruz
           2      3
        (0)--(1)--(2)
         |   / \   |
        6| 8/   \5 | 7
         | /      \|
         (3)-------(4)
               9         */
        System.out.println("Prim’s MST:");
        PrimsMST prims = new PrimsMST();
        int graphMST[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                         { 2, 0, 3, 8, 5 },
                                         { 0, 3, 0, 0, 7 },
                                         { 6, 8, 0, 0, 9 },
                                         { 0, 5, 7, 9, 0 } };
        prims.primMST(graphMST);
        System.out.println("\n");
        //4-C
        BFT bftList = new BFT(4);

        bftList.addEdge(0, 1);
        bftList.addEdge(0, 2);
        bftList.addEdge(1, 2);
        bftList.addEdge(2, 0);
        bftList.addEdge(2, 3);
        bftList.addEdge(3, 3);

        System.out.println("Breadth First Traversal"+"(vertex = 2'den başlayarak)");

        bftList.BFS(2);
    }
}

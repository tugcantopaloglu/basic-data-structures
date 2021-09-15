package com.tugcantopaloglu;

class PrimsMST {
    // dikey sayısı
    private static final int V = 5;

    //MST içinde bulunmayan diklerin min key yardımıyla bulunması
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // MST'yi yazdıran metod
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Köşe \tAğırlık");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // MST'yi oluşturan ve yazdıran metod
    void primMST(int graph[][])
    {
        // MST'yi tutan array
        int parent[] = new int[V];

        // min ağırlığı olan köşeyi seçen keyler
        int key[] = new int[V];

        //MST içinde bulunanları temsil ediyoruz
        Boolean mstSet[] = new Boolean[V];

        //tüm keyleri INFINITE kabul ediyoruz
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // ilk vertex her zaman MST'de içerilecek
        key[0] = 0; // key = 0 yani bu vertex ilk vertex
        parent[0] = -1; // ilk node her zaman MST'nin kökü

        //MST V köşeden oluşacak
        for (int count = 0; count < V - 1; count++) {
            //en küçük köşeyi seçerek işlemleri yapıyoruz
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // MST'yi yazdır
        printMST(parent, graph);
    }

}

package com.tugcantopaloglu;

class ShortestPathDij {
    // Minimum mesafe değeri ile tepe noktasını bulmak için metod
    // en kısa yolları içeren ağaca dahil edilmemiş olan köşeler içinde arıyoruz.
    static final int V = 9;
    int minDistance(int dist[], Boolean sptSet[])
    {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // uzaklık arrayini yazdırıyoruz
    void printSolution(int dist[], int n)
    {
        System.out.println("Köşelerin mesafesi:");
        System.out.println("Köşe Numarası -> Mesafe");
        for (int i = 0; i < V; i++)
            System.out.println(i + " -> " + dist[i]);
    }
    // Dijkstra's ana noktadan en kısa mesafeyi bulan ve graph alan metod. Graph köşe değerleri içeriyor
    void dijkstrasShortestPath(int graph[][], int src)
    {
        int dist[] = new int[V]; // çıktı arrayi
        // noktadan i'ye en kısa değer

        // sptSet[i] = true -> i en kısa yolu içeriyorsa
        Boolean sptSet[] = new Boolean[V];

        // her uzaklığı INFINITE olarak işliyoruz ve stpSet[] = false olarak ayarlanıyor
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // ana noktadan uzaklık her zaman 0'dır
        dist[src] = 0;

        // her yere olan en kısa yolu buluyoruz
        for (int count = 0; count < V - 1; count++) {
            // En kısa değeri bulmaya çalışıyoruz
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                     if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // en son işlenmiş haldeki arrayi yazdırıyoruz
        printSolution(dist, V);
    }
}

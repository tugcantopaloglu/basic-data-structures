package com.tugcantopaloglu;
import java.util.*;

class BFT
{
    private int V;   // köşe sayısı
    private LinkedList<Integer> adj[]; //köşe listesi

    // Constructor
    BFT(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // grapha köşeleri ekleyen fonksiyon
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // s kaynağına göre BFT yazdırıyor
    void BFS(int s)
    {
        //bakılmamış tüm köşeleri false yapıyor
        boolean visited[] = new boolean[V];

        // sıra oluşturuyor
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //node'u işaretliyor
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            //köşeyi çıkarıp yazdırıyor
            s = queue.poll();
            System.out.print(s+" ");


            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
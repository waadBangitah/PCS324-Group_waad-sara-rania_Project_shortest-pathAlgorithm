package application2;

public class AllSourceSPAlg extends ShortestPathAlgorithm{
     public AllSourceSPAlg(Graph graph) {
        super(graph);
    }
    public void computeDijkstraAlg() {
        Vertex dist[] = new Vertex[g.veticesNo]; ///to save dist between vertex
        Boolean isVisit[] = new Boolean[g.veticesNo];//to check vertex is visit
        for (int w = 0; w < g.veticesNo; w++) {
            dist[w] = new Vertex(INF);
            isVisit[w] = false;
        }
        int[] source = new int[g.veticesNo];
        dist[0].weight = 0;
        int i =0;
      
            while(i < g.veticesNo - 1){
            int minDist = minDistance(dist, isVisit);
            source[0] = -1;
            isVisit[minDist] = true;
            for (int v = 0; v < g.veticesNo; v++) 
          {
                if (g.verticies[minDist][v] != null) {
                    if (!isVisit[v] && g.verticies[minDist][v].weight != 0 && dist[minDist].weight != INF && (dist[minDist].weight + g.verticies[minDist][v].weight) < dist[v].weight) {
                        source[v] = minDist;
                        dist[v].weight = dist[minDist].weight + g.verticies[minDist][v].weight;
                    }
                }
            }
         i++;}
       if (g.veticesNo == 10) {
                printVertex(dist, source);
            }

    }
    int minDistance(Vertex[] dist, Boolean[] isVisit) {
        int minW = INF; int mIndex = 0;
        for (int i = 0; i < g.veticesNo; i++) {
            if (!isVisit[i] && dist[i].weight <= minW) {
                minW = dist[i].weight;
                mIndex = i;
            }
        }
        return mIndex;
    }

    void printVertex(Vertex dist[], int[] source) {
        for (int i = 0; i < g.veticesNo; i++) {
            if(g.read_file == true)
            {
                 System.out.print("From "+g.labels.get(0) +"\tto "+g.labels.get(i)+ "\t|\tThe Shortest Distance is " + dist[i].weight + "\t|\t Path : ");
            }
            else
            {
                  System.out.print("From "+g.labels.get(0) +"\tto "+g.labels.get(i)+ "\t|\tThe Shortest Distance is " + dist[i].weight + "\t|\t Path : ");
            }
            printPath(i, source);
           System.out.println(" ");
        }
    }

    private void printPath(int i, int[] source) {
        if (i == -1) {
            return;
        }
        printPath(source[i], source);
        if(g.read_file == true)
        {
             if(i!=0){
             System.out.print(" ➜ ");
            }
            System.out.print(g.labels.get(i) + " ");
        }
        else
        {
        System.out.print(i + " ");
        }
    }
}

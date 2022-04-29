package application2;
/**
 *
 * @author waadb
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm{
    Vertex dist[][]=g.verticies;
     public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

     public void computeFloyedWarshalAlg() {
    
        for (int w = 0; w < g.veticesNo; w++) {
            for (int s = 0; s < g.veticesNo; s++) {
                for (int r = 0; r < g.veticesNo; r++) {
                    if (g.verticies[s][w] == null) {
                        g.verticies[s][w] = new Vertex(INF);
                    }
                    if (g.verticies[w][r] == null) {
                        g.verticies[w][r] = new Vertex(INF);
                    }
                    if (g.verticies[s][r] == null) {
                        g.verticies[s][r] = new Vertex(INF);
                    }
                    g.verticies[s][r].weight = Math.min(g.verticies[s][r].weight, (g.verticies[s][w].weight + g.verticies[w][r].weight));

                }
            }
            if (g.veticesNo == 10) {
                System.out.println("***D( " + w + " )***");
                g.Print_Graph();
            }
        }
    }

}

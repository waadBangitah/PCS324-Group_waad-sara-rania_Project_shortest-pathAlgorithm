package application2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
public class Graph {
    Vertex[][] verticies;
    int veticesNo;
    int edgeNo;
    boolean isDigraph;
    Vector<String> labels;
    boolean read_file;
    public Graph() {
        read_file = false;
        labels = new Vector<String>();
    }

    public Graph(boolean isDigraph) {
        read_file = false;
        this.isDigraph = isDigraph;
        labels = new Vector<String>();
    }

    public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
        read_file = false;
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        labels = new Vector<String>();
        verticies = new Vertex[veticesNo][veticesNo];
    }
    public void makeGraph() {
        Random randomNum = new Random();///create random class
        for (int i = 0; i < veticesNo - 1; i++) {//Make sure that the resulting graph is connected. 
            int RandomNum = randomNum.nextInt(20) + 1;//generate random weights for edge between 0-20
            addEdge(i, i + 1, RandomNum);
        }
        int remaningEdge = edgeNo - (veticesNo - 1);//generate remaining edges 

        for (int i = 0; i < remaningEdge; i++) {
            int source = randomNum.nextInt(veticesNo);
            int target = randomNum.nextInt(veticesNo);
            int weight = randomNum.nextInt(20) + 1;
            if ((source == target)) {
                i--;
            } else {
                addEdge(source, target, weight);
            }
        }
    }
       //////////////////////////////////////
    public void addEdge(int v, int u, int w) {
        verticies[v][u] = new Vertex(w);
        if (isDigraph) {
            verticies[u][v] = new Vertex(w);
        }
        if (read_file) {
            if (isDigraph) {
                   edgeNo++;
            } else {
                 edgeNo += 2;
            }
        }
    }
    //////////////////////////////////////////////
    
    public void readGraphFromFile(String fileName) throws FileNotFoundException, IOException {
        read_file = true;
        veticesNo = 10;
        verticies = new Vertex[veticesNo][veticesNo];
        String source, target; int weight;
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        String graphType = input.next();
        int isgraphD = input.nextInt();
        if (input.hasNextLine()) {
            if (isgraphD == 0) {
                isDigraph = true;
            } else {
                isDigraph = false;
            }
            int sourceP, targetP;
            while (input.hasNextLine()) {
                source = input.next();
                 addVertLabel(source);
                target = input.next();
                addVertLabel(target);
                weight = input.nextInt();
                sourceP = getVertPos(source);
                targetP = getVertPos(target);
                addEdge(sourceP, targetP, weight);
            }
        }
        input.close();
    }
    //////////////////////////////////////
    public int getVertPos(String vertex) {
        int pos = -1;
        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).equals(vertex)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
/////////////////////////
    public boolean addVertLabel(String Label) {
        if (labels.contains(Label)) {
            return false;
        } else {
            labels.add(Label);
            return true;
        }
    }
 
  ////////////////////////////////////
    public void Print_Graph() {
        System.out.print(" ");
        for (int i = 0; i < veticesNo; i++) {
            System.out.print("  " + labels.get(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < veticesNo; i++) {
         System.out.print(labels.get(i));
            for (int j = 0; j < veticesNo; j++) {
                if (i == j) {
                    System.out.print("  0\t");

                } else if (verticies[i][j] != null) {

                    if (verticies[i][j].weight == 99999) {
                        System.out.print("  ∞\t");
                    } else {
                        System.out.print("  " + verticies[i][j].weight + "\t");
                    }
                } else {
                    System.out.print("  ∞\t");
                }

            }
            System.out.println("");
        }
        System.out.println("--------------------------");
    }
}

    


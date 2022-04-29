package application2;
//////////////////////////////
///waad Bangitah///1907141////
///sara hadef//////1905974////
///rania altonisi//1914955////
//////////////////////////////
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author waadb
 */
public class Application2 {
    static File file = new File("result.txt");
    public static void main(String[] args) throws IOException {
        int n = 0;
        int m = 0;
        int Choice = -1;
        int Choice2 = -1;
        int Choice3 = -1;
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(file);
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("** program to computing the shortest path of a graph **");
            System.out.println("-------------------------------------------------------");
            System.out.println("Choose from the main menu:");
            System.out.println("///////1-  Read from file            ");
            System.out.println("////// 2-  make graph                ");
            System.out.println("////// 3-  exit       ");
            System.out.println("-------------------------------------------------------\n");
            System.out.print("choice one: ");
            Choice = input.nextInt();
            if (Choice == 3) {
                break;
            }
            ///////////////////////////////Read from file/////////////////////////////////////////////////
            
           inner1: while (Choice == 1) {
                System.out.println("****************************");
                System.out.println("****** Read from file ******");
                System.out.println("1- Floyd-Warshall Algorithm ");
                System.out.println("2-  Dijkstra Algorithm      ");
                System.out.println("3- return to main menu ");
                System.out.println("****************************\n");
                System.out.print("choice one of the algorithms : ");
                Choice2 = input.nextInt();
                Graph g = new Graph();
                g.readGraphFromFile(".\\test.txt");
                if (Choice2 == 1) {
                    System.out.println("******************************************");
                    System.out.println("              The graph \n");
                    System.out.println("******************************************");
                    g.Print_Graph();
                    SingleSourceSPAlg a = new SingleSourceSPAlg(g);
                    long start_timekrskal = System.currentTimeMillis();
                    System.out.println("******************************************");
                    System.out.println("      Graph with Floyed-Warshal \n");
                    System.out.println("******************************************");
                    a.computeFloyedWarshalAlg();

                    long finesh_timekrskal = System.currentTimeMillis();
                    System.out.println("*********FloyedWarshal time " + (finesh_timekrskal - start_timekrskal) + "*********");
                    System.out.println("------------------------------------------------------------------------------------");
                    continue;
                }
                ///////////////////////////////////////////
                if (Choice2 == 2) {
                    System.out.println("***********************************************************");
                    System.out.println("The shortest distances from vertex 'A' to other vertices \n");
                    System.out.println("***********************************************************");
                    AllSourceSPAlg s = new AllSourceSPAlg(g);
                    long start_time_s = System.currentTimeMillis();
                    s.computeDijkstraAlg();
                    long finesh_time_s = System.currentTimeMillis();
                    System.out.println("--------------------------");
                    System.out.println("*********Dijkstra time " + (finesh_time_s - start_time_s) + "*********");
                    System.out.println("------------------------------------------------------------------------------------");
                    continue;
                }
                ///////////////////////////////////////////
                if (Choice2 == 3) {
                    break inner1;
                }}
                ///////////////////////////////make graph/////////////////////////////////////////////////
              
                 inner2: while (Choice == 2) {
                    System.out.println("****************************");
                    System.out.println("****** make graph  ******");
                    System.out.println("1- Floyd-Warshall Algorithm ");
                    System.out.println("2-  Dijkstra Algorithm      ");
                    System.out.println("3- return to main menu ");
                    System.out.println("****************************\n");
                    System.out.print("choice one of the algorithms : ");
                    Choice3 = input.nextInt();
                    if (Choice3 == 3) {
                        break inner2;
                    }
                    /////////////////////////////////
                     if (Choice3 == 1) {
                    System.out.println("*** where n = number of vertices and m = number of edges ***");
                    System.out.println("*** These are the available cases ***");
                    System.out.println("      ____________________________");
                    System.out.println("      1|  n=2,000  |  m=10,000   |");
                    System.out.println("      2|  n=3,000  |  m=15,000   |");
                    System.out.println("      3|  n=4,000  |  m=20,000   |");
                    System.out.println("      4|  n=5,000  |  m=25,000   |");
                    System.out.println("      5|  n=6,000  |  m=30,000   |");
                    System.out.println("      ____________________________");
                    System.out.println("****************************");
                    for (int iteration = 1; iteration < 6; iteration++) {
                        System.out.println("///////////////////////////////////////////////");
                        System.out.println("////////////////iteration no: " + iteration + "////////////////");
                        System.out.println("//////////////////////////////////////////////");
                        switch (iteration) {
                            case 1: {
                                n=2000  ;  m=10000;
                            }
                            break;
                            case 2: {
                                n=3000  ;  m=15000;
                            }
                            break;
                            case 3: {
                                n=4000  ;  m=20000;
                            }
                            break;
                            case 4: {
                               n=5000  ;  m=25000;
                            }
                            break;
                            case 5: {
                              n=6000  ;  m=30000; 
                            }
                            break;
                        }
                        // make graph
                        Graph graph = new Graph(n, m, false);
                        System.out.println("Number of Vertex: "+n+" Number of Edge: "+m);
                        long start_timeMK = System.currentTimeMillis();
                        graph.makeGraph();
                        long finesh_timeMK = System.currentTimeMillis();
                        System.out.println("*********Make Graph time " + (finesh_timeMK - start_timeMK) + "*********");

                        /////////Algorethems////////////
                       
                            SingleSourceSPAlg a = new SingleSourceSPAlg(graph);
                            long start_timekrskal = System.currentTimeMillis();
                            a.computeFloyedWarshalAlg();
                            long finesh_timekrskal = System.currentTimeMillis();
                            System.out.println("*********FloyedWarshal time " + (finesh_timekrskal - start_timekrskal) + "*********");
                            continue;
                        }}
                        ////////////////////////////////////////////  
                        if (Choice3 == 2) {
                            System.out.println("*** where n = number of vertices and m = number of edges ***");
                    System.out.println("*** These are the available cases ***");
                    System.out.println("      ____________________________");
                    System.out.println("      1|  n=5,000  |  m=25,000   |");
                    System.out.println("      2|  n=10,000 |  m=50,000   |");
                    System.out.println("      3|  n=15,000 |  m=75,000   |");
                    System.out.println("      4|  n=20,000 |  m=100,000  |");
                    System.out.println("      5|  n=25,000 |  m=125,000  |");
                    System.out.println("      ____________________________");
                    System.out.println("****************************");
                              for (int iteration = 1; iteration < 6; iteration++) {
                        System.out.println("///////////////////////////////////////////////");
                        System.out.println("////////////////iteration no: " + iteration + "////////////////");
                        System.out.println("//////////////////////////////////////////////");
                        switch (iteration) {
                            case 1: {
                                n = 5000;
                                m = 25000;
                            }
                            break;
                            case 2: {
                                n = 10000;
                                m = 50000;
                            }
                            break;
                            case 3: {
                                n = 15000;
                                m = 75000;
                            }
                            break;
                            case 4: {
                                n = 20000;
                                m = 100000;
                            }
                            break;
                            case 5: {
                                n = 25000;
                                m = 125000;
                            }
                            break;
                        }
                        // make graph
                        Graph graph = new Graph(n, m, false);
                        System.out.println("Number of Vertex: "+n+" Number of Edge: "+m);
                        long start_timeMK = System.currentTimeMillis();
                        graph.makeGraph();
                        long finesh_timeMK = System.currentTimeMillis();
                        System.out.println("*********Make Graph time " + (finesh_timeMK - start_timeMK) + "*********");

                            AllSourceSPAlg s = new AllSourceSPAlg(graph);
                            long start_time_s = System.currentTimeMillis();
                            s.computeDijkstraAlg();
                            long finesh_time_s = System.currentTimeMillis();
                            System.out.println("*********Dijkstra time " + (finesh_time_s - start_time_s) + "*********");
                            continue;
                        }}
                    }
                    output.close();
                }
            }
        }


package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

    	// WRITE YOUR CODE HERE
        StdIn.setFile(args[0]);

        StdOut.setFile(args[1]);

        int count_generators = StdIn.readInt();

        int [] generators_value = new int [count_generators];

        double [] funcionality_value = new double[count_generators];

        int[][] edge_values = new int[count_generators][count_generators];

        int i = 0;
        while (i < count_generators) {

            generators_value[i] = StdIn.readInt();

            funcionality_value[i] = StdIn.readDouble();

        i++;

        }

        for(int b = 0; b < count_generators; b++){

            for(int c = 0; c < count_generators; c++){

                edge_values [b] [c] = (int) (StdIn.readInt()/(funcionality_value[b]*funcionality_value[c]));


        }
    }
    int[] minCost = dijkstra(edge_values);

    StdOut.print(minCost[count_generators - 1]);

}
 private static int [] dijkstra (int [][] edgee){

    int [] less = new int [edgee.length];

    boolean [] put = new boolean[edgee.length];

    int a = 1;

    while (a < less.length) {

        less[a] = Integer.MAX_VALUE;

        a++;
    }

    int b = 0;

    while (b < less.length) {
        
        int curr = rec_less_node(less, put);

        put[curr] = true;

        int i = 0;

        while (i < edgee.length) {

            int cumSum = less[curr] + edgee[curr][i];
            
            if (edgee[curr][i] != 0 && !put[i] && cumSum < less[i]) {
                
                less[i] = cumSum;
            }
            i++;
        }

        b++;
    }

    return less;
}


    private static int rec_less_node (int[] less_cost, boolean [] p){

        int least = Integer.MAX_VALUE, least_nodee = -1;

        for(int a = 0; a < less_cost.length; a++){

            if(least > less_cost[a] && !p[a]){

                least = less_cost[a];

                least_nodee = a;
            }
        }
        return least_nodee;
    }


    }
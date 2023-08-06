package avengers;

import java.util.HashMap;

/**
 * Given a Set of Edges representing Vision's Neural Network, identify all of the 
 * vertices that connect to the Mind Stone. 
 * List the names of these neurons in the output file.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * MindStoneNeighborNeuronsInputFile name is passed through the command line as args[0]
 * Read from the MindStoneNeighborNeuronsInputFile with the format:
 *    1. v (int): number of neurons (vertices in the graph)
 *    2. v lines, each with a String referring to a neuron's name (vertex name)
 *    3. e (int): number of synapses (edges in the graph)
 *    4. e lines, each line refers to an edge, each line has 2 (two) Strings: from to
 * 
 * Step 2:
 * MindStoneNeighborNeuronsOutputFile name is passed through the command line as args[1]
 * Identify the vertices that connect to the Mind Stone vertex. 
 * Output these vertices, one per line, to the output file.
 * 
 * Note 1: The Mind Stone vertex has out degree 0 (zero), meaning that there are 
 * no edges leaving the vertex.
 * 
 * Note 2: If a vertex v connects to the Mind Stone vertex m then the graph has
 * an edge v -> m
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for EVERY neuron (vertex) neighboring the Mind Stone neuron (vertex)
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/MindStoneNeighborNeurons mindstoneneighborneurons.in mindstoneneighborneurons.out
 *
 * 
 */


public class MindStoneNeighborNeurons {
    
    public static void main (String [] args) {
        
    	if ( args.length < 2 ) {
            StdOut.println("Execute: java MindStoneNeighborNeurons <INput file> <OUTput file>");
            return;
        }
    	
    	// WRITE YOUR CODE HERE
        String in = args[0];
        String out = args[1];
        StdIn.setFile(in);
        StdOut.setFile(out);

        int count_neurons = StdIn.readInt();
        int[] neu_ind = new int[count_neurons];
        String[] neu_name = new String[count_neurons];

        int a = 0;

        while (a < count_neurons) {

            String ad = StdIn.readString();

            neu_ind[a] = a;

            neu_name[a] = ad;

            a++;

        }

        int count_synapse = StdIn.readInt();

        int[][] synapses = new int [count_neurons][count_neurons];

        for(int i = 0; i < count_synapse; i++){

            String starting = StdIn.readString(), ending = StdIn.readString();

            int startingrow = 0, endingcolumn = 0;

            for (int j = 0; j < count_neurons; j++) {
                if (neu_name[j].equals(starting)) {
                    startingrow = neu_ind[j];
                }
                if (neu_name[j].equals(ending)) {
                    endingcolumn = neu_ind[j];
                }
            }
        
            synapses[startingrow][endingcolumn] = 1;
            i++;
        }



        int vertex_o_degree = -1;

        for(int c = 0; c < count_neurons;c++){

            int degree = 0;

            for(int b = 0; b < count_neurons;b++){

                if(synapses[c][b] == 1) 

                degree++;
        }

        if(degree ==0){

            vertex_o_degree = c;

            break;
        }
        
    }

        int d = 0;
        while (d < count_neurons) {

        if (synapses[d][vertex_o_degree] == 1) {

            StdOut.println(neu_name[d]);

        }

            d++;
            
        }         
            }
        }

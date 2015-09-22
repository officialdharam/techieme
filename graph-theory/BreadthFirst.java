public class BreadthFirst {

    public static void main(String[] args) {
        BreadthFirst bfsDriver = new BreadthFirst(); 
        List<List<Integer>> adjList = bfsDriver.prepareGraphAdjacencyList();
        List<Integer> visitedListForBFS = bfsDriver.bfs(adjList);
        for (Integer vertex : visitedListForBFS) {
            System.out.print(vertex + " , ");
        }
    }

/**
 * Code for breadth first traversal given an adjacency list.
 * 
 * @param graph 
 */
    private List<Integer> bfs(List<List<Integer>> graph) {
        List<Integer> visitedList = new ArrayList<Integer>();
        Queue<Integer> tempQueue = new ArrayDeque<Integer>();
        tempQueue.add(1);
        visitedList.add(1);
        Integer poll = null;
        while (!tempQueue.isEmpty()) {
            poll = tempQueue.poll();
            List<Integer> adjListForPoll = graph.get(poll - 1);
			
            for (Integer vertex : adjListForPoll) {
                if (!visitedList.contains(vertex)) {
                    visitedList.add(vertex);
                    tempQueue.offer(vertex);
                }
            }
        }

        return visitedList;
	}

    /**
     * Helper method to create a adjacency list for the demonstration graph.
     */
    private List<List<Integer>> prepareGraphAdjacencyList() {
    // data structure appropriate to store adjacency list. A list of lists.
    List<List<Integer>> graphAdjList = new ArrayList<List<Integer>>();

    List<Integer> adj1 = new ArrayList<Integer>(2);
    adj1.add(2);
    adj1.add(3);

    List<Integer> adj2 = new ArrayList<Integer>(3);
    adj2.add(1);
    adj2.add(5);
    adj2.add(6);

    List<Integer> adj3 = new ArrayList<Integer>(2);
    adj3.add(1);
    adj3.add(4);

    List<Integer> adj4 = new ArrayList<Integer>(3);
    adj4.add(3);
    adj4.add(5);
    adj4.add(7);

    List<Integer> adj5 = new ArrayList<Integer>(3);
    adj5.add(2);
    adj5.add(4);
    adj5.add(7);

    List<Integer> adj6 = new ArrayList<Integer>(3);
    adj6.add(2);
    adj6.add(7);
    adj6.add(8);

    List<Integer> adj7 = new ArrayList<Integer>(4);
    adj7.add(4);
    adj7.add(5);
    adj7.add(6);
    adj7.add(9);

    List<Integer> adj8 = new ArrayList<Integer>(2);
    adj8.add(6);
    adj8.add(9);

    List<Integer> adj9 = new ArrayList<Integer>(2);
    adj9.add(7);
    adj9.add(8);

    graphAdjList.add(adj1);
    graphAdjList.add(adj2);
    graphAdjList.add(adj3);
    graphAdjList.add(adj4);
    graphAdjList.add(adj5);
    graphAdjList.add(adj6);
    graphAdjList.add(adj7);
    graphAdjList.add(adj8);
    graphAdjList.add(adj9);

    return graphAdjList;
}
}

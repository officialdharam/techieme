public class DepthFirst {

    public static void main(String[] args) {
        DepthFirst dfsDriver = new DepthFirst();
        List<List<Integer>> adjList = dfsDriver.prepareGraphAdjacencyList();
        List<Integer> visitedListForDFS = dfsDriver.dfs(adjList);
        for (Integer vertex : visitedListForDFS) {
            System.out.print(vertex + " , ");
        }
    }

/**
 * COde for breadth first traversal given an adjacency list.
 * 
 * @param graph
 * @return
 */
    private List<Integer> dfs(List<List<Integer>> graph) {
        List<Integer> visitedList = new ArrayList<Integer>();
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.push(1);
        visitedList.add(1);
        Integer temp = 1;
	
        while (!tempStack.isEmpty()) {
            temp = tempStack.peek();   
            boolean found = false;
			
            for(Integer vertex : graph.get(temp-1)){
                if(!visitedList.contains(vertex)){
                    visitedList.add(vertex);
                    tempStack.push(vertex);
                    found = true;
                    break;
                }
            }
			
            if(!found){
                temp = tempStack.pop();
            }
        }
        return visitedList;
     }

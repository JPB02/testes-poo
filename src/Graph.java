import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    // Instance Variables
    private Map<String, Set<String>> adj; // graph adjacency list

    // Constructors
    public Graph() {
        this.adj = new HashMap<>();
    }

    public Graph(Map<String, Set<String>> adj) {
        this.adj = new HashMap<>(adj);
    }

    // Methods
    public void addArch(String vOrig, String vDest) {

        Set<String> adjSet = adj.getOrDefault(vOrig, new HashSet<>());

        adjSet.add(vDest);

        adj.put(vOrig, adjSet);

    }

    public boolean isSink(String v) {

        Set<String> adjSet = adj.getOrDefault(v, new HashSet<>());

        return adjSet.isEmpty();

    }

    public int size() {

        int vNum = adj.size();
        int aNum = 0;

        for(String v : adj.keySet()) {
            aNum += adj.get(v).size();
        }

        return aNum + vNum;

    }


    // Recursive, because I can't do it otherwise :(
    public boolean existsPath(String vOrig, String vDest, Set<String> visitedArcs) {

        if (vOrig == null || vOrig.isEmpty() || vDest == null || vDest.isEmpty() || vOrig.equals(vDest)) {
            return false;
        }

        if (visitedArcs.contains(vOrig)) {
            return false;
        }

        visitedArcs.add(vOrig);

        Set<String> adjList = adj.getOrDefault(vOrig, new HashSet<>());
        for (String vertex : adjList) {
            if (vertex.equals(vDest)) {
                return true;
            } else {
                if (existsPath(vertex, vDest, visitedArcs)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Returns a Set with all arcs of a vertex v
    public Set<Map.Entry<String, String>> fanOut (String v) {

        Set<String> adjVs = adj.getOrDefault(v, new HashSet<>());

        Set<Map.Entry<String, String>> adjSet = new HashSet<>();

        for(String adjV : adjVs) {
            // Create new Map with the original vertex and the dest vertex
            Map.Entry<String,String> arc = Map.entry(v, adjV);
            adjSet.add(arc);
        }

        return adjSet;

    }

}

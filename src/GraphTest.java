import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphTest {

    public static void main(String[] args) {
        // Create a new graph
        Graph graph = new Graph();

        // Add some arcs
        graph.addArch("A", "B");
        graph.addArch("A", "C");
        graph.addArch("B", "C");
        graph.addArch("C", "D");

        // Test isSink method
        System.out.println("Is vertex D a sink? " + graph.isSink("D"));
        System.out.println("Is vertex C a sink? " + graph.isSink("C"));

        // Test size method
        System.out.println("Graph size: " + graph.size());

        // Test existsPath method
        System.out.println("Does path exist from A to D? " + graph.existsPath("A", "D", new HashSet<>()));

        // Test fanOut method
        System.out.println("Fan out of vertex A:");
        Set<Map.Entry<String, String>> fanOutSet = graph.fanOut("A");
        for (Map.Entry<String, String> arc : fanOutSet) {
            System.out.println("(" + arc.getKey() + ", " + arc.getValue() + ")");
        }
    }

}

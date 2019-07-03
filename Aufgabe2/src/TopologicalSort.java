// O. Bittel;
// 22.02.2017

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Klasse zur Erstellung einer topologischen Sortierung.
 * @author Oliver Bittel
 * @since 22.02.2017
 * @param <V> Knotentyp.
 */
public class TopologicalSort<V> {
    private List<V> ts = new LinkedList<>(); // topologisch sortierte Folge
	int[] inDegree = new int[20]; //Anz. noch nicht besuchter Vorgänger
	Queue<V> q = new LinkedList<>();

	/**
	 * Führt eine topologische Sortierung für g durch.
	 * @param g gerichteter Graph.
	 */
	public TopologicalSort(DirectedGraph<V> g) {

		topSort(g);

    }

    public List<V> topSort(DirectedGraph<V> g) {

		for(V v: g.getVertexSet()) {
			inDegree[(Integer)v] = g.getPredecessorVertexSet(v).size();
			if(inDegree[(Integer)v] == 0) {
				q.add(v);
			}
		}

		while (!q.isEmpty()) {
			V v = q.remove();
			ts.add(v);
			for(V w: g.getSuccessorVertexSet(v)) {
				if(--inDegree[(Integer) w] == 0) {
					q.add(w);
				}
			}
		}

		if(ts.size() != g.getNumberOfVertexes()) {
			return null;
		} else {
			return ts;
		}
	}
    
	/**
	 * Liefert eine nicht modifizierbare Liste (unmodifiable view) zurück,
	 * die topologisch sortiert ist.
	 * @return topologisch sortierte Liste
	 */
	public List<V> topologicalSortedList() {
		return Collections.unmodifiableList(ts);
    }

	public static void main(String[] args) {
		DirectedGraph<Integer> g = new AdjacencyListDirectedGraph<>();
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		System.out.println(g);

		TopologicalSort<Integer> ts = new TopologicalSort<>(g);
		
		if (ts.topologicalSortedList() != null) {
			System.out.println(ts.topologicalSortedList()); // [1, 2, 3, 4, 5, 6, 7]
		}
	}
}
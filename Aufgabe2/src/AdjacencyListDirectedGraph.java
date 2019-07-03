// O. Bittel;
// 19.03.2018


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

/**
 * Implementierung von DirectedGraph mit einer doppelten TreeMap
 * für die Nachfolgerknoten und einer einer doppelten TreeMap
 * für die Vorgängerknoten.
 * <p>
 * Beachte: V muss vom Typ Comparable&lt;V&gt; sein.
 * <p>
 * Entspicht einer Adjazenzlisten-Implementierung
 * mit schnellem Zugriff auf die Knoten.
 * @author Oliver Bittel
 * @since 19.03.2018
 * @param <V> Knotentyp.
 */
public class AdjacencyListDirectedGraph<V> implements DirectedGraph<V> {
	// doppelte Map für die Nachfolgerknoten:
	private final Map<V, Map<V, Double>> succ = new TreeMap<>();

	// doppelte Map für die Vorgängerknoten:
	private final Map<V, Map<V, Double>> pred = new TreeMap<>();

	private int numberEdge = 0;

	// Kante = Edge
	// Knoten = Vertex

	@Override
	public boolean addVertex(V v) {
		/**
		 * Fügt neuen Knoten zum Graph dazu.
		 * @param v Knoten
		 * @return true, falls Knoten noch nicht vorhanden war.
		 */
		if (!containsVertex(v)) {
			succ.put(v, new TreeMap<>());
			pred.put(v, new TreeMap<>());
			return true;
		}
		return false;


	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		/**
		 * Fügt neue Kante mit Gewicht weight zum Graph dazu.
		 * Falls einer der beiden Knoten noch nicht im Graphen vorhanden ist,
		 * dann wird er dazugefügt.
		 * Falls die Kante schon vorhanden ist, dann wird das Gewicht
		 * mit weight überschrieben.
		 * @param v Startknoten
		 * @param w Zielknoten
		 * @param weight Gewicht
		 * @return true, falls Kante noch nicht vorhanden war.
		 */
		addVertex(v);
		addVertex(w);
		if(!containsEdge(v,w)) {
			numberEdge++;
		}
		succ.get(v).put(w, weight);
		pred.get(w).put(v, weight);
		return true;
	}

	@Override
	public boolean addEdge(V v, V w) {
		/**
		 * Fügt neue Kante (mit Gewicht 1) zum Graph dazu.
		 * Falls einer der beiden Knoten noch nicht im Graphen vorhanden ist,
		 * dann wird er dazugefügt.
		 * Falls die Kante schon vorhanden ist, dann wird das Gewicht
		 * mit 1 überschrieben.
		 * @param v Startknoten
		 * @param w Zielknoten
		 * @return true, falls Kante noch nicht vorhanden war.
		 */
		return addEdge(v, w, 1.0);
	}

	@Override
	public boolean containsVertex(V v) {
		/**
		 * Prüft ob Knoten v im Graph vorhanden ist.
		 * @param v Knoten
		 * @return true, falls Knoten vorhanden ist.
		 */
		return succ.containsKey(v);
	}

	@Override
	public boolean containsEdge(V v, V w) {
		/**
		 * Prüft ob Kante im Graph vorhanden ist.
		 * @param v Startknoten
		 * @param w Endknoten
		 * @return true, falls Kante vorhanden ist.
		 */
		return succ.get(v).containsKey(w);
	}

	@Override
	public double getWeight(V v, V w) {
		/**
		 * Liefert Gewicht der Kante zurück.
		 * @param v Startknoten
		 * @param w Endknoten
		 * @throws IllegalArgumentException falls die Kante nicht existiert.
		 * @return Gewicht der Kante.
		 */
		if (!containsEdge(v, w)) {
			throw new IllegalArgumentException();
		}
		return succ.get(v).get(w);
	}


	@Override
	public int getInDegree(V v) {
		/**
		 * Liefert Eingangsgrad des Knotens v zurück.
		 * Das ist die Anzahl der Kanten mit Zielknoten v.
		 * @param v Knoten
		 * @throws IllegalArgumentException falls Knoten v
		 * nicht im Graph vorhanden ist.
		 * @return Knoteneingangsgrad
		 * Eingangsgrad = Wie viele Vorgaengerknoten dieser Knoten hat.
		 */
		if (!containsVertex(v)) {
			throw new IllegalArgumentException();
		}
		return pred.get(v).size();
	}

	@Override
	public int getOutDegree(V v) {
		/**
		 * Liefert Ausgangsgrad des Knotens v zurück.
		 * Das ist die Anzahl der Kanten mit Quellknoten v.
		 * @param v Knoten
		 * @throws IllegalArgumentException falls Knoten v
		 * nicht im Graph vorhanden ist.
		 * @return Knotenausgangsgrad
		 */
		if (!containsVertex(v)) {
			throw new IllegalArgumentException();
		}
		return succ.get(v).size();
	}

	@Override
	public Set<V> getVertexSet() {
		/**
		 * Liefert
		 * eine nicht modifizierbare Sicht (unmodifiable view)
		 * auf die Menge aller Knoten im Graph zurück.
		 *
		 * @return Knotenmenge
		 */
		return Collections.unmodifiableSet(succ.keySet()); // nicht modifizierbare Sicht
	}

	@Override
	public Set<V> getPredecessorVertexSet(V v) {
		/**
		 * Liefert eine nicht modifizierbare Sicht (unmodifiable view) auf
		 * die Menge aller Vorgängerknoten von v zurück.
		 * Das sind alle die Knoten, von denen eine Kante zu v führt.
		 * @param v Knoten
		 * @throws IllegalArgumentException falls Knoten v
		 * nicht im Graph vorhanden ist.
		 * @return Knotenmenge
		 */
		return Collections.unmodifiableSet(pred.get(v).keySet()); // nicht modifizierbare Sicht
	}

	@Override
	public Set<V> getSuccessorVertexSet(V v) {
		/**
		 * Liefert eine nicht modifizierbare Sicht (unmodifiable view) auf
		 * die Mengeneue Kante (mit Gewicht 1) zum Graph dazu.
		 * Falls einer der beid aller Nachfolgerknoten von v zurück.
		 * Das sind alle die Knoten, zu denen eine Kante von v führt.
		 * @param v Knoten
		 * @throws IllegalArgumentException falls Knoten v
		 * nicht im Graph vorhanden ist.
		 * @return Knotenmenge
		 */
		if (!containsVertex(v)) {
			throw new IllegalArgumentException();
		}
		return Collections.unmodifiableSet(succ.get(v).keySet()); // nicht modifizierbare Sicht
	}

	@Override
	public int getNumberOfVertexes() {
		/**
		 * Liefert Anzahl der Knoten im Graph zurück.
		 * @return Knotenzahl.
		 */
		return succ.size();
	}

	@Override
	public int getNumberOfEdges() {
		/**
		 * Liefert Anzahl der Kanten im Graph zurück.
		 * @return Kantenzahl.
		 */
		return numberEdge;
	}

	@Override
	public DirectedGraph<V> invert() {
		/**
		 * Erzeugt einen invertierten Graphen,
		 * indem jede Kante dieses Graphens in umgekehrter Richtung abgespeichert wird.
		 * @return invertierter Graph
		 */
		DirectedGraph<V> invertedGraph = new AdjacencyListDirectedGraph<>();
		for (V v: succ.keySet()) {
			for (V w : succ.get(v).keySet()) {
				invertedGraph.addEdge(w, v);
			}
		}
		return invertedGraph;
	}




	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (V v : succ.keySet()) {
			for (V w : succ.get(v).keySet()) {
				s.append(v).append(" ---> ").append(w).append(" weight = ")
						.append(succ.get(v).get(w)).append("\n");
			}
		}
		return s.toString();
	}


	public static void main(String[] args) {
		DirectedGraph<Integer> g = new AdjacencyListDirectedGraph<>();
		g.addEdge(1,2);
		g.addEdge(2,5);
		g.addEdge(5,1);
		g.addEdge(2,6);
		g.addEdge(3,7);
		g.addEdge(4,3);
		g.addEdge(4,6);
		g.addEdge(7,4);

		System.out.println("Anzahl der Knoten im Graph:");
		System.out.println(g.getNumberOfVertexes()); // 7
		System.out.println("Anzahl der Kanten im Graph:");
		System.out.println(g.getNumberOfEdges());  // 8
		System.out.println("Menge aller Knoten im Graph:");
		System.out.println(g.getVertexSet()); // 1, 2, ..., 7
		System.out.println("Anzahl Kanten mit Quellknoten V 2:");
		System.out.println(g.getOutDegree(2));    // 2
		System.out.println("Vorgänger Knoten von V 2:");
		System.out.println(g.getSuccessorVertexSet(2)); // 5, 6
		System.out.println("Anzahl Kanten mit Zielknoten V 6");
		System.out.println(g.getInDegree(6));    // 2
		System.out.println("Nachfolger Knoten von V 6");
		System.out.println(g.getPredecessorVertexSet(6)); // 2, 4

		System.out.println("Enthält Kante 1-2");
		System.out.println(g.containsEdge(1,2)); // true
		System.out.println("Enthält Kante 2-1");
		System.out.println(g.containsEdge(2,1)); // false
		System.out.println("Gewicht der Kante 1-2");
		System.out.println(g.getWeight(1,2)); // 1.0
		System.out.println("Anzahl aller Kanten:");
		System.out.println(g.getNumberOfEdges());
		g.addEdge(1, 2, 5.0);
		System.out.println("Neue Kante 2-1 mit Gewicht 5.0");
		g.addEdge(2, 1, 5.0);
		System.out.println("Anzahl aller Kanten:");
		System.out.println(g.getNumberOfEdges());
		System.out.println("Gewicht des neu hinzugefügten Knoten:");
		System.out.println(g.getWeight(1,2)); // 5.0
		System.out.println("Invertierter Graph:");
		System.out.println(g.invert());
		System.out.println("Graph:");
		System.out.println(g);
		Set<Integer> s = g.getSuccessorVertexSet(2);
		System.out.println(s);
	}
}
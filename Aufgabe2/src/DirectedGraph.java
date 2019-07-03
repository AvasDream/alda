// O. Bittel;
// 05.09.2018


import java.util.Set;

/**
 * Graph mit gerichteten Kanten.
 * Mit g.addEdge(v,w, weight) wird eine gerichtete Kante von v nach w mit dem Gewicht weight einfügt.
 * Falls kein Gewicht angegeben wird, dann ist das Gewichte implizit auf 1 gesetzt.
 * Der Graph einthält keine Mehrfachkanten.
 * @author Oliver Bittel
 * @since 05.09.2018
 * @param <V> Knotentyp.
 */
public interface DirectedGraph<V> {
	/**
     * Fügt neuen Knoten zum Graph dazu.
     * @param v Knoten
     * @return true, falls Knoten noch nicht vorhanden war.
     */
    boolean addVertex(V v);

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
    boolean addEdge(V v, V w);

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
    boolean addEdge(V v, V w, double weight);

    /**
     * Prüft ob Knoten v im Graph vorhanden ist.
     * @param v Knoten
     * @return true, falls Knoten vorhanden ist.
     */
    boolean containsVertex(V v);

    /**
     * Prüft ob Kante im Graph vorhanden ist.
     * @param v Startknoten
     * @param w Endknoten
     * @return true, falls Kante vorhanden ist.
     */
    boolean containsEdge(V v, V w);
    
    /**
     * Liefert Gewicht der Kante zurück.
     * @param v Startknoten
     * @param w Endknoten
	 * @throws IllegalArgumentException falls die Kante nicht existiert.
     * @return Gewicht der Kante.
     */
    double getWeight(V v, V w);

    /**
     * Liefert Anzahl der Knoten im Graph zurück.
     * @return Knotenzahl.
     */
    int getNumberOfVertexes();

    /**
     * Liefert Anzahl der Kanten im Graph zurück.
     * @return Kantenzahl.
     */
    int getNumberOfEdges();

    /**
     * Liefert eine nicht modifizierbare Sicht (unmodifiable view) 
	 * auf die Menge aller Knoten im Graph zurück.
	 * 
     * @return Knotenmenge
     */
    Set<V> getVertexSet();
    

    /**
     * Liefert Eingangsgrad des Knotens v zurück.
     * Das ist die Anzahl der Kanten mit Zielknoten v.
     * @param v Knoten
     * @throws IllegalArgumentException falls Knoten v
     * nicht im Graph vorhanden ist.
     * @return Knoteneingangsgrad
     */
    int getInDegree(V v);

    /**
     * Liefert Ausgangsgrad des Knotens v zurück.
     * Das ist die Anzahl der Kanten mit Quellknoten v.
     * @param v Knoten
     * @throws IllegalArgumentException falls Knoten v
     * nicht im Graph vorhanden ist.
     * @return Knotenausgangsgrad
     */
    int getOutDegree(V v);

    /**
     * Liefert eine nicht modifizierbare Sicht (unmodifiable view) auf
	 * die Menge aller Vorgängerknoten von v zurück.
     * Das sind alle die Knoten, von denen eine Kante zu v führt.
     * @param v Knoten
     * @throws IllegalArgumentException falls Knoten v
     * nicht im Graph vorhanden ist.
     * @return Knotenmenge
     */
    Set<V> getPredecessorVertexSet(V v);

    /**
     * Liefert eine nicht modifizierbare Sicht (unmodifiable view) auf 
	 * die Menge aller Nachfolgerknoten von v zurück. 
     * Das sind alle die Knoten, zu denen eine Kante von v führt.
     * @param v Knoten
     * @throws IllegalArgumentException falls Knoten v
     * nicht im Graph vorhanden ist.
     * @return Knotenmenge
     */
    Set<V> getSuccessorVertexSet(V v);
	
	/**
     * Erzeugt einen invertierten Graphen, 
	 * indem jede Kante dieses Graphens in umgekehrter Richtung abgespeichert wird. 
     * @return invertierter Graph
     */
    DirectedGraph<V> invert();
}

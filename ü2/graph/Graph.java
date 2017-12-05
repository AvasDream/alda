// O. Bittel;
// 22.02.2017

package graph;
import java.util.List;

/**
 * Graph, der gerichtet oder ungerichtet sein kann.
 * Der Graph ist gewichtet. Falls keine Gewichte angegeben werden,
 * dann sind die Gewichte implizit auf 1 gesetzt.
 * Der Graph einthält keine Mehrfachkanten.
 * @author Oliver Bittel
 * @since 22.02.2017
 * @param <V> Knotentyp.
 */
public interface Graph<V> {
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
     * @throws IllegalArgumentException falls einer der Knoten
     * nicht im Graph vorhanden ist.
     * @return Gewicht, falls Kante existiert, sonst Double.NaN.
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
     * Liefert Liste aller Knoten im Graph zurück.
     * @return Knotenliste
     */
    List<V> getVertexList();
    
    /**
     * Liefert Liste aller Kanten im Graph zurück.
     * @return Kantenliste.
     */
    List<Edge<V>> getEdgeList();

}

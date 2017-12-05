// O. Bittel;
// 22.02.2017

package graph;

/**
 * Klasse für Kanten.
 * @author Oliver Bittel
 * @since 22.02.2017
 * @param <V> Knotentyp.
 */

public class Edge<V> {

    /**
     * Startknoten.
     */
    final protected V source;
    /**
     * Zielknoten
     */
    final protected V target;
    /**
     * Gewicht.
     */
    protected double weight;

    /**
     * Erzeugt neue Kante mit Gewicht 1.
     * @param source Startknoten.
     * @param target Zielknoten.
     */
    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
        this.weight = 1.0;
    }

    /**
     * Erzeugt neue Kante mit Gewicht weight.
     * @param source Startknoten.
     * @param target Zielknoten.
     * @param weight Gewicht.
     */
    public Edge(V source, V target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     * Liefert Startknoten zurück.
     * @return Startknoten.
     */
    public V getSource() {
        return this.source;
    }

    /**
     * Liefert Zielknoten zurück.
     * @return Zielknoten.
     */
    public V getTarget() {
        return this.target;
    }

    /**
     * Liefert Gewicht der Kante zurück.
     * @return Gewicht.
     */
    public double getWeight() {
        return this.weight;
    }
	
	/**
     * Setzt das Gewicht der Kante auf weight.
	 * @param weight Gewicht.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Liefert String-Darstellung der Kante zurück.
     * @return String-Darstellung.
     */
    @Override public String toString() {
        if (weight == 1)
            return source + " -- " + target;
        else
            return source + " -- " + target + " (" + weight + ")";
    }
}

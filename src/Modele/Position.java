package Modele;

public class Position {
    private double positionX;
    private double positionY;

    /**
     * Constructeur de la classe Position
     *
     * @param positionX Position de l'objet en X
     * @param positionY Position de l'obejt en Y
     * @author Tremblay Jeremy, Vignon Ugo, Viton Antoine, Wissocq Maxime, Coudour Adrien
     */
    public Position(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * Getter position X
     *
     * @return La position X de l'objet
     * @author Tremblay Jeremy, Vignon Ugo, Viton Antoine, Wissocq Maxime, Coudour Adrien
     */
    public double getPositionX() {
        return positionX;
    }

    /**
     * Setter de la position X
     *
     * @param positionX Nouvelle position X de l'objet
     * @author Tremblay Jeremy, Vignon Ugo, Viton Antoine, Wissocq Maxime, Coudour Adrien
     */
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    /**
     * Getter de position Y
     *
     * @return Position Y de l'objet
     * @author Tremblay Jeremy, Vignon Ugo, Viton Antoine, Wissocq Maxime, Coudour Adrien
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     * Setter de la position Y
     *
     * @param positionY Nouvelle position Y de l'objet
     * @author Tremblay Jeremy, Vignon Ugo, Viton Antoine, Wissocq Maxime, Coudour Adrien
     */
    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "{" + positionX + "; " + positionY + "}";
    }

    @Override
    public int hashCode() {
        return (int) (positionX + positionY);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Position autre = (Position) obj;
        return equals(autre);
    }

    public boolean equals(Position p) {
        return (p.getPositionX() == positionX) && (p.getPositionY() == positionY);
    }
}
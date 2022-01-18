package modele.pokemon;

/**
 * Classe qui identifie une position
 */
public class Position {
    private double positionX; //sur l'axe x
    private double positionY; //sur l'axe y

    /**
     * Constructeur de la classe Position
     * @param positionX Position de l'objet en X
     * @param positionY Position de l'obejt en Y
     */
    public Position(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Getter et setter
    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "{" + positionX + "; " + positionY + "}";
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
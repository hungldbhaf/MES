package Model;

public class Position {
    public String posID;
    public String posName;
    private Double posBonus;

    public Position() {
        super();
    }

    public Position(String posID, String posName, Double posBonus) {
        this.posID = posID;
        this.posName = posName;
        this.posBonus = posBonus;
    }

    public String getPosID() {
        return posID;
    }

    public void setPosID(String posID) {
        this.posID = posID;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Double getPosBonus() {
        return posBonus;
    }

    public void setPosBonus(Double posBonus) {
        this.posBonus = posBonus;
    }

    public double getPosSalary() {
        return 0;
    }

}

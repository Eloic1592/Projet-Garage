package model;

public class Employe_Specialite extends Model {
    int idEmploye;
    int idSpecialite;

    public Employe_Specialite(int idEmploye, int idSpecialite) {
        this.setIdEmploye(idEmploye);
        this.setIdSpecialite(idSpecialite);
        this.setNbrField(2);
    }

    public Employe_Specialite() {
        this.setNbrField(2);
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

}

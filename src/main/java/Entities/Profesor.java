package Entities;

/**
 * Created by dioni on 2/17/2017.
 */
public class Profesor {
    private int id;
    private int id_user;
    private int materie;
    private String descriere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getMaterie() {
        return materie;
    }

    public void setMaterie(int materie) {
        this.materie = materie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}

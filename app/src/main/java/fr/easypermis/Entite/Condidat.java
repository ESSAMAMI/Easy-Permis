package fr.easypermis.Entite;

public class Condidat {

    private String name;
    private String surname;
    private String login;
    private int tel;

    public Condidat(String name, String surname, String login, int tel) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}

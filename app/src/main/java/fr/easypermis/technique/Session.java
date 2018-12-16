package fr.easypermis.technique;

import fr.easypermis.Entite.Condidat;

public class Session {

    private static Session session = null ;
    private Condidat condidat;


    private Session(Condidat condidat){

        super();
        this.condidat = condidat;
    }

    private static boolean open(String login, String pwd, Condidat condidat){

        if(condidat != null){
            return true;
        }
        return false;
    }

    public static Session getSession() {
        return session;
    }

    public void close(){
        Session.session = null;
    }

    public Condidat getCondidat(){

        return this.condidat;
    }
}

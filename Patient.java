import java.util.*;
/**
 * In der Klasse Patient wird dessen Name, Geburtsdatum, Geschlecht, Adresse und Telefonnummer gepeichert. 
 * Jedem Patienten wird automatisch ein Paket mit sechs Standardimpfungen zugewiesen. Dem Patient kann jede Standardimpfung 
 * extra geimpft werden. Es kann sein Impfstatus für einzelne Impfungen, sowie die bei den StdImpfungen
 * hinterlegte Information abgerufen werden.
 * 
 * @author Pascale Gülcher, Hannah Schweitz
 * @version 02.10.2020
 */

public class Patient
{   
    private String Patientenname, Geburtsdatum, Geschlecht, Adresse, Telefonnummer;
    private HashMap <String, StdImpfung> HashImpfungen = new HashMap();

    /**
     * Konstruktor für Objekte der Klasse Patient, Attributwerte werden übergeben, erstellt die HashMap HashImpfungen mit 
     * sechs Objekten der Klasse StdImpfung.
     * 
     * @param String Patientenname, String Geburtsdatum, String Geschlecht, String Adresse, String Telefonnummer
     */
    public Patient(String Patientenname, String Geburtsdatum, String Geschlecht, String Adresse, String Telefonnummer)
    {
        this.Patientenname = Patientenname;
        this.Geburtsdatum = Geburtsdatum;
        this.Geschlecht = Geschlecht;
        this.Adresse = Adresse;
        this.Telefonnummer = Telefonnummer;

        HashImpfungen.put("HepatitisA", new StdImpfung("HepatitisA"));
        HashImpfungen.put("HepatitisB", new StdImpfung("HepatitisB"));
        HashImpfungen.put("Mumps", new StdImpfung("Mumps"));
        HashImpfungen.put("Roeteln", new StdImpfung("Roeteln"));
        HashImpfungen.put("Masern", new StdImpfung("Masern"));
        HashImpfungen.put("Tetanus", new StdImpfung("Tetanus"));
    }

    /**
     * Standardkonstruktor für Objekte der Klasse Patient, legt Attributwerte fest, erstellt die HashMap HashImpfungen mit 
     * sechs Objekten der Klasse StdImpfung.
     * 
     * @param keine
     */
    public Patient()
    {
        Patientenname = "Max Mustermann";
        Geburtsdatum = "01.02.2020";
        Geschlecht = "w/m/d";
        Adresse = "Seestraße 1, 12345 Musterstadt";
        Telefonnummer = "+491234567890";

        HashImpfungen.put("HepatitisA", new StdImpfung("HepatitisA"));
        HashImpfungen.put("HepatitisB", new StdImpfung("HepatitisB"));
        HashImpfungen.put("Mumps", new StdImpfung("Mumps"));
        HashImpfungen.put("Roeteln", new StdImpfung("Roeteln"));
        HashImpfungen.put("Masern", new StdImpfung("Masern"));
        HashImpfungen.put("Tetanus", new StdImpfung("Tetanus"));
    }

    /**
     * Impft HepatitisA.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "HepatitisA" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner zwei ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus zwei, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String HepatitisAImpfen() throws Exception
    {
        StdImpfung A= HashImpfungen.get("HepatitisA");
        if( A.getImpfstatus() <2)
        {
            A.StatusAendern();
           
            String C= A.setNaechsteImpfung();
        
        
            return C;
        }
        else
            throw new Exception("Keine weitere HepatitisA-Impfung notwendig");
    }

    /**
     * Impft HepatitisB.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "HepatitisB" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner drei ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus drei, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String HepatitisBImpfen() throws Exception
    {
        StdImpfung A = HashImpfungen.get("HepatitisB");

        if( A.getImpfstatus() <3)
        {
            A.StatusAendern();
            String C = A.setNaechsteImpfung();
            return C;
        }
        else
            throw new Exception("Keine weitere Impfung notwendig");    
    }

    /**
     * Impft Masern.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "Masern" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner zwei ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus zwei, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String MasernImpfen() throws Exception
    {
        StdImpfung A= HashImpfungen.get("Masern");
        if( A.getImpfstatus() <2)
        {
            A.StatusAendern();
            String C= A.setNaechsteImpfung();
            return C;
        }
        else
            throw new Exception("Keine weitere Impfung notwendig");
    }

    /**
     * Impft Mumps.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "Mumps" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner zwei ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus zwei, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String MumpsImpfen() throws Exception
    {
        StdImpfung A = HashImpfungen.get("Mumps");
        if( A.getImpfstatus() <2)
        {
            A.StatusAendern();
            String C= A.setNaechsteImpfung();
            return C;
        }
        else
            throw new Exception("Keine weitere Impfung notwendig");
    }

    /**
     * Impft Röteln.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "Roeteln" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner zwei ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus zwei, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String RoetelnImpfen() throws Exception
    {
        StdImpfung A= HashImpfungen.get("Roeteln");
        if( A.getImpfstatus() <2)
        {
            A.StatusAendern();
            String C= A.setNaechsteImpfung();
            return C;
        }
        else
            throw new Exception("Keine weitere Impfung notwendig");
    }

    /**
     * Impft Tetanus.
     * Speichert die Daten des Objekts StdImpfung mit dem Key "Tetanus" aus der HashMap HashImpfungen im Objekt A. Durch externen
     * Methodenaufruf der Methode getImpfstatus wird in der if-Bedingung geprüft, ob der Impfstatus kleiner fünf ist. 
     * Trifft dies zu, wird der Impstatus mit externem Methodenaufruf der Methode StatusAendern() um eins erhöht und das 
     * Datum der nächsten Impfung mit externem Methodenaufruf der Methode setNaechteImfung() aktualiesiert und in der 
     * String-Variable C gespeichert, welche dann ausgegeben wird. Ist der Impfstatus fünf, wird der String "Keine weitere 
     * Impfung notwendig" ausgegeben.
     *
     * @return String C, String
     */
    public String TetanusImpfen() throws Exception
    {
        StdImpfung A= HashImpfungen.get("Tetanus");
        if( A.getImpfstatus() <5)
        {
            A.StatusAendern();
            String C= A.setNaechsteImpfung();
            return C;
        }
        else
            throw new Exception("Keine weitere Impfung notwendig");
    }

    /**
     * Gibt aktuellen Status der eingegebenen Impfung zurück.
     * Speichert Objekt der Klasse StdImpfung mit dem eingebenen Key Impfname aus der HashMap HashImpfungen in A. Speichert den 
     * durch externen Methodenaufruf der Methode getImpfstatus() Impfstatus in der int-Variable ImpfStatus. Speichert den 
     * Impfname + ": " + Impfstatus in der String-Variable Ausgabe und gibt diese dann aus.
     *
     * @param String Impfname
     * @return String Ausgabe
     */
    public String Impfuebersicht(String Impfname)
    {
        StdImpfung A= HashImpfungen.get(Impfname);
        int ImpfStatus = A.getImpfstatus();
        String Ausgabe = Impfname + ": " + ImpfStatus;
        return Ausgabe;
    }

    /**
     * Gibt aktuellen Status aller Standardimpfungen zurück.
     * Speichert alle Impfnamen der Objekte der HashMap HashImpfungen in der Set-Liste Impfnamen. Ruft mit einer for-each-Schleife
     * für alle Impfnamen über einen internen Methodenaufruf die Methode Impfuebersicht() auf. Speichert die Impfstatus in der 
     * String-Variable Ausgabe und gibt diese dann aus.
     *
     * @return String Ausgabe
     */
    public String GesamteImpfuebersicht()

    {
        Set<String> Impfnamen = HashImpfungen.keySet();
        String Ausgabe = " ";
        for(String s: Impfnamen)
        {
            String Impfstatus = Impfuebersicht(s);
            Ausgabe = Ausgabe + Impfstatus + "\n ";
        }
        return Ausgabe; 
    }

    /**
     * Gibt Informationen über einzelne Impfungen zurück.
     * Speichert Objekt der Klasse StdImpfung mit dem eingebenen Key Impfname aus der HashMap HashImpfungen in A. Speichert den 
     * durch externen Methodenaufruf der Methode getInformation() Impfstatus in der String-Variable Info. Speichert den 
     * Impfname + ": " + Info in der String-Variable Ausgabe und gibt diese dann aus.
     * 
     * @param String Impfname
     * @return String Ausgabe
     */
    public String Informationsuebersicht(String Impfname)
    {
        StdImpfung A = HashImpfungen.get(Impfname);
        String Info = A.getInformation();
        String Ausgabe = Impfname + ": " + Info;
        return Ausgabe;
    }

    /**
     * Ändert den Patienenname
     * Überschreibt den Patientenname mit dem String-Parameter neuerName.
     * 
     * @param String neuerName
     * 
     */
    public void setPatientenname(String neuerName)
    {
        Patientenname = neuerName;
    }

    /**
     * Ändert das Geburtsdatum
     * Überschreibt das Geburtsdatum mit dem String-Parameter neuesGeburtsdatum.
     * 
     * @param String neuesGeburtsdatum
     * 
     */
    public void setGeburtsdatum(String neuesGeburtsdatum)
    {
        Geburtsdatum = neuesGeburtsdatum;
    }

    /**
     * Ändert das Geschlecht
     * Überschreibt das Geschlecht mit dem String-Parameter neuesGeschlecht.
     * 
     * @param String neuesGeschlecht
     * 
     */
    public void setGeschlecht(String neuesGeschlecht)
    {
        Geschlecht = neuesGeschlecht;
    }

    /**
     * Ändert die Adresse
     * Überschreibt die Adresse mit dem String-Parameter neueAdresse.
     * 
     * @param String neueAdresse
     * 
     */
    public void setAdresse(String neueAdresse)
    {
        Adresse = neueAdresse;
    }

    /**
     * Ändert die Telefonnummer
     * Überschreibt die Telefonnummer mit dem String-Parameter neueTelefonnummer.
     * 
     * @param String neueTelefonnummer
     * 
     */
    public void setTelefonnummer(String neueTelefonnummer)
    {
        Telefonnummer = neueTelefonnummer;
    }

    /**
     * Gibt den Patientennamen aus
     * 
     * @return String Patientenname
     * 
     */
    public String getPatientenname()
    {
        return Patientenname;
    }

    /**
     * Gibt das Geburtsdatum aus
     * 
     * @return String Geburtsdatum
     * 
     */
    public String getGeburtsdatum()
    {
        return Geburtsdatum;
    }

    /**
     * Gibt das Geschlecht aus
     * 
     * @return String Geschlecht
     * 
     */
    public String getGeschlecht()
    {
        return Geschlecht;
    }

    /**
     * Gibt die Adresse aus
     * 
     * @return String Adresse
     * 
     */
    public String getAdresse()
    {
        return Adresse;
    }

    /**
     * Gibt die Telefonnummer aus
     * 
     * @return String Telefonnummer
     * 
     */
    public String getTelefonnummer()
    {
        return Telefonnummer;
    }
}

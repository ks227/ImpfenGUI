/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author Konrad Sautter
 */
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
    /**
 * Klassenname: Anwendung
 * Über Anwendung wird Patientenaufnahme und -verwaltung gesteuert. Außerdem kann geimpft werden. Von der Oberfläche soll auf diese Klasse
 * zugegriffen werden, um die nötigen Methoden auszuführen.
 * Ein zweiter Konstruktor ist hier nicht sinnvoll, da im Konstruktor nur eine ArrayList erzeugt wird, in die alle neu erstellten Patienten 
 * eingefügt werden. 
 * 
 * @author Konrad Sautter, Sophia Parpoulas 
 * @version 02.10.2020
 */

public class Anwendung

{
    private ArrayList<Patient>Liste;

    /**
     * Standard Konstruktor, der durch erzeugen einer ArrayList eine Liste aller Patienten anlegt.
     * @param: Keine
     * @return: Keine
     */
    public Anwendung()
    {
        Liste=new ArrayList<Patient>();
    }

    /**
     * Get- Methode zum Testen. Die Methode gibt die Länge der ArrayList aus, um zu testen, ob ein Patient hinzugefügt
     * wurde.
     * @param: Keine
     * @return: Laenge als int Zahl
     */
    public int getLaenge()
    {
        return Liste.size();
    }

    /**
     * Methode zum anlegen eines neuen Patienten, durch erzeugen eines neuen Objekts der Klasse Patient. Anschließendes Speichern in der ArrayList.
     * @param: String: Name, Geburtstag, Geschlecht, Adresse, Telefonnummer -> Attribute des Objekts Patient
     * @return: Keine
     */
    public void PatientHinzufuegen(String Name, String Geburtstag, String Geschlecht, String Adresse, String Telefonnummer)
    {
        Patient A= new Patient(Name,Geburtstag,Geschlecht,Adresse,Telefonnummer);
        Liste.add(A);
    }

    /**
     * Methode zum Suchen eines Patienten in der ArrayList durch Eingabe des Namens. Name wird verwendet um mit einer foreach Schleife jedes 
     * Element der Liste zu durchsuchen. Falls der Name mit einem Namen auf der Liste übereinstimmt, wird der Patient zurück gegeben. Ansonsten 
     * wird eine Fehlermeldung ausgegeben.
     * @param: String Name 
     * @return: Objekt Patient
     */ 
    public Patient PatientSuchen(String Name)// throws Exception
    {
        for (Patient e: Liste)
        {
            if (e.getPatientenname().equals(Name))
            {
                return e;
            }

            //else throw new Exception ("Patien nicht vorhanden");

        }
        return null;
    }

    /**
     * Methode zum löschen eines Patienten durch Eingabe des Namens. Die Methode ruft durch einen internen Methodenaufruf die Methode PatientSuchen()
     * auf. Falls der Patient gefunden wird, wird dieser entfernt.
     * @param: String Name
     * @return: Keine
     */
    public void PatientLoeschen(String Name) throws NullPointerException
    {
        Patient H = PatientSuchen(Name);
        if(H!=null)
        {
            Liste.remove(H);
            System.out.println("Der Patient wurde erfolgreich gelöscht.");
        }

        else
            throw new NullPointerException("Patient nicht vorhanden");
    }

    /**
     * Mehtode zum Impfen eines Patienten durch eingabe seines Namens und des Namens der Impfung, die durchgeführt werden soll.
     * Der Patient wird durch einen internen Methodenaufruf der Methode PatientSuchen() aufgerufen.
     * Anschließend wird durch eine switch-Anweisung die durchzuführende Impfung herausgesucht und durch einen externen Methodenaufruf
     * der jeweiligen Impfmethode in der Klasse Patient durchgeführt.
     * @param: String: Patientenname, Impfname
     * @return: String:"Impfung erfolgreich durchgeführt"
     */
    public String Impfen(String Patientenname, String Impfname) throws Exception
    {
        Patient B= PatientSuchen(Patientenname); 
        String x;
        if(B!=null)

        {

            switch(Impfname)
            {
                case "HepatitisA": x="Impfung durchgefuehrt. Naechste Impfung:   " +B.HepatitisAImpfen();
                break;
                case "HepatitisB": x="Impfung durchgefuehrt. Naechste Impfung:  " +B.HepatitisBImpfen();
                break;
                case "Masern": x="Impfung durchgefuehrt. Naechste Impfung:  " +B.MasernImpfen();
                break;
                case "Mumps": x="Impfung durchgefuehrt. Naechste Impfung:  " +B.MumpsImpfen();
                break;
                case"Roeteln": x="Impfung durchgefuehrt. Naechste Impfung:  " +B.RoetelnImpfen();
                break;
                case "Tetanus": x="Impfung durchgefuehrt. Naechste Impfung:  " +B.TetanusImpfen();
                break;
                default: x="Impfung nicht vorhanden";
                break;
            }
            return  x;
        }
        else throw new NullPointerException ("Patient nicht vorhanden");

    }

    /**
     * Methode um den aktuellen Impfstatus eines Patinten abzufragen.
     * Es wird durch einen internen Methodenaufruf der Methode PatientSuchen() auf den Patient zugegriffen. Der Impfstatus wird 
     * durch einen externen Methodenaufruf der Methode Impfuebersicht() aus der Klasse Patient aufgerufen und in einer Variablen "Status" 
     * vom Datentyp int gespeichert.
     * @param: String: Name, Impfname
     * @return: int Status
     */
    public String StatusAbfragen(String Name, String Impfname) throws NullPointerException
    {
        Patient D= PatientSuchen(Name);
        if(D!=null)
        {
            String Status= D.Impfuebersicht(Impfname);
            return Status;
        }
        else throw new NullPointerException ("Patient nicht vorhanden");
    }

    /**
     * Methode um den Impfstatus jeder Impfung aufzurufen.
     * Es wird durch einen internen Methodenaufruf der Methode PatientSuchen() auf den Patient zugegriffen. Durch einen externen Methodenaufruf der Methode GesamteImpfuebersicht() der 
     * Klasse Patient wird der status jeder Impfung des Patienten in einer Variablen gespeichert und anschließend ausgegeben.
     * @param: String: Name
     * @return: String Status
     */
    public String AllgemeinerStatus(String Name) throws NullPointerException
    {
        Patient F= PatientSuchen(Name);
        if(F!=null)
        {

            String Status = F.GesamteImpfuebersicht();
            return Status;
        }
        else throw new NullPointerException("Patient nicht vorhanden");
    }

    /**
     * Methode um die Informationen einer Impfung abzurufen.
     * Es wird durch einen internen Methodenaufruf der Methode PatientSuchen() auf den Patient zugegriffen.
     * Der Impfstatus wird durch einen externen Methodenaufruf der Methode Informationsuebersicht() aus der Klasse Patient aufgerufen 
     * und in einer variablen "Info" vom Datentyp String gespeichert.
     * @param: String: Name, Impfname
     * @return: String Info
     */
    public String InformationenAbfragen(String Name, String Impfname) throws NullPointerException
    {
        Patient E = PatientSuchen(Name);
        if(E!=null)
        {
            String Info= E.Informationsuebersicht(Impfname);
            return Info;
        }
        else throw new NullPointerException ("Patient nicht vorhanden");
    }

    /**
     * Eine Methode um die Patientendaten zu bearbeiten. Durch eine Switch Anweisung wird je der Eingabe die entsprechende Set Methode aus der
     * Klasse Patient ausgewählt und durch einen externen Methodenaufruf ausgeführt. Dadurch wird der neue Eingabewert im Patienten gespeichert.
     * @param: String: zuAenderndeDaten, Patientenname, neueDaten
     * @return: String: Bestätigung der Änderung im Falle einer der cases. Im Falle eines default: Hinfauf auf falsche Eingabe
     */
    public String PatientendatenAendern(String zuAenderndeDaten, String Patientenname, String neueDaten)
    {
        Patient X= PatientSuchen(Patientenname);

        String ausgabe;
        if(X!=null)

        {
            switch(zuAenderndeDaten)

            {

                case "Patientenname": X.setPatientenname(neueDaten);
                ausgabe= zuAenderndeDaten + "  erfolgreich geändert";
                break;
                case "Geburtsdatum": X.setGeburtsdatum(neueDaten);
                ausgabe= zuAenderndeDaten + "  erfolgreich geändert";
                break;
                case "Geschlecht": X.setGeschlecht(neueDaten);
                ausgabe= zuAenderndeDaten + "  erfolgreich geändert";
                break;
                case "Adresse": X.setAdresse(neueDaten);
                ausgabe= zuAenderndeDaten + "  erfolgreich geändert";
                break;
                case "Telefonnummer": X.setTelefonnummer(neueDaten);
                ausgabe= zuAenderndeDaten + "  erfolgreich geändert";
                break;
                default: ausgabe="falsche Eingabe";
            }
            return ausgabe;
        }
        else throw new NullPointerException ("Patient nicht vorhanden");
    }
}




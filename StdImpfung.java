/**
 * In der Klasse StdImpfung werden für jede Impfung die Attribute initialisiert.
 * Es wird der nächste Impftermin ausgegeben und der jeweilige Impfstatus wird geändert. 
 * 
 * 
 * 
 *
 * @author (Lena Speiser & Christopher Eichbaum) 
 * @version (02.10.2020)
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StdImpfung 
{

    private String Impfname;
    private String Information;
    //private int abstand;
    private String naechsteImpfung;
    private int Impfstatus;
    private int maxAnzahl;
    private int [] abstaende;

    /**
     * Standart-Konstruktor um der Impfung "HepatitisB" Attributwerte zuzuweisen
     * @param keine
     * @return keine
     */
    public StdImpfung()
    {
        Impfname="HepatitisB";
        Information = "Bei häufigem Reisen, geschwächter Immunabwehr und Kontakt zu Kranken, Impfung bei 2, 4 und 6 Monaten";
        abstaende[0]=2;
        abstaende[1]=2;
        naechsteImpfung = "0";
        Impfstatus=0;
        maxAnzahl=0;
    }

    /** Konstruktor um jeder Impfung Attributwerte zu überschreiben (durch eine switch-Anweisung).
     * @param String Impfname
     * @return keine
     * 
     */
    public StdImpfung(String Impfname)
    {
        abstaende= new int [2];
        switch(Impfname)
        {
            case "HepatitisA": Information=" Bei Häufigem Reisen oder Kontakt zu Kranken. \nAbstand zwischen der ersten und zweiten Impfung 6 Monate";
            abstaende[0]=6;
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=2;
            break;
            
            case "HepatitisB": Information=" Bei häufigem Reisen, geschwächter Immunabwehr und Kontakt zu Kranken. \nImpfung bei 2, 4 und 6 Monaten";
            abstaende[0]=2;
            abstaende[1]=2;
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=3;
            break;
            
            case "Mumps": Information=" Viruserkrankung über Tröpfcheninfektion. \nErste Impfung bei 11 Monaten und zweite bei 15 Monaten ";
            abstaende[0]=4;
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=2;
            break;

            case "Roeteln": Information=" Erwachsene Frauen und Personal, welches Kontakt zu Schwangeren und Kleinkindern hat. \nErste Impfung nach 11 Monaten und die zweite nach 15";
            abstaende[0]=4;
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=2;
            break;

            case "Masern": Information=" Besonders gefährdet sind ungeimpfte Kleinkinder und Jugendliche, \nErste Impfung nach 13 Monaten und die zweite nach 17 Monaten  ";
            abstaende[0]=4;   
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=2;
            break;
            
            case "Tetanus": Information=" Soll Wundstarrkrampf durch Krankheitserreger verhindern. \nErste Impfung nach 2 Monaten, die zweite nach 4 Monaten und die letzte nach 10 Monaten, soll alle 10 Jahre wiederholt werden";
            abstaende[0]=2;
            abstaende[1]=6;
            naechsteImpfung="0";
            Impfstatus=0;
            maxAnzahl=3;
            break;
        }

    }

    /**
     * Get-Methode (getInformation) zum Abrufen der Informationen über die einzelnen Impfungen. 
     * @param keine
     * @return String Information
     */
    public String getInformation()
    {
        return Information;
    }

    /**
     * Get-Methode (setNaechsteImpfung), welche durch einen internen Methodenaufruf auf die Methode Datum() zugreift und das neue Datum zurück gibt.
     * @param keine
     * @return String naechsteImpfung
     */
    public String setNaechsteImpfung() throws Exception
    {
        naechsteImpfung=Datum();
        return naechsteImpfung;
    }

    /**
     * Get-Methode (getImpfstatus), welche durch einen internen Methodenaufruf auf die Methode StatusAendern() zugreift und den neuen Status zurück gibt.
     * @param keine
     * @return int Impfstatus (durch internen Methodenaufruf)
     */
    public int getImpfstatus()
    {
        return Impfstatus;
    }

    
    /**
     * Methode welche durch eine if/else Bedingung den Impfstatus um +1 erhöht und eine Excetion wirft, wenn die maximale Anzahl der Impfungen erreicht wurde. 
     * @param keine
     * @return int Impfstatus
     */
    public int StatusAendern() throws Exception
    {

        if (Impfstatus<2)
        {
            Impfstatus=Impfstatus+1;
            return Impfstatus;
        }

        else if (maxAnzahl==3 && Impfstatus==2)
        {
            Impfstatus=Impfstatus+1;
            return Impfstatus;
        }

        else

            throw new Exception("Keine weitere Impfung notwendig");

    }

    /**
     * Methode, welche durch eine if/else Bedingung für den jeweiligen Impfabstand (abstaende[]) das neue Impfdatum berechnet. Die dazu benötigten Methoden wurden zuvor aus der 
     * Java Klassenbibliothek importiert. Wenn keine weitere Impfung notwenig ist, wird eine Exception geworfen. 
     * @param keine
     * @return String durch externen Methodenaufruf von importierte Klassen.
     * 
     */
    public  String  Datum () throws Exception
    {
        int i= getImpfstatus()-1; 
        Date now= new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        Date future;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        
        if (i<abstaende.length && abstaende[i]==2)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 61);
            future = calendar.getTime();
            return dateFormat.format(future);
        }
        else if(i<abstaende.length && abstaende[i]==4)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 122);
            future = calendar.getTime();
            return dateFormat.format(future);
        }

        else
        if(i<abstaende.length && abstaende[i]==6)

        {
            calendar.add(Calendar.DAY_OF_MONTH, 180);
            future = calendar.getTime();
            return dateFormat.format(future);
        }
        else
        throw new Exception("Keine weitere Impfung notwendig");
    }

}

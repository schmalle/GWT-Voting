package org.metams.voting.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.metams.voting.client.votingService;

public class votingServiceImpl extends RemoteServiceServlet implements votingService
{
    // Implementation of sample interface method
    public String getMessage(String msg)
    {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }


    /**
     * returns a set of questions
     * @param nr
     * @return
     */
    public String getQuestions(int nr)
    {

        if (nr == 1)
        {
            return "Das SDSK" + ";" +
                    "muss nur ausgefüllt werden, wenn ausreichend Budget und Ressourcen zur Verfügung stehen" + ";" +
                    "ist zum Gate 2 vollständig auszufüllen"+ ";" +
                    "enthaelt Datenschutzinformation, Berechtigungskonzept und BSI Grundschutzkatalog"+ ";" +
                    "definiert ein Mindestmass an notwendiger Dokumentation fuer die Freigabe eines IT/NT Systems"+ ";" +
                    "4";

        }

        if (nr == 2)
        {
            return "Wo ist das \"evil bit\" spezifiziert?" + ";" +
                    "RFC2616 - Hypertext Transfer Protocol -- HTTP/1.1" + ";" +
                    "RFC2460 - Internet Protocol, Version 6 (IPv6) Specification"+ ";" +
                    "RFC3514 - The Security Flag in the IPv4 Header"+ ";" +
                    "RFC2979 - Behavior of and Requirements for Internet Firewalls"+ ";" +
                    "3";
        }



        if (nr == 3)
        {

            return "Wieviele Kundendaten hat Sony beim Angriff auf das Playtstaion Network im April 2011 verloren ?" + ";" +
                     "120000" + ";" +
                     "2,4 Millionen"+ ";" +
                     "24 Millionen"+ ";" +
                     "75 Millionen"+ ";" +
                     "4";






        }

        if (nr == 4)
        {
            return "Welche Hackergruppe zeichnete für die Operation Payback verantwortlich? " + ";"+
            "Chaos Computer Club        " + ";"+
        "Anonymous                            " + ";"+
        "LulzSec                                      " + ";"+
        "AntiSec                                              " + ";"+
                "2";
        }


        if (nr == 5)
        {
            return "Wiviele Zertifikate wurden bei dem Diginotar Hack von Angreifern ausgestellt?" + ";"+

            "1 – 100  " + ";"+
            "201 – 300        " + ";"+
            "301 – 400                " + ";"+
            "501 - 600                        " + ";"+
                "4";

        }

        if (nr == 6)
        {
            return "Wiviele neue Viren sind in 2010 erschienen? " + ";"+

            "< 50000000  " + ";"+
            "> 5000000 & < 10 000 000" + ";"+
            "> 10000000 & < 15 000 000" + ";"+
            "> 15 000 0000 " + ";"+
                "4";

        }

        if (nr == 7)
        {
            return "Welcher Server unterstützt CSRF Tokens im Standardlieferumfang? " + ";"+

            "Apache 2.6                                                                  " + ";"+
            "Nginx 1.08                                                                   " + ";"+
            "Tomcat 7                                                                  " + ";"+
            "Jetty 6                                                                  " + ";"+
                "3";

        }

        if (nr == 8)
        {
            return "Was macht folgender Perl Code ($_='krjhruaesrltre c a cnp,ohet':$_.=$1,print$2while s/(..)(.)\\/\\/) ? " + ";"+

            "Nichts, da fehlerhaft" + ";"+
            "Ausgabe Just another perl hacker" + ";"+
            "Ausgabe von Zeichenmuell" + ";"+
            "Ausgabe der aktuellen Uhrzeit" + ";"+
                "1";

        }

        if (nr == 9)
        {
            return "In einigen Comicpanels taucht versehentlich ein 4. Neffe neben Tick, Trick und Track auf. Wie heisst er?" + ";"+

           "Treck " + ";"+
           "Tack " + ";"+
           "Trock" + ";"+
           "Tuck" + ";"+
                "1";

        }

        if (nr == 10)
        {
            return "Desperate Housewives wird von Mary Alice, der Erzählerin der Serie, begleitet und war eine enge Freundin von Susan, Gabrielle, Lynette und Bree. Wie kam sie ums leben?" + ";"+

            "durch eine Vergiftung " + ";"+
            "durch ein Gewaltverbrechen" + ";"+
            "beging Suizid" + ";"+
            "durch einen Autounfall" + ";"+
                    "3";

        }

        if (nr == 11)
        {
            return "Wie heisst der zurzeit beste deutsche Golfspieler auf der Weltrangliste?"
                    + ";Bernhard Langer;Martin Kaymer;Tiger Woods;Vijay Sing;2";
        }

        if (nr == 12)
        {
            return "Wie heisst Madonna mit buergerlichem Namen?;Madonna Louise DAntonio;Madonna Louise Ciccone;Madonna Louise Francesco;Madonna Louise Bertolli;2";
        }

        if (nr == 13)
        {
            return "Welches Element ist nicht Teil der Umsetzung in der Kerberos Authentifizierung?;Message authentication code;Ticket-granting ticket;Authentication service;Users, programs, and services;1";

        }

        if (nr == 14)
        {
            return "Was ist mit Identity Theft gemeint?;Wenn in einem Online-PC-Spiel Rollen mit Mitspielern getauscht werden;Wenn der Awender durch Aufforderung seine Indentität wechseln soll;Wenn die Anwendung im Betrieb eine neue Identitaet übernimmt und unter dieser weiter arbeitet;Wenn ein Anwender im Internet die Identitaet eines anderen durch unerlaubtes Entwenden von Benutzerdaten uebernimmt;4";
        }

        if (nr == 15)
        {
            return "Der W32 / Duqu Schadcode nutzt eine 0day Luecke im; TrueType Font Parsing; RPC Handling; OLE Subtype Parsing; SWF Parsing;1";
        }


        if (nr == 16)
        {
            return "Bei welchem Erkennungsverfahren pruefen Virenschutzprogramme den Code verdaechtiger Software auf typische Schadmerkmale?;Malistik;Heuristik;Balistik;Statistik;2";
        }

        if (nr == 17)
        {
            return "Warum muss bei Verwendung von Session-Cookies das Attribut httpOnly gesetzt sein?;Das Attribut httpOnly ermoeglicht den verschluesselten Zugriff auf Cookies über clientseitigen Scripting-Code (z. B. JavaScript);Das Attribut httpOnly ermoeglicht den unverschluesselten Zugriff auf Cookies über clientseitigen Scripting-Code (z. B. JavaScript);Das Attribut httpOnly verhindert den Zugriff auf Cookies ueber clientseitigen Scripting-Code (z. B. JavaScript);Ich kenne Cookies nur mit Schokolade;3";
        }

        if (nr == 18)
        {
            return "Warum muss bei Oracle Datenbanken die Funktion für Case Sensitive Passwords aktiviert werden?;Nur nach der Aktivierung dieser Funktion ist es moeglich GSC (german-special-characters) für Passwoerter zu verwenden;Die Funktion erleichtert die Eingabe von Passwörtern, weil auch aehnliche Passwoerter akzeptiert werden;Die Unterscheidung nach Gross- und Kleinschreibung erschwert das Erraten von Passwoertern durch Ausweitung des Suchbereichs erheblich;Die Funktion Case Sensitive Passwords verhindert die Verwendung sensitiver (dt. empfindlicher) Passwoerter, die durch Angreifer leichter zu erraten sind.;3";
        }

        if (nr == 19)
        {
            return "Warum muss der Enterprise Service Bus alle Serviceanbieter und alle Servicekonsumenten (Benutzer) anhand kryptografisch starker Mechanismen authentisieren?;Nur die ordnungsgemaesse Authentisierung kann gewaehrleisten, dass die bereitgestellten Informationen immer von allen Benutzer gelesen werden koennen.;Nur die ordnungsgemaesse Authentisierung kann gewaehrleisten, dass die bereitgestellten Informationen mit der richtigen Busline transportiert werden.;Nur die ordnungsgemaesse Authentisierung kann gewaehrleisten, dass die bereitgestellten Informationen ausschließlich vom designierten Benutzer gelesen werden.;Es muss ausgeschlossen werden, dass Servicekonsumenten beim Konsumieren vom Serviceanbieter erwischt werden.;3";
        }


        if (nr == 20)
        {
            return "Wann wurde die Stars / DuQu Schadsoftware erstmals im Iran gefunden ?;Februar 2011;Maerz 2011;April 2011;Mai 2011;3";
        }

        if (nr == 21)
        {
            return "Wer hat den in Q4 / 2011 bekannt gewordenen Bundestrojaner programmiert ?;Digitask;Digiteam;Digital;Digitech;1";
        }

        if (nr == 22)
        {
            return "Welche Abkuerzung stammt NICHT aus dem IT Sicherheitsbereich?;ROP;XSS;RTLC;ASLR;3";
        }

        return null;

    }   // getQuestions
}
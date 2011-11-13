package org.metams.voting.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.user.client.*;
import com.sun.servicetag.SystemEnvironment;
import org.metams.voting.client.event.*;

import java.util.ArrayList;
import java.util.List;


//import javax.xml.soap.Text;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class voting implements EntryPoint
{
    private Timer t = null;
    private boolean m_stop = false;
    private int m_progress = 0;
    private int correctAnswers = 0;
    private int m_counter = 1;
    private int m_timer = 0;
    private Button m_button = new Button("Weiter");
    private TextHolder m_questions = new TextHolder();

    private HTML textHTML = new HTML("");

    private HTML antworten = new HTML("");
    private HTML zeit = new HTML("");


    private CheckBox textBoxA = new CheckBox("");
    private CheckBox textBoxB = new CheckBox("");
    private CheckBox textBoxC = new CheckBox("");
    private CheckBox textBoxD = new CheckBox("");
    private HandlerWidget m_handlerWidget = new HandlerWidget();

    private ProgressBar progressBar = new ProgressBar(20, ProgressBar.SHOW_TIME_REMAINING + ProgressBar.SHOW_TEXT);


    /**
     * This is the entry point method.
     */
    public void onModuleLoad()
    {

        //Window.alert("Quiz beginnt nach Drücken der \"OK\" Taste !");



        m_handlerWidget.setButtons(textBoxA, textBoxB, textBoxC, textBoxD, textHTML);
       // m_button.setEnabled(false);


        RootPanel.get("slot1").add(new HandlerWidget());

        RootPanel.get("a").add(textBoxA);
        RootPanel.get("b").add(textBoxB);
        RootPanel.get("c").add(textBoxC);
        RootPanel.get("d").add(textBoxD);


        RootPanel.get("frage").add(textHTML);

        RootPanel.get("slot2").add(m_button);                       // WAR SLOT1 ?

        RootPanel.get("status").add(progressBar);
        if (RootPanel.get("e") != null)
            RootPanel.get("e").add(antworten);
        else
            System.out.println("Error, no e entity found !");

        if (RootPanel.get("f") != null)
             RootPanel.get("f").add(zeit);
        else
            System.out.println("Error, no f entity found !");

   //     zeit.setVisible(false);
   //     antworten.setVisible(false);


        textBoxA.addClickHandler(new ClickHandler()
        {
             public void onClick(ClickEvent event)
             {
                 textBoxB.setValue(false);
                 textBoxC.setValue(false);
                 textBoxD.setValue(false);
               }
        });

        textBoxB.addClickHandler(new ClickHandler()
        {
             public void onClick(ClickEvent event)
             {
                 textBoxA.setValue(false);
                 textBoxC.setValue(false);
                 textBoxD.setValue(false);
               }
        });

        textBoxC.addClickHandler(new ClickHandler()
        {
             public void onClick(ClickEvent event)
             {
                 textBoxB.setValue(false);
                 textBoxA.setValue(false);
                 textBoxD.setValue(false);
               }
        });

        textBoxD.addClickHandler(new ClickHandler()
        {
             public void onClick(ClickEvent event)
             {
                 textBoxB.setValue(false);
                 textBoxC.setValue(false);
                 textBoxA.setValue(false);
               }
        });


        //
        // add handler for "Weiter" button
        //
        m_button.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {

                boolean m_timeOut = progressBar.getTimeOut();
                if (!m_timeOut)
                {

                    System.out.println("Kein Timeout");

                    if (!textBoxA.getValue() && !textBoxB.getValue() && !textBoxC.getValue() && !textBoxD.getValue())
                    {
                        System.out.println("falsch gedrueckt, zu frueh ohne eine antwort");
                        return;
                    }
                    else
                    {
                        System.out.println("richtig gedrueckt");

                    }


                }



                m_stop = true;

                if (t != null)
                    t.cancel();

                RootPanel.get("status").clear();
                progressBar = new ProgressBar(20, ProgressBar.SHOW_TIME_REMAINING + ProgressBar.SHOW_TEXT);

                progressBar.setProgress(0);
                RootPanel.get("status").add(progressBar);


                //System.out.println("onClick(" + (m_counter - 1) + "): instantiated new progressBar object");

                //m_button.setEnabled(false);


                if (!m_timeOut)
                {

                    System.out.println("No timeout");


                if (m_handlerWidget.getRightAnswer() == 1 && textBoxA.getValue())
                {
                    correctAnswers++;
                }

                if (m_handlerWidget.getRightAnswer() == 2 && textBoxB.getValue())
                {
                    correctAnswers++;
                }

                if (m_handlerWidget.getRightAnswer() == 3 && textBoxC.getValue())
                {
                    correctAnswers++;
                }

                if (m_handlerWidget.getRightAnswer() == 4 && textBoxD.getValue())
                {
                    correctAnswers++;
                }

                }

                else
                {
                    System.out.println("timeout");


                }

                m_timeOut = false;

                textBoxA.setValue(false);
                textBoxB.setValue(false);
                textBoxC.setValue(false);
                textBoxD.setValue(false);

                m_timer += m_progress;
                antworten.setHTML("<br>Richtige Antworten: " + correctAnswers);
                zeit.setText("Verbrauchte Zeiteinheiten: " + m_timer);

//                System.out.println("Info: Time needed: " + m_timer + " Correct answers: " + correctAnswers);

                generateData();
            }
        });

        //
        // start the process for the first entry
        //
        generateData();

    }     // onModuleLoad


    /**
     *
     */
    private void generateData()
    {
        // This is the reoccuring part


        m_stop = false;

        if (m_counter != 22)
        {

            System.out.println("generateData(" + m_counter + ")");
            votingService.App.getInstance().getQuestions(m_counter++, new ASyncCallBackQuestion(m_questions));


            t = new Timer()
            {
                public void run()
                {

                    int progress = progressBar.getProgress() + 3;                 // Todo Change this to final value
                    m_progress = progress;
                    if (progress > 100)
                    {
                        this.cancel();
                        progressBar.setProgress(0);

                        System.out.println("generateData(" + (m_counter - 1) + "): canceld time and activate button");

                     }

                    if (m_stop)
                    {
                        this.cancel();
                        progressBar.setProgress(0);
                    }

                    progressBar.setProgress(progress);
                }
            };

            t.scheduleRepeating(1000);

        }
        else
        {
            RootPanel.get("a").setVisible(false);
            RootPanel.get("b").setVisible(false);
            RootPanel.get("c").setVisible(false);
            RootPanel.get("d").setVisible(false);
            RootPanel.get("slot1").setVisible(false);
            RootPanel.get("slot2").setVisible(false);
            textHTML.setHTML("<H1>Auswertung</H1>");
            antworten.setHTML("<br>Richtige Antworten: " + correctAnswers);
            zeit.setText("Verbrauchte Zeiteinheiten: " + m_timer);


            System.out.println("Richtige Antworten: " + correctAnswers);
        }


    }   // generateData


}

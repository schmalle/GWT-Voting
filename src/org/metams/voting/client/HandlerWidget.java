package org.metams.voting.client;

import com.google.gwt.user.client.ui.RadioButton;
import org.metams.voting.client.event.TextLoadedEvent;

import com.google.gwt.user.client.ui.*;

/**
 *
 * Based on
 *
 * GWT event bus example: Alex Reid ar@phiz.net http://phiz.net
 *
 * This is a UI widget that registers itself on the event bus and handles onPeopleLoaded custom events.
 *
 * @author Alex Reid
 */
public class HandlerWidget extends com.google.gwt.user.client.ui.Label implements TextLoadedEvent.Handler
{

    private CheckBox[]   m_buttons = new CheckBox[4];
    private HTML            m_htmlHeading = null;
    private int             m_rightAnswer = 0;

    /*
        returns the right answer, if existing
     */
    public int getRightAnswer() {return m_rightAnswer; }

    /*
        create the answer buttons
     */
    public void setButtons(CheckBox a, CheckBox b, CheckBox c, CheckBox d, HTML x)
    {
        m_buttons[0] = a;
        m_buttons[1] = b;
        m_buttons[2] = c;
        m_buttons[3] = d;
        m_htmlHeading = x;
    }


        public HandlerWidget()
        {
                 // Widget registers itself on the event bus
                EventBus.get().addHandler(TextLoadedEvent.TYPE, this);
        }

        public void onPeopleLoaded(TextLoadedEvent p)
        {
            /*
                0Heading
                1234Vier Fragen
                5Richtige Antwort
             */


                String out = p.getPersonList();
                String splittedStuff[] = out.split(";");

                m_htmlHeading.setText(splittedStuff[0]);

                for (int runner = 0; runner <= 3; runner++)
                {
                     m_buttons[runner].setText(splittedStuff[runner + 1]);
                }

                m_rightAnswer = new Integer(splittedStuff[5]).intValue();

                System.out.println("HandlerWidget: Right answer is: " + m_rightAnswer);

        }
}
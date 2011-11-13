package org.metams.voting.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.metams.voting.client.*;
import org.metams.voting.client.event.TextLoadedEvent;

class ASyncCallBackQuestion implements AsyncCallback<String>
{
    private TextHolder m_questions = null;

    public boolean isThere()
    {
        return (m_questions != null);
    }

    public String returnQuestion()
    {
        return m_questions.getText();
    }

    public ASyncCallBackQuestion(TextHolder x)
    {
        this.m_questions = x;
    }


    /**
     * onSuccess
     *
     * @param result
     */
    public void onSuccess(String result) {

        TextLoadedEvent customEvent = new TextLoadedEvent();
        customEvent.setStaffList(result);

        EventBus.get().fireEvent(customEvent);
   }

    public void onFailure(Throwable throwable) {
        m_questions = null;
    }
}

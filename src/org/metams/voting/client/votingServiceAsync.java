package org.metams.voting.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface votingServiceAsync
{
    void getMessage(String msg, AsyncCallback<String> async);


    void getQuestions(int msg, AsyncCallback<String> async);



}

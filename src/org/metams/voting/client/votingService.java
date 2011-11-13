package org.metams.voting.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("votingService")
public interface votingService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    String getQuestions(int number);


    /**
     * Utility/Convenience class.
     * Use votingService.App.getInstance() to access static instance of votingServiceAsync
     */
    public static class App
    {
        private static votingServiceAsync ourInstance = GWT.create(votingService.class);

        public static synchronized votingServiceAsync getInstance() {
            return ourInstance;
        }
    }
}

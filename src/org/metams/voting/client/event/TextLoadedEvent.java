package org.metams.voting.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import org.metams.voting.client.Staff;

import java.util.*;


/**
 * GWT event bus example: Alex Reid ar@phiz.net http://phiz.net
 *
 * This is the custom event object that gets fired.
 *
 * @author Alex Reid
 */
public class TextLoadedEvent extends
                GwtEvent<TextLoadedEvent.Handler>
{
        /**
         * Interface to describe this event. Handlers must implement.
         */
        public interface Handler extends EventHandler
        {
                public void onPeopleLoaded(TextLoadedEvent p);
        }

        @Override
        protected void dispatch(TextLoadedEvent.Handler handler)
        {
                handler.onPeopleLoaded(this);
        }

        @Override
        public GwtEvent.Type<TextLoadedEvent.Handler> getAssociatedType()
        {
                return TYPE;
        }

        public static final GwtEvent.Type <TextLoadedEvent.Handler> TYPE = new GwtEvent.Type<TextLoadedEvent.Handler>();

        /**
         * Custom data held within this event object.
         */
        private String personList;

        public String getPersonList() {
                return personList;
        }

        public void setStaffList(String pl) {
                this.personList = pl;
        }
}

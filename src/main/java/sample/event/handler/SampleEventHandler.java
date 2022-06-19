package sample.event.handler;

import org.wso2.carbon.identity.core.bean.context.MessageContext;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;
import org.wso2.carbon.user.core.UserStoreManager;

import java.util.Map;

public class SampleEventHandler extends AbstractEventHandler {

    /**
     * Handles the Custom Event.
     *
     * @param event Event required for handling.
     */
    @Override
    public void handleEvent(Event event) {

        //get the event properties.
        Map<String, Object> eventProperties = event.getEventProperties();

        //get the event name from event properties.
        String eventName = event.getEventName();

        //userStore manager instance to interact with the userStore manager.
        UserStoreManager userStoreManager =
                (UserStoreManager) eventProperties.get(IdentityEventConstants.EventProperty.USER_STORE_MANAGER);

        //add your desired functionality here
    }

    /**
     * Returns the priority of the handler.
     *
     * @return Priority level.
     */
    @Override
    public int getPriority(MessageContext messageContext) {

        return 70;
    }

    /**
     * Returns the name of the handler.
     *
     * @return Handler name.
     */
    @Override
    public String getName() {

        return "SampleEventHandler";
    }

    /**
     * Returns the friendly name of the handler.
     *
     * @return Friendly name.
     */
    public String getFriendlyName() {

        return "Sample Event Handler";
    }
}

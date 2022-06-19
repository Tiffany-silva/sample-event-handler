package sample.event.handler.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;
import sample.event.handler.SampleEventHandler;

/**
 * This class implements the service component for Sample Handler.
 */
@Component(
        name = "sample.event.handler.internal.SampleEventHandlerComponent",
        immediate = true
)
public class SampleEventHandlerComponent {

    private static final Log LOG = LogFactory.getLog(SampleEventHandlerComponent.class);

    @Activate
    protected void activate(ComponentContext context) {

        try {
            BundleContext bundleContext = context.getBundleContext();
            bundleContext.registerService(AbstractEventHandler.class.getName(),
                    new SampleEventHandler(), null);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Successfully deployed the custom service");
            }
        } catch (Throwable throwable) {
            LOG.error("Error while activating Custom Event Handler component.", throwable);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Custom Event Handler is deactivated ");
        }
    }
}

# Sample Event Handler
An introduction to WSO2 Event Handlers.
WSO2 introduces the Eventing Framework to trigger events such as `PRE_SET_USER_CLAIMS`,` POST_ADD_USER` and to perform 
operations based on the events that are published.

Event Handlers are subscribed to events to perform actions before or after certain events. An example of Event Handlers 
in WSO2 Identity Server is [`EmailVerificationHandler`](https://github.com/wso2-extensions/identity-governance/blob/master/components/org.wso2.carbon.identity.recovery/src/main/java/org/wso2/carbon/identity/recovery/handler/UserEmailVerificationHandler.java).

### Build & Deploy
1. To build the maven artifact file, run the following command,
   `mvn clean install`.

2. Add the built jar file located in `~/<HOME>/sample.event.handler/target` directory to `<IS_HOME>/repository/components/dropins` directory. 
3. Add the following configuration in the `deployment.toml` configuration file located in `<IS_HOME>/repository/conf`directory.
```
[[event_handler]]
name= "sampleEventHandler"
subscriptions =["PRE_SET_EVENT","POST_SET_EVENT"]
```
4. If the `deployment.toml` file is not used, add the configuration to `<IS_HOME>/repository/conf/identity/identity-event.properties` file.
```
module.name.22=sampleEventHandler
customEvent.subscription.1=PRE_SET_EVENT
customEvent.subscription.2=POST_SET_EVENT
```

Catch you on the rebound!

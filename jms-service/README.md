# jms-service

## Description

This module contains an example of JMS messaging using Spring. Basically we configure a sender using `JmsTemplate` and a Listener using the annotation `@JmsListener@JmsListener`

When a message is sent, you should see in the logs how the sender and the receiver processes the message:

```
Sending an email message.
Received <Email{to=example@mail.com, body=Sample body}>

```
## References

* [JMS Spring Framework](https://docs.spring.io/spring/docs/5.1.4.RELEASE/spring-framework-reference/integration.html#jms)
* [Messaging with JMS](https://spring.io/guides/gs/messaging-jms/)

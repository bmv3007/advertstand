package service;

import mb.ListOfProducts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by Maria on 19.08.2017.
 */



   @Singleton
   @Startup
public class GetMessage {


    Context context = null;
    TopicSession session = null;
    TopicSubscriber receiver = null;
    TopicConnection connection = null;

    @Inject
    ListOfProducts listOfProducts;


    @PostConstruct
    public void recieveMessage() {

        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put("java.naming.provider.url", "tcp://localhost:61616");
        props.put("topic.topic1", "topic1");
        props.put("connectionFactoryNames", "topicCF");


        try {
            context = new InitialContext(props);

            TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("topicCF");
            Topic topic = (Topic) context.lookup("topic1");

            connection = connectionFactory.createTopicConnection();


            session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);

            MessageListener listener = new MessageListener() {
                public void onMessage(Message msg) {


                    listOfProducts.loadListOfProducts();

                    //***************************

                }
            };

            connection.start();
            receiver = session.createSubscriber(topic);
            receiver.setMessageListener(listener);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void destroy() {
        if (connection != null) {
            try {
                receiver.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
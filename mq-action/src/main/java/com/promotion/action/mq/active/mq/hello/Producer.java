package com.promotion.action.mq.active.mq.hello;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by shifeifei on 2017/5/10.
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        /**
         * 1.建立ConnectionFactory工厂对象，需要填入用户名、密码、以及要连接的地址，
         * 均使用默认即可，默认端口为tcp://localhost:61616
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");

        /**
         * 2.通过ConnectionFactory工厂对象我们创建一个Connection连接，
         * 并且调用Connection的start方法开启连接，Connection默认是关闭的。
         */
        Connection connection = connectionFactory.createConnection();
        connection.start();
        /**
         * 3.通过Connection对象创建Session会话（上下文环境对象），用于接收消息，
         * 参数配置1为是否启用是事务，参数配置2为签收模式，一般我们设置自动签收。
         */
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        /**
         * 4.通过Session创建Destination对象，指的是一个客户端用来指定生产消息目标和消费消息来源的对象，
         * 在P2P模式中，Destination被称作Queue即队列；在Pub/Sub模式，Destination被称作Topic即主题。
         * 在程序中可以使用多个Queue和Topic。
         */
        Destination destination = session.createQueue("hello-active-mq");

        /**
         * 5.我们需要通过Session对象创建消息的发送和接收对象（生产者和消费者）MessageProducer/MessageConsumer。
         */
        MessageProducer producer = session.createProducer(destination);

        /**
         * 6.我们可以使用MessageProducer的setDeliveryMode方法为其设置持久化特性和非持久化特性（DeliveryMode)。
         */
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        /**
         * 7.最后我们使用JMS规范的TextMessage形式创建数据（通过Session对象），
         * 并用MessageProducer的send方法发送数据。同理客户端使用receive方法进行接收数据。最后不要忘记关闭Connection连接。
         */
        TextMessage message = session.createTextMessage();

        for (int i = 0; i < 5; i++) {
            message.setText("我是消息内容,i=" + i);
            producer.send(message);
            System.out.println(message.toString());
        }
        if (null != connection) {
            connection.close();
        }

    }

}

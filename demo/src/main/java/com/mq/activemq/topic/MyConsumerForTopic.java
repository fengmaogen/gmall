package com.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @classs: MyProducerForTopic
 * @author: fengmg
 * @date: 2020/1/16 17:03
 * @description: 基于发布/订阅模式传输类型的消费者测试
 * @version: 1.0
 */
public class MyConsumerForTopic {

    private static final String ACTIVEMQ_URL = "tcp://192.168.1.31:61616";

    public static void main(String[] args) throws JMSException {
        //创建activemq工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列，并标识队列名称，消费者根据名称获取消息
        Destination destination = session.createTopic("topicTest");
        //创建生产者
        MessageConsumer consumer = session.createConsumer(destination);
        //接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    //打印消息
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package com.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @classs: MyProducerForTopic
 * @author: fengmg
 * @date: 2020/1/16 17:03
 * @description: 基于发布/订阅模式传输类型的生产者测试
 * @version: 1.0
 */
public class MyProducerForTopic {

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
        MessageProducer producer = session.createProducer(destination);
        //发布消息
        for (int i = 1; i < 10; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("发布的第" + i + "个消息");
            //发布消息
            producer.send(textMessage);
            //打印消息
            System.out.println(textMessage.getText());
        }
        //关闭连接
        connection.close();
    }
}

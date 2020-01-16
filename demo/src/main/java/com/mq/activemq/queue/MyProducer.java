package com.mq.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @classs: MyProducer
 * @author: fengmg
 * @date: 2020/1/16 10:33
 * @description: 基于点对点传输类型的生产者测试
 * @version: 1.0
 */
public class MyProducer {

    private final static String ACTIVEMQ_URL = "tcp://192.168.1.31:61616";

    public static void main(String[] args) throws JMSException {
        //创建activemq工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Destination destination = session.createQueue("myQueue");
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        //发送信息
        for (int i = 1; i <= 10; i++) {
            //创建文本信息
            TextMessage textMessage = session.createTextMessage("第" + i + "个文本信息");
            //发送文本消息
            producer.send(textMessage);
            //打印
            System.out.println(textMessage.getText());
        }
        connection.close();
    }
}

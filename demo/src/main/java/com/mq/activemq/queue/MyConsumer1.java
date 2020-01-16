package com.mq.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @classs: MyConsumer
 * @author: fengmg
 * @date: 2020/1/16 16:26
 * @description:  消费者2
 * @version: 1.0
 */
public class MyConsumer1 {

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
        //创建队列
        Destination destination = session.createQueue("myQueue");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //监听消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取到的信息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //关闭连接
//        connection.close();
    }
}

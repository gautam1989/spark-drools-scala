package com.rabbitmq

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.test.Emp;

object ReceiveScala {
  
  
  def main(args: Array[String]): Unit = {
    
    var QUEUE_NAME = "EMPIN"


	   val factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    val connection = factory.newConnection();
	    val channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	   
	    
	  
	      
	      
	      
	      
	    //  channel.basicConsume(QUEUE_NAME, true, consumer);
	    
    
    
  }
  
}
package com.rabbitmq;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.Emp;

public class Send {
	  private final static String QUEUE_NAME = "EMPIN";

	  public static void main(String[] argv)
	      throws java.io.IOException, TimeoutException {
		    ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    String message = "Hello World!2";
		    List<Emp> inputData = Arrays.asList(
		  	      new Emp("a",12,false),
		  	      new Emp("b",22,false),
		  	      new Emp("c",32,false),
		  	      new Emp("d",42,false)
		  	     
		  	    );
		    Gson gson=new Gson();
		   // System.out.println(gson.toJson(inputData));
		    channel.basicPublish("", QUEUE_NAME, null, gson.toJson(inputData).getBytes());
		    System.out.println(" [x] Sent '" + message + "'");
		    
		    channel.close();
		    connection.close();
	  }
	}
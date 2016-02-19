package com.cml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.kie.api.io.ResourceType
import org.kie.api.runtime.rule.RuleContext
import org.kie.internal.KnowledgeBaseFactory
import org.kie.internal.builder.KnowledgeBuilderFactory
import org.kie.internal.io.ResourceFactory
import org.kie.internal.runtime.StatefulKnowledgeSession
import scala.collection.JavaConversions._
import org.apache.spark.broadcast.Broadcast
import org.kie.api.KieBase
import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer
import org.kie.api.runtime.StatelessKieSession
import org.kie.internal.command.CommandFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import scala.collection.JavaConverters._
import java.lang.reflect.Type
import com.google.gson.reflect.TypeToken
import org.kie.api.cdi.KBase

object ScalaSpTest {
  def main(args: Array[String]): Unit = {
   
   	val conf = new SparkConf()
			.setAppName("WordCount")
			.setMaster("local")
    val sc = new SparkContext(conf)
    
    var l=List(1,2,3,4)
    
    var count=sc.parallelize(l).count()
    println(count)
    
     val textFile = sc.textFile("/home/cloudera/Desktop/inputs/input1")
     
     val countAllWords = textFile.count()
     println("TOTAL WORDS:"+count)
     
     val wordCount= textFile.flatMap (x => x.split(" ")).map( x =>(x,1)).reduceByKey((a,b)=>a+b)
     wordCount.collect().foreach(x=>println(x._1))
   	
     println("WORDCOUNT:"+wordCount)
     
    
  }
}
package com.test

import org.apache.spark.api.java.JavaRDD
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.util.Calendar
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

object RddTest {


	def main(args: Array[String]): Unit = {
			val today = Calendar.getInstance().getTime()
					val conf = new SparkConf()
			.setAppName("WordCount")
			.setMaster("local")
			val sc = new SparkContext(conf)
   

			val e1=new Emp("g",21,false)
			val e2=new Emp("a",22,false)
			val e3=new Emp("a",22,false)

			val l=List(e1,e2,e3);
			val e: RDD[Emp]=sc.parallelize(l)
					val liste=e.map { x => (x.name,1) }.reduceByKey(_+_).collectAsMap().filter(p=>p._2.equals(2))
					println("keys:"+liste.keys)
					liste.keys.foreach { x => println(x) }
					val today2 = Calendar.getInstance().getTime()
							;

	}
	


	
	
}

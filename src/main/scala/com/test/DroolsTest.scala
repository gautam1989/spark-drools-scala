package com.test

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

object DroolsTest {

   
  
	def main(args: String): Unit = {


			println(args)
			// buid the builder and base
			val kbuilder = KnowledgeBuilderFactory
			.newKnowledgeBuilder()
			kbuilder.add(ResourceFactory
					.newClassPathResource("approval.drl"), 
					ResourceType.DRL)
					if (kbuilder.hasErrors()) {
						throw new RuntimeException(kbuilder
								.getErrors().toString())
					}

			val kbase = KnowledgeBaseFactory.newKnowledgeBase()
					kbase.addKnowledgePackages(
							kbuilder.getKnowledgePackages())
									val conf = new SparkConf()
			.setAppName("WordCount")
			.setMaster("local")
			val sc = new SparkContext(conf)

								val rules = kbase//loadRules();
			        val broadcastRules = sc.broadcast(rules);
							val session = broadcastRules.value.newStatelessKieSession();
							// buid the builder and base
  

					
		

			val e1=new Emp("g",12,false)
			val e2=new Emp("f",12,false)


			val gson = new Gson
			val mapType :Type = new TypeToken[Array[Emp]] {}.getType
			val applicants:Array[Emp]= gson.fromJson(args, mapType)


			val s=applicants.map { x => applyRules(session,broadcastRules.value, x)}.filter { x => x.isApp() }.size
			applicants.map { x => applyRules(session,broadcastRules.value, x)}.foreach { x => println(x.name + " " +x.age+" "+x.isApp())
			 
		//	 val l=session.getGlobal("cityLocator").asInstanceOf[EmpCompletion]
			
			
			}
	}



	def applyRules(session:StatelessKieSession,base:KieBase,a:Emp):Emp={
			//val session = base.newStatelessKieSession();
				var Elist:List[Emp] = List()
			 session.setGlobal("cityLocator", new EmpCompletion(Elist))
			session.execute(CommandFactory.newInsert(a));
		
			return a;
	}

}



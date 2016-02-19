package com.test

import org.kie.api.io.ResourceType
import org.kie.api.runtime.rule.RuleContext
import org.kie.internal.KnowledgeBaseFactory
import org.kie.internal.builder.KnowledgeBuilderFactory
import org.kie.internal.io.ResourceFactory
import org.kie.internal.runtime.StatefulKnowledgeSession

object Functions {
  
  def insertEmpResponse(kcontext: RuleContext, 
      emp: Emp): Unit = {
    // create and insert a TrafficResponse bean
    // back into the session
     println("added1")
    val sess = kcontext.getKnowledgeRuntime()
      .asInstanceOf[StatefulKnowledgeSession]
     val empcompletion:EmpCompletion = sess.getGlobal("cityLocator").asInstanceOf[EmpCompletion]
     println(empcompletion)
    empcompletion.addEmp(emp)
    println("added")
  //  sess.insert(EmpCompletion(emp).addEmp(emp))
    
    // log the step
  }
  
}
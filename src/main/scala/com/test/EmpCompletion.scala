package com.test

class EmpCompletion(var empList:List[Emp]) {
  
  
  
  def addEmp( e:Emp):Unit={
    e :: empList
   println("Emp to add is: "+e.name)  
  }
  
  
  
}
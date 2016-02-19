package com.test

class Emp(var name: String,var age: Int,var approved :Boolean) extends Serializable  {
  
 /* var name:String = n
  var age:Int = a
  var ap:Boolean = approved;
  */
  
  def setAp(a:Boolean):Unit={
    approved=a
  }
  
  def isApp():Boolean={
    return approved
  }
  
}
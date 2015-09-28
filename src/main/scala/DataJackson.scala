case class DataJackson(
     
     private var _event_type:String,
     private var _timestamp:Long
     ){ 
  
    def this(){
      this("",0)
      
    }
    
   // {"recs": {"ints": {"3": [186337307, 183665084, 186097159, 186236234, 180818566, 186374324]}}
    
    def getEvent_type = _event_type
    def setEvent_type(value:String):Unit={_event_type = value}
    
    def getTimestamp = _timestamp
    def setTimestamp(value:Long):Unit={_timestamp = value}
    
    
    
    
    
}
 
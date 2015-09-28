case class Item(
     private var _title:String,
     private var _domainid:Int,
     private var _categoryid:String,
     private var _channelid:Int,
     private var _created_at:String,
     private var _expires_at:String,
     private var _flag: Int,
     private var _id: Int,
     private var _img: String, 
     private var _kicker: String,
     private var _published_at: String,
     private var _text : String,
     private var _updated_at : String ,
     private var _url: String,
     private var _version: Int
     ){ 
    def this(){
      this("",0,"",0,"","",0,0,"","","","","","",0)
      
    }
    
    def getTitle = _title
    def setTitle(value:String):Unit={_title = value}
    def getDomainid = _domainid
    def setDomainid(value:Int):Unit={_domainid = value}
    def getCategoryid = _categoryid
    def setCategoryid(value:String):Unit={_categoryid = value}
    def getChannelid = _channelid
    def setChannelid(value:Int):Unit={_channelid = value}
    def getCreated_at = _created_at
    def setCreated_at(value:String):Unit={_created_at = value}
    def getExpires_at = _expires_at
    def setExpires_at(value:String):Unit={_expires_at = value}
    def getFlag = _flag
    def setFlag(value:Int):Unit={_flag = value}
    def getId = _id
    def setId(value:Int):Unit={_id = value}
    def getImg = _img
    def setImg(value:String):Unit={_img = value}
    def getKicker = _kicker
    def setKicker(value:String):Unit={_kicker = value}
    def getPublished_at = _published_at
    def setPublished_at(value:String):Unit={_published_at = value}
    def getText = _text
    def setText(value:String):Unit={_text = value}
    def getUpdated_at = _updated_at
    def setUpdated_at(value:String):Unit={_updated_at = value}
    def getUrl = _url
    def setUrl(value:String):Unit={_url = value}
    def getVersion = _version
    def setVersion(value:Int):Unit={_version = value}
    
    
    
    
    
}
 
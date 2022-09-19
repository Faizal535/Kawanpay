package com.kawan.pay

class DataClass {
    var date:String? = null
    var category:String? = null
    var spending:Int? = null
    constructor(){}
    constructor(date:String?,category: String?,spending:Int?){
        this.date = date
        this.category = category
        this.spending = spending
    }


}
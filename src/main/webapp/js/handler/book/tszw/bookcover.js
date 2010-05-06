function handlerProcess(){     
    var info={
        nextLinkPath: "/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/div[3]/a[1]",
        mapping : [
            {name:'description',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/div[2]/p[1]"},
                
            {name:'category',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/��Ʒ���\s*(\S*)/i},

            {name:'hit',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/�ܵ������\s*(\S*)/i},
    
            {name:'recommendation',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/���Ƽ�����\s*(\S*)/i},
    
            {name:'totalChar',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/���������\s*(\S*)/i},       
                                             
            {name:'updateTime',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/����ʱ�䣺\s*(\S*)/i},       
    
            {name:'author',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/table/tbody", 
                param2:/�鼮���ߣ�\s*(\S*)/i},        
                
            {name:'name',    op:'xpath.textcontent.regex', 
                param1:"/html/body/div[3]/div[@id='centerm']/div[@id='content']/div[1]/div[1]/p"},
                
            {name:'coverUrl', op:'assign.value',  param1:window.location.toString()}
        ]
    };
    var book = HandlerHelper.parseBookCover(info.mapping);
    HandlerHelper.postBookCover(book, {action:'Goto.XPath.Link.Href', param1:info.nextLinkPath});
}

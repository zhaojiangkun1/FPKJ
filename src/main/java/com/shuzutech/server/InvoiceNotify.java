package com.shuzutech.server;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class InvoiceNotify {


    @RequestMapping(value = "/invoice/notify",method = RequestMethod.POST)
    public String getInvoiceInfo(@RequestBody String body) throws IOException, ParserConfigurationException, SAXException {
        boolean flag = OperatorNotifyXml.isXmlDocument(body);
        OperatorNotifyXml.write(body);
        if (flag) {
            return OperatorNotifyXml.parseXml("D:\\IdeaProjects\\FPKJ\\src\\main\\resources\\fptz.xml","returnmsg");
        }
        return "参数不合法";
    }
}

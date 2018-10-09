package test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        //创建 JaxWsDynamicClientFactory 工厂实例
        JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
        //根据服务地址创建客户端
        Client client=factory.createClient("http://localhost:8080/services/student?wsdl");
        Object [] result;
        try {
            result=client.invoke("qryStudentEntityByid", "");
            System.out.println(Arrays.asList(result[0]));
            /*result=client.invoke("getUserByName", "Jack");
            System.out.println( result[0]);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

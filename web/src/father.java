public class father {

//    service方法出现this
    public void service(String method){
        if ("get".equals(method)){
            this.doGet();
        }else if ("post".equals(method)){
            this.doPost();
        }
    }


    public void doGet(){
        System.out.println("fs执行get");
    }
    public void doPost(){
        System.out.println("fs执行post");
    }
}

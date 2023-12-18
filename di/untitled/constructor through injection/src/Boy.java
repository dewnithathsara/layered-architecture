5public class Boy {
    Agreement agreement;

    public Boy(Agreement a){
        this.agreement=a;
    }
    public void chattingWithGirl(){
       Agreement agreement=new Girl();
        agreement.chat();

    }
    public void test(){
        Agreement agreement=new Girl();
        agreement.chat();
    }
    public static void main(String args[]){
        Boy boy=new Boy(new Girl());
        boy.chattingWithGirl();
        boy.test();
    }
}

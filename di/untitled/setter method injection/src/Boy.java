public class Boy {

    Agreement agreement;
    public  void setterAgreement(Agreement aggrement){
        this.agreement=aggrement;

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

        Boy boy=new Boy();
        boy.setterAgreement(new Girl());
        boy.chattingWithGirl();
        boy.test();
    }
}

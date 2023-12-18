public class Boy implements DI{
    Agreement agreement;
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
        boy.inject(new Girl());
        boy.chattingWithGirl();
        boy.test();
    }

    @Override
    public void inject(Agreement a) {
    this.agreement=a;
    }
}

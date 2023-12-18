public class Boy {
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
        boy.chattingWithGirl();
        boy.test();
    }
}

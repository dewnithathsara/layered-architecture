public class Boy {
    Agreement agreement;
    /*public Boy(Agreement a){
        this.agreement=a;
    }*/
   /* public Boy(){

    }*/
    public void setAgreement(Agreement a){
        this.agreement=a;
    }

    public void chattingWithGirl(){

        agreement.chat();
    }

    public void test(){

        agreement.chat();
    }

    public static void main(String args[]){


        Boy boy1=new Boy();
        boy1.setAgreement(new Girl());
        boy1.chattingWithGirl();

        boy1.test();
    }
}

public class chess {
    boolean inplayspace(int a, int b){
        if(a>8||a<0||b>8||b<0) return false;
        else return true;
    }
    public static void main(String args[]){
        chess obj = new chess();
        System.out.println("ksj");
        System.out.println(obj.inplayspace(1,-1));




    }
}

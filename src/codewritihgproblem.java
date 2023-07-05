import java.util.ArrayList;

public class codewritihgproblem {

    public static void main(String[] args) {
        String[][] queries = {{"ADD", "2"},{"ADD", "4"},{"ADD", "9"}
                ,{"GET_NEXT", "0"},{"GET_NEXT", "1"},{"GET_NEXT", "2"},{"GET_NEXT", "3"},{"GET_NEXT", "4"},{"GET_NEXT", "9"}};
        ArrayList<Integer>abs =new ArrayList<>();

        int n= queries.length;
        String []b= new String[n];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[i].length; j++) {
                String value=queries[i][j];

                if(value.equals("ADD")){
                    abs.add(Integer.parseInt(queries[i][j+1]));
                    b[i]="";
                }else if (value.equals("EXISTS")){
                     if(abs.isEmpty()){
                         b[i]="false";
                     }else{
                         int num=Integer.parseInt(queries[i][j+1]);
                         if(abs.contains(num)){
                             b[i]="true";
                         }else {
                             b[i]="false";
                         }
                     }
                }else if(value.equals("REMOVE")){
                    int num= Integer.parseInt(queries[i][j+1]);
                    if (abs.contains(num)){
                        int indx=abs.indexOf(num);
                        abs.remove(indx);
                        b[i]="true";
                    }else{
                        b[i]="false";
                    }
                }else if (value.equals("GET_NEXT")){
                    int num = Integer.parseInt(queries[i][j+1]);
                    int num2=101;
                        for (int k = 0; k < abs.size(); k++) {
                            if (abs.get(k) > num) {
                                if(num2>abs.get(k)){
                                    num2=abs.get(k);
                                }else {
                                    b[i] = "";
                                }
                            } else {
                                b[i] = "";
                            }
                        }
                        if(num2==101){
                            b[i] = "";
                        }else {
                            b[i] = ""+num2;
                        }
                }
            }
        }

        for (int i = 0; i < b.length ; i++) {
            //System.out.println(abs.get(i));
            System.out.println(b[i]);
        }

    }
}

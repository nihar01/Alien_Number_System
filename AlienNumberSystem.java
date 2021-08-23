import java.util.*;
// import java.util.ArrayList;

public class AlienNumberSystem {    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the number to be incremented by 1");
        System.out.println("Enter the String of characters representing Alien number system");
        // int number=sc.nextInt();
        String n=sc.nextLine();
        String B=sc.nextLine();

        int base=B.length();
        HashMap<Character,Integer> h=new HashMap<>(); 
        HashMap<Integer,Character> h1=new HashMap<>();  

        for(int i=0;i<base;i++)
        {
            h.put(B.charAt(i), i);
            h1.put(i,B.charAt(i));
        }

        for(Map.Entry<Character,Integer> m : h.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());  
        }

         String st="";
        for(int i=0;i<n.length();i++)
        {
            Character c=n.charAt(i);
           st=st.concat(Integer.toString(h.getOrDefault(c,-1)));
        }    
        System.out.print(st+" before addition");
        System.out.println("");

       String a=st;
       String b="1";

       int len_a, len_b;
     
       len_a = a.length();
       len_b = b.length();
    
       String sum, s;
       s = "";
       sum = "";
    
       int diff;
       diff = Math.abs(len_a - len_b);
       for (int i = 1; i <= diff; i++)
           s += "0";
       if (len_a < len_b)
           a = s + a;
       else
           b = s + b;
    
       int curr, carry = 0;
       
       for (int i = Math.max(len_a, len_b) - 1;
                           i > -1; i--) {
 
           curr = carry + (a.charAt(i) - '0') +
                       (b.charAt(i) - '0');

           carry = curr / base;

           curr = curr % base;

           sum = (char)(curr + '0') + sum;
       }
       if (carry > 0)
           sum = (char)(carry + '0') + sum;

     String result_num= sum;
        System.out.print(result_num+" after incrementing by 1"+"\n");

        String result_string="";

        for(int i=0;i<result_num.length();i++)
        {
            Integer aa=Character.getNumericValue(result_num.charAt(i));
          result_string=result_string.concat(Character.toString(h1.getOrDefault(aa,'?')));
        }
        System.out.print("Next number according to Alien number system ->"+result_string+"\n");
        sc.close();
    }
}


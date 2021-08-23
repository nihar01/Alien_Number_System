import java.util.*;
// import java.util.ArrayList;

public class AlienNumberSystem {    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the number to be incremented by 1"); 
         String n=sc.nextLine();
        System.out.println("Enter the String of characters representing Alien number system");
        // int number=sc.nextInt();
       
        String B=sc.nextLine();

        int base=B.length();
        HashMap<Character,Integer> h=new HashMap<>(); //mapping from  character to integer
        HashMap<Integer,Character> h1=new HashMap<>();  //mapping from integer to character

        for(int i=0;i<base;i++)
        {
            h.put(B.charAt(i), i);  //adding mapping from char to number in hashmap
            h1.put(i,B.charAt(i));
        }

        // for(Map.Entry<Character,Integer> m : h.entrySet()){    
        //     System.out.println(m.getKey()+" "+m.getValue());    
        // }

         String s="";
        for(int i=0;i<n.length();i++)
        {
            Character c=n.charAt(i);
           s=s.concat(Integer.toString(h.getOrDefault(c,-1)));              //Converting sring of character to string of integers
        }    
        System.out.print(s+" before addition");
        System.out.println("");
        String result_num=  sumBaseB(s, "1", base);            // calling function to increment by 1
        System.out.print(result_num+" after incrementing by 1"+"\n");    //string after incrementing by 1

        String result_string="";

        for(int i=0;i<result_num.length();i++)
        {
            Integer a=Character.getNumericValue(result_num.charAt(i));
          result_string=result_string.concat(Character.toString(h1.getOrDefault(a,'?')));   //converting character string back to Integer string
        }

        System.out.print("Next number according to Alien number system ->"+result_string+"\n");   //final string in Alien number system

        sc.close();
    }

    static String sumBaseB(String a, String b, int base)
    {
        int len_a, len_b;
        len_a = a.length();
        len_b = b.length();
        String sum, s;
        s = "";
        sum = "";
     
        int diff;
        diff = Math.abs(len_a - len_b);
        // Padding 0 in front of the
        // number to make both numbers equal
        for (int i = 1; i <= diff; i++)
            s += "0";
         
        // Condition to check if the strings
        // have lengths mis-match
        if (len_a < len_b)
            a = s + a;
        else
            b = s + b;
        int curr, carry = 0;
        // Loop to find the find the sum
        // of two integers of base B
        for (int i = Math.max(len_a, len_b) - 1;i > -1; i--) {
             
            // Current Place value for
            // the resultant sum
            curr = carry + (a.charAt(i) - '0') +(b.charAt(i) - '0');
     
            // Update carry
            carry = curr / base;
     
            // Find current digit
            curr = curr % base;
     
            // Update sum result
            sum = (char)(curr + '0') + sum;
        }
        if (carry > 0)
            sum = (char)(carry + '0') + sum;
        return sum;
    }
}


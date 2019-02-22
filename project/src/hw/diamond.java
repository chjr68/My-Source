package hw;
import java.util.*;
public class diamond {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	      
	      int i,star,blank;
	      
	      while(true)
	      {
	      System.out.print("숫자를 입력해주세요 : ");
	      int number = s.nextInt();
	      
	      if((number%2)==0)
	         {
	         System.out.println("홀수를 입력해주세요.\n");   
	         continue;
	         }
	      for(i=0;i<number;i++)
	      {
	         for(blank=0;blank<number-i-1;blank++)
	            System.out.printf(" ");
	         for(star=0;star<2*i+1;star++)
	            System.out.printf("*");
	         System.out.println();
	      }      
	      
	      
	      
	      for(i=number-2;i>=0;i--)
	      {
	         for(blank=0;blank<number-i-1;blank++)
	            System.out.printf(" ");
	         for(star=0;star<2*i+1;star++)
	            System.out.printf("*");
	         System.out.println();
	      }      
	      
	      }

	}

}

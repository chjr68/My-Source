package hw;
import java.util.*;

class BankAccount{
	private String name;
	private String account_num;
	private String passwd;
	private int money;
	private int fix_d;
	public BankAccount()
	{
		
		fix_d=1;
		setting();
	}
	public boolean setting()
	{
		if (fix_d == 1)
			return true;
		else 
			return false;
	}
	public void setName(String name) 
	{
		this.name = name;	
	}
	public String getName()
	{
		return name;
	}
	public void setNum(String account_num) 
	{
		this.account_num = account_num;	
	}
	public String getNum()
	{
		return account_num;
	}
	public void setPasswd(String passwd) 
	{
		this.passwd = passwd;	
	}
	public String getPasswd()
	{
		return passwd;
	}
	
	public int getMoney()
	{
		return money;
	}
	private boolean isPasswdCorrect(String passwd)
	{
		if(this.passwd.equals(passwd))
			return true;
		else 
			{
				System.out.println("비밀번호가 틀렸습니다.");
				return false;
			}
		
	}
	public void Deposit(int gold) 
	{
			money+=gold;
		
	} //입금
	public void Withdraw(int gold) 
	{
			if(money >=gold) 
				money-=gold;
			else
				System.out.println("잔액이 부족합니다.");
	} //출금
	public void SendMoney(BankAccount ba,int gold,String key,int select) //이체
	{
		System.out.println();
		if(isPasswdCorrect(key))
		{
			if(select == 1)
				Deposit(gold);
			else if(select == 2)
			{
				if(money >= gold)
				{
					ba.Deposit(gold);
					Withdraw(gold);
				}
				else
					System.out.println("잔액이 부족합니다.");	
			}
			else if(select == 3)
				Withdraw(gold);
		}
	}
}
public class account {
	public void PrintMenu()
	{
		System.out.println("-----메뉴를 선택해주세요.-----");
		System.out.println("1. 계좌생성");
		System.out.println("2. 기존계좌입력");
		System.out.println("0. 종료");
		System.out.println("------------------------------");
		
	}
	
	public void PrintDoWhat()
	{
		System.out.println("-----어떤 작업을 하시겠습니까?-----");
		System.out.println("1. 입금하기");
		System.out.println("2. 이체하기");
		System.out.println("3. 출금하기");
		System.out.println("4. 잔액확인");
		System.out.println("5. 계좌정보 수정하기");
		System.out.println("0. 이전메뉴로 가기");
		System.out.println("-----------------------------------");
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		
		account m = new account();
		
		int check = 0; //0이면 입력된 정보가 없음, 1이면 입력된 정보가 있음
		
		while(true)
		{
			
			m.PrintMenu();
			System.out.print("번호를 입력해주세요 : ");
			int choice = s.nextInt(); //초기메뉴선택값 변수
			if (choice == 1)
			{				
				System.out.println("첫번째 계좌를 생성합니다.");
				System.out.print("계좌번호를 입력해주세요 : ");
				a.setNum(s.next());
				System.out.print("이름을 입력해주세요 : ");
				a.setName(s.next());
				System.out.print("비밀번호를 입력해주세요 : ");
				a.setPasswd(s.next());
				
				System.out.println();
				
				System.out.println("두번째 계좌를 생성합니다.");
				System.out.print("계좌번호를 입력해주세요 : ");
				b.setNum(s.next());
				System.out.print("이름을 입력해주세요 : ");
				b.setName(s.next());
				System.out.print("비밀번호를 입력해주세요 : ");
				b.setPasswd(s.next());
				
				System.out.println("\n계좌생성 완료!");
				check = 1;
			}
			else if(choice == 2)
			{
				if(check == 0)
					System.out.println("입력된 정보가 없습니다. 계좌를 먼저 생성해주세요.");
				else
				{
					int exit = 0;
					while(exit !=1)
					{
						System.out.println("==어느 계좌에서 작업하시겠습니까?==");
						System.out.println("1. 소유주 : "+a.getName() + "/" +"계좌번호 : "+a.getNum());
						System.out.println("2. 소유주 : "+b.getName() + "/" +"계좌번호 : "+b.getNum());
						System.out.print("번호를 입력해주세요 : ");
						int choice2 = s.nextInt(); //소유주 결정 변수
						
						
						m.PrintDoWhat();
						System.out.print("번호를 입력해주세요 : ");
						int choiceMenu = s.nextInt();
						
						if(choiceMenu == 1)
						{
							System.out.print("얼마를 입금하시겠습니까? : ");
							int temp1 = s.nextInt();
							System.out.print("비밀번호를 입력해주세요 : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+a.getMoney() +"원");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+b.getMoney() +"원");
							}
						}
						else if(choiceMenu == 2)
						{
							System.out.print("얼마를 이체하시겠습니까? : ");
							int temp1 = s.nextInt();
							System.out.print("비밀번호를 입력해주세요 : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+a.getMoney() +"원");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+b.getMoney() +"원");
							}
						}
						else if(choiceMenu == 3)
						{
							System.out.print("얼마를 출금하시겠습니까? : ");
							int temp1 = s.nextInt();
							System.out.print("비밀번호를 입력해주세요 : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+a.getMoney() +"원");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("잔액 : "+b.getMoney() +"원");
							}
						}
						else if(choiceMenu == 4)
						{
							if(choice2 ==1)
								System.out.println("잔액 : "+a.getMoney() +"원");
							else if(choice2 ==2)
								System.out.println("잔액 : "+b.getMoney() +"원");
						}
						else if(choiceMenu == 5)
						{
							if(a.setting() || b.setting())
								System.out.println("계좌수정불가");
						}
						else if(choiceMenu == 0)
						{
							exit=1;
						}
						else
							System.out.println("번호를 확인해주세요.");
					}
				}
			}
			else if(choice == 0)
			{
				System.out.println("계좌이체를 종료합니다.");	
				break;
			}
			else
				System.out.println("메뉴를 확인하고 다시 입력해주세요.");
				
		}

	}
		
	

}

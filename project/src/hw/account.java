package hw;
import java.util.*;

class BankAccount{


	//TODO : 필드 및 함수명을 Fullname + 알아보기 쉽게
	//쓰는 방식은 좋습니다.
	//하지만 _d 의 명칭이 붙는 경우는 
	//보통 debug모드에만 컴파일되어 이용되는 변수나
	//10진수의 decimal,
	//또는 다른 약속된 특수한 방법으로 사용되는 변수에 표기합니다.
	//차후 이러한 변수명을 짓는 방식은 팀원과 토의하여 결정하기를 바랍니다.
	//가장 기초적인 Naming Rule은 대표적인 방법으로는 카멜 또는 파스칼이 존재합니다.   



	private String name;
	private String account_num;
	private String passwd;
	private int money;

	//오해의 소지가 있는 변수명
	private int fix_d;
	

	//생성자는 객체생성시 필수로 한번 돌아가 때문에 
	//생성자가 하나뿐이라면 fix_d를 사용하여 초기화를 확인할 필요는 없습니다.
	//해당 변수는 true false 만을 사용하기 때문에 boolean타입이 좀더 정확합니다.
	
	//만약 어떤 생성자가 실행됬는지 확인하는것을 원한다면
	//ENUM를 사용한 상태표시법을 추천합니다.
	// http://www.nextree.co.kr/p11686/

	public BankAccount()
	{
		
		fix_d=1;
		setting();
	}
	//확인하는 함수의 명칭은 is를 앞에 붙이는 것이 좋습니다. ex) isSetting()
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

	// 현재의 코드가 짧아서 어느정도 파악이 되지만
	//이후 코드가 길어지거나 함수가 많아지면 변수가 필드값인지 지역값인지 햇갈리게 됩니다.
	//대응 방법으로는 this. 를 붙여주거나 필드명에 m_ 를 붙이는 방식 등이 잇습니다.

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

	//주석은 일반적으로 설명하려는 함수 바로 위에 적는 것이 일반적입니다.
	//함수의 명칭을 보고 해당 메서드가 입금을 동작하는 것을 압니다.
	//이러한 내용보다는 해당 함수가 어떻게 동작하는지, 
	//몇몇 swich case 문이 어떤 값으로 작동되는지 등의
	//간단한 원리를 적는 것이 더 도움이 됩니다.

	//TODO : true false의 경우는 [boolean, if else]
	//	유한한 조건의 경우	[정수값  , switch]
	//	범위 조건의 경우 	[값        ,다중 if]
	//	를 사용하는 것이 일반적입니다.
	//	switch는 4개이상의 조건인 경우 if보다 더 빠르게 동작한다고 합니다.
	//	그러나 사실 크게 속도에 매달리지 않는 한 코드상 보기 편한 swich - enum 방식을 채용합니다.

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

//TODO: choese를 enum방식으로 고쳐보세요.
//훨씬 더 직관적인 코드가 됩니다.

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

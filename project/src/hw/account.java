package hw;
import java.util.*;

class BankAccount{


	//TODO : �ʵ� �� �Լ����� Fullname + �˾ƺ��� ����
	//���� ����� �����ϴ�.
	//������ _d �� ��Ī�� �ٴ� ���� 
	//���� debug��忡�� �����ϵǾ� �̿�Ǵ� ������
	//10������ decimal,
	//�Ǵ� �ٸ� ��ӵ� Ư���� ������� ���Ǵ� ������ ǥ���մϴ�.
	//���� �̷��� �������� ���� ����� ������ �����Ͽ� �����ϱ⸦ �ٶ��ϴ�.
	//���� �������� Naming Rule�� ��ǥ���� ������δ� ī�� �Ǵ� �Ľ�Į�� �����մϴ�.   



	private String name;
	private String account_num;
	private String passwd;
	private int money;

	//������ ������ �ִ� ������
	private int fix_d;
	

	//�����ڴ� ��ü������ �ʼ��� �ѹ� ���ư� ������ 
	//�����ڰ� �ϳ����̶�� fix_d�� ����Ͽ� �ʱ�ȭ�� Ȯ���� �ʿ�� �����ϴ�.
	//�ش� ������ true false ���� ����ϱ� ������ booleanŸ���� ���� ��Ȯ�մϴ�.
	
	//���� � �����ڰ� ��������� Ȯ���ϴ°��� ���Ѵٸ�
	//ENUM�� ����� ����ǥ�ù��� ��õ�մϴ�.
	// http://www.nextree.co.kr/p11686/

	public BankAccount()
	{
		
		fix_d=1;
		setting();
	}
	//Ȯ���ϴ� �Լ��� ��Ī�� is�� �տ� ���̴� ���� �����ϴ�. ex) isSetting()
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

	// ������ �ڵ尡 ª�Ƽ� ������� �ľ��� ������
	//���� �ڵ尡 ������ų� �Լ��� �������� ������ �ʵ尪���� ���������� �ް����� �˴ϴ�.
	//���� ������δ� this. �� �ٿ��ְų� �ʵ�� m_ �� ���̴� ��� ���� �ս��ϴ�.

	private boolean isPasswdCorrect(String passwd)
	{
		if(this.passwd.equals(passwd))
			return true;
		else 
			{
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				return false;
			}
		
	}

	//�ּ��� �Ϲ������� �����Ϸ��� �Լ� �ٷ� ���� ���� ���� �Ϲ����Դϴ�.
	//�Լ��� ��Ī�� ���� �ش� �޼��尡 �Ա��� �����ϴ� ���� �дϴ�.
	//�̷��� ���뺸�ٴ� �ش� �Լ��� ��� �����ϴ���, 
	//��� swich case ���� � ������ �۵��Ǵ��� ����
	//������ ������ ���� ���� �� ������ �˴ϴ�.

	//TODO : true false�� ���� [boolean, if else]
	//	������ ������ ���	[������  , switch]
	//	���� ������ ��� 	[��        ,���� if]
	//	�� ����ϴ� ���� �Ϲ����Դϴ�.
	//	switch�� 4���̻��� ������ ��� if���� �� ������ �����Ѵٰ� �մϴ�.
	//	�׷��� ��� ũ�� �ӵ��� �Ŵ޸��� �ʴ� �� �ڵ�� ���� ���� swich - enum ����� ä���մϴ�.

	public void Deposit(int gold) 
	{
			money+=gold;
		
	} //�Ա�
	public void Withdraw(int gold) 
	{
			if(money >=gold) 
				money-=gold;
			else
				System.out.println("�ܾ��� �����մϴ�.");
	} //���
	public void SendMoney(BankAccount ba,int gold,String key,int select) //��ü
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
					System.out.println("�ܾ��� �����մϴ�.");	
			}
			else if(select == 3)
				Withdraw(gold);
		}
	}
}

//TODO: choese�� enum������� ���ĺ�����.
//�ξ� �� �������� �ڵ尡 �˴ϴ�.

public class account {
	public void PrintMenu()
	{
		System.out.println("-----�޴��� �������ּ���.-----");
		System.out.println("1. ���»���");
		System.out.println("2. ���������Է�");
		System.out.println("0. ����");
		System.out.println("------------------------------");
		
	}
	
	public void PrintDoWhat()
	{
		System.out.println("-----� �۾��� �Ͻðڽ��ϱ�?-----");
		System.out.println("1. �Ա��ϱ�");
		System.out.println("2. ��ü�ϱ�");
		System.out.println("3. ����ϱ�");
		System.out.println("4. �ܾ�Ȯ��");
		System.out.println("5. �������� �����ϱ�");
		System.out.println("0. �����޴��� ����");
		System.out.println("-----------------------------------");
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		
		account m = new account();
		
		int check = 0; //0�̸� �Էµ� ������ ����, 1�̸� �Էµ� ������ ����
		
		while(true)
		{
			
			m.PrintMenu();
			System.out.print("��ȣ�� �Է����ּ��� : ");
			int choice = s.nextInt(); //�ʱ�޴����ð� ����
			if (choice == 1)
			{				
				System.out.println("ù��° ���¸� �����մϴ�.");
				System.out.print("���¹�ȣ�� �Է����ּ��� : ");
				a.setNum(s.next());
				System.out.print("�̸��� �Է����ּ��� : ");
				a.setName(s.next());
				System.out.print("��й�ȣ�� �Է����ּ��� : ");
				a.setPasswd(s.next());
				
				System.out.println();
				
				System.out.println("�ι�° ���¸� �����մϴ�.");
				System.out.print("���¹�ȣ�� �Է����ּ��� : ");
				b.setNum(s.next());
				System.out.print("�̸��� �Է����ּ��� : ");
				b.setName(s.next());
				System.out.print("��й�ȣ�� �Է����ּ��� : ");
				b.setPasswd(s.next());
				
				System.out.println("\n���»��� �Ϸ�!");
				check = 1;
			}
			else if(choice == 2)
			{
				if(check == 0)
					System.out.println("�Էµ� ������ �����ϴ�. ���¸� ���� �������ּ���.");
				else
				{
					int exit = 0;
					while(exit !=1)
					{
						System.out.println("==��� ���¿��� �۾��Ͻðڽ��ϱ�?==");
						System.out.println("1. ������ : "+a.getName() + "/" +"���¹�ȣ : "+a.getNum());
						System.out.println("2. ������ : "+b.getName() + "/" +"���¹�ȣ : "+b.getNum());
						System.out.print("��ȣ�� �Է����ּ��� : ");
						int choice2 = s.nextInt(); //������ ���� ����
						
						
						m.PrintDoWhat();
						System.out.print("��ȣ�� �Է����ּ��� : ");
						int choiceMenu = s.nextInt();
						
						if(choiceMenu == 1)
						{
							System.out.print("�󸶸� �Ա��Ͻðڽ��ϱ�? : ");
							int temp1 = s.nextInt();
							System.out.print("��й�ȣ�� �Է����ּ��� : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+a.getMoney() +"��");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+b.getMoney() +"��");
							}
						}
						else if(choiceMenu == 2)
						{
							System.out.print("�󸶸� ��ü�Ͻðڽ��ϱ�? : ");
							int temp1 = s.nextInt();
							System.out.print("��й�ȣ�� �Է����ּ��� : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+a.getMoney() +"��");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+b.getMoney() +"��");
							}
						}
						else if(choiceMenu == 3)
						{
							System.out.print("�󸶸� ����Ͻðڽ��ϱ�? : ");
							int temp1 = s.nextInt();
							System.out.print("��й�ȣ�� �Է����ּ��� : ");
							String temp2 = s.next();
							
							if(choice2 ==1)
							{
								a.SendMoney(a,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+a.getMoney() +"��");
							}
							else if(choice2 ==2)
							{
								b.SendMoney(b,temp1,temp2,choiceMenu);
								System.out.println("�ܾ� : "+b.getMoney() +"��");
							}
						}
						else if(choiceMenu == 4)
						{
							if(choice2 ==1)
								System.out.println("�ܾ� : "+a.getMoney() +"��");
							else if(choice2 ==2)
								System.out.println("�ܾ� : "+b.getMoney() +"��");
						}
						else if(choiceMenu == 5)
						{
							if(a.setting() || b.setting())
								System.out.println("���¼����Ұ�");
						}
						else if(choiceMenu == 0)
						{
							exit=1;
						}
						else
							System.out.println("��ȣ�� Ȯ�����ּ���.");
					}
				}
			}
			else if(choice == 0)
			{
				System.out.println("������ü�� �����մϴ�.");	
				break;
			}
			else
				System.out.println("�޴��� Ȯ���ϰ� �ٽ� �Է����ּ���.");
				
		}

	}
		
	

}

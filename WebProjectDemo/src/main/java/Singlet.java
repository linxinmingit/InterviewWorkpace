/**
 * ����ʽ��ָȫ�ֵĵ���ʵ���ڵ�һ�α�ʹ��ʱ������

        ����ʽ��ָȫ�ֵĵ���ʵ������װ��ʱ������
 * @author Administrator
 *
 */
public class Singlet {
	/**
	 * ����ʽ����ģʽ
	 */
	private static Singlet singlet;
	/**
	 * �ѹ�������Ϊ˽�У��������Է�ֹ���ⲿ�������
	 */
	private Singlet(){};
	public static Singlet getSinglet()
	{
		if(singlet == null)
		{
		   singlet = new Singlet();	
		}
		return singlet;
	}
}
class SingletB{
	/**
	 * ����ʽʵ��
	 */
	private static final SingletB SINGLET = new SingletB();
	private SingletB(){};
	public static SingletB getSingletB()
	{
		return SINGLET;
	}
}

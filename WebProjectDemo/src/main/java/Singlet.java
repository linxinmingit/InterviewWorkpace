/**
 * 懒汉式：指全局的单例实例在第一次被使用时构建。

        饿汉式：指全局的单例实例在类装载时构建。
 * @author Administrator
 *
 */
public class Singlet {
	/**
	 * 懒汉式单例模式
	 */
	private static Singlet singlet;
	/**
	 * 把构造器改为私有，这样可以防止被外部的类调用
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
	 * 饿汉式实现
	 */
	private static final SingletB SINGLET = new SingletB();
	private SingletB(){};
	public static SingletB getSingletB()
	{
		return SINGLET;
	}
}

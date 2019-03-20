package cn.changemax.mas.test;

/**
 * <p>
 * Title: SingletonFactory.java
 * </p>
 * <p>
 * Description:在内部类被加载和初始化，才创建SingletonFactory实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部类加载和初始化时，创建的，因此线程安全的。相较DCL双检查锁机制更为精简，其线程也是安全的。
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2019年2月25日
 * @version 1.0
 */
public class SingletonFactory { 
 
	private SingletonFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static class Inner{
		private static final SingletonFactory singletonFactory = new SingletonFactory();
	}

//	静态返回该实例
	public static SingletonFactory getSingletonFactory() {
		return Inner.singletonFactory;
	}

	public static void main(String[] args) {
		System.out.println(SingletonFactory.getSingletonFactory());
	}

}

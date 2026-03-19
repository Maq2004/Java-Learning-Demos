package day_11;

public class Main {
	
	public static void main(String[] args) {
		
		// 1. 多态引用 vs 具体类型引用
		// Pet xiaoHei = new Cat("小黑", "black", 12, "big", "lihua");
		// Cat xiaoHei = new Cat("小黑", "black", 12, "big", "lihua");

		// 2. 同名字段隐藏（field hiding）验证
		//   - 父类 Pet 有 private String catName
		//   - 子类 Cat 有 private String catName（独立的两块内存）
		//   - 两者不同步、不联动

		// System.out.println("父类视角的名字: " + xiaoHei.getCatName());
		//   → 调用的是 Pet 的 getCatName()，返回 Pet.catName 的值

		// System.out.println("子类视角的名字: " + xiaoHei.getSubName());
		//   → 调用的是 Cat 的 getSubName()，返回 Cat.catName 的值

		// 3. 方法调用观察
		// xiaoHei.makeSound("小黑");
		//   - 如果 xiaoHei 是 Pet 类型引用：调用 Pet 的 makeSound()
		//   - 如果 xiaoHei 是 Cat 类型引用：调用 Cat 的 makeSound()（因为已重写/覆盖）
		//   注意：当前 Cat 的 makeSound 带参数，而 Pet 的也带参数，但未加 @Override，实际是重载而非重写

		// 4. equals() 默认行为验证
		// System.out.print(xiaoHei.equals(xiaoHei2));
		//   → 未重写 equals()，调用 Object 的实现 → 比较的是引用地址（==）
		//   → 即使内容完全相同，也返回 false（因为是两个不同对象）

		// 5. 只修改子类字段的效果（验证字段独立性）
		/*
		    xiaoHei.changeSubOnly("大黑");

		    System.out.println("修改后 - 父类视角: " + xiaoHei.getCatName());
		    System.out.println("修改后 - 子类视角: " + xiaoHei.getSubName());
		*/
		// 结论：修改 this.catName 只影响子类自己的 catName
//		        父类的 catName 保持不变（两者是独立的两个变量）
	    
	    QiFish QiFish = new QiFish(110);
	    
	    BaiFish BaiFish = new BaiFish(48);
	    
	    FeiFish FeiFish = new FeiFish(60);
	    
	    System.out.println(QiFish.Fishspeed(3));
	    
	    System.out.println(BaiFish.Fishspeed(3));
	    
	    System.out.println(FeiFish.Fishspeed(3));
	    
	    
	    
	    
		
	}

}

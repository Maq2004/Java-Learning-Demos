package day02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//类是具有相同属性和行为的一系列事物的集合
		//对象是现实生活中的具体事物
		//关系：类是对象的模板，对象是类的实例
//		Dog dog = new Dog();
	
		// 类名 对象名 = new 类名（）
		
//		dog.name = "小白";
//		dog.age=22;
//		dog.sayhello();
	
		
		
//		Car car1 = new Car();
//		
//		car1.brand = "benci";
//		car1.color = "black";
//		car1.price = 3800000;
//		
//		car1.shouw();
//		
//		
	
		
		
		
		
		//面向对象思想是只关注参与时间的对象，不关系具体过程，
		//具体过程被打散到对象中，在main函数中组合出具体过程的思想
		//写一个面向对象的登陆程序
		        // --- 核心理论区 ---
		        // 1. 对于一个固定大小的类型来说（如 int, double），Java数组对他们的处理是直接存放数据。
		        //    byte(8-bit), short(16-bit), int(32-bit), long(64-bit)
		        //    float(32-bit), double(64-bit), char(16-bit), boolean(1/8-bit)
		        
		        // 2. 而对于一个不固定大小的类型（如用户自定义的对象），Java数组存放的是地址。
		        //    这是在性能（数组槽位固定大小，方便寻址）和灵活（对象内容可大可小）之间的平衡。

		        // --- 初始化区 ---
		        // users 是一个存放 UserInfo 类型引用的数组，此时只开辟了引用的空间
		        // 它现在包含 50 个 null(地址) 值，并没有指向任何 UserInfo 实体。
		        UserInfo[] users = new UserInfo[50];
		        
		        // 必须进行初始化，否则直接访问 users[i].username 会报 NullPointerException
		        // 因为此时数组格子里只有空地址，没有对应的内存。
//		        for (int i = 0; i < 50; i++) {
//		            users[i] = new UserInfo(); 
//		        }
		        
		        

		        // --- 对象创建与赋值 ---
//		        UserInfo maqian = new UserInfo();
//		        maqian.username = "maqian";
//		        maqian.userpasswd = "202522430721";
		        UserInfo Usermanager = new UserInfo();
		        
		        Usermanager.register(users, 0, "maqian", "123456");

		        // 正确的赋值：将初始化好的 maqian 对象的内存地址，直接复制一份放入 users[0] 处
		        // 此时 maqian 变量和 users[0] 指向堆内存中同一个对象实体。
//		        users[0] = maqian;

		        // --- 用户交互区 ---
		        Scanner input = new Scanner(System.in);
		        UserInfo enteruser = new UserInfo();
		        
		        System.out.println("请输入用户名和密码：");
		        enteruser.username = input.next();
		        enteruser.userpasswd = input.next();

		        // --- 逻辑比对区 ---
		        boolean flag = true;
		        for (int i = 0; i < 50; i++) {
		            // 注意：此处必须确保 users[i] 不为 null 才能调用 .username
		            // 因为我们在上面循环里 new 了对象，所以这里是安全的。
		            if (users[i]!= null && 
		            	enteruser.username.equals(users[i].username) &&
		                enteruser.userpasswd.equals(users[i].userpasswd)) {
		                System.out.println("欢迎回来");
		                flag = false;
		                break;
		            }
		        }

		        if (flag) {
		            System.out.println("账号或密码错误");
		        }
		        
		        input.close();

//		        1. 数组的“双标”本质：性能与灵活的拔河
//		       数组里的格子到底装什么，看类型：
//
//		        固定大小（基本类型）： int, double 等。它们是“死”的，大小在 JVM 里定死了。所以数组格子里直接塞数值。
//
//		        直觉： 就像一排硬币槽，直接放硬币，伸手就拿，速度最快。
//
//		        不固定大小（引用类型）： UserInfo 对象、String 等。它们是“活”的，属性可多可少。所以数组格子里只存地址。
//
//		        直觉： 就像一排快递柜，格子里只放“取货码（地址）”，房子（对象实体）盖在堆内存的别处。这保证了数组格子的宽度永远整齐划一。
//
//		        2. “空指针”的真相：买了柜子没盖房
//		        当我写 UserInfo[] users = new UserInfo[50]; 时，内存中发生了什么？
//
//		        内存真相： 我只是在堆里买了 50 个空柜子，每个柜子里的初始值都是 null（空地址）。
//
//		        报错原因： 如果没 new UserInfo() 就去改名字，就像拿着一张空白取货单去取货，系统当然会崩溃（NullPointerException）。
//
//		        解决： 必须手动给每个柜子塞进一个刚盖好的“房子地址”。
//
//		        3. 引用拷贝与“联动效应”：改房子 vs 改路牌
//		        这是我今天理解最深的地方。A = B（对象赋值）其实是复印地址：
//
//		        改房子（属性赋值）： users[0].name = "xxx"。这是顺着地址去装修。因为大家手里拿的是同一个地址，所以会产生联动。
//
//		        改路牌（变量赋值）： users[0] = null。这只是把这个格子的地址抹掉了。如果还有别的变量（比如 maqian）指着那座房子，房子就不会倒。
//
//		        核心： 只要还有一把钥匙在，房子就在；钥匙全丢了，GC（垃圾回收）才会来拆房。
//
//		        4. 方法栈帧：局部变量的生死瞬间
//		        理解为什么要把逻辑写在方法（如 register）里：
//
//		        栈帧机制： 方法运行时，会在栈里开个临时包间。局部变量（如 temp）就住在里面。
//
//		        自动清理： 方法一结束，包间直接炸毁，temp 瞬间消失。
//
//		        接力逻辑： 在 temp 消失前，我得把地址交给 users[i] 这种“长寿命”的数组。这样“临时工”跑了，“成果（对象）”还能留在堆里。
//
//		        5. 管家哲学：对象是实体，类是模具
//		        Manager 类（管家）： 它是干活的工具人。我不一定要在他身上存数据。
//
//		        static（静态）： 这是“类自带技能”，不用 new 就能用。
//
//		        参数化： 方法不能写死（硬编码），得通过参数把名字和密码传进去，这样“模具”才能印出不同的“产品”。
		
		
		
		
		
		
		
		
		
		
		
	}
}

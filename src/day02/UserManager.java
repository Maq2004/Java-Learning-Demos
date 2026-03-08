package day02;

public class UserManager {

	public static void register( UserInfo users[] , int index , String name ,String passwd ) {
		
		UserInfo temp = new UserInfo();
		temp.username = name;
		temp.userpasswd = passwd;
		users[index] = temp;
	}
	
}
/*
 * ==============================================================================
 * 【核心理论深度复盘：Java 内存管理与对象生命周期】
 * ==============================================================================
 * * 1. 变量的本质：是“遥控器”而非“实体” 🎮
 * - UserInfo maqian = new UserInfo();
 * - 在栈(Stack)中产生的 maqian 变量只是一个【引用(Reference)】，存放的是内存地址。
 * - 真正的“房子”——对象实体，存放在堆(Heap)中。
 * * 2. 赋值的本质：是“复制门牌号” 🏠
 * - users[0] = maqian; 
 * - 这行代码并没有搬动房子，只是把 maqian 纸条上的地址复印了一份放进数组格子。
 * - 此时存在【一房多钥】：修改 maqian.username，数组里看到的数据也会随之改变。
 * * 3. 为什么不建议在 main 中直接手动赋值？（如：maqian = new UserInfo()...）
 * - 【线的堆积】：在 main 方法定义的变量（如 maqian）是一根强引用的“线”。
 * - 【GC 阻碍】：只要 main 方法没执行完，maqian 变量就一直拽着堆里的对象。
 * - 即便你执行了 users[0] = null，只要 maqian 变量还指向它，垃圾回收(GC)就无法清理该内存。
 * * 4. 封装方法（静态/实例）注册的妙处 ♻️
 * - 【临时引用的自毁】：在 register 方法内部定义的 UserInfo temp 是局部变量。
 * - 方法执行一结束，栈帧弹出，temp 变量立即消失（线断了）。
 * - 内存中只剩下【数组】这一根线牵着对象，这让对象的生命周期完全交由数组控制。
 * * 5. 静态 vs 实例方法的选择 🛠️
 * - 静态注册 (UserManager.register): 工具属性强。将“逻辑”与“数据(UserInfo)”彻底解耦。
 * - 实例注册 (UserInfo.register): 对象属性强。但在逻辑上，让“数据”自己负责“存入数组”略显混乱。
 * - 结论：推荐【静态工具类】方案，职责清晰，且不会产生多余的实例变量干扰内存。
 * * 6. 手动触发回收 🧹
 * - users[index] = null; 
 * - 这是注销的精髓。当最后一根指向对象的线断开，对象变成“孤岛”，GC 会自动释放其占用的内存。
 * ==============================================================================
 */
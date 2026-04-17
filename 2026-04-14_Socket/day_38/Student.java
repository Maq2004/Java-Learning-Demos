package day_38;

import java.io.Serializable;

/*
 * 实体类规范总结：
 * 1. 只要是需要在网络上通过 Socket 传输，或者写入本地文件的对象。
 * 2. 必须实现 java.io.Serializable 接口。
 * 3. 这是一个标记接口，如果没有它，ObjectOutputStream 在执行 writeObject 时会直接抛异常。
 */
public class Student implements Serializable {
	
	private String name;
	private String pwd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
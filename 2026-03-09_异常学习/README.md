# 2026-03-09 学习小结

1. 异常多路捕获 + 顺序
- 写出了经典的多catch：InputMismatch → Arithmetic → Exception兜底  
- 注释里自己总结了“从子类写到父类，最后Exception收尾”，顺序完全正确  
- 实际场景：输入字母/除零都分别捕获，兜底Exception也加了，程序不会崩溃还很友好

2. finally的理解更深了
- 每个try基本都加了finally打印“程序结束”  
- 小结里写了三点本质区别：  
  - catch成功后程序继续往下走（switch还能执行）  
  - finally是“强制执行”，return/throw都挡不住  
  - 判断要不要写finally：外部资源（Scanner/文件/连接）必须写，成对操作也要闭环  
- 这三点写得特别到位，已经抓到finally的灵魂了

3. throw 和 throws 配合使用
- 写了calc方法 throws 多个异常（InputMismatch + Arithmetic + Exception）  
- 里面if(b==0) throw new ArithmeticException  
- main里调用catch + printStackTrace + getMessage  
- 注释里区分得很清楚：throws是“提前警告可能有炸弹”，throw是“炸弹真爆了”

4. 自定义异常实战
- throw new AgeException("年龄出错")  
- catch(AgeException ex) 打印 ex.getMessage()  

5. 其他小亮点
- 星期判断案例：try-catch InputMismatch → switch判断1-7 → 超出范围提示  
- 异常捕获后程序不停止（catch完继续走switch），这个现象抓住了  
- 整体思路：从“异常来了程序崩” → “异常来了我能友好处理还继续跑”

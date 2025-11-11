# lottery-2025winter

## 11
🚨 问题：声明式事务太早执行

问题就在于执行顺序。

@Transactional
@DBRouter(key = "uId")
public void doSomething(Long uId) { ... }


Spring 的 AOP 顺序通常是：

@Transactional 切面先执行
→ 拿到连接（此时 DBContextHolder 还没设置）
→ 使用默认数据源（通常是主库）

@DBRouter 切面后执行
→ 设置 DBContextHolder（如 “db02”）

于是：

事务管理器一开始就从 默认数据源 拿连接；

后面虽然你切换了库，但事务已经开始；

后续 SQL 实际可能发到另一个库；

结果：事务和 SQL 不在一个连接上 ❌。
# panache-projection-reproducer project

### Steps to reproduce
1. Start Postgres Docker Container 
`./scripts/test/start-containers.sh`
1. Run Program
`./mvnw quarkus:dev`

When i try to project a class with MULTIPLE entity relation it throws
```
2020-07-06 12:32:45,039 ERROR [io.qua.run.Application] (Quarkus Main Thread) Error running Quarkus application: java.lang.NullPointerException
	at org.hibernate.hql.internal.NameGenerator.generateColumnNames(NameGenerator.java:27)
	at org.hibernate.hql.internal.ast.util.SessionFactoryHelper.generateColumnNames(SessionFactoryHelper.java:434)
	at org.hibernate.hql.internal.ast.tree.SelectClause.initializeColumnNames(SelectClause.java:270)
	at org.hibernate.hql.internal.ast.tree.SelectClause.finishInitialization(SelectClause.java:260)
	at org.hibernate.hql.internal.ast.tree.SelectClause.initializeExplicitSelectClause(SelectClause.java:255)
	at org.hibernate.hql.internal.ast.HqlSqlWalker.useSelectClause(HqlSqlWalker.java:1026)
	at org.hibernate.hql.internal.ast.HqlSqlWalker.processQuery(HqlSqlWalker.java:794)
	at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.query(HqlSqlBaseWalker.java:689)
	at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.selectStatement(HqlSqlBaseWalker.java:325)
	at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.statement(HqlSqlBaseWalker.java:273)
	at org.hibernate.hql.internal.ast.QueryTranslatorImpl.analyze(QueryTranslatorImpl.java:276)
	at org.hibernate.hql.internal.ast.QueryTranslatorImpl.doCompile(QueryTranslatorImpl.java:192)
	at org.hibernate.hql.internal.ast.QueryTranslatorImpl.compile(QueryTranslatorImpl.java:144)
	at org.hibernate.engine.query.spi.HQLQueryPlan.<init>(HQLQueryPlan.java:113)
	at org.hibernate.engine.query.spi.HQLQueryPlan.<init>(HQLQueryPlan.java:73)
	at org.hibernate.engine.query.spi.QueryPlanCache.getHQLQueryPlan(QueryPlanCache.java:162)
	at org.hibernate.internal.AbstractSharedSessionContract.getQueryPlan(AbstractSharedSessionContract.java:604)
	at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:716)
	at org.hibernate.internal.AbstractSessionImpl.createQuery(AbstractSessionImpl.java:23)
	at io.quarkus.hibernate.orm.runtime.entitymanager.TransactionScopedEntityManager.createQuery(TransactionScopedEntityManager.java:317)
	at io.quarkus.hibernate.orm.runtime.entitymanager.ForwardingEntityManager.createQuery(ForwardingEntityManager.java:142)
	at io.quarkus.hibernate.orm.panache.common.runtime.CommonPanacheQueryImpl.createBaseQuery(CommonPanacheQueryImpl.java:360)
	at io.quarkus.hibernate.orm.panache.common.runtime.CommonPanacheQueryImpl.createQuery(CommonPanacheQueryImpl.java:315)
	at io.quarkus.hibernate.orm.panache.common.runtime.CommonPanacheQueryImpl.list(CommonPanacheQueryImpl.java:266)
	at io.quarkus.hibernate.orm.panache.runtime.PanacheQueryImpl.list(PanacheQueryImpl.java:149)
	at io.efraim.Main$App.run(Main.java:65)
	at io.efraim.Main_App_Subclass.run$$superaccessor1(Main_App_Subclass.zig:208)
	at io.efraim.Main_App_Subclass$$function$$1.apply(Main_App_Subclass$$function$$1.zig:33)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.proceed(AroundInvokeInvocationContext.java:54)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:119)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:92)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.doIntercept(TransactionalInterceptorRequired.java:32)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.intercept(TransactionalInterceptorBase.java:53)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.intercept(TransactionalInterceptorRequired.java:26)
	at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired_Bean.intercept(TransactionalInterceptorRequired_Bean.zig:339)
	at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:41)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:41)
	at io.quarkus.arc.impl.InvocationContexts.performAroundInvoke(InvocationContexts.java:32)
	at io.efraim.Main_App_Subclass.run(Main_App_Subclass.zig:169)
	at io.efraim.Main_App_ClientProxy.run(Main_App_ClientProxy.zig:157)
	at io.quarkus.runtime.ApplicationLifecycleManager.run(ApplicationLifecycleManager.java:111)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:61)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:38)
	at io.efraim.Main.main(Main.java:19)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at io.quarkus.runner.bootstrap.StartupActionImpl$3.run(StartupActionImpl.java:144)
	at java.base/java.lang.Thread.run(Thread.java:834)
``` 


# panache-projection-reproducer project

### Steps to reproduce
1. Start Postgres Docker Container 
`./scripts/test/start-containers.sh`
1. Run Program
`./mvnw quarkus:dev`

When i try to project a class with some entity relation it throws
```
2020-07-03 12:48:20,055 WARN  [org.hib.eng.jdb.spi.SqlExceptionHelper] (Quarkus Main Thread) SQL Error: 0, SQLState: 42702
2020-07-03 12:48:20,055 ERROR [org.hib.eng.jdb.spi.SqlExceptionHelper] (Quarkus Main Thread) ERROR: column reference "id" is ambiguous
  Position: 156
2020-07-03 12:48:20,065 ERROR [io.qua.run.Application] (Quarkus Main Thread) Error running Quarkus application: javax.persistence.PersistenceException: org.hibernate.exceptio
n.SQLGrammarException: could not extract ResultSet
        at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:154)
        at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1542)
        at org.hibernate.query.Query.getResultList(Query.java:165)
        at io.quarkus.hibernate.orm.panache.common.runtime.CommonPanacheQueryImpl.firstResult(CommonPanacheQueryImpl.java:284)
        at io.quarkus.hibernate.orm.panache.runtime.PanacheQueryImpl.firstResult(PanacheQueryImpl.java:159)
        at io.efraim.Main$App.run(Main.java:49)
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
Caused by: org.hibernate.exception.SQLGrammarException: could not extract ResultSet
        at org.hibernate.exception.internal.SQLStateConversionDelegate.convert(SQLStateConversionDelegate.java:103)
        at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:42)
        at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
        at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
        at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.extract(ResultSetReturnImpl.java:67)
        at org.hibernate.loader.Loader.getResultSet(Loader.java:2279)
        at org.hibernate.loader.Loader.executeQueryStatement(Loader.java:2037)
        at org.hibernate.loader.Loader.executeQueryStatement(Loader.java:1999)
        at org.hibernate.loader.Loader.doQuery(Loader.java:953)
        at org.hibernate.loader.Loader.doQueryAndInitializeNonLazyCollections(Loader.java:354)
        at org.hibernate.loader.Loader.doList(Loader.java:2825)
        at org.hibernate.loader.Loader.doList(Loader.java:2807)
        at org.hibernate.loader.Loader.listIgnoreQueryCache(Loader.java:2639)
        at org.hibernate.loader.Loader.list(Loader.java:2634)
        at org.hibernate.loader.hql.QueryLoader.list(QueryLoader.java:506)
        at org.hibernate.hql.internal.ast.QueryTranslatorImpl.list(QueryTranslatorImpl.java:400)
        at org.hibernate.engine.query.spi.HQLQueryPlan.performList(HQLQueryPlan.java:219)
        at org.hibernate.internal.SessionImpl.list(SessionImpl.java:1412)
        at org.hibernate.query.internal.AbstractProducedQuery.doList(AbstractProducedQuery.java:1565)
        at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1533)
        ... 28 more
Caused by: org.postgresql.util.PSQLException: ERROR: column reference "id" is ambiguous
  Position: 156
        at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse(QueryExecutorImpl.java:2533)
        at org.postgresql.core.v3.QueryExecutorImpl.processResults(QueryExecutorImpl.java:2268)
        at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:313)
        at org.postgresql.jdbc.PgStatement.executeInternal(PgStatement.java:448)
        at org.postgresql.jdbc.PgStatement.execute(PgStatement.java:369)
        at org.postgresql.jdbc.PgPreparedStatement.executeWithFlags(PgPreparedStatement.java:159)
        at org.postgresql.jdbc.PgPreparedStatement.executeQuery(PgPreparedStatement.java:109)
        at io.agroal.pool.wrapper.PreparedStatementWrapper.executeQuery(PreparedStatementWrapper.java:75)
        at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.extract(ResultSetReturnImpl.java:57)
        ... 43 more

``` 

